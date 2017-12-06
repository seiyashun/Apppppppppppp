package com.tangtuongco.apppppppppppp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.tangtuongco.apppppppppppp.R;
import com.tangtuongco.apppppppppppp.model.User;
import com.tangtuongco.apppppppppppp.ulti.FormatHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DangKyActivity extends AppCompatActivity {
    DatabaseReference mData;
    EditText edtID,edtPASSWORD,edtNAME,edtBIRTH,edtNUMBER,edtEMAIL,edtADDRESS;
    Button btnSIGNUP;
    User nguoidung = new User();
   


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

        anhxa();
        control();



    }

    private void control() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user= database.getReference("User");

        btnSIGNUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(edtID.getText().toString()).exists())
                        {
                            Toast.makeText(DangKyActivity.this, "Tồn tại ID", Toast.LENGTH_SHORT).show();


                        }
                        else
                        {
                            if(edtID.getText().toString().trim().length()<=7 )
                            {
                                Toast.makeText(DangKyActivity.this, "Nhập ID lớn hơn 7 kí tự", Toast.LENGTH_SHORT).show();
                            }
                            if(edtNAME.getText().toString().length()==0)
                            {
                                Toast.makeText(DangKyActivity.this, "Nhập tên", Toast.LENGTH_SHORT).show();
                            }
                            if (edtPASSWORD.getText().toString().length()<=7)
                            {
                                Toast.makeText(DangKyActivity.this, "Password phải lớn hơn hoặc bằng 7 kí tự", Toast.LENGTH_SHORT).show();
                            }
                            if(edtADDRESS.getText().toString().trim().length()==0)
                            {
                                Toast.makeText(DangKyActivity.this, "Địa chỉ không hợp lệ", Toast.LENGTH_SHORT).show();
                            }
                            if(edtBIRTH.getText().toString().trim().length()==0)
                            {
                                Toast.makeText(DangKyActivity.this, "Nhập ngày sinh định dạnh dd/MM/yyyy", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                User user=new User();
                                user.setID(edtID.getText().toString());
                                user.setName(edtNAME.getText().toString());
                                user.setEmail(edtEMAIL.getText().toString());
                                user.setSoDienThoai(edtNUMBER.getText().toString());
                                user.setDiaChi(edtADDRESS.getText().toString());
                                user.setPASSWORD(edtPASSWORD.getText().toString());
                                try {
                                    user.setNgaySinh(FormatHelper.formatstring(edtBIRTH.getText().toString()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }



                                table_user.child(edtID.getText().toString()).setValue(user);
                                Toast.makeText(DangKyActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                finish();
                            }


                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
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
