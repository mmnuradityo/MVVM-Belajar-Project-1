package com.project_n.mvvmbelajarproject1.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project_n.mvvmbelajarproject1.R;
import com.project_n.mvvmbelajarproject1.ViewModel.ItemPeopleViewModel;
import com.project_n.mvvmbelajarproject1.databinding.ItemPeopleBinding;
import com.project_n.mvvmbelajarproject1.model.People;

import java.util.Collections;
import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.myViewHolder> {

    private List<People> peopleList;

    public PeopleAdapter() {
        this.peopleList = Collections.emptyList();
    }

    @NonNull
    @Override
    public PeopleAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemPeopleBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_people, viewGroup, false);
        return new myViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleAdapter.myViewHolder myViewHolder, int i) {
        myViewHolder.bindPeople(peopleList.get(i));
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
        notifyDataSetChanged();
    }

    static class myViewHolder extends RecyclerView.ViewHolder {

        private ItemPeopleBinding binding;

        public myViewHolder(@NonNull ItemPeopleBinding binding) {
            super(binding.itemPeople);
            this.binding = binding;
        }

        public void bindPeople(People people) {
            if (binding.getPeopleViewModel() == null) {
                binding.setPeopleViewModel(new ItemPeopleViewModel(people, itemView.getContext()));
            } else {
                binding.getPeopleViewModel().setPeople(people);
            }
        }
    }


}
