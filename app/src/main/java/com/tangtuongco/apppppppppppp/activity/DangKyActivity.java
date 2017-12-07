package com.tangtuongco.apppppppppppp.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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

public class DangKyActivity extends AppCompatActivity {
    DatabaseReference mData;
    EditText edtID,edtPASSWORD,edtNAME,edtBIRTH,edtNUMBER,edtEMAIL,edtADDRESS;
    Button btnSIGNUP;
    User nguoidung = new User();
    int flag=0;


   


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
        mData=FirebaseDatabase.getInstance().getReference("User");

        anhxa();
        control();



    }

    private void control() {
        final int flag = 0;
        btnSIGNUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });

    }

    private void addUser() {
        String ID=edtID.getText().toString().trim();
        String NgaySin=edtBIRTH.getText().toString();
        String DiaChi=edtADDRESS.getText().toString();
        String Name=edtNAME.getText().toString();
        String Email=edtEMAIL.getText().toString();
        String SDT=edtNUMBER.getText().toString();
        String Pass=edtPASSWORD.getText().toString();

        if(!TextUtils.isEmpty(ID))
        {
            User user= new User();
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

            mData.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot postSnapshot:dataSnapshot.getChildren()) {
                        User post = postSnapshot.getValue(User.class);
                        String idddd = post.getID();

                        if (idddd.equals(edtID.getText().toString()))
                        {
                            flag++;
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            if(flag!=0)
            {
                Toast.makeText(this, "Đăng Ký Không Thành Công", Toast.LENGTH_SHORT).show();
            }
            else
            {
                mData.child(ID).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(DangKyActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    }
                });
            }




        }
        else
        {
            Toast.makeText(this, "Xin Nhập ID", Toast.LENGTH_SHORT).show();
        }

    }


    private void anhxa() {
        edtID=findViewById(R.id.edtID);
        edtPASSWORD=findViewById(R.id.edtPASS);
        edtNAME=findViewById(R.id.edtNAME);
        edtEMAIL=findViewById(R.id.edtEMAIL);
        edtBIRTH=findViewById(R.id.edtBIRTH);
        edtADDRESS=findViewById(R.id.edtADDRESS);
        edtNUMBER=findViewById(R.id.edtNUMBER);
        btnSIGNUP=findViewById(R.id.btnSIGNUP);


    }
}
