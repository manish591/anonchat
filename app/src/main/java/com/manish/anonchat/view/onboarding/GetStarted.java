package com.manish.anonchat.view.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

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

        binding.getStarted.setOnClickListener(v -> {
            ViewPager2 viewPager2 = requireActivity().findViewById(R.id.onboardingViewPager);
            viewPager2.setCurrentItem(1, true);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}