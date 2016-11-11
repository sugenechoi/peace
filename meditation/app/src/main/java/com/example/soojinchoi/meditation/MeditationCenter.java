package com.example.soojinchoi.meditation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

/**
 * Created by soojinchoi on 16. 10. 11..
 */
public class MeditationCenter extends Activity
{

    boolean show = true;
    LinearLayout ll_meditationSoundControl;
    LinearLayout ll_sb_between;
    LinearLayout ll_sb_combined;
    Button but_pauseAndPlay;
    Button but_voiceControl;
    Button but_stop;
    boolean isPressed1 = false;
    boolean isPressed2 = false;
    boolean isPressed3 = false;
    boolean isPressed4 = false;
    ImageView iv_voice;
    ImageView iv_nature;
    MediaPlayer mPlayer1;
    MediaPlayer mPlayer2;
    FrameLayout fl_parent;
    SeekBar sb_voiceControl_between;
    SeekBar sb_voiceControl_combined;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meditationcenter);

        VideoView vv_meditationBackground = (VideoView) findViewById(R.id.vv_meditationbackground);
        ll_meditationSoundControl = (LinearLayout) findViewById(R.id.ll_meditationsoundcontrol);
        ll_meditationSoundControl.setVisibility(View.INVISIBLE);
        ll_sb_between = (LinearLayout) findViewById(R.id.ll_sb_between);
        ll_sb_combined = (LinearLayout) findViewById(R.id.ll_sb_combined);

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

        mPlayer1 = MediaPlayer.create(this, R.raw.clair_de_lune);
        mPlayer2 = MediaPlayer.create(this, R.raw.lovefoolosophy);
        mPlayer1.start();
        //mPlayer2.start();

        //vv_meditationBackground.setOnTouchListener(click_vv);

        but_pauseAndPlay = (Button) findViewById(R.id.but_pauseAndPlay);
        but_pauseAndPlay.setOnClickListener(click_pauseAndPlay);   //이름 한꺼번에 바꾸기- fn, shift, f6두번

        but_voiceControl = (Button) findViewById(R.id.but_voiceControl);
        but_voiceControl.setOnClickListener(click_voiceControl);

        but_stop = (Button) findViewById(R.id.but_stop);
        but_stop.setOnClickListener(click_stop);

        FrameLayout fl_dummy = (FrameLayout) findViewById(R.id.fl_dummy);
        fl_dummy.setOnClickListener(click_dummy);

        iv_voice = (ImageView) findViewById(R.id.iv_voice);
        iv_nature = (ImageView) findViewById(R.id.iv_nature);

        fl_parent = (FrameLayout) findViewById(R.id.fl_parent);

        sb_voiceControl_between = (SeekBar) findViewById(R.id.sb_voiceControl_between);
        sb_voiceControl_combined = (SeekBar) findViewById(R.id.sb_voiceControl_combined);
        ll_sb_combined.setVisibility(View.INVISIBLE);
        sb_voiceControl_between.setOnSeekBarChangeListener(changeEvent_between);
        //sb_voiceControl_combined.setOnSeekBarChangeListener(changeEvent_combined);

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

    SeekBar.OnSeekBarChangeListener changeEvent_between = new SeekBar.OnSeekBarChangeListener()
    {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b)
        {
            Log.d("apple", i+"");
            mPlayer1.setVolume(i,i);
            //mPlayer2.setVolume(i,i);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar)
        {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar)
        {

        }
    };

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

    View.OnClickListener click_pauseAndPlay = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            funcClickImageChange(but_pauseAndPlay, R.drawable.pausebutton, R.drawable.playbutton);
            funcClickSoundChange();

        }
    };

    View.OnClickListener click_stop = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            Log.d("apple","d");
            final android.support.v7.app.AlertDialog.Builder alert = new android.support.v7.app.AlertDialog.Builder(MeditationCenter.this);
            alert.setTitle("끝내시겠습니까?");
            alert.setMessage("명상이 진행중인데 진짜 끝내실거에요?");
            alert.setPositiveButton("끝내기", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    fl_parent.removeAllViews();
                    View maincenter = View.inflate(MeditationCenter.this, R.layout.maincenter, null);
                    fl_parent.addView(maincenter);

                    mPlayer1.stop();
                    mPlayer2.stop();
                }
            });
            alert.setNegativeButton("취소", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    dialogInterface.dismiss();
                }
            });
            alert.show();
        }
    };

    View.OnClickListener click_voiceControl = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            funcSeekBarChange();
        }
    };


    void funcClickImageChange(Button button, int a, int b)
    {
        if(isPressed1)
        {
            button.setBackgroundResource(a);
        }
        else
        {
            button.setBackgroundResource(b);
        }

        isPressed1 = !isPressed1;
    }

    void funcClickSoundChange()
    {
        if(isPressed3)
        {
            mPlayer1.start();
            mPlayer2.start();
        }
        else
        {
            mPlayer1.pause();
            mPlayer2.pause();
        }
        isPressed3 = !isPressed3;
    }

    void funcSeekBarChange()
    {
        if(isPressed4)
        {
            ll_sb_between.setVisibility(View.INVISIBLE);
            ll_sb_combined.setVisibility(View.VISIBLE);
        }
        else
        {
            ll_sb_between.setVisibility(View.VISIBLE);
            ll_sb_combined.setVisibility(View.INVISIBLE);
        }
        isPressed4 = !isPressed4;
    }

    void funcVisibility (ImageView iv1, ImageView iv2)
    {
        if(isPressed2)
        {
            funcTest(iv1, View.VISIBLE);
            funcTest(iv2, View.VISIBLE);
        }
        else
        {
            funcTest(iv1, View.INVISIBLE);
            funcTest(iv2, View.INVISIBLE);
        }
        isPressed2 = !isPressed2;

    }

    void funcTest(ImageView iv, int isOnOff)
    {
        iv.setVisibility(isOnOff);
    }

}
