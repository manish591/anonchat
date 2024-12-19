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

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.manish.anonchat.R;
import com.manish.anonchat.databinding.FragmentUsernameBinding;
import com.manish.anonchat.model.Users;

public class Username extends Fragment {

    private FragmentUsernameBinding binding;
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private SharedPreferences sharedPref;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentUsernameBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPref = requireActivity().getSharedPreferences(SHARED_PREF_TABLE, MODE_PRIVATE);

        binding.createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.username.getText().toString();

                if(username.isEmpty()) {
                    Toast.makeText(requireActivity(), "Username can't be empty" + username, Toast.LENGTH_SHORT).show();
                    return;
                }

                Users newUser = new Users(username);

                db.collection("users").add(newUser).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        sharedPref.edit().putString(SHARED_PREF_KEY, newUser.getUsername()).apply();
                        NavHostFragment.findNavController(Username.this)
                                .navigate(R.id.Welcome);
                    }
                });
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}