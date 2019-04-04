package com.example.administrator.androidck;

import java.io.Serializable;

public class Sach implements Serializable{
    int id;
    String LoaiSach;
    String TenSach;
    String TacGia;
    String NXB;
    int SoLuongSach;

    public Sach(){

    }
    public Sach(int id,String loaiSach, String tenSach, String tacGia, String NXB, int soLuongSach) {
        this.id = id;
        LoaiSach = loaiSach;
        TenSach = tenSach;
        TacGia = tacGia;
        this.NXB = NXB;
        SoLuongSach = soLuongSach;
    }

    public Sach(String loaiSach, String tenSach, String tacGia, String NXB, int soLuongSach) {
        LoaiSach = loaiSach;
        TenSach = tenSach;
        TacGia = tacGia;
        this.NXB = NXB;
        SoLuongSach = soLuongSach;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String tacGia) {
        TacGia = tacGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaiSach() {
        return LoaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        LoaiSach = loaiSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public int getSoLuongSach() {
        return SoLuongSach;
    }

    public void setSoLuongSach(int soLuongSach) {
        SoLuongSach = soLuongSach;
    }
}
