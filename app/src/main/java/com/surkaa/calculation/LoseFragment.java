package com.surkaa.calculation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.surkaa.calculation.databinding.FragmentLoseBinding;

public class LoseFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel myViewModel;
        myViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication()).create(MyViewModel.class);
        FragmentLoseBinding binding = FragmentLoseBinding.inflate(inflater, container, false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
        binding.loseBack.setOnClickListener(v -> {
            NavController controller = Navigation.findNavController(v);
            controller.navigate(R.id.titleFragment);
        });
        return binding.getRoot();
    }
}