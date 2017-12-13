package com.tangtuongco.apppppppppppp.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.database.ValueEventListener;
import com.tangtuongco.apppppppppppp.R;
import com.tangtuongco.apppppppppppp.model.Host;
import com.tangtuongco.apppppppppppp.model.User;

public class LoginActivity extends AppCompatActivity {
    EditText edtID,edtPass;
    Button btnDangNhap,btnDangKy;
    String idss ;
    String mkss ;
    int flag=0;
    User user=new User();

    DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();
        mData=FirebaseDatabase.getInstance().getReference();
//        Host a=new Host("HOST","HOST123");
//        mData.child("HOST").child("HOST").setValue(a);



       addControl();


    }

    private void addControl() {
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,DangKyActivity.class);
                startActivity(intent);
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

    }

    private void loginUser() {
        final String ID = edtID.getText().toString();
        final String Pass=edtPass.getText().toString();
        if (!TextUtils.isEmpty(ID))
        {
            if(ID.equals("HOST"))
            {
                mData.child("HOST").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        Host h=dataSnapshot.getValue(Host.class);
                        if(Pass.equals(h.getMatKhauHost().toString()))
                        {
                            Toast.makeText(LoginActivity.this, "Host đăng nhập", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this,HostActivity.class);
                            startActivity(intent);
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
            else
            {
                mData.child("User").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int flag = 0;
                        for(DataSnapshot postSnapshot:dataSnapshot.getChildren()) {
                            User a = postSnapshot.getValue(User.class);
                            //Log.d("AAA",String.valueOf(a.getID()));
                            if(a.getID().equals(ID))
                            {
                                if(a.getPassword().equals(Pass)) {
                                    user=a;
                                    flag = 1;
                                }

                            }
                        }
                        if(flag == 1)
                        {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("taikhoan", user);
                            startActivity(intent);
                            return;
                        }
                        else
                        {

                            Toast.makeText(LoginActivity.this, "Sai Tài Khoản Hoặc Mật Khẩu", Toast.LENGTH_SHORT).show();


                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

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
        edtID=findViewById(R.id.edtIDDDDD);
        edtPass=findViewById(R.id.edtPASSSSSS);
        btnDangKy= findViewById(R.id.btnREG);
        btnDangNhap=findViewById(R.id.btnLOGIN);
    }
}
