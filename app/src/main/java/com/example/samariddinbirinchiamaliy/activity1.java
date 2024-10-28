package com.example.samariddinbirinchiamaliy;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import java.util.Map;
import android.media.MediaPlayer;

public class activity1 extends AppCompatActivity {

    // 1 dan 24 gacha bo'lgan raqamlar uchun lug'at
    private static final Map<Integer, String> telefon = Map.ofEntries(
            Map.entry(1, "+998947811209"),
            Map.entry(2, "+998940492417"),
            Map.entry(3, "+998944477484"),
            Map.entry(4, "+998914180265"),
            Map.entry(5, "+998888547744"),
            Map.entry(6, "+998945895355"),
            Map.entry(7, "+998974717671"),
            Map.entry(8, "+998933593379"),
            Map.entry(9, "+998940503304"),
            Map.entry(10, "+998884834500"),
            Map.entry(11, "+998911942504"),
            Map.entry(12, "+998941903876"),
            Map.entry(13, "+998991870358"),
            Map.entry(14, "+998910293676"),
            Map.entry(15, "+998944240922"),
            Map.entry(16, "+998918877477"),
            Map.entry(17, "+998948196469"),
            Map.entry(18, "+998931900332"),
            Map.entry(19, "+998933243803"),
            Map.entry(20, "+998910251904"),
            Map.entry(21, "+998976902123"),
            Map.entry(22, "+998883273020"),
            Map.entry(23, "+998904990425"),
            Map.entry(24, "+998918870815")
    );
    private static final Map<Integer, String> telegram = Map.ofEntries(
            Map.entry(1, "https://t.me/alijonovna_004"),
            Map.entry(2, "https://t.me/mohinur20055"),
            Map.entry(3, "https://t.me/Begzod_Eshmatov"),
            Map.entry(4, "https://t.me/D1lshodovna_1106"),
            Map.entry(5, "https://t.me/Turdibek_Ismatov"),
            Map.entry(6, "https://t.me/Matematik_Dilshoda"),
            Map.entry(7, "https://t.me/gaybullaev1ch"),
            Map.entry(8, "https://t.me/murotbayeva"),
            Map.entry(9, "https://t.me/Rayhonimsiz_Onajon"),
            Map.entry(10, "https://t.me/narzikulova_d"),
            Map.entry(11, "https://t.me/baxa_Na"),
            Map.entry(12, "https://t.me/M1rzabek_Nurmamat0v"),
            Map.entry(13, "https://t.me/Maftuna_13_02"),
            Map.entry(14, "https://t.me/Elshod04"),
            Map.entry(15, "https://t.me/aslan0924"),
            Map.entry(16, "https://t.me/Maftuna_13_02"),
            Map.entry(17, "https://t.me/shahlo_0711"),
            Map.entry(18, "https://t.me/Miss_dildora1diadema"),
            Map.entry(19, "https://t.me/udev23"),
            Map.entry(20, "https://t.me/sheikh_0119"),
            Map.entry(21, "https://t.me/Tursun0v95"),
            Map.entry(22, "https://t.me/nurbek_3020"),
            Map.entry(23, "https://t.me/Umidj0n_0425"),
            Map.entry(24, "https://t.me/xursandof")
    );
    private static final Map<Integer, String> manzil = Map.ofEntries(
            Map.entry(1, "https://maps.app.goo.gl/vLuvFxXRNrhomFRR6"),
            Map.entry(2, "https://maps.app.goo.gl/eaQjhRNpw79C1iKg7"),
            Map.entry(3, "https://maps.app.goo.gl/DTfenfnhcskXsw9b9"),
            Map.entry(4, "https://maps.app.goo.gl/QS7Z3LfLzCbiS9uV6"),
            Map.entry(5, "https://maps.app.goo.gl/cbhkPPFBXR6RPRku6"),
            Map.entry(6, "https://maps.app.goo.gl/t7E6Y8tg6HuVUf5J6"),
            Map.entry(7, "https://maps.app.goo.gl/gGdTLDhsEs6rB9wx6"),
            Map.entry(8, "https://maps.app.goo.gl/KtHiEfxWpxRd3LSYA"),
            Map.entry(9, "https://maps.app.goo.gl/y9dz95KzYfStRo4TA"),
            Map.entry(10, "https://maps.app.goo.gl/xoomQK5DQWfGuiBNA"),
            Map.entry(11, "https://maps.app.goo.gl/4YrQoLoF1qB4vCoa7"),
            Map.entry(12, "https://maps.app.goo.gl/jDjNCer82uSLJySu8"),
            Map.entry(13, "https://maps.app.goo.gl/SxDvGCZagnNDda9H7"),
            Map.entry(14, "https://maps.app.goo.gl/jU6msTtmReUDaxi26"),
            Map.entry(15, "https://maps.app.goo.gl/5pyF1YKbFr9XB1CAA"),
            Map.entry(16, "https://maps.app.goo.gl/uTQoPbeVjsWTC2DY9"),
            Map.entry(17, "https://maps.app.goo.gl/LWeStXQBoAsaFK2E7"),
            Map.entry(18, "https://maps.app.goo.gl/SxDvGCZagnNDda9H7"),
            Map.entry(19, "https://maps.app.goo.gl/zXmeggv921Srrbyz7"),
            Map.entry(20, "https://maps.app.goo.gl/uTQoPbeVjsWTC2DY9"),
            Map.entry(21, "https://maps.app.goo.gl/qTjEAbcqcWRGwtU5A"),
            Map.entry(22, "https://maps.app.goo.gl/FWgaNVUrG1aDBxmeA"),
            Map.entry(23, "https://maps.app.goo.gl/eaQjhRNpw79C1iKg7"),
            Map.entry(24, "https://maps.app.goo.gl/qTjEAbcqcWRGwtU5A")
    );
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



