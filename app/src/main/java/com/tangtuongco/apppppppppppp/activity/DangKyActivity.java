package com.tangtuongco.apppppppppppp.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.tangtuongco.apppppppppppp.R;
import com.tangtuongco.apppppppppppp.model.BaiViet;
import com.tangtuongco.apppppppppppp.model.User;
import com.tangtuongco.apppppppppppp.ulti.FormatHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.os.Build.ID;

public class DangKyActivity extends AppCompatActivity {
    DatabaseReference mData, mUser;
    EditText edtID, edtPASSWORD, edtNAME, edtBIRTH, edtNUMBER, edtEMAIL, edtADDRESS;
    Button btnSIGNUP,btnCheckkkkk;
    User user = new User();
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Đăng Ký");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mData = FirebaseDatabase.getInstance().getReference();


        anhxa();
        btnSIGNUP.setEnabled(true);
        loadDataSpinner();
        control();



    }

    private void loadDataSpinner() {

    }


    private void control() {
        Intent i =getIntent();
        user= (User) i.getSerializableExtra("taikhoan");


        btnSIGNUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });

    }


    private void addUser() {
        final String ID = edtID.getText().toString().trim();
        final String NgaySin = edtBIRTH.getText().toString();
        final String DiaChi = edtADDRESS.getText().toString();
        final String Name = edtNAME.getText().toString();
        final String Email = edtEMAIL.getText().toString();
        final String SDT = edtNUMBER.getText().toString();
        final String Pass = edtPASSWORD.getText().toString();


        if (!TextUtils.isEmpty(ID)) {

                final User user = new User();
                try {
                    user.setNgaySinh(FormatHelper.formatstring(NgaySin));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                user.setID(ID);
                user.setPassword(Pass);
                user.setSDT(SDT);
                user.setEmail(Email);
                user.setName(Name);
                user.setDiaChi(DiaChi);


                mData.child("User").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int flag = 0;
                        for(DataSnapshot postSnapshot:dataSnapshot.getChildren()) {
                            User a = postSnapshot.getValue(User.class);
                            //Log.d("AAA",String.valueOf(a.getID()));
                            if(a.getID().equals(ID))
                            {

                                    flag = 1;

                            }
                        }
                        if(flag == 1)
                        {
                            Toast.makeText(DangKyActivity.this, "Trùng Tài Khoản", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            mData.child("User").child(ID).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(DangKyActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                    finish();

                                }
                            });
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


        }
        else
        {
            Toast.makeText(this, "Xin Nhập ID", Toast.LENGTH_SHORT).show();
        }
    }

    public void addNewUser(User user) {
        final String ID = edtID.getText().toString().trim();
        String NgaySin = edtBIRTH.getText().toString();
        String DiaChi = edtADDRESS.getText().toString();
        String Name = edtNAME.getText().toString();
        String Email = edtEMAIL.getText().toString();
        String SDT = edtNUMBER.getText().toString();
        String Pass = edtPASSWORD.getText().toString();

        try {
            user.setNgaySinh(FormatHelper.formatstring(NgaySin));
        } catch (Exception e) {
            e.printStackTrace();
        }

        user.setID(ID);
        user.setPassword(Pass);
        user.setSDT(SDT);
        user.setEmail(Email);
        user.setName(Name);
        user.setDiaChi(DiaChi);
        mData.child(ID).setValue(user);


    }


    private void anhxa() {
        edtID = findViewById(R.id.edtID);
        edtPASSWORD = findViewById(R.id.edtPASS);
        edtNAME = findViewById(R.id.edtNAME);
        edtEMAIL = findViewById(R.id.edtEMAIL);
        edtBIRTH = findViewById(R.id.edtBIRTH);
        edtADDRESS = findViewById(R.id.edtADDRESS);
        edtNUMBER = findViewById(R.id.edtNUMBER);
        btnSIGNUP = findViewById(R.id.btnSIGNUP);



    }
}
