package com.project_n.mvvmbelajarproject1.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseInterface {

    interface baseActivityInterface extends componentActivity {
        int getLayout();
        void initComponenet(Bundle savedInstanceState);
        void findView();
    }

    interface baseFragmentInterface extends componentActivity {
        int getLayout();
        View binding();
        void initComponent(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
        void findView(View v);
    }

    interface componentActivity {
        void initView();
        void listener();
        void setData();
    }


}
