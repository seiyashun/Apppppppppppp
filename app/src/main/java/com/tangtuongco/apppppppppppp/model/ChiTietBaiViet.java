package com.tangtuongco.apppppppppppp.model;

import java.util.ArrayList;

/**
 * Created by Administrator on 06/12/2017.
 */

public class ChiTietBaiViet {
    private String mabaiviet;
    private String noidung;
    private String video;
    private ArrayList<BinhLuan> binhluan;

    public ChiTietBaiViet(String mabaiviet, String noidung, String video, ArrayList<BinhLuan> binhluan) {
        this.mabaiviet = mabaiviet;
        this.noidung = noidung;
        this.video = video;
        this.binhluan = binhluan;
    }

    public String getMabaiviet() {

        return mabaiviet;
    }

    public void setMabaiviet(String mabaiviet) {
        this.mabaiviet = mabaiviet;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public ArrayList<BinhLuan> getBinhluan() {
        return binhluan;
    }

    public void setBinhluan(ArrayList<BinhLuan> binhluan) {
        this.binhluan = binhluan;
    }
}
