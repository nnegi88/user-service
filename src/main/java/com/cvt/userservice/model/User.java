package com.cvt.userservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection = "user")
public class User {
    @Id
    private String userId;
    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String userName;
    @NotNull(message = "Email should have a value")
    private String email;
    @NotNull(message = "Phone number should have a value")
    private String phoneNo;

    public User(){ }

    public User(String userId, String userName, String email, String phoneNo) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
