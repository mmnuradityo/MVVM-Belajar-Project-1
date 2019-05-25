package com.project_n.mvvmbelajarproject1.data;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PeopleService {

    @GET("people")
    Observable<PeopleResponse> fetchPeople(
            @Query("results") int page,
            @Query("nat") String nat
    );
    
}