package com.tangtuongco.apppppppppppp.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.os.Build.ID;

public class DangKyActivity extends AppCompatActivity {
    DatabaseReference mData, mUser;
    EditText edtID, edtPASSWORD, edtNAME, edtBIRTH, edtNUMBER, edtEMAIL, edtADDRESS;
    Button btnSIGNUP, btnCheckkkkk,btnChonNgay;
    User user = new User();
    int count = 0;
    Calendar dateTime= Calendar.getInstance();
    private int mYear, mMonth, mDay;


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
                onBackPressed();


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
        Intent i = getIntent();
        user = (User) i.getSerializableExtra("taikhoan");


        btnSIGNUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
        btnChonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(DangKyActivity.this,d,dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show();


            }
        });

    }
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            dateTime.set(Calendar.YEAR,i);
            dateTime.set(Calendar.MONTH,i1);
            dateTime.set(Calendar.DAY_OF_MONTH,i2);
            Calendar c = Calendar.getInstance();

//            if(c.get(Calendar.YEAR)<dateTime.get(Calendar.YEAR))
//            {
//
//            }
//            else
//            {
//                if(c.get(Calendar.MONTH)<dateTime.get(Calendar.MONTH))
//                {
//
//                }
//                else
//                {
//                    if(c.get(Calendar.DAY_OF_MONTH)<dateTime.get(Calendar.DAY_OF_MONTH))
//                    {
//                        Toast.makeText(DangKyActivity.this, "Lớn hơn ngày hiện tại !!! LỖI", Toast.LENGTH_SHORT).show();
//                    }
//                    else
//                    {
//                        updateText();
//                    }
//                }
//            }
            if(dateTime.compareTo(c)<=0)
            {
                updateText();
            }
            else
            {
                Toast.makeText(DangKyActivity.this, "Ngày sinh phài nhỏ hơn ngày hiện tại", Toast.LENGTH_SHORT).show();
            }

//            updateText();



        }
    };

    private void updateText() {
        edtBIRTH.setText(FormatHelper.formatNgay(dateTime.getTime()));
    }


    private void addUser() {
        final String ID = edtID.getText().toString().trim();
        final String NgaySin = edtBIRTH.getText().toString();
        final String DiaChi = edtADDRESS.getText().toString();
        final String Name = edtNAME.getText().toString();
        final String Email = edtEMAIL.getText().toString().trim();
        final String SDT = edtNUMBER.getText().toString();
        final String Pass = edtPASSWORD.getText().toString();
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



        if (!TextUtils.isEmpty(ID)) {

            if(ID.trim().length()<7)
            {
                Toast.makeText(this, "ID phải dài hơn 7 kí tự", Toast.LENGTH_SHORT).show();
                
            }
            else
            if(Pass.length()<7)
            {
                Toast.makeText(this, "PASS phải dài hơn 7 kí tự", Toast.LENGTH_SHORT).show();
            }
            if(NgaySin.length()==0)
            {
                Toast.makeText(this, "Chọn Ngày Sinh", Toast.LENGTH_SHORT).show();
            }
            if(Email.length()==0)
            {
                Toast.makeText(this, "Nhập Mail", Toast.LENGTH_SHORT).show();
            }
            if(SDT.length()==0)
            {
                Toast.makeText(this, "Nhập Số Điện Thoại", Toast.LENGTH_SHORT).show();
            }
            if(DiaChi.length()==0)
            {
                Toast.makeText(this, "Nhập Địa Chỉ", Toast.LENGTH_SHORT).show();
            }
            if(!Email.matches(emailPattern))
            {
                Toast.makeText(this, "Sai định dạng MAIL", Toast.LENGTH_SHORT).show();
            }
            else
            {
                final User user = new User();
                try {
                    user.setNgaySinh(FormatHelper.formatstring(NgaySin));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                user.setPhanLoai(1);
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
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            User a = postSnapshot.getValue(User.class);
                            //Log.d("AAA",String.valueOf(a.getID()));
                            if (a.getID().equals(ID)) {

                                flag = 1;

                            }
                        }
                        if (flag == 1) {
                            Toast.makeText(DangKyActivity.this, "Trùng Tài Khoản", Toast.LENGTH_SHORT).show();
                        } else {
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




        } else {
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
        btnChonNgay=findViewById(R.id.btnChonNgay);


    }
}
