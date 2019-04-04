package com.example.administrator.androidck;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class FragmentListMuonSach extends Fragment {
    MySQLite sqLite;
     ListView lv_MuonSach;
    public static List<NguoiMuon> ListNguoiMuon;
    ImageView img_add_NguoiMuon;
    static NguoiMuonAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ListNguoiMuon = new ArrayList<>();
        ListNguoiMuon.add(new NguoiMuon("Le Van A","Conan-91","Truyen","Kim Dong",20,"20/04/2019"));
        ListNguoiMuon.add(new NguoiMuon("Le Van B","Conan-92","Truyen","Kim Dong",30,"21/05/2019"));
        ListNguoiMuon.add(new NguoiMuon("Le Van C","Conan-93","Truyen","Kim Dong",40,"22/06/2019"));
        ListNguoiMuon.add(new NguoiMuon("Le Van D","Conan-94","Truyen","Kim Dong",50,"23/07/2019"));
        ListNguoiMuon.add(new NguoiMuon("Le Van E","Conan-95","Truyen","Kim Dong",10,"24/08/2019"));
        ListNguoiMuon.add(new NguoiMuon("Le Van F","Conan-95","Truyen","Kim Dong",10,"24/08/2019"));
        ListNguoiMuon.add(new NguoiMuon("Le Van G","Conan-95","Truyen","Kim Dong",10,"24/08/2019"));
        return inflater.inflate(R.layout.fragment_list_muon_sach, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();

        lv_MuonSach = (ListView)getActivity().findViewById(R.id.lv_ListMuonSach);
        img_add_NguoiMuon = (ImageView) getActivity().findViewById(R.id.img_Add_MuonSach);


        adapter = new NguoiMuonAdapter(getContext(),R.layout.item_muon_sach_layout,ListNguoiMuon);
        lv_MuonSach.setAdapter(adapter);

        img_add_NguoiMuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),addNewNguoiMuon.class);
                startActivity(intent);
            }
        });

        lv_MuonSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NguoiMuon item = ListNguoiMuon.get(position);
                Intent intent = new Intent(getContext(),deltailMuonSach.class);
                intent.putExtra("itemMuonSach", (Serializable) item);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        if (ListNguoiMuon.size() > 0 && adapter != null){
            adapter.notifyDataSetChanged();
        }
    }

}
