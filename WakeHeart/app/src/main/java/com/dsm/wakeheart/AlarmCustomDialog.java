package com.dsm.wakeheart;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.skyfishjy.library.RippleBackground;

/**
 * Created by parktaeim on 2017. 9. 24..
 */

public class AlarmCustomDialog extends Activity {

    private Button okButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_alarm);

        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
        rippleBackground.startRippleAnimation();

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();  // 음악 재생


        okButton = (Button) findViewById(R.id.okButton);
        //확인 버튼 눌러 다이얼로그 끄기, 음악재생도 함께 종료
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                mediaPlayer.stop();
            }
        });

    }

}
