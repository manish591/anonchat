package com.manish.anonchat.view;

import static android.content.Context.MODE_PRIVATE;
import static com.manish.anonchat.view.MainActivity.SHARED_PREF_KEY;
import static com.manish.anonchat.view.MainActivity.SHARED_PREF_TABLE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.manish.anonchat.R;
import com.manish.anonchat.databinding.FragmentMessagesBinding;

import java.util.ArrayList;

public class Messages extends Fragment {

    private FragmentMessagesBinding binding;
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    ArrayList<String> items = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentMessagesBinding.inflate(inflater, container, false);

        adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, items);
        binding.messagesList.setAdapter(adapter);

        fetchMessages();

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void fetchMessages() {
        SharedPreferences sharedPref = requireActivity().getSharedPreferences(SHARED_PREF_TABLE, MODE_PRIVATE);
        String username = sharedPref.getString(SHARED_PREF_KEY, null);

        db.collection("messages").whereEqualTo("username", username).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(!queryDocumentSnapshots.isEmpty()) {
                    items.clear();

                    for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                        String receiverUsername = document.getString("username");
                        String message = document.getString("text");

                        if(receiverUsername != null && receiverUsername.equals(username)) {
                            items.add(message);
                        }
                    }

                    adapter.notifyDataSetChanged();
                    Toast.makeText(requireActivity(), "Messages fetched" + items.size(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireActivity(), "No messages", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}