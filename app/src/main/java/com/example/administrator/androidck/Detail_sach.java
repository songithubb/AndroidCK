package com.example.administrator.androidck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Detail_sach extends AppCompatActivity {
    TextView txtTenSach, txtLoaiSach, txtNhaXB,txtSL,txtTacGia;
    Button btncanle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sach);
        onIt();
        onGetInt();
        btncanle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void onGetInt() {
        Intent intent = getIntent();
        Sach item = (Sach) intent.getSerializableExtra("itemSach");
        txtTenSach.setText(item.getTenSach());
        txtLoaiSach.setText(item.getLoaiSach());
        txtTacGia.setText(item.getTacGia());
        txtNhaXB.setText(item.getNXB());
        txtSL.setText(item.getSoLuongSach()+"");
    }

    private void onIt() {

        txtTenSach = (TextView)findViewById(R.id.txt_TenSach);
        txtLoaiSach = (TextView)findViewById(R.id.txt_LoaiSach);
        txtNhaXB = (TextView)findViewById(R.id.txt_NXB);
        txtSL= (TextView)findViewById(R.id.txt_SoLuong);
        txtTacGia = (TextView)findViewById(R.id.txt_TacGia);
        btncanle = (Button)findViewById(R.id.btn_cancle);
    }
}
