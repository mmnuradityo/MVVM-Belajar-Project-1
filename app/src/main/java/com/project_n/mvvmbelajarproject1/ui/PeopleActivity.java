package com.project_n.mvvmbelajarproject1.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.project_n.mvvmbelajarproject1.R;
import com.project_n.mvvmbelajarproject1.ViewModel.PeopleViewModel;
import com.project_n.mvvmbelajarproject1.databinding.ActivityPeopleBinding;
import com.project_n.mvvmbelajarproject1.model.People;
import com.project_n.mvvmbelajarproject1.ui.adapter.PeopleAdapter;
import com.project_n.mvvmbelajarproject1.ui.base.BaseActivity;

import java.util.Observable;
import java.util.Observer;

public class PeopleActivity extends BaseActivity implements Observer {

    private ActivityPeopleBinding peopleBinding;
    private PeopleViewModel peopleViewModel;

    @Override
    public int getLayout() {
        return 0;
    }

    @Override
    public void initComponenet(Bundle savedInstanceState) {
        peopleBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_people);
        setSupportActionBar(peopleBinding.toolbar);
        peopleViewModel = new PeopleViewModel(this);
        peopleBinding.setMainViewModel(peopleViewModel);
        setSupportActionBar(peopleBinding.toolbar);
    }

    @Override
    public void findView() {

    }

    @Override
    public void initView() {
        PeopleAdapter adapter = new PeopleAdapter();
        peopleBinding.listPeople.setAdapter(adapter);
        peopleBinding.listPeople.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void listener() {

    }

    @Override
    public void setData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        peopleViewModel.reset();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof  PeopleViewModel) {
            PeopleAdapter adapter = (PeopleAdapter) peopleBinding.listPeople.getAdapter();
            PeopleViewModel peopleViewModel = (PeopleViewModel) observable;
            assert adapter == null;
            adapter.setPeopleList(peopleViewModel.getPeopleList());
        }
    }


}
