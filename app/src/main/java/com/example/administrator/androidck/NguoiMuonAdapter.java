package com.example.administrator.androidck;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.INotificationSideChannel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class NguoiMuonAdapter extends ArrayAdapter<NguoiMuon> {
    Context mcontext;
    int mLayout;
    List<NguoiMuon> nguoiMuonList;

    public NguoiMuonAdapter(@NonNull Context context, int resource, @NonNull List<NguoiMuon> objects) {
        super(context, resource, objects);
                this.mcontext = context;
        this.mLayout = resource;
        this.nguoiMuonList = objects;
    }

//    public NguoiMuonAdapter(Context mcontext, int mLayout, List<NguoiMuon> nguoiMuonList) {
//        this.mcontext = mcontext;
//        this.mLayout = mLayout;
//        this.nguoiMuonList = nguoiMuonList;
//    }

//    @Override
//    public int getCount() {
//        return nguoiMuonList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return nguoiMuonList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         convertView = LayoutInflater.from(mcontext).inflate(mLayout,parent,false);
        final NguoiMuon item = nguoiMuonList.get(position);
        TextView txtTenNguoiMuon = (TextView)convertView.findViewById(R.id.txt_TenNguoiMuon);
        TextView txtTenSach = (TextView)convertView.findViewById(R.id.txt_TenSachMuon);
        TextView txtSoLuong = (TextView)convertView.findViewById(R.id.txtSoLuongMuon);
        TextView txtNgayMuon = (TextView)convertView.findViewById(R.id.txtNgayMuon);
        CheckBox chkTraSach = (CheckBox)convertView.findViewById(R.id.chk_TraSach);
        Button btndetail = (Button)convertView.findViewById(R.id.btn_chitiet);
        txtTenNguoiMuon.setText(item.getTenNguoiMuon());
        txtTenSach.setText(item.getTenSach());
        txtSoLuong.setText(item.getSoLuong()+"");
        txtNgayMuon.setText(item.getNgayMuon());

       chkTraSach.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               nguoiMuonList.remove(position);
               notifyDataSetChanged();
           }
       });

       btndetail.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(mcontext,deltailMuonSach.class);
               intent.putExtra("itemMuonSach",item);
               mcontext.startActivity(intent);
           }
       });
        return convertView;
    }


//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//
////        final LayoutInflater inflater = (LayoutInflater)mcontext.fro;
//        convertView = LayoutInflater.from(mcontext).inflate(mLayout,parent,false);
//        final NguoiMuon item = nguoiMuonList.get(position);
//        TextView txtTenNguoiMuon = (TextView)convertView.findViewById(R.id.txt_TenNguoiMuon);
//        TextView txtTenSach = (TextView)convertView.findViewById(R.id.txt_TenSachMuon);
//        TextView txtSoLuong = (TextView)convertView.findViewById(R.id.txtSoLuongMuon);
//        TextView txtNgayMuon = (TextView)convertView.findViewById(R.id.txtNgayMuon);
//        CheckBox chkTraSach = (CheckBox)convertView.findViewById(R.id.chk_TraSach);
//        Button btndetail = (Button)convertView.findViewById(R.id.btn_chitiet);
//        txtTenNguoiMuon.setText(item.getTenNguoiMuon());
//        txtTenSach.setText(item.getTenSach());
//        txtSoLuong.setText(item.getSoLuong()+"");
//        txtNgayMuon.setText(item.getNgayMuon());
//
//       chkTraSach.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//           @Override
//           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//               nguoiMuonList.remove(position);
//               notifyDataSetChanged();
//           }
//       });
//
//       btndetail.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Intent intent = new Intent(mcontext,deltailMuonSach.class);
//               intent.putExtra("itemMuonSach",item);
//               mcontext.startActivity(intent);
//           }
//       });
//        return convertView;
//    }

//    public void AddItem(NguoiMuon item ){
//        nguoiMuonList.add(item);
//        notifyDataSetChanged();
//    }
}
