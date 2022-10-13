package com.surkaa.calculation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.surkaa.calculation.databinding.FragmentQuestionBinding;

public class QuestionFragment extends Fragment {
    final StringBuilder strUserResult = new StringBuilder();
    FragmentQuestionBinding binding;

    @Override
    @SuppressWarnings("ConstantConditions")
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //region 连接MyViewModel与QuestionFragment
        MyViewModel myViewModel;
        myViewModel = ViewModelProvider.AndroidViewModelFactory
                .getInstance(requireActivity().getApplication()).create(MyViewModel.class);
        binding = FragmentQuestionBinding.inflate(inflater, container, false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
        myViewModel.generator(10);
        //endregion

        //region 设置按键监听器
        binding.buttonOk.setOnClickListener(view -> {
            MutableLiveData<Integer> score = myViewModel.getScore();
            NavController controller = Navigation.findNavController(view);
            if (String.valueOf(myViewModel.getResult().getValue()).equals(strUserResult.toString()) || binding.switch1.isChecked()) {
                binding.tvUserResult.setText(getString(R.string.correct_message));
                score.setValue(score.getValue() + 1);
                myViewModel.generator(5 * score.getValue());
            } else {
                if (score.getValue() > MainActivity.highScore) {
                    MainActivity.highScore = score.getValue();
                    controller.navigate(R.id.action_questionFragment_to_winFragment);
                } else {
                    controller.navigate(R.id.action_questionFragment_to_loseFragment);
                }
            }
            strUserResult.setLength(0);
        });
        binding.buttonClear.setOnClickListener(view -> setListener());
        binding.button0.setOnClickListener(view -> setListener('0'));
        binding.button1.setOnClickListener(view -> setListener('1'));
        binding.button2.setOnClickListener(view -> setListener('2'));
        binding.button3.setOnClickListener(view -> setListener('3'));
        binding.button4.setOnClickListener(view -> setListener('4'));
        binding.button5.setOnClickListener(view -> setListener('5'));
        binding.button6.setOnClickListener(view -> setListener('6'));
        binding.button7.setOnClickListener(view -> setListener('7'));
        binding.button8.setOnClickListener(view -> setListener('8'));
        binding.button9.setOnClickListener(view -> setListener('9'));
        //endregion

        return binding.getRoot();
    }

    public void setListener(char ch) {
        strUserResult.append(ch);
        binding.tvUserResult.setText(strUserResult);
    }

    public void setListener() {
        strUserResult.setLength(0);
        binding.tvUserResult.setText(getString(R.string.question_your_answer));
    }

}