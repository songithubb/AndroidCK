package com.example.administrator.androidck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddNewListSach extends AppCompatActivity {

    EditText edtTenSach;
    EditText edtLoaiSach;
    EditText edtSL;
    EditText edtNXB;
    EditText edtTacGia;
    Button btnSave;
    Button btnCanle;
    List<Sach> arrlist;
    MySQLite sqLite;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_list_sach);

        onIt();
        AddData();

    }

    private void AddData() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onValuedateForm()){
                    sqLite = new MySQLite(AddNewListSach.this);
                    sqLite.OpenDB();
                    Sach item = new Sach(edtLoaiSach.getText().toString(),edtTenSach.getText().toString(),edtTacGia.getText().toString(),edtNXB.getText().toString(), Integer.parseInt(edtSL.getText().toString()));
                    arrlist = new ArrayList<>();
                    arrlist.addAll(sqLite.getAll());
                    boolean check = false;
                    int position = 0;
                    String mTenSach = edtTenSach.getText().toString();
                    for (int i= 0; i<arrlist.size();i++){

                        String TenSach = arrlist.get(i).getTenSach();
                        if (mTenSach.equals(TenSach)){
                            check = true;
                            position = i;
                            return;
                        }
                    }
                    if(check== false){
                        sqLite.addItem(item);
                        Toast.makeText(AddNewListSach.this,"Da Tao Sach Moi Vao List Sach",Toast.LENGTH_LONG).show();
                        finish();
                    }
                    else {
                        int sl = item.getSoLuongSach() + arrlist.get(position).getSoLuongSach();
                        sqLite.UpdateData(item.getTenSach(),sl);
                        Toast.makeText(AddNewListSach.this,"Da Them Sach Vao List",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        btnCanle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean onValuedateForm() {
        String errorText = "This field can't be blank";
        String TenSach ="", loaiSach="", Tacgia ="",NXB ="",SL="";

        TenSach = edtTenSach.getText().toString();
        loaiSach = edtLoaiSach.getText().toString();
        Tacgia = edtTacGia.getText().toString();
        NXB = edtNXB.getText().toString();
        SL = edtSL.getText().toString();

        if(TenSach.length() < 1){
            edtTenSach.setError(errorText);
            return false;
        }
        if(loaiSach.length() < 1){
            edtTenSach.setError(errorText);
            return false;
        }
        if(Tacgia.length() < 1){
            edtLoaiSach.setError(errorText);
            return false;
        }
        if(NXB.length() < 1){
            edtNXB.setError(errorText);
            return false;
        }
        if(SL.length() < 1){
            edtSL.setError(errorText);
            return false;
        }

        return true;
    }

    private void onIt() {
        edtTenSach = (EditText)findViewById(R.id.edt_Add_TenSach);
        edtLoaiSach = (EditText)findViewById(R.id.edt_Add_LoaiSach);
        edtSL = (EditText)findViewById(R.id.edt_Add_SoLuong);
        edtTacGia = (EditText)findViewById(R.id.edt_Add_TacGia);
        edtNXB = (EditText)findViewById(R.id.edt_Add_NXB);
        btnSave = (Button) findViewById(R.id.btnAddSave);
        btnCanle = (Button) findViewById(R.id.btn_Add_cancle);
    }
}
