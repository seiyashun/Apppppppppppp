package com.tangtuongco.apppppppppppp.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.tangtuongco.apppppppppppp.R;
import com.tangtuongco.apppppppppppp.model.BaiViet;
import com.tangtuongco.apppppppppppp.model.ChiTietBaiViet;
import com.tangtuongco.apppppppppppp.model.ChuDe;
import com.tangtuongco.apppppppppppp.model.User;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ThemBaiViet extends AppCompatActivity {
    User user = new User();
    EditText edtTieuDe;
    ImageView imgMonAn;
    Button btnDangBai, btnUpload, btnChon;
    TextView txtTrangThai;
    Spinner spinnerTHELOAI;
    String record = "";
    String tamthoi;
    String tamthoivideo;
    DatabaseReference mData;
    private Uri filePath;
    private static final int REQUEST_READ_PERMISSION = 9003;
    final int REQUEST_CHOOSE_PIC = 321;
    VideoView videoview;
    ProgressBar trangthai;
    private Uri videoUri;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    private static final int REQUEST_CODE=101;
    private StorageReference videoRef;
    SimpleExoPlayer exoPlayer;
    SimpleExoPlayerView exoPlayerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_bai_viet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Bài Viết Mới");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        anhxa();
        mData = FirebaseDatabase.getInstance().getReference();
//        StorageReference storageReference=FirebaseStorage.getInstance().getReference();
//        videoRef=storageReference.child("/video/"+user.getID()+createID()+"/monan.3gp");

        loadDataSpinner();

        control();

    }

    @Override
    public void onBackPressed() {
        finish();
    }
    //    public  void upload(View view)
//    {
//        if(videoUri!=null)
//        {
//            UploadTask uploadTask=videoRef.putFile(videoUri);
//
//            uploadTask.addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception exception) {
//                    Toast.makeText(ThemBaiViet.this, "Upload thất bại", Toast.LENGTH_SHORT).show();
//                }
//            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    Toast.makeText(ThemBaiViet.this, "Upload thành công", Toast.LENGTH_SHORT).show();
//                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
//                   Uri downloadUrl = taskSnapshot.getDownloadUrl();
//
//                }
//            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
//                    updateProgress(taskSnapshot);
//                }
//            });
//
//        }
//    }

