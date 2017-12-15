package com.tangtuongco.apppppppppppp.model;

import java.io.Serializable;

/**
 * Created by Administrator on 08/12/2017.
 */

public class ChiTietBaiViet implements Serializable {
    private String video;
    private String IDChiTietBaiViet;
    private String IDCuaBaiViet;

    public ChiTietBaiViet() {
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getIDChiTietBaiViet() {
        return IDChiTietBaiViet;
    }

    public void setIDChiTietBaiViet(String IDChiTietBaiViet) {
        this.IDChiTietBaiViet = IDChiTietBaiViet;
    }

    public String getIDCuaBaiViet() {
        return IDCuaBaiViet;
    }

    public void setIDCuaBaiViet(String IDCuaBaiViet) {
        this.IDCuaBaiViet = IDCuaBaiViet;
    }

    public ChiTietBaiViet(String video, String IDChiTietBaiViet, String IDCuaBaiViet) {

        this.video = video;
        this.IDChiTietBaiViet = IDChiTietBaiViet;
        this.IDCuaBaiViet = IDCuaBaiViet;
    }
}
