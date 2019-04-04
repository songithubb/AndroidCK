package com.example.administrator.androidck;

import java.io.Serializable;
import java.security.PublicKey;

public class NguoiMuon implements Serializable {

    public int ID;
    public String TenNguoiMuon;
    public String TenSach;
    public String LoaiSach;
    public String NXB;
    public int SoLuong;
    public String NgayMuon;
    public NguoiMuon(){}

    public NguoiMuon(int ID, String tenNguoiMuon, String tenSach, String loaiSach, String NXB, int soLuong, String ngayMuon) {
        this.ID = ID;
        TenNguoiMuon = tenNguoiMuon;
        TenSach = tenSach;
        LoaiSach = loaiSach;
        this.NXB = NXB;
        SoLuong = soLuong;
        NgayMuon = ngayMuon;
    }

    public NguoiMuon(String tenNguoiMuon, String tenSach, String loaiSach, String NXB, int soLuong, String ngayMuon) {
        TenNguoiMuon = tenNguoiMuon;
        TenSach = tenSach;
        LoaiSach = loaiSach;
        this.NXB = NXB;
        SoLuong = soLuong;
        NgayMuon = ngayMuon;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        NgayMuon = ngayMuon;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenNguoiMuon() {
        return TenNguoiMuon;
    }

    public void setTenNguoiMuon(String tenNguoiMuon) {
        TenNguoiMuon = tenNguoiMuon;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public String getLoaiSach() {
        return LoaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        LoaiSach = loaiSach;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
}
