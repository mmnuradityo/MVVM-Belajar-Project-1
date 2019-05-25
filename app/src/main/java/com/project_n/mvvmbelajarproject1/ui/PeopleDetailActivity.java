package com.project_n.mvvmbelajarproject1.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import com.project_n.mvvmbelajarproject1.R;
import com.project_n.mvvmbelajarproject1.ViewModel.PeopleDetailViewModel;
import com.project_n.mvvmbelajarproject1.databinding.ActivityPeopleDetailBinding;
import com.project_n.mvvmbelajarproject1.model.People;
import com.project_n.mvvmbelajarproject1.ui.base.BaseActivity;

public class PeopleDetailActivity extends BaseActivity {

    private static final String EXTRA_PEOPLE = "EXTRA_PEOPLE";
    private ActivityPeopleDetailBinding peopleDetailBinding;

    public static String launchDetail(Context context) {
        return null;
    }

    @Override
    public int getLayout() {
        return 0;
    }

    @Override
    public void initComponenet(Bundle savedInstanceState) {
        peopleDetailBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_people_detail);
        setSupportActionBar(peopleDetailBinding.toolbar);
        displayHomeAsUoEnabled();
        getExtrasFromIntent();
    }

    @Override
    public void findView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void listener() {

    }

    @Override
    public void setData() {

    }

    public static Intent launchDetail(Context context, People people) {
        Intent i = new Intent(context, PeopleDetailActivity.class);
        i.putExtra(EXTRA_PEOPLE, people);
        return i;
    }

    private void getExtrasFromIntent() {
        People people = (People) getIntent().getSerializableExtra(EXTRA_PEOPLE);
        PeopleDetailViewModel peopleDetailViewModel = new PeopleDetailViewModel(people);
        peopleDetailBinding.setPeopleDetailViewModel(peopleDetailViewModel);
        setTitle(people.name.title+"."+people.name.first+" "+people.name.last);
    }

    private void displayHomeAsUoEnabled() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
