package com.tangtuongco.apppppppppppp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 07/12/2017.
 */

public class User implements Serializable {
    private String ID;
    private String Password;
    private Date NgaySinh;
    private String DiaChi;
    private String SDT;
    private String Email;
    private String Name;
    ArrayList<BaiViet> listBaiViet;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<BaiViet> getListBaiViet() {
        return listBaiViet;
    }

    public void setListBaiViet(ArrayList<BaiViet> listBaiViet) {
        this.listBaiViet = listBaiViet;
    }

    public User() {

    }

    public User(String ID, String password, Date ngaySinh, String diaChi, String SDT, String email, String name, ArrayList<BaiViet> listBaiViet) {

        this.ID = ID;
        Password = password;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        this.SDT = SDT;
        Email = email;
        Name = name;
        this.listBaiViet = listBaiViet;
    }
}
