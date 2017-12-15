package com.tangtuongco.apppppppppppp.model;

import java.io.Serializable;

/**
 * Created by Administrator on 08/12/2017.
 */

public class ChuDe implements Serializable {
    private String idcd;
    private String TenChuDe;

    public String getIdcd() {
        return idcd;
    }

    public void setIdcd(String idcd) {
        this.idcd = idcd;
    }

    public String getTenChuDe() {
        return TenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        TenChuDe = tenChuDe;
    }

    public ChuDe() {

    }

    public ChuDe(String idcd, String tenChuDe) {

        this.idcd = idcd;
        TenChuDe = tenChuDe;
    }
}
