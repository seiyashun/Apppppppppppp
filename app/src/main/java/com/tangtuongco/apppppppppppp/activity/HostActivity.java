package com.tangtuongco.apppppppppppp.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tangtuongco.apppppppppppp.R;
import com.tangtuongco.apppppppppppp.adapter.adapterListMember;
import com.tangtuongco.apppppppppppp.model.User;

import java.util.ArrayList;

public class HostActivity extends AppCompatActivity {
    DatabaseReference mData;
    ListView lstDanhSach;
    EditText edtThemmm;
    Button btnThem;
    final ArrayList<User> arrUs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        mData = FirebaseDatabase.getInstance().getReference();


        anhxa();
        loadUser();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control();
            }
        });
        control();
    }

    private void control() {


        if(!TextUtils.isEmpty(edtThemmm.getText().toString()))
        {
            final String ID = edtThemmm.getText().toString();
            mData.child("User").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    User a = dataSnapshot.getValue(User.class);
                    if (a.getID().equals(ID)) {

                        thucthi(a);
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
            Toast.makeText(this, "Xin Nhập ID", Toast.LENGTH_SHORT).show();
        }


    }

    private void thucthi(User a) {
        User b = a;
        b.setPhanLoai(2);
        arrUs.add(b);
        mData.child("User").child(b.getID().toString()).setValue(b).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(HostActivity.this, "Cấp quyền thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void loadUser() {

        final adapterListMember adapterList = new adapterListMember(arrUs, getApplicationContext());
        lstDanhSach.setAdapter(adapterList);

        mData.child("User").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                User a = dataSnapshot.getValue(User.class);
                if (a.getPhanLoai() == 2) {
                    arrUs.add(a);
                    adapterList.notifyDataSetChanged();
                }


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                adapterList.notifyDataSetChanged();


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

    private void anhxa() {
        lstDanhSach = findViewById(R.id.lstMember);
        btnThem = findViewById(R.id.btnPhongChucVu);
        edtThemmm = findViewById(R.id.edtThemAdmin);
    }
}
