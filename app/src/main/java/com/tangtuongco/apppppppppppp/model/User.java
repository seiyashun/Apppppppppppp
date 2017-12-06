package com.tangtuongco.apppppppppppp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 30/11/2017.
 */

public class User extends Account implements Serializable {

  private String Name;
  private String Email;
  private Date NgaySinh;
  private String SoDienThoai;
  private String DiaChi;
  private ArrayList<BaiViet> arrayListBaiViet;

    public User(String ID, String PASSWORD, String name, String email, Date ngaySinh, String soDienThoai, String diaChi, ArrayList<BaiViet> arrayListBaiViet) {
        super(ID, PASSWORD);
        Name = name;
        Email = email;
        NgaySinh = ngaySinh;
        SoDienThoai = soDienThoai;
        DiaChi = diaChi;
        this.arrayListBaiViet = arrayListBaiViet;
    }

    public User() {

    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public ArrayList<BaiViet> getArrayListBaiViet() {
        return arrayListBaiViet;
    }

    public void setArrayListBaiViet(ArrayList<BaiViet> arrayListBaiViet) {
        this.arrayListBaiViet = arrayListBaiViet;
    }
}
