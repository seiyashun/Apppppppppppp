package com.tangtuongco.apppppppppppp.model;

/**
 * Created by Administrator on 12/12/2017.
 */

public class Host {
    private String TaiKhoanHost;
    private String MatKhauHost;

    public String getTaiKhoanHost() {
        return TaiKhoanHost;
    }

    public void setTaiKhoanHost(String taiKhoanHost) {
        TaiKhoanHost = taiKhoanHost;
    }

    public String getMatKhauHost() {
        return MatKhauHost;
    }

    public void setMatKhauHost(String matKhauHost) {
        MatKhauHost = matKhauHost;
    }

    public Host() {

    }

    public Host(String taiKhoanHost, String matKhauHost) {

        TaiKhoanHost = taiKhoanHost;
        MatKhauHost = matKhauHost;
    }
}
