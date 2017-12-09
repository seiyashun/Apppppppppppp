package com.tangtuongco.apppppppppppp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.tangtuongco.apppppppppppp.R;
import com.tangtuongco.apppppppppppp.model.BaiViet;
import com.tangtuongco.apppppppppppp.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ViewFlipper viewFlipper;
    ListView lstMain;
    TextView idbarrr,emailbarr;
    DatabaseReference mData;
    User user;
    int flag=0;
    ArrayList<BaiViet> listbvuser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemBaiViet.class);
                intent.putExtra("taikhoan", user);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        idbarrr=header.findViewById(R.id.txtIDBARR);
        emailbarr=header.findViewById(R.id.txtEMAILBARRR);
        getSupportActionBar().setTitle("Trang Chủ");


        mData= FirebaseDatabase.getInstance().getReference("BaiViet");
        anhxa();
        ActionViewFlipper();
        control();

    }

    private void control() {
        Intent i =getIntent();
        user= (User) i.getSerializableExtra("taikhoan");
        idbarrr.setText(user.getName().toString());
        emailbarr.setText(user.getEmail().toString());
        BaiViet baiViet=new BaiViet();
        baiViet.setIduser(user.getID());
        String id=user.getID();
        mData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                BaiViet bv = new BaiViet();
                bv.setIduser(user.getID());


                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    BaiViet post = postSnapshot.getValue(BaiViet.class);
                    String idddd = post.getIduser();


                    if (idddd.equals(user.getID())) {
                        {

                            flag = 1;

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

        }
        else
        {
           mData.child(id).setValue(baiViet).addOnCompleteListener(new OnCompleteListener<Void>() {
               @Override
               public void onComplete(@NonNull Task<Void> task) {

               }
           });
        }
    }

    private void ActionViewFlipper() {
        ArrayList<Integer> mangquangcao= new ArrayList<>();
        mangquangcao.add(R.drawable.anh1);
        mangquangcao.add(R.drawable.anh2);
        mangquangcao.add(R.drawable.anh3);
        mangquangcao.add(R.drawable.anh4);
        for(int i=0;i<mangquangcao.size();i++)
        {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
            Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
            Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
            viewFlipper.setInAnimation(animation_slide_in);
            viewFlipper.setOutAnimation(animation_slide_out);

        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);

    }


    private void anhxa() {


        viewFlipper = findViewById(R.id.viewflipper);
        lstMain = findViewById(R.id.lstMain);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
