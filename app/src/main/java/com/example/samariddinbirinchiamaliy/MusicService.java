// MusicService.java
package com.example.samariddinbirinchiamaliy;

import android.content.Context;
import android.media.MediaPlayer;

public class MusicService {
    private MediaPlayer mediaPlayer;

    // Konstruktor orqali musiqani yuklash
    public MusicService(Context context, int musicResource) {
        mediaPlayer = MediaPlayer.create(context, musicResource);
        mediaPlayer.setLooping(true); // Musiqa takrorlanishi uchun
    }

    // Musiqani boshlash
    public void startMusic() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    // Musiqani to'xtatish
    public void stopMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    // Musiqani pauza qilish
    public void pauseMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    // Musiqani davom ettirish
    public void resumeMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }
}
