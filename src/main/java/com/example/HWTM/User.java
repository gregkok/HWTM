package com.example.HWTM;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String user_password;
    private String address;
    private String url;


    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.user_password = password;
    }

    public User(Long id,String firstName, String lastName, String userName, String email, String password, String address, String url) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.user_password = password;
        this.address = address;
        this.url = url;
    }
    public User(String firstName, String lastName, String userName, String email, String password, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.user_password = password;
        this.address = address;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
