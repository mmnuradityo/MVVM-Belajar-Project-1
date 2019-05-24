package com.project_n.mvvmbelajarproject1.ViewModel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.v4.util.Consumer;
import android.view.View;

import com.project_n.mvvmbelajarproject1.R;
import com.project_n.mvvmbelajarproject1.model.People;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class PeopleViewModel extends Observable {

    public ObservableInt peopleProgress;
    public ObservableInt peopleRecyecler;
    public ObservableInt peopleLable;
    public ObservableField<String> messageLable;

    private List<People> peopleList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public PeopleViewModel(@NonNull Context context) {
        this.context = context;
        this.peopleList = new ArrayList<>();
        peopleProgress = new ObservableInt(View.GONE);
        peopleRecyecler = new ObservableInt(View.GONE);
        peopleLable= new ObservableInt(View.VISIBLE);
        messageLable = new ObservableField<>(context.getString(R.string.default_loading_people));
    }

    public void onClickFabLoad(View view) {
        initializeViews();
        fetchPeopleList();
    }

    private void initializeViews() {
        peopleLable.set(View.GONE);
        peopleRecyecler.set(View.GONE);
        peopleProgress.set(View.VISIBLE);
    }

    private void fetchPeopleList() {

        PeopleApplication peopleApplication = new PeopleApplication.create(context);
        PeopleService peopleService  = new PeopleService.getPeopleService();

        Disposable disposable = peopleService.fetchPeople(10, "en")
                .subscribeOn(peopleApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PeopleResponse>() {
                    @Override public void accept(PeopleResponse peopleResponse) {
                        changePeopleDataSet(PeopleResponse.getPeopleList());
                        peopleLable.set(View.GONE);
                        peopleRecyecler.set(View.VISIBLE);
                        peopleProgress.set(View.GONE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        messageLable.set(context.getString(R.string.error_loading_people));
                        peopleLable.set(View.VISIBLE);
                        peopleRecyecler.set(View.GONE);
                        peopleProgress.set(View.GONE);
                    }
                });

        compositeDisposable.add(disposable);
    }

    private void changePeopleDataSet(List<People> peoples) {
        peopleList.addAll(peoples);
        setChanged();
        notifyObservers();
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    private void unSubscribwFromObservable() {
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset() {
        unSubscribwFromObservable();
        compositeDisposable = null;
        context = null;
    }
}
