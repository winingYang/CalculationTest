package com.surkaa.calculation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> leftNumber;
    private MutableLiveData<Character> operator;
    private MutableLiveData<Integer> rightNumber;
    private MutableLiveData<Integer> result;
    private MutableLiveData<Integer> score;

    public void generator(int level) {
        Random random = new Random();
        int left = random.nextInt(level) + 1;
        int right = left;
        while (right == left) {
            right = random.nextInt(level) + 1;
        }
        int max = Math.max(left, right);
        int min = Math.min(left, right);
        if (random.nextBoolean()) {
            getResult().setValue(max);
            getLeftNumber().setValue(min);
            getOperator().setValue('+');
            getRightNumber().setValue(max - min);
        } else {
            getResult().setValue(min);
            getLeftNumber().setValue(max);
            getOperator().setValue('-');
            getRightNumber().setValue(max - min);
        }
    }

    public MutableLiveData<Integer> getLeftNumber() {
        if (leftNumber == null) {
            leftNumber = new MutableLiveData<>();
            leftNumber.setValue(0);
        }
        return leftNumber;
    }

    public MutableLiveData<Character> getOperator() {
        if (operator == null) {
            operator = new MutableLiveData<>();
            operator.setValue('+');
        }
        return operator;
    }

    public MutableLiveData<Integer> getRightNumber() {
        if (rightNumber == null) {
            rightNumber = new MutableLiveData<>();
            rightNumber.setValue(0);
        }
        return rightNumber;
    }

    public MutableLiveData<Integer> getResult() {
        if (result == null) {
            result = new MutableLiveData<>();
            result.setValue(0);
        }
        return result;
    }

    public MutableLiveData<Integer> getScore() {
        if (score == null) {
            score = new MutableLiveData<>();
            score.setValue(0);
        }
        return score;
    }

}
