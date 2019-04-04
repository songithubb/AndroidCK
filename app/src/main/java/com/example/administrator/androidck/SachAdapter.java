package com.example.administrator.androidck;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class SachAdapter extends BaseAdapter{
    Context mcontext;
    int mlayout;
    List<Sach> sachList;

    public SachAdapter(Context mcontext, int mlayout, List<Sach> sachList) {
        this.mcontext = mcontext;
        this.mlayout = mlayout;
        this.sachList = sachList;
    }

    @Override
    public int getCount() {
        return sachList.size();
    }

    @Override
    public Object getItem(int position) {
        return sachList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mlayout,null);
        // anhxa
        TextView txtTenSach = (TextView)convertView.findViewById(R.id.txt_Add_TenSach);
        TextView txtLoaiSach = (TextView)convertView.findViewById(R.id.txt_Add_LoaiSach);
        TextView txtSLT = (TextView)convertView.findViewById(R.id.txt_Add_SLT);
        TextView txtTacGia = (TextView)convertView.findViewById(R.id.txt_Add_TacGia);
        TextView txtNXB = (TextView)convertView.findViewById(R.id.txt_Add_NXB);
        ImageView imgXoa =(ImageView)convertView.findViewById(R.id.img_Add_Xoa);
        ImageView imgDetail = (ImageView)convertView.findViewById(R.id.img_Add_Edit);
        final Sach item = sachList.get(position);

        txtTenSach.setText(item.getTenSach());
        txtLoaiSach.setText(item.getLoaiSach());
        txtSLT.setText(item.getSoLuongSach()+"");
        txtTacGia.setText(item.getTacGia());
        txtNXB.setText(item.getNXB());

        imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySQLite mDB = new MySQLite(mcontext);
                mDB.OpenDB();

                mDB.DeleteData(item);
                sachList.remove(position);
                notifyDataSetChanged();
            }
        });
        imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,Detail_sach.class);
                intent.putExtra("itemSach",item);
                mcontext.startActivity(intent);
            }
        });
        return convertView;
    }
}
