package com.tangtuongco.apppppppppppp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_user= database.getReference("User");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();


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
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(edtID.getText().toString()).exists()) {
                            User userlogin = dataSnapshot.child(edtID.getText().toString()).getValue(User.class);


                            if (userlogin.getPASSWORD().equals(edtPass.getText().toString())) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("taikhoan",userlogin);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(LoginActivity.this, "Sai password", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "ID không tồn tại", Toast.LENGTH_SHORT).show();
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
        edtID=findViewById(R.id.edtIDDDDD);
        edtPass=findViewById(R.id.edtPASSSSSS);
        btnDangKy= findViewById(R.id.btnREG);
        btnDangNhap=findViewById(R.id.btnLOGIN);
    }
}
