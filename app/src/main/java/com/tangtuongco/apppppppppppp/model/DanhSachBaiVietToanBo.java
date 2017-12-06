package com.tangtuongco.apppppppppppp.model;

import java.util.ArrayList;

/**
 * Created by Administrator on 06/12/2017.
 */

public class DanhSachBaiVietToanBo {
    private ArrayList<BaiViet> arrayListBaiVietToanBo;
    private String tennguoiviet;

    public DanhSachBaiVietToanBo() {
    }

    public ArrayList<BaiViet> getArrayListBaiVietToanBo() {

        return arrayListBaiVietToanBo;
    }

    public void setArrayListBaiVietToanBo(ArrayList<BaiViet> arrayListBaiVietToanBo) {
        this.arrayListBaiVietToanBo = arrayListBaiVietToanBo;
    }

    public String getTennguoiviet() {
        return tennguoiviet;
    }

    public void setTennguoiviet(String tennguoiviet) {
        this.tennguoiviet = tennguoiviet;
    }

    public DanhSachBaiVietToanBo(ArrayList<BaiViet> arrayListBaiVietToanBo, String tennguoiviet) {

        this.arrayListBaiVietToanBo = arrayListBaiVietToanBo;
        this.tennguoiviet = tennguoiviet;
    }
}
