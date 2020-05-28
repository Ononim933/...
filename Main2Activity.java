package com.example.zinatullin_timurka91;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.drm.DrmStore;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.OnlinRadio.R;

import static android.drm.DrmStore.Action.PLAY;

public class Main2Activity extends AppCompatActivity {
    private ImageView imagePlayPause;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    TextView textView;
    ImageView imageView;
    CheckBox checkBox;
    private ImageView imageNext;
    private ImageView imagePrevious;
    String audio = "http://air.radiorecord.ru:8101/rr_320";
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView);
        ImageView imageBack;
        seekBar = findViewById(R.id.seekBar);
        imageNext = findViewById(R.id.imageView);
        prepareMediaPlayer();
        imagePrevious = findViewById(R.id.imageView2);
        imagePlayPause = findViewById(R.id.imagePlayPause);
        mediaPlayer = new MediaPlayer();
        imageBack = findViewById(R.id.imageBack);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        imageView = findViewById(R.id.imageView5);
        int pos = getIntent().getIntExtra("pos", -1);
        if (pos == 0) {
            imageView.setImageResource(R.drawable.record);
            mediaPlayer.reset();
            audio = "http://air.radiorecord.ru:8101/rr_320";
            textView.setText("Radio Record");
        }
        if (pos == 1) {
            imageView.setImageResource(R.drawable.super1);
            mediaPlayer.reset();
            audio = "http://air.radiorecord.ru:8102/sd90_320";
            textView.setText("Супердискотека 90-х");
        }
        if (pos == 2) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.trancemission);
            audio = "http://air.radiorecord.ru:8102/tm_320";
            textView.setText("Trancemission");
        }
        if (pos == 3) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.russianmix);
            audio = "http://air.radiorecord.ru:8102/rus_320";
            textView.setText("Russian Mix");
        }
        if (pos == 4) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.medliakfm);
            audio = "http://air.radiorecord.ru:8102/mdl_320";
            textView.setText("Медляк FM");
        }
        if (pos == 5) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.recordchillout);
            audio = "http://air.radiorecord.ru:8102/chil_320";
            textView.setText("Record Chill-Out");
        }
        if (pos == 6) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.recordclub);
            audio = "http://air.radiorecord.ru:8102/club_320";
            textView.setText("Record Club");
        }
        if (pos == 7) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.gopfm);
            audio = "http://air.radiorecord.ru:8102/gop_320";
            textView.setText("Гоп FM");
        }
        if (pos == 8) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.vipmix);
            audio = "http://air.radiorecord.ru:8102/vip_320";
            textView.setText("Vip Mix");
        }
        if (pos == 9) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.pirate);
            audio = "http://air.radiorecord.ru:8102/ps_320";
            textView.setText("Pirate Station");
        }
        if (pos == 10) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.deep);
            audio = "http://air.radiorecord.ru:8102/deep_320";
            textView.setText("Record Deep");
        }
        if (pos == 11) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.breaks);
            audio = "http://air.radiorecord.ru:8102/brks_320";
            textView.setText("Record Breaks");
        }
        if (pos == 12) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.dancecore);
            audio = "http://air.radiorecord.ru:8102/dc_320";
            textView.setText("Record Dancecore");
        }
        if (pos == 13) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.recorddubstep);
            audio = "http://air.radiorecord.ru:8102/dub_320";
            textView.setText("Record Dubstep");
        }
        if (pos == 14) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.recordtrap);
            audio = "http://air.radiorecord.ru:8102/trap_320";
            textView.setText("Record Trap");
        }
        if (pos == 15) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.teodor);
            audio = "http://air.radiorecord.ru:8102/teo_320";
            textView.setText("Teodor Hardstyle");
        }
        if (pos == 17) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.pump);
            audio = "http://air.radiorecord.ru:8102/pump_320";
            textView.setText("Pump'n'Klubb");
        }
        if (pos == 16) {
            mediaPlayer.reset();
            imageView.setImageResource(R.drawable.yofm);
            audio = "http://air.radiorecord.ru:8102/yo_320";
            textView.setText("Yo! FM");
        }
        imageNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    imagePlayPause.setImageResource(R.drawable.ic_play);
                }
                if (audio == "http://air.radiorecord.ru:8101/rr_320") {
                    mediaPlayer.reset();
                    textView.setText("Супердискотека 90-х");
                    imageView.setImageResource(R.drawable.super1);
                    audio = "http://air.radiorecord.ru:8102/sd90_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/sd90_320") {
                    mediaPlayer.reset();
                    textView.setText("Trancemission");
                    imageView.setImageResource(R.drawable.trancemission);
                    audio = "http://air.radiorecord.ru:8102/tm_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/tm_320") {
                    mediaPlayer.reset();
                    textView.setText("Russian Mix");
                    imageView.setImageResource(R.drawable.russianmix);
                    audio = "http://air.radiorecord.ru:8102/rus_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/rus_320") {
                    mediaPlayer.reset();
                    textView.setText("Медляк FM");
                    imageView.setImageResource(R.drawable.medliakfm);
                    audio = "http://air.radiorecord.ru:8102/mdl_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/mdl_320") {
                    mediaPlayer.reset();
                    textView.setText("Record Chill-Out");
                    imageView.setImageResource(R.drawable.recordchillout);
                    audio = "http://air.radiorecord.ru:8102/chil_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/chil_320") {
                    mediaPlayer.reset();
                    textView.setText("Record Club");
                    imageView.setImageResource(R.drawable.recordclub);
                    audio = "http://air.radiorecord.ru:8102/club_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/club_320") {
                    mediaPlayer.reset();
                    textView.setText("Гоп FM");
                    imageView.setImageResource(R.drawable.gopfm);
                    audio = "http://air.radiorecord.ru:8102/gop_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/gop_320") {
                    mediaPlayer.reset();
                    textView.setText("Vip Mix");
                    imageView.setImageResource(R.drawable.vipmix);
                    audio = "http://air.radiorecord.ru:8102/vip_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/vip_320") {
                    mediaPlayer.reset();
                    textView.setText("Pirate Station");
                    imageView.setImageResource(R.drawable.pirate);
                    audio = "http://air.radiorecord.ru:8102/ps_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/ps_320") {
                    mediaPlayer.reset();
                    textView.setText("Record Deep");
                    imageView.setImageResource(R.drawable.deep);
                    audio = "http://air.radiorecord.ru:8102/deep_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/deep_320") {
                    mediaPlayer.reset();
                    textView.setText("Record Breaks");
                    imageView.setImageResource(R.drawable.breaks);
                    audio = "http://air.radiorecord.ru:8102/brks_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/brks_320") {
                    mediaPlayer.reset();
                    textView.setText("Record Dancecore");
                    imageView.setImageResource(R.drawable.dancecore);
                    audio = "http://air.radiorecord.ru:8102/dc_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/dc_320") {
                    mediaPlayer.reset();
                    textView.setText("Record Dubstep");
                    imageView.setImageResource(R.drawable.recorddubstep);
                    audio = "http://air.radiorecord.ru:8102/dub_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/dub_320") {
                    mediaPlayer.reset();
                    textView.setText("Record Trap");
                    imageView.setImageResource(R.drawable.recordclub);
                    audio = "http://air.radiorecord.ru:8102/trap_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/trap_320") {
                    mediaPlayer.reset();
                    textView.setText("Teodor Hardstyle");
                    imageView.setImageResource(R.drawable.teodor);
                    audio = "http://air.radiorecord.ru:8102/teo_320";
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/teo_320") {
                    mediaPlayer.reset();
                    textView.setText("Yo! FM");
                    audio = "http://air.radiorecord.ru:8102/yo_320";
                    imageView.setImageResource(R.drawable.yofm);
                    return;
                }
                if (audio == "http://air.radiorecord.ru:8102/yo_320") {
                    mediaPlayer.reset();
                    textView.setText("Pump'n'Klubb");
                    imageView.setImageResource(R.drawable.pump);
                    audio = "http://air.radiorecord.ru:8102/pump_320";
                    return;
                }

            }
        });

        imagePrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (audio == "http://air.radiorecord.ru:8101/rr_320") {
                    Intent intent1 = new Intent(Main2Activity.this, MainActivity.class);
                    startActivityForResult(intent1, 0);
                    overridePendingTransition(0, 0);
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    imagePlayPause.setImageResource(R.drawable.ic_play);
                }
                if (audio == "http://air.radiorecord.ru:8102/sd90_320") {
                    mediaPlayer.reset();
                    textView.setText("Radio Record");
                    imageView.setImageResource(R.drawable.record);
                    audio = "http://air.radiorecord.ru:8101/rr_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/tm_320") {
                    mediaPlayer.reset();
                    imageView.setImageResource(R.drawable.super1);
                    textView.setText("Супердискотека 90-х");
                    audio = "http://air.radiorecord.ru:8102/sd90_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/rus_320") {
                    mediaPlayer.reset();
                    textView.setText("Trancemission");
                    imageView.setImageResource(R.drawable.trancemission);
                    audio = "http://air.radiorecord.ru:8102/tm_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/mdl_320") {
                    mediaPlayer.reset();
                    textView.setText("Russian Mix");
                    imageView.setImageResource(R.drawable.russianmix);
                    audio = "http://air.radiorecord.ru:8102/rus_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/chil_320") {
                    mediaPlayer.reset();
                    textView.setText("Медляк FM");
                    imageView.setImageResource(R.drawable.medliakfm);
                    audio = "http://air.radiorecord.ru:8102/mdl_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/club_320") {
                    mediaPlayer.reset();
                    textView.setText("Record Chill-Out");
                    imageView.setImageResource(R.drawable.recordchillout);
                    audio = "http://air.radiorecord.ru:8102/chil_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/gop_320") {
                    mediaPlayer.reset();
                    textView.setText("Record Club");
                    imageView.setImageResource(R.drawable.recordclub);
                    audio = "http://air.radiorecord.ru:8102/club_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/vip_320") {
                    mediaPlayer.reset();
                    imageView.setImageResource(R.drawable.gopfm);
                    textView.setText("Гоп FM");
                    audio = "http://air.radiorecord.ru:8102/gop_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/ps_320") {
                    mediaPlayer.reset();
                    textView.setText("Vip Mix");
                    imageView.setImageResource(R.drawable.vipmix);
                    audio = "http://air.radiorecord.ru:8102/vip_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/deep_320") {
                    mediaPlayer.reset();
                    textView.setText("Pirate Station");
                    imageView.setImageResource(R.drawable.pirate);
                    audio = "http://air.radiorecord.ru:8102/ps_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/brks_320") {
                    mediaPlayer.reset();
                    textView.setText("Record Deep");
                    imageView.setImageResource(R.drawable.deep);
                    audio = "http://air.radiorecord.ru:8102/deep_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/dc_320") {
                    mediaPlayer.reset();
                    textView.setText("Record Breaks");
                    imageView.setImageResource(R.drawable.breaks);
                    audio = "http://air.radiorecord.ru:8102/brks_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/dub_320") {
                    mediaPlayer.reset();
                    textView.setText("Record Dancecore");
                    imageView.setImageResource(R.drawable.dancecore);
                    audio = "http://air.radiorecord.ru:8102/dc_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/trap_320") {
                    mediaPlayer.reset();
                    textView.setText("Record Dubstep");
                    imageView.setImageResource(R.drawable.recorddubstep);
                    audio = "http://air.radiorecord.ru:8102/dub_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/teo_320") {
                    mediaPlayer.reset();
                    textView.setText("Record Trap");
                    imageView.setImageResource(R.drawable.recordtrap);
                    audio = "http://air.radiorecord.ru:8102/trap_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/yo_320") {
                    mediaPlayer.reset();
                    textView.setText("Teodor Hardstyle");
                    imageView.setImageResource(R.drawable.teodor);
                    audio = "http://air.radiorecord.ru:8102/teo_320";
                }
                if (audio == "http://air.radiorecord.ru:8102/pump_320") {
                    mediaPlayer.reset();
                    textView.setText("Yo! FM");
                    imageView.setImageResource(R.drawable.yofm);
                    audio = "http://air.radiorecord.ru:8102/yo_320";
                }
            }
        });
        imagePlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    imagePlayPause.setImageResource(R.drawable.ic_play);
                } else {
                    mediaPlayer.start();
                    imagePlayPause.setImageResource(R.drawable.ic_pause);
                }
            }
        });

        prepareMediaPlayer();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int maxVolume = 50;
                int currVolume = (seekBar.getProgress());
                float volume = (float) (Math.log(maxVolume - currVolume) / Math.log(maxVolume));
                mediaPlayer.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void prepareMediaPlayer(){
        try {
            mediaPlayer.setDataSource(audio);
            mediaPlayer.prepare();
        }catch (Exception exception){
            Toast toast = Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT);
            toast.show();
        }
        }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.reset();
        }

    }

    @Override
    public void onBackPressed() {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.reset();
        super.onBackPressed();
    }
}
}