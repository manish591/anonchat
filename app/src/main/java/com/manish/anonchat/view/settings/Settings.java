package com.manish.anonchat.view.settings;

import static android.content.Context.MODE_PRIVATE;
import static com.manish.anonchat.view.MainActivity.SHARED_PREF_KEY;
import static com.manish.anonchat.view.MainActivity.SHARED_PREF_TABLE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.manish.anonchat.R;
import com.manish.anonchat.databinding.FragmentSettingsBinding;

public class Settings extends Fragment {
    private FragmentSettingsBinding binding;
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private SharedPreferences sharedPref;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPref = requireActivity().getSharedPreferences(SHARED_PREF_TABLE, MODE_PRIVATE);

        binding.backButton.setOnClickListener(v -> {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.action_settings_to_homeViewPager);
        });

        binding.deleteAccount.setOnClickListener(v -> {
            db.collection("users").document(sharedPref.getString(SHARED_PREF_KEY, "")).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    sharedPref.edit().remove(SHARED_PREF_KEY).apply();
                    Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.action_settingsFragment_to_onboardingViewPager);
                }
            });
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}