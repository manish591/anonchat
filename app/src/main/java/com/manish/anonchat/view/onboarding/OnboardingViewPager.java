package com.manish.anonchat.view.onboarding;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manish.anonchat.databinding.FragmentOnboardingViewPagerBinding;

import java.util.ArrayList;
import java.util.List;

public class OnboardingViewPager extends Fragment {
    private FragmentOnboardingViewPagerBinding binding;

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentOnboardingViewPagerBinding.inflate(inflater, container, false);

        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new GetStarted());
        fragmentList.add(new Username());

        binding.onboardingViewPager.setUserInputEnabled(false);
        binding.onboardingViewPager.setAdapter(new ViewPagerAdapter(this, fragmentList));

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}