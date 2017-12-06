package com.tangtuongco.apppppppppppp.model;

import java.io.Serializable;

/**
 * Created by Administrator on 06/12/2017.
 */

public class Account implements Serializable {
    private String ID;
    private String PASSWORD;

    public Account() {
    }

    public Account(String ID, String PASSWORD) {

        this.ID = ID;
        this.PASSWORD = PASSWORD;
    }

    public String getID() {

        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
