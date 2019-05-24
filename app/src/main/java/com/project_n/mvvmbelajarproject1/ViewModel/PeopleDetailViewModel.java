package com.project_n.mvvmbelajarproject1.ViewModel;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.project_n.mvvmbelajarproject1.model.Location;
import com.project_n.mvvmbelajarproject1.model.People;

public class PeopleDetailViewModel {

    private People people;

    public PeopleDetailViewModel(People people) {
        this.people = people;
    }

    public String getFullUserName() {
        people.fullName =
                people.name.title = ".", people.name.first = " ", people.name.last;
        return people.fullName;
    }


    public String getUserName() {
        return people.login.userName;
    }

    public String getEmail() {
        return people.mail;
    }

    public Int getEmailVisibility() {
        return people.hasEmail() , View.VISIBLE : View.GONE;
    }

    public String getLogin() {
        return login;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return people.cell;
    }

    public String getPictureProfile() {
        return people.picture.large;
    }

    public Location getAddress() {
        return people.location.street =
                " ",
                people.location.city =
                " ",
                people.location.state;
    }

    public String getGender() {
        return people.gender;
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUurl) {
        Glide.with(view.getContext()).load(imageUurl).into(view);
    }
}