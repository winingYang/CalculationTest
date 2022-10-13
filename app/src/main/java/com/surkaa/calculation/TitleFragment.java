package com.surkaa.calculation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.surkaa.calculation.databinding.FragmentTitleBinding;

public class TitleFragment extends Fragment {

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel myViewModel;
        myViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication()).create(MyViewModel.class);
        FragmentTitleBinding binding = FragmentTitleBinding.inflate(inflater, container, false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
        binding.buttonEnter.setOnClickListener(v -> {
            NavController controller = Navigation.findNavController(v);
            controller.navigate(R.id.action_titleFragment_to_questionFragment);
        });
        binding.tvTitleScore.setText(getString(R.string.title_high_score_message) + MainActivity.highScore);
        return binding.getRoot();
    }
}