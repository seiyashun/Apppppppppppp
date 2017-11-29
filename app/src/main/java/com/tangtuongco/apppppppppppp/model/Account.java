package com.tangtuongco.apppppppppppp.model;

/**
 * Created by Administrator on 30/11/2017.
 */

public class Account {
    private String ID;
    private String Password;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Account(String ID, String password) {

        this.ID = ID;
        Password = password;
    }
}
