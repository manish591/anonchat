package com.manish.anonchat.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manish.anonchat.R;
import com.manish.anonchat.databinding.FragmentWelcomeBinding;

public class Welcome extends Fragment {

    private FragmentWelcomeBinding binding;

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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}