package com.project_n.mvvmbelajarproject1.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements BaseInterface.baseActivityInterface {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayout() != 0) {
            setContentView(getLayout());
        }
        initComponenet(savedInstanceState);
        findView();
        initView();
        listener();
        setData();
    }


}
