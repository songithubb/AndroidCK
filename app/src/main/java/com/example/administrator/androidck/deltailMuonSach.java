package com.example.administrator.androidck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

public class deltailMuonSach extends AppCompatActivity{
    TextView txtTenNguoiMuon;
    TextView txtTenSach;
    TextView txtLoaiSach;
    TextView txtNXB;
    TextView txtSL;
    TextView txtNgayMuonSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muon_sach_detail_layout);
        onIt();
        onGetIn();
    }

    private void onGetIn() {
        Intent intent = getIntent();
        NguoiMuon item = (NguoiMuon) intent.getSerializableExtra("itemMuonSach");
        txtTenNguoiMuon.setText(item.getTenNguoiMuon());
        txtTenSach.setText(item.getTenSach());
        txtLoaiSach.setText(item.getLoaiSach());
        txtNXB.setText(item.getNXB());
        txtSL.setText(item.getSoLuong()+"");
        txtNgayMuonSach.setText(item.getNgayMuon());
    }

    private void onIt() {
        txtTenNguoiMuon = (TextView)findViewById(R.id.txt_Detail_NguoiMuon);
        txtTenSach = (TextView)findViewById(R.id.txt_Detail_TenSach);
        txtLoaiSach = (TextView)findViewById(R.id.txt_Detail_LoaiSach);
        txtNXB = (TextView)findViewById(R.id.txt_Detail_NXB);
        txtSL = (TextView)findViewById(R.id.txt_Detail_SL);
        txtNgayMuonSach = (TextView)findViewById(R.id.txt_Detailngaymuon);
    }
}
