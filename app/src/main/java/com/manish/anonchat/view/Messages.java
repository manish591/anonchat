package com.manish.anonchat.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manish.anonchat.R;
import com.manish.anonchat.databinding.FragmentMessagesBinding;
import com.manish.anonchat.databinding.FragmentWelcomeBinding;

public class Messages extends Fragment {

    private FragmentMessagesBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentMessagesBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.getMessages.setOnClickListener(v ->
                NavHostFragment.findNavController(Messages.this)
                        .navigate(R.id.action_Messages_to_Welcome)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}