package com.example.setting;

import android.content.Intent;
import android.net.Uri;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.app.Activity.RESULT_OK;

public class MainActivity extends AppCompatActivity {
    private ImageView img1;
    private Button imgbutton;


    private final int Code_image_galeery=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        imgbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivityForResult(Intent.createChooser(new Intent().
                        setAction(Intent.ACTION_GET_CONTENT).
                        setType("image/*"),"Selecting un image"),Code_image_galeery);
            }
        });

            }
    private void init(){
        this.img1=findViewById(R.id.profile_pic);
        this.imgbutton=findViewById(R.id.editbutton);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Code_image_galeery && resultCode == RESULT_OK) {
            Uri imgUri = data.getData();
            if (imgUri != null) {
                img1.setImageURI(imgUri);
            }
        }
    }

        }
