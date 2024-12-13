package com.manish.anonchat.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manish.anonchat.R;
import com.manish.anonchat.databinding.FragmentGetStartedBinding;
import com.manish.anonchat.databinding.FragmentUsernameBinding;

public class Username extends Fragment {

    private FragmentUsernameBinding binding;

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

        binding.createAccount.setOnClickListener(v ->
                NavHostFragment.findNavController(Username.this)
                        .navigate(R.id.action_GetStarted_to_DOB)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}