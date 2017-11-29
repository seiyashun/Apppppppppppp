package com.tangtuongco.apppppppppppp.model;

import java.util.Date;

/**
 * Created by Administrator on 30/11/2017.
 */

public class User extends Account {
  private String Name;
  private String Email;
  private Date NgaySinh;
  private String SoDienThoai;
  private String DiaChi;

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

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
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

    public User(String ID, String password, String name, String email, String diaChi, Date ngaySinh, String soDienThoai, String diaChi1) {
        super(ID, password);
        Name = name;

        Email = email;
        DiaChi = diaChi;
        NgaySinh = ngaySinh;
        SoDienThoai = soDienThoai;
        DiaChi = diaChi1;
    }

    public User(String ID, String password) {
        super(ID, password);
    }
}
