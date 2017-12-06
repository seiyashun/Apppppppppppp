package com.tangtuongco.apppppppppppp.model;

import java.util.ArrayList;

/**
 * Created by Administrator on 06/12/2017.
 */

public class TheLoai {
    private String matheloai;
    private String tentheloai;
    private ArrayList<BaiViet> arrayListBaiViet;

    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public ArrayList<BaiViet> getArrayListBaiViet() {
        return arrayListBaiViet;
    }

    public void setArrayListBaiViet(ArrayList<BaiViet> arrayListBaiViet) {
        this.arrayListBaiViet = arrayListBaiViet;
    }

    public TheLoai(String matheloai, String tentheloai, ArrayList<BaiViet> arrayListBaiViet) {

        this.matheloai = matheloai;
        this.tentheloai = tentheloai;
        this.arrayListBaiViet = arrayListBaiViet;
    }
}
