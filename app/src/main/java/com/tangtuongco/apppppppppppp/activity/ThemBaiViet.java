package com.tangtuongco.apppppppppppp.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.tangtuongco.apppppppppppp.R;
import com.tangtuongco.apppppppppppp.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThemBaiViet extends AppCompatActivity {
    User user=new User();
    EditText edtTieuDe;
    Button btnDangBai,btnUpload;
    TextView txtTrangThai;
    Spinner spinnerTHELOAI;
    String record="";
    private Uri filePath;
    private static final int REQUEST_READ_PERMISSION=9003;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_bai_viet);
        anhxa();

        control();

    }

    private void control() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Món Hầm");
        data.add("Món Mặn");
        data.add("Món Chay");
        data.add("Món Ngọt");
        data.add("Món Canh");

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        spinnerTHELOAI.setAdapter(adapterSpinner);
        /*spinnerTHELOAI.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        record ="Món Hầm";
                        break;
                    case 1:
                        record ="Món Mặn";
                        break;
                    case 2:
                        record ="Món Chay";
                        break;
                    case 3:
                        record ="Món Ngọt";
                        break;
                    case 4:
                        record ="Món Canh";
                        break;
                }
            }
        });*/
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowFileChooser();


            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_READ_PERMISSION && requestCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            txtTrangThai.setText(filePath.toString());
            filePath=data.getData();
        }
    }

    private void ShowFileChooser()
    {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Chọn Video"),REQUEST_READ_PERMISSION);

    }

    private void anhxa() {
        Intent i =getIntent();
        user= (User) i.getSerializableExtra("taikhoan");
        btnDangBai=findViewById(R.id.btnDANGBAI);
        btnUpload=findViewById(R.id.btnUPVIDEO);
        txtTrangThai=findViewById(R.id.txtTRANGTHAI);
        edtTieuDe=findViewById(R.id.edtTieuDe);
        spinnerTHELOAI=findViewById(R.id.spinnerTHELOAI);
    }
}
