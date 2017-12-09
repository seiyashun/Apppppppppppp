package com.tangtuongco.apppppppppppp.model;

import java.util.List;

/**
 * Created by Administrator on 08/12/2017.
 */

public class ListBaiVietCaNhan {
    private String iduser;
    private String idbaiviet;

    public ListBaiVietCaNhan() {
    }

    public String getIduser() {

        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getIdbaiviet() {
        return idbaiviet;
    }

    public void setIdbaiviet(String idbaiviet) {
        this.idbaiviet = idbaiviet;
    }

    public List<BaiViet> getListBaiViet() {
        return listBaiViet;
    }

    public void setListBaiViet(List<BaiViet> listBaiViet) {
        this.listBaiViet = listBaiViet;
    }

    public ListBaiVietCaNhan(String iduser, String idbaiviet, List<BaiViet> listBaiViet) {

        this.iduser = iduser;
        this.idbaiviet = idbaiviet;
        this.listBaiViet = listBaiViet;
    }

    List<BaiViet> listBaiViet;
}
