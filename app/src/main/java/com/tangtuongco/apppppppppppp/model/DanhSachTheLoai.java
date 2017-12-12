package com.tangtuongco.apppppppppppp.model;

/**
 * Created by Administrator on 12/12/2017.
 */

public class DanhSachTheLoai {
    private String MaTheLoai;
    private String TenTheLoai;

    public String getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        MaTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        TenTheLoai = tenTheLoai;
    }

    public DanhSachTheLoai() {

    }

    public DanhSachTheLoai(String maTheLoai, String tenTheLoai) {
        MaTheLoai = maTheLoai;
        TenTheLoai = tenTheLoai;
    }
}
