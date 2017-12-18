package com.tangtuongco.apppppppppppp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tangtuongco.apppppppppppp.R;
import com.tangtuongco.apppppppppppp.model.User;
import com.tangtuongco.apppppppppppp.ulti.FormatHelper;

public class ChiTietNguoiDung extends AppCompatActivity {
    TextView diachi,email,id,name,ngaysinh,sdt;
    DatabaseReference mData;
    User userHienTai=new User();
    Button btnDoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_nguoi_dung);
        mData = FirebaseDatabase.getInstance().getReference();
        anhxa();
        loadData();

    }

    private void loadData() {
        Intent i = getIntent();
        Bundle extras= i.getExtras();
        final String IDUser= extras.getString("NguoiDungHienTai");


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

    private void thucthiuser(User a) {
        userHienTai=a;
        diachi.setText(a.getDiaChi());
        email.setText(a.getEmail());
        id.setText(a.getID());
        name.setText(a.getName());
        sdt.setText(a.getSDT());
        ngaysinh.setText(FormatHelper.formatNgay(a.getNgaySinh()));

    }

    private void anhxa() {
        diachi=findViewById(R.id.txtChiTietDiaChi);
        email=findViewById(R.id.txtChiTietEmail);
        id=findViewById(R.id.txtChiTietID);
        name=findViewById(R.id.txtChiTietTen);
        ngaysinh=findViewById(R.id.txtChiTietNgaySinh);
        sdt=findViewById(R.id.txtChiTietSDT);
        btnDoi=findViewById(R.id.btnDoi);
    }
}
