package com.example.soojinchoi.meditation;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by soojinchoi on 16. 10. 11..
 */
public class MeditationCenter extends Activity
{

    boolean show = true;
    LinearLayout ll_meditationSoundControl;
    Button but_pauseAndPlay;
    Button but_voiceControl;
    boolean isPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meditationcenter);

        VideoView vv_meditationBackground = (VideoView) findViewById(R.id.vv_meditationbackground);
        ll_meditationSoundControl = (LinearLayout) findViewById(R.id.ll_meditationsoundcontrol);
        ll_meditationSoundControl.setVisibility(View.INVISIBLE);

        MediaController mc = new MediaController(this); //mediacontroller - 동영상 재생,정지 등등/소리 줄이려고 이거 쓰심
        mc.setMediaPlayer(vv_meditationBackground);

        int id = getResources().getIdentifier("swaying", "raw", getPackageName());
        String path = "android.resource://" + getPackageName() + "/" + id;

        vv_meditationBackground.setVideoURI(Uri.parse(path));
        vv_meditationBackground.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
            @Override
            public void onPrepared(MediaPlayer mp)
            {
                mp.setVolume(0f, 0f);
            }
        });
        vv_meditationBackground.start();

        //vv_meditationBackground.setOnTouchListener(click_vv);

        but_pauseAndPlay = (Button) findViewById(R.id.but_pauseAndPlay);
        funcClickchange(but_pauseAndPlay, R.drawable.pausebutton, R.drawable.playbutton);
        //but_pauseAndPlay.setOnClickListener(click_pauseAndPlay);   //이름 한꺼번에 바꾸기- fn, shift, f6두번

        but_voiceControl = (Button) findViewById(R.id.but_voiceControl);
        funcClickchange(but_voiceControl, R.drawable.voicecontrol, R.drawable.speakerbutton);
        //but_voiceControl.setOnClickListener(click_voiceControl);

        FrameLayout fl_dummy = (FrameLayout) findViewById(R.id.fl_dummy);
        fl_dummy.setOnClickListener(click_dummy);

    }

//    View.OnTouchListener click_vv = new View.OnTouchListener()
//    {
//        @Override
//        public boolean onTouch(View view, MotionEvent motionEvent)
//        {
//            if (show == true)
//            {
//                ll_meditationSoundControl.setVisibility(View.VISIBLE);
//                show = false;
//            }
//            else
//            {
//                ll_meditationSoundControl.setVisibility(View.INVISIBLE);
//                show = true;
//            }
//            return false; //listenr 2개 이상일 때는 true
//        }
//    };

    View.OnClickListener click_dummy = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            if (show == true)
            {
                ll_meditationSoundControl.setVisibility(View.VISIBLE);
                show = false;
            }
            else
            {
                ll_meditationSoundControl.setVisibility(View.INVISIBLE);
                show = true;
            }
        }
    };

//    View.OnClickListener click_pauseAndPlay = new View.OnClickListener()
//    {
//        @Override
//        public void onClick(View view)
//        {
//            if (isPressed)
//                but_pauseAndPlay.setBackgroundResource(R.drawable.pausebutton);
//            else
//                but_pauseAndPlay.setBackgroundResource(R.drawable.playbutton);
//
//            isPressed = !isPressed;
//        }
//    };
//
//    View.OnClickListener click_voiceControl = new View.OnClickListener() {
//        @Override
//        public void onClick(View view)
//        {
//            if(isPressed)
//                but_voiceControl.setBackgroundResource(R.drawable.voicecontrol);
//            else
//                but_voiceControl.setBackgroundResource(R.drawable.speakerbutton);
//
//            isPressed = !isPressed;
//        }
//    };


    void funcClickchange(Button button, int a, int b)
    {
        if(isPressed)
            button.setBackgroundResource(a);
        else
            button.setBackgroundResource(b);

        isPressed = !isPressed;
    }

}
