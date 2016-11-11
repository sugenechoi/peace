package com.example.soojinchoi.meditation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by soojinchoi on 16. 10. 4..
 */
public class startbreathing extends AppCompatActivity
{
    TextView tv_breathinout;
    boolean inout;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startbreathinglayout);

        ImageView iv_deepbreath = (ImageView) findViewById(R.id.iv_deepbreath);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);

        tv_breathinout = (TextView) findViewById(R.id.tv_breathinout);
        inout = false;

        final Button but_startbreathing_continue = (Button) findViewById(R.id.but_startbreathing_continue);
        //but_startbreathing_continue.setVisibility(View.INVISIBLE);
        but_startbreathing_continue.setOnClickListener(click_shortbreathingcontinue);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {

            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {
                if ( inout == false)
                {
                    funcAnim(2,1,1,0);
                    tv_breathinout.setText("내쉬고");
                    inout = true;
                }
                else
                {
                    funcAnim(1,2,1,0);
                    tv_breathinout.setText("마쉬고");
                    inout = false;
                }

                if (count == 4)
                {
                    but_startbreathing_continue.setVisibility(View.VISIBLE);
                }
            }
        });
        iv_deepbreath.startAnimation(animation);
        funcAnim(1,2,1,0);
    }

    void funcAnim(float a, float b, float textAlphaValue1, float textAlphaValue2)
    {
        ObjectAnimator anim = ObjectAnimator.ofFloat(tv_breathinout, View.SCALE_X, a, b);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(tv_breathinout, View.SCALE_Y, a, b);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(tv_breathinout, View.ALPHA, textAlphaValue1, textAlphaValue2);
        anim.setDuration(5000);
        anim1.setDuration(5000);
        anim2.setDuration(5000);

        AnimatorSet animset = new AnimatorSet();
        animset.playTogether(anim, anim1, anim2); // 파라미터에 ... 있으면 여러개 적용할 수 있음.

        count++;
        animset.start();
    }

    View.OnClickListener click_shortbreathingcontinue= new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            Intent i = new Intent(startbreathing.this, PreShortMeditation.class);
            startActivity(i);
            finish();
        }
    };
}
