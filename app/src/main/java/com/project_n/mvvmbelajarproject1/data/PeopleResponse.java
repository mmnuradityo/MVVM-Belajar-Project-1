package com.project_n.mvvmbelajarproject1.data;

import com.google.gson.annotations.SerializedName;
import com.project_n.mvvmbelajarproject1.model.People;

import java.util.List;

public class PeopleResponse {

    @SerializedName("results")
    private List<People> peopleList;

    public List<People> getPeopleList() {
        return peopleList;
    }
}