package com.tangtuongco.apppppppppppp.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tangtuongco.apppppppppppp.R;
import com.tangtuongco.apppppppppppp.adapter.adapterListViewBinhLuan;
import com.tangtuongco.apppppppppppp.model.BaiViet;
import com.tangtuongco.apppppppppppp.model.BinhLuan;
import com.tangtuongco.apppppppppppp.model.User;

import java.util.ArrayList;

public class BaiVietChiTiet extends AppCompatActivity {
    TextView txtTieuDe;
    VideoView videoView;
    ListView lstBinhLuan;
    EditText edtBinhLuan;
    Button btnBinhLuan;
    DatabaseReference mData;
    BaiViet baiVietHienTai = new BaiViet();
    User userHienTai = new User();
    BinhLuan binhluan=new BinhLuan();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_viet_chi_tiet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Bài Viết Chi Tiết");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();


            }
        });


        mData = FirebaseDatabase.getInstance().getReference();


        anhxa();
        loadBaiViet();
        control();
    }

    private void control() {
        btnBinhLuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binhluan.setIDBaiViet(baiVietHienTai.getIDBAIVIET());
                binhluan.setIDNguoiBinhLuan(userHienTai.getID());
                binhluan.setNoiDungBinhLuan(edtBinhLuan.getText().toString());
                mData.child("DanhSachBinhLuan").child(baiVietHienTai.getTenBaiViet()).push().setValue(binhluan).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Toast.makeText(BaiVietChiTiet.this, "Bình Luận Thành Công", Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });

    }

    private void loadBaiViet() {
        Intent i = getIntent();
        Bundle extras= i.getExtras();
        final String IDUser= extras.getString("NguoiDungHienTai");
        final String IDBaiViet=extras.getString("BaiVietHienTai");

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

        mData.child("DanhSachBaiViet").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                BaiViet a = dataSnapshot.getValue(BaiViet.class);
                if(a.getIDBAIVIET().equals(IDBaiViet)) {
                    thucthi(a);
                    loadBinhLuan(a);
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


//        final ArrayList<BaiViet> arrBaiViet=new ArrayList<>();
//        final adapterManHinhChinh adaptarmain = new adapterManHinhChinh(arrBaiViet, getApplicationContext());
//        lstMain.setAdapter(adaptarmain);




    }

    private void loadBinhLuan(BaiViet a) {
        final ArrayList<BinhLuan> arrBinhLuan=new ArrayList<>();
        final adapterListViewBinhLuan adapterBl = new adapterListViewBinhLuan(arrBinhLuan,getApplicationContext());
        lstBinhLuan.setAdapter(adapterBl);
        mData.child("DanhSachBinhLuan").child(baiVietHienTai.getTenBaiViet()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                BinhLuan a= dataSnapshot.getValue(BinhLuan.class);
                arrBinhLuan.add(a);
                capnhatbinhluan(a,adapterBl);


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

    private void capnhatbinhluan(BinhLuan a, adapterListViewBinhLuan adapterBl) {
        adapterBl.notifyDataSetChanged();

    }

    private void thucthiuser(User a) {
        userHienTai=a;


    }

    private void thucthi(BaiViet a) {
        baiVietHienTai=a;
        txtTieuDe.setText(a.getTenBaiViet());
        String video = a.getChiTietBaiViet().getVideo();
        Uri videoUri= Uri.parse(video);
        videoView.setVideoURI(videoUri);
        videoView.start();

    }

    private void anhxa() {
        txtTieuDe=findViewById(R.id.txtTieuDeBaiViet);
        videoView=findViewById(R.id.videoChiTiet);
        lstBinhLuan=findViewById(R.id.lstCmt);
        edtBinhLuan=findViewById(R.id.edtBinhLuan);
        btnBinhLuan=findViewById(R.id.btnBinhLuan);

    }
}