//    public  void chonvideo(View view)
//    {
//        Intent intent =new Intent();
//        intent.setType("video/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent,"Chọn video"),REQUEST_CODE);
//    }

    private void updateProgress(UploadTask.TaskSnapshot taskSnapshot) {

        long uploadBytes=taskSnapshot.getBytesTransferred();

        long progress = (100*uploadBytes);
        Toast.makeText(this, "Uploading", Toast.LENGTH_SHORT).show();

        trangthai.setProgress((int) progress);


    }

    private void loadDataSpinner() {
        final ArrayList<String> arrChuDe = new ArrayList<>();
        final ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrChuDe);
        spinnerTHELOAI.setAdapter(adapterSpinner);
        mData.child("DanhSachTheLoai").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChuDe cd = dataSnapshot.getValue(ChuDe.class);
                arrChuDe.add(cd.getTenChuDe().toString());
                adapterSpinner.notifyDataSetChanged();

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

    private void control() {
        final String aaaa;


        final StorageReference storageRef = storage.getReferenceFromUrl("gs://cookapp-db2c5.appspot.com");
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chonpic();


            }
        });


        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.setType("video/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Chọn video"),REQUEST_CODE);


            }
        });
        btnDangBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(tamthoivideo))
                {
                    int idbaiviet = createID();
                    String chude = spinnerTHELOAI.getSelectedItem().toString();
                    ChiTietBaiViet chitiet = new ChiTietBaiViet();
                    BaiViet bv = new BaiViet();
                    bv.setIduser(user.getID().toString());
                    bv.setTenChuDe(chude.toString());
                    bv.setIDBAIVIET(String.valueOf(idbaiviet));
                    chitiet.setIDCuaBaiViet(bv.getIDBAIVIET());
                    int idchitiet = createID();
                    idchitiet = idchitiet + 1;
                    chitiet.setIDChiTietBaiViet(String.valueOf(idchitiet));
                    bv.setTenBaiViet(edtTieuDe.getText().toString());
                    bv.setChiTietBaiViet(chitiet);
                    bv.setImageIndex(tamthoi);
                    chitiet.setVideo(tamthoivideo);

                    Long tslong = System.currentTimeMillis() / 1000;
                    String ts = createTime();
                    bv.setTime(ts);


                    String IDBAIVIET = createID() + user.getID().toString();
                    mData.child("DanhSachBaiViet").push().setValue(bv).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(ThemBaiViet.this, "Đăng Bài Thành Công", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });
                }
                else {
                    Toast.makeText(ThemBaiViet.this, "Xin chọn video", Toast.LENGTH_SHORT).show();
                }





            }
        });


    }

    private void ThemLink(String linkhinh) {
        tamthoi = linkhinh;
    }

    private void chonpic() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_CHOOSE_PIC);
    }

    public int createID() {
        Date now = new Date();
        int id = Integer.parseInt(new SimpleDateFormat("ddHHmmss", Locale.US).format(now));
        return id;
    }

    public String createTime() {
        Date now = new Date();
        String id = (new SimpleDateFormat("ddMMyyHHmmss", Locale.US).format(now));
        return id;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final StorageReference storageRef = storage.getReferenceFromUrl("gs://cookapp-db2c5.appspot.com");
        //Up video
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK &&data!=null && data.getData()!=null)
        {




            StorageReference mountainsRef = storageRef.child("/video/"+user.getID()+createID()+"monan.mp4");

            videoUri=data.getData();

                UploadTask uploadTask=mountainsRef.putFile(videoUri);

                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                public void onFailure(@NonNull Exception exception) {
                        Toast.makeText(ThemBaiViet.this, "Upload thất bại", Toast.LENGTH_SHORT).show();
                    // Handle unsuccessful uploads
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                    Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    Toast.makeText(ThemBaiViet.this, "Upload thành công", Toast.LENGTH_SHORT).show();
                    loadvideo(downloadUrl);
                    final String linkvdieo = String.valueOf(downloadUrl);
                    ThemLinkVideo(linkvdieo);
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                        updateProgress(taskSnapshot);
                    }
                });














        }
        //Up ảnh
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CHOOSE_PIC) {


                try {
                    Uri imageUri = data.getData();
                    InputStream is = null;
                    is = getContentResolver().openInputStream(imageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    imgMonAn.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                StorageReference mountainsRef = storageRef.child("monan" + createID() + ".png");
                //Them Hinh Len Sto
                imgMonAn.setDrawingCacheEnabled(true);
                imgMonAn.buildDrawingCache();
                Bitmap bitmap = imgMonAn.getDrawingCache();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] dataaaaaa = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(dataaaaaa);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast.makeText(ThemBaiViet.this, "Chưa Up được", Toast.LENGTH_SHORT).show();
                        // Handle unsuccessful uploads
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        final String linkhinh = String.valueOf(downloadUrl);
                        ThemLink(linkhinh);


                    }


                });

                //Picasso.with(getApplicationContext()).load(imageUri).into(imgAva);

            }
        }
    }

    private void ThemLinkVideo(String linkvdieo) {
        tamthoivideo=linkvdieo;
        txtTrangThai.setText("Đã có video");
    }

    private void loadvideo(Uri downloadUrl) {

//        videoview.setVideoURI(downloadUrl);
//        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                mediaPlayer.setVolume(55,55);
//            }
//        });
//        videoview.start();
        BandwidthMeter bandwidthMeter=new DefaultBandwidthMeter();
        TrackSelector trackSelector=new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
        exoPlayer= ExoPlayerFactory.newSimpleInstance(this,trackSelector);
        DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
        ExtractorsFactory extractorsFactory=new DefaultExtractorsFactory();
        MediaSource videosource=new ExtractorMediaSource(videoUri,dataSourceFactory,extractorsFactory,null,null);
        exoPlayerView.setPlayer(exoPlayer);
        exoPlayer.prepare(videosource);
        exoPlayer.setPlayWhenReady(true);

    }

    private void ShowFileChooser() {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Chọn Video"), REQUEST_READ_PERMISSION);

    }

    private void anhxa() {
        Intent i = getIntent();
        user = (User) i.getSerializableExtra("taikhoan");
        btnDangBai = findViewById(R.id.btnDANGBAI);
        btnUpload = findViewById(R.id.btnUPVIDEO);
        txtTrangThai = findViewById(R.id.txtTRANGTHAI);
        edtTieuDe = findViewById(R.id.edtTieuDe);
        spinnerTHELOAI = findViewById(R.id.spinnerTHELOAI);
        btnChon = findViewById(R.id.btnChon);
        imgMonAn = findViewById(R.id.imgMonAn);
        trangthai =findViewById(R.id.pdbar);
//        videoview=findViewById(R.id.videoview);
        exoPlayerView=findViewById(R.id.exoplayerview1);

    }
}