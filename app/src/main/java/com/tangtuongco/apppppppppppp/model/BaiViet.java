package com.tangtuongco.apppppppppppp.model;

import java.util.ArrayList;

/**
 * Created by Administrator on 08/12/2017.
 */

public class BaiViet {
    private String iduser;
    private String idchude;
    private String IDBAIVIET;
    private String TenBaiViet;
    ChiTietBaiViet chiTietBaiViet;

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getIdchude() {
        return idchude;
    }

    public void setIdchude(String idchude) {
        this.idchude = idchude;
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

    public ChiTietBaiViet getChiTietBaiViet() {
        return chiTietBaiViet;
    }

    public void setChiTietBaiViet(ChiTietBaiViet chiTietBaiViet) {
        this.chiTietBaiViet = chiTietBaiViet;
    }

    public BaiViet() {

    }

    public BaiViet(String iduser, String idchude, String IDBAIVIET, String tenBaiViet, ChiTietBaiViet chiTietBaiViet) {

        this.iduser = iduser;
        this.idchude = idchude;
        this.IDBAIVIET = IDBAIVIET;
        TenBaiViet = tenBaiViet;
        this.chiTietBaiViet = chiTietBaiViet;
    }
}