    private EditText editTextSms;
    private Button buttonSms, buttonTel, buttonHemIs, buttonManzil, buttontelegram;

    private static final int REQUEST_CALL_PERMISSION = 1;
    private static final int REQUEST_SMS_PERMISSION = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        musicService = new MusicService(this, R.raw.meduza);
        musicService.startMusic();





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);  // activity1.xml dan foydalanamiz

        // TextView orqali uzatilgan raqamni ko'rsatish
        TextView textView = findViewById(R.id.textView);  // textView XML dan olingan

        // Intent orqali raqamni qabul qilish
        int number = getIntent().getIntExtra("numberKey", -1);  // Default -1 agar uzatilmasa

        // Raqamni TextView da ko'rsatish
        textView.setText("Qabul qilingan raqam: " + number);

        editTextSms = findViewById(R.id.editTextSMS);
        buttonTel = findViewById(R.id.buttontel);
        buttonSms = findViewById(R.id.buttonsms);
        buttonHemIs = findViewById(R.id.buttonhemis); // `buttonhemis`ni toping
        buttonManzil = findViewById(R.id.buttonmanzil);
        buttontelegram = findViewById(R.id.buttontg);

        // Telefon chaqiruvini amalga oshirish
        buttonTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int key = 1; // Tugma uchun kalit (1 dan 24 gacha)
                makePhoneCall(number);
            }
        });

        // SMS yuborish
        buttonSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int key = 1; // Tugma uchun kalit (1 dan 24 gacha)
                sendSms(number);
            }
        });

        // Havolani brauzerda ochish
        buttonHemIs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://student.jbnuu.uz"; // Ochiq havola
                openBrowser(url);
            }
        });

        //Telegramga o'tish
        buttontelegram.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String tgusername = telegram.get(number);
                openBrowser(tgusername);
            }
        });

        //manzilni korsatish
        buttonManzil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String m = manzil.get(number);
                openBrowser(m);
            }
        });
    }

    private void makePhoneCall(int key) {
        String phoneNumber = telefon.get(key); // Kalit orqali raqamni oling

        if (phoneNumber != null && phoneNumber.trim().length() > 0) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Ruxsat yo'q bo'lsa, so'rang
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
            } else {
                // Ruxsat mavjud bo'lsa, chaqiruvni amalga oshiring
                String dial = "tel:" + phoneNumber;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            // Raqam topilmasa, xabar berish
            Toast.makeText(this, "Raqam topilmadi!", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendSms(int key) {
        String phoneNumber = telefon.get(key); // Kalit orqali raqamni oling
        String message = editTextSms.getText().toString(); // EditTextdan matnni oling

        if (phoneNumber != null && phoneNumber.trim().length() > 0) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                // Ruxsat yo'q bo'lsa, so'rang
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS_PERMISSION);
            } else {
                // Ruxsat mavjud bo'lsa, SMS yuboring
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Toast.makeText(this, "Xabar yuborildi!", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Raqam topilmasa, xabar berish
            Toast.makeText(this, "Raqam topilmadi!", Toast.LENGTH_SHORT).show();
        }
    }

    private void openBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url)); // URLni brauzerda ochish
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Ruxsat berilganda, chaqiruvni amalga oshirish
                int key = 1; // Tugma uchun kalit
                makePhoneCall(key);
            } else {
                // Ruxsat berilmasa, foydalanuvchiga xabar berish
                Toast.makeText(this, "Ruxsat berilmagan", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_SMS_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Ruxsat berilganda, SMS yuboring
                int key = 1; // Tugma uchun kalit
                sendSms(key);
            } else {
                // Ruxsat berilmasa, foydalanuvchiga xabar berish
                Toast.makeText(this, "Ruxsat berilmagan", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
