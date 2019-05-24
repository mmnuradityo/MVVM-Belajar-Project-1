package com.project_n.mvvmbelajarproject1.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment implements BaseInterface.baseFragmentInterface {

    private View v;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getLayout() != 0) {
            v = inflater.inflate(getLayout(), container, false);
            initComponent(inflater, container, savedInstanceState);
        } else {
            initComponent(inflater, container, savedInstanceState);
            v = binding();
        }
        findView(v);
        initView();
        listener();
        setData();
        return v;
    }


}
