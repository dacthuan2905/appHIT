package com.example.apphit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.apphit.homepage.AddClassRoom;

public class ClassRoom extends AppCompatActivity {
   ImageView layout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_classroom);
        layout=findViewById(R.id.imgadd_class);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ClassRoom.this, AddClassRoom.class);
                startActivity(intent);
            }
        });

    }
}
