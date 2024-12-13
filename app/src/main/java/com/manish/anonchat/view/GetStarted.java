package com.manish.anonchat.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.manish.anonchat.R;
import com.manish.anonchat.databinding.FragmentGetStartedBinding;

public class GetStarted extends Fragment {

    private FragmentGetStartedBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentGetStartedBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.getStarted.setOnClickListener(v ->
                NavHostFragment.findNavController(GetStarted.this)
                        .navigate(R.id.action_GetStarted_to_Username)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}