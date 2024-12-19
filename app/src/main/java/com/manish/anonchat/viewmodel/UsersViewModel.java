package com.manish.anonchat.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.manish.anonchat.model.Users;

public class UsersViewModel extends ViewModel {
    private MutableLiveData<Users> usersData;

    public UsersViewModel() {
        usersData = new MutableLiveData<>();
    }

    public void setUsersData(Users users) {
        usersData.setValue(users);
    }

    public LiveData<Users> getUsersData() {
        return usersData;
    }

    public void setUsername(String username) {
        if(usersData.getValue() != null) {
            Users updatedUsers = usersData.getValue();
            updatedUsers.setUsername(username);
            setUsersData(updatedUsers);
        }
    }
}
