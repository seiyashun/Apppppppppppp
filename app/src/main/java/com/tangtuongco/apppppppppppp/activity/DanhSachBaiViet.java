package com.tangtuongco.apppppppppppp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tangtuongco.apppppppppppp.R;
import com.tangtuongco.apppppppppppp.adapter.adapterDanhSachBaiVietTheoChuDe;
import com.tangtuongco.apppppppppppp.model.BaiViet;
import com.tangtuongco.apppppppppppp.model.ChuDe;
import com.tangtuongco.apppppppppppp.model.User;

import java.util.ArrayList;

public class DanhSachBaiViet extends AppCompatActivity {
    ListView lstDanhSach;
    DatabaseReference mData;
    User userHienTai= new User();
    ArrayList<BaiViet> arrayListBaiVietHienTai=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_bai_viet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Danh Sách Bài Viết");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();


            }
        });



        lstDanhSach=findViewById(R.id.lstDanhSachBaiViet);
        mData = FirebaseDatabase.getInstance().getReference();
        getDuLieu();


        control();
    }

    private void getDuLieu() {
        Intent i = getIntent();
        Bundle extras= i.getExtras();
        final String IDUser= extras.getString("NguoiDungHienTai");
        final String IDChuDe=extras.getString("ChuDe");
        final ArrayList<BaiViet> a=new ArrayList<>();
        mData.child("DanhSachBaiViet").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                BaiViet a=dataSnapshot.getValue(BaiViet.class);
                if(a.getTenChuDe().equals(IDChuDe))
                {
                    thucthibaiviet(a);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mData.child("User").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                User a=dataSnapshot.getValue(User.class);
                if(a.getID().equals(IDUser))
                {
                    thucthiuser(a);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void thucthibaiviet(BaiViet a) {
             arrayListBaiVietHienTai.add(a);
//        final adapterManHinhChinh adaptarmain = new adapterManHinhChinh(arrBaiViet, getApplicationContext());
//        lstMain.setAdapter(adaptarmain);

        adapterDanhSachBaiVietTheoChuDe adapterDanhSachBaiViet = new adapterDanhSachBaiVietTheoChuDe(arrayListBaiVietHienTai,getApplicationContext());
        lstDanhSach.setAdapter(adapterDanhSachBaiViet);
    }

    private void thucthiuser(User a) {
        userHienTai=a;

    }

    private void control() {
        lstDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BaiViet a = new BaiViet();
                a=arrayListBaiVietHienTai.get(i);
                Intent intent = new Intent(DanhSachBaiViet.this, BaiVietChiTiet.class);
                Bundle extras=new Bundle();
                extras.putString("NguoiDungHienTai",userHienTai.getID());
                extras.putString("BaiVietHienTai",a.getIDBAIVIET());

                intent.putExtras(extras);
                startActivity(intent);
            }
        });

    }
}
