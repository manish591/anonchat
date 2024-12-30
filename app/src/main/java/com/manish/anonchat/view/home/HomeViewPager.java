package com.manish.anonchat.view.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manish.anonchat.R;
import com.manish.anonchat.databinding.FragmentHomeViewPagerBinding;
import com.manish.anonchat.view.onboarding.GetStarted;
import com.manish.anonchat.view.onboarding.Username;
import com.manish.anonchat.view.onboarding.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeViewPager extends Fragment {
    FragmentHomeViewPagerBinding binding;

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.viewPlay.setOnClickListener(v -> {
           binding.homeViewPager.setCurrentItem(0, true);
        });

        binding.viewMessages.setOnClickListener(v -> {
            binding.homeViewPager.setCurrentItem(1, true);
        });

        binding.settingsBtn.setOnClickListener(v -> {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.action_homeViewPager_to_settings);
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeViewPagerBinding.inflate(inflater, container, false);

        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new Welcome());
        fragmentList.add(new Messages());

        binding.homeViewPager.setAdapter(new ViewPagerAdapter(this, fragmentList));

        return binding.getRoot();
    }
}