package com.tangtuongco.apppppppppppp.model;

/**
 * Created by Administrator on 30/11/2017.
 */

public class Admin extends Account{
    public String getNameAdmin() {
        return NameAdmin;
    }

    public void setNameAdmin(String nameAdmin) {
        NameAdmin = nameAdmin;
    }

    public Admin(String ID, String password, String nameAdmin) {

        super(ID, password);
        NameAdmin = nameAdmin;
    }

    private String NameAdmin;

    public Admin(String ID, String password) {
        super(ID, password);
    }
}
