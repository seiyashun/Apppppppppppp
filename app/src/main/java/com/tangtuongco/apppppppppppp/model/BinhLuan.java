package com.tangtuongco.apppppppppppp.model;

import java.io.Serializable;

/**
 * Created by Administrator on 15/12/2017.
 */

public class BinhLuan implements Serializable {
    private String IDBaiViet;
    private String IDNguoiBinhLuan;
    private String NoiDungBinhLuan;

    public BinhLuan() {
    }

    public String getIDBaiViet() {

        return IDBaiViet;
    }

    public void setIDBaiViet(String IDBaiViet) {
        this.IDBaiViet = IDBaiViet;
    }

    public String getIDNguoiBinhLuan() {
        return IDNguoiBinhLuan;
    }

    public void setIDNguoiBinhLuan(String IDNguoiBinhLuan) {
        this.IDNguoiBinhLuan = IDNguoiBinhLuan;
    }

    public String getNoiDungBinhLuan() {
        return NoiDungBinhLuan;
    }

    public void setNoiDungBinhLuan(String noiDungBinhLuan) {
        NoiDungBinhLuan = noiDungBinhLuan;
    }

    public BinhLuan(String IDBaiViet, String IDNguoiBinhLuan, String noiDungBinhLuan) {

        this.IDBaiViet = IDBaiViet;
        this.IDNguoiBinhLuan = IDNguoiBinhLuan;
        NoiDungBinhLuan = noiDungBinhLuan;
    }
}
