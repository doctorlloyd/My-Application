package com.example.doc.final_project.pojos;

/**
 * Created by Admin on 2017/02/16.
 */

public class Client {
    private String userName;
    private String email;
    private String contact;
    private String password;
    private String address;

    public Client(String address, String contact, String email, String password, String userName) {
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public Client(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public Client() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
