package com.manish.anonchat.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.manish.anonchat.model.Users;

import java.sql.Timestamp;

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

    public void setDateOfBirth(Timestamp dob) {
        if(usersData.getValue() != null) {
            Users updatedUsers = usersData.getValue();
            updatedUsers.setDOB(dob);
            setUsersData(updatedUsers);
        }
    }

    public void setUsername(String username) {
        if(usersData.getValue() != null) {
            Users updatedUsers = usersData.getValue();
            updatedUsers.setUsername(username);
            setUsersData(updatedUsers);
        }
    }

    public void setUserId(String user_id) {
        if(usersData.getValue() != null) {
            Users updatedUsers = usersData.getValue();
            updatedUsers.setUserId(user_id);
            setUsersData(updatedUsers);
        }
    }
}
