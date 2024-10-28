package com.example.samariddinbirinchiamaliy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private MusicService musicService;



    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Musiqa resurslarini tozalash
        if (musicService != null) {
            musicService.stopMusic();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Ilova pauza holatiga o'tganda musiqani pauza qilish
        if (musicService != null) {
            musicService.pauseMusic();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Ilova qayta ishga tushganda musiqani davom ettirish
        if (musicService != null) {
            musicService.resumeMusic();
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            musicService = new MusicService(this, R.raw.orqafon);
            musicService.startMusic();
            return insets;
        });


        Button stopbtn = findViewById(R.id.buttonRight);
        Button playbtn = findViewById(R.id.buttonLeft);

        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (musicService != null) {
                    musicService.pauseMusic();
                }
            }
        });
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (musicService != null) {
                    musicService.resumeMusic();
                }

            }
        });

        // 24 ta tugmani qidirish va raqam uzatishni tashkil etish
        for (int i = 1; i <= 24; i++) {
            int resId = getResources().getIdentifier("button" + i, "id", getPackageName());
            Button button = findViewById(resId);
            final int number = i; // Lambdani to'g'ri ishlatish uchun

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Raqamni uzatish
                    Intent intent = new Intent(MainActivity.this, activity1.class);
                    intent.putExtra("numberKey", number); // Raqamni uzatamiz
                    startActivity(intent);
                }
            });
        }

    }
}