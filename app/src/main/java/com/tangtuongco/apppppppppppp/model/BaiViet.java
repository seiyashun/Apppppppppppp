package com.tangtuongco.apppppppppppp.model;

/**
 * Created by Administrator on 08/12/2017.
 */

public class BaiViet {
    private String iduser;

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    private String IDBAIVIET;
    private String TenBaiViet;

    public BaiViet() {
    }

    public String getIDBAIVIET() {

        return IDBAIVIET;
    }

    public void setIDBAIVIET(String IDBAIVIET) {
        this.IDBAIVIET = IDBAIVIET;
    }

    public String getTenBaiViet() {
        return TenBaiViet;
    }

    public void setTenBaiViet(String tenBaiViet) {
        TenBaiViet = tenBaiViet;
    }

    public BaiViet(String iduser, String IDBAIVIET, String tenBaiViet) {
        this.iduser = iduser;
        this.IDBAIVIET = IDBAIVIET;
        TenBaiViet = tenBaiViet;
    }
}
