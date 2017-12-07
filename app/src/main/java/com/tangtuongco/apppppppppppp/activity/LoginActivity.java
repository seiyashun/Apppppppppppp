package com.tangtuongco.apppppppppppp.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        mData=FirebaseDatabase.getInstance().getReference("User");


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


        mData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot:dataSnapshot.getChildren()) {
                    User post = postSnapshot.getValue(User.class);
                    String idddd = post.getID();
                    String passs=post.getPassword();

                    if (idddd.equals(edtID.getText().toString()))
                    {
                        if(passs.equals(edtPass.getText().toString())) {

                            flag=1;
                            user=post;

                        }

                    }


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        if(flag!=0)
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

    private void anhxa() {
        edtID=findViewById(R.id.edtIDDDDD);
        edtPass=findViewById(R.id.edtPASSSSSS);
        btnDangKy= findViewById(R.id.btnREG);
        btnDangNhap=findViewById(R.id.btnLOGIN);
    }
}
