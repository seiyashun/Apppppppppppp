package com.tangtuongco.apppppppppppp.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 08/12/2017.
 */

public class BaiViet implements Serializable {
    private String iduser;
    private String tenchude;
    private String IDBAIVIET;
    private String ImageIndex;
    private String TenBaiViet;
    private String time;
    ChiTietBaiViet chiTietBaiViet;

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getTenchude() {
        return tenchude;
    }

    public void setTenchude(String tenchude) {
        this.tenchude = tenchude;
    }

    public String getIDBAIVIET() {
        return IDBAIVIET;
    }

    public void setIDBAIVIET(String IDBAIVIET) {
        this.IDBAIVIET = IDBAIVIET;
    }

    public String getImageIndex() {
        return ImageIndex;
    }

    public void setImageIndex(String imageIndex) {
        ImageIndex = imageIndex;
    }

    public String getTenBaiViet() {
        return TenBaiViet;
    }

    public void setTenBaiViet(String tenBaiViet) {
        TenBaiViet = tenBaiViet;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ChiTietBaiViet getChiTietBaiViet() {
        return chiTietBaiViet;
    }

    public void setChiTietBaiViet(ChiTietBaiViet chiTietBaiViet) {
        this.chiTietBaiViet = chiTietBaiViet;
    }

    public BaiViet() {

    }

    public BaiViet(String iduser, String tenchude, String IDBAIVIET, String imageIndex, String tenBaiViet, String time, ChiTietBaiViet chiTietBaiViet) {

        this.iduser = iduser;
        this.tenchude = tenchude;
        this.IDBAIVIET = IDBAIVIET;
        ImageIndex = imageIndex;
        TenBaiViet = tenBaiViet;
        this.time = time;
        this.chiTietBaiViet = chiTietBaiViet;
    }
}
