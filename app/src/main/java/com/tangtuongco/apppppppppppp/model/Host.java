package com.tangtuongco.apppppppppppp.model;

/**
 * Created by Administrator on 30/11/2017.
 */

public class Host {
    private String IDHost;
    private String PassHost;

    public String getIDHost() {
        return IDHost;
    }

    public void setIDHost(String IDHost) {
        this.IDHost = IDHost;
    }

    public String getPassHost() {
        return PassHost;
    }

    public void setPassHost(String passHost) {
        PassHost = passHost;
    }

    public Host(String IDHost, String passHost) {

        this.IDHost = IDHost;
        PassHost = passHost;
    }
}
