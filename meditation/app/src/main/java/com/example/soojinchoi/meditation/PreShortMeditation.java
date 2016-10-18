package com.example.soojinchoi.meditation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by soojinchoi on 16. 10. 11..
 */
public class PreShortMeditation extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preshortmeditationlayout);

        ImageView iv_playshortmeditation = (ImageView) findViewById(R.id.iv_playshortmeditation);
        iv_playshortmeditation.setOnClickListener(click_play);
    }

    View.OnClickListener click_play = new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            Intent i = new Intent(PreShortMeditation.this, MeditationCenter.class);
            startActivity(i);
        }
    };
}
