package com.example.administrator.androidck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.administrator.androidck.FragmentListMuonSach.ListNguoiMuon;
import static com.example.administrator.androidck.FragmentListMuonSach.adapter;

public class addNewNguoiMuon extends AppCompatActivity {
    EditText edtTenNguoiMuon, edtTenSach, edtLoaiSach, edtNXB, edtNgayMuonSach, edtSoLuong;
    Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_nguoi_muon);

        onIt();
        onValuedateForm();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onValuedateForm()){
                    NguoiMuon item = new NguoiMuon(edtTenNguoiMuon.getText().toString(),edtTenSach.getText().toString(),edtLoaiSach.getText().toString(),edtNXB.getText().toString(),Integer.parseInt(edtSoLuong.getText().toString()),edtNgayMuonSach.getText().toString());
                    FragmentListMuonSach.ListNguoiMuon.add(item);
//                    FragmentListMuonSach.adapter.notifyDataSetChanged();
                    finish();
                }
            }
        });


    }
    private boolean onValuedateForm() {
        String TenNM, TenSach,LoaiSach,NXB,SL,NgayMS;

        TenNM = edtTenNguoiMuon.getText().toString();
        TenSach = edtTenSach.getText().toString();
        LoaiSach = edtLoaiSach.getText().toString();
        NXB = edtNXB.getText().toString();
        SL = edtSoLuong.getText().toString();
        NgayMS = edtNgayMuonSach.getText().toString();

        if (TenNM.length() < 1){
            edtTenNguoiMuon.setError("is not blank");
            return false;
        }
        if (TenSach.length() < 1){
            edtTenSach.setError("is not blank");
            return false;
        }
        if (LoaiSach.length() < 1){
            edtLoaiSach.setError("is not blank");
            return false;
        }
        if (NXB.length() < 1){
            edtNXB.setError("is not blank");
            return false;
        }
        if (SL.length() < 1){
            edtSoLuong.setError("is not blank");
            return false;
        }
        if (NgayMS.length() < 1){
            edtNgayMuonSach.setError("is not blank");
            return false;
        }
        return true;
    }
    private void onIt() {
        edtTenNguoiMuon = (EditText) findViewById(R.id.edt_AddM_TenNguoiMuon);
        edtTenSach = (EditText)findViewById(R.id.edt_AddM_TenSachMuon);
        edtLoaiSach = (EditText)findViewById(R.id.edt_AddM_LoaiSach);
        edtNXB = (EditText)findViewById(R.id.edt_AddM_NXB);
        edtSoLuong = (EditText)findViewById(R.id.edt_AddM_SoLuong);
        edtNgayMuonSach = (EditText)findViewById(R.id.edt_AddM_NgayMuon);
        btnsave = (Button)findViewById(R.id.btn_AddM_Save);
    }
}
