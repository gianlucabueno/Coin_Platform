package com.system.platform.dtos;

import com.system.platform.entities.Account;
import com.system.platform.entities.User;
import com.system.platform.entities.UserStatus;

import java.io.Serial;
import java.io.Serializable;

public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;
    private String password;

    private UserStatus status;

    private Account account;

    private int coins;

    private int vouchers;

    private int totalCourses;

    public UserDTO(){

    }

    public UserDTO(User obj){
        id = obj.getId();
        name = obj.getName();
        email= obj.getEmail();
        password= obj.getPassword();
        status = obj.getStatus();
        account = obj.getAccount();
        coins = obj.getCoins();
        vouchers = obj.getCoins();
        totalCourses = obj.getTotalCourses();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public UserStatus getStatus() {
        return status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getVouchers() {
        return vouchers;
    }

    public void setVouchers(int vouchers) {
        this.vouchers = vouchers;
    }

    public int getTotalCourses() {
        return totalCourses;
    }

    public void setTotalCourses(int totalCourses) {
        this.totalCourses = totalCourses;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
