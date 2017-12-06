package com.tangtuongco.apppppppppppp.model;

import java.util.ArrayList;

/**
 * Created by Administrator on 06/12/2017.
 */

public class BaiViet {
    private String mabaiviet;
    private String matheloai;
    private String hinhanh;

    public BaiViet() {
    }

    public String getMabaiviet() {

        return mabaiviet;
    }

    public void setMabaiviet(String mabaiviet) {
        this.mabaiviet = mabaiviet;
    }

    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public ChiTietBaiViet getChiTietBaiViet() {
        return chiTietBaiViet;
    }

    public void setChiTietBaiViet(ChiTietBaiViet chiTietBaiViet) {
        this.chiTietBaiViet = chiTietBaiViet;
    }

    public BaiViet(String mabaiviet, String matheloai, String hinhanh, ChiTietBaiViet chiTietBaiViet) {

        this.mabaiviet = mabaiviet;
        this.matheloai = matheloai;
        this.hinhanh = hinhanh;
        this.chiTietBaiViet = chiTietBaiViet;
    }

    private ChiTietBaiViet chiTietBaiViet;


}
