package com.example.appli_math.ui.pythagoras;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PythagorasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PythagorasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}