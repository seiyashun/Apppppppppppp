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
    private int PhanLoai; //1 là người dùng , 2 là admin
    private String Email;
    private String Name;
    private String time;
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

    public int getPhanLoai() {
        return PhanLoai;
    }

    public void setPhanLoai(int phanLoai) {
        PhanLoai = phanLoai;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<BaiViet> getListBaiViet() {
        return listBaiViet;
    }

    public void setListBaiViet(ArrayList<BaiViet> listBaiViet) {
        this.listBaiViet = listBaiViet;
    }

    public User() {

    }

    public User(String ID, String password, Date ngaySinh, String diaChi, String SDT, int phanLoai, String email, String name, String time, ArrayList<BaiViet> listBaiViet) {

        this.ID = ID;
        Password = password;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        this.SDT = SDT;
        PhanLoai = phanLoai;
        Email = email;
        Name = name;
        this.time = time;
        this.listBaiViet = listBaiViet;
    }




}
