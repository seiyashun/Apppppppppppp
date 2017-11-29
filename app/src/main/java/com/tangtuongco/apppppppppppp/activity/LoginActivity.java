package com.tangtuongco.apppppppppppp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tangtuongco.apppppppppppp.R;

public class LoginActivity extends AppCompatActivity {
    Button btnDangNhap,btnDangKy;

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
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void anhxa() {
        btnDangKy= findViewById(R.id.btnREG);
        btnDangNhap=findViewById(R.id.btnLOGIN);
    }
}
