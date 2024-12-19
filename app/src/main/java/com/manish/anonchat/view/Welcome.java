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
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.manish.anonchat.R;
import com.manish.anonchat.databinding.FragmentWelcomeBinding;

import java.util.Map;

public class Welcome extends Fragment {

    private FragmentWelcomeBinding binding;
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.viewMessages.setOnClickListener(v ->
                NavHostFragment.findNavController(Welcome.this)
                        .navigate(R.id.action_Welcome_to_Messages)
        );

        getUserData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void getUserData() {
        SharedPreferences sharedPref = requireActivity().getSharedPreferences(SHARED_PREF_TABLE, MODE_PRIVATE);
        String username = sharedPref.getString(SHARED_PREF_KEY, null);

        if(username != null) {
            db.collection("users").whereEqualTo("username", username).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    if (!queryDocumentSnapshots.isEmpty()) {
                        String username = queryDocumentSnapshots.getDocuments().get(0).getString("username");
                        binding.link.setText("https://anon-chat-web.vercel.app/" + username);
                    } else {
                        Toast.makeText(requireActivity(), "User not found", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(requireActivity(), "Error occured", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}