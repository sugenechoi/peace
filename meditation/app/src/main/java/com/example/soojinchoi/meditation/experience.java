package com.example.soojinchoi.meditation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by soojinchoi on 16. 9. 24..
 */
public class experience extends AppCompatActivity {
    int count = 0;
    Button but_ex_continue;
    Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.experiencelayout);

        buttons = new Button[3];

        buttons[0] = (Button) findViewById(R.id.but_ex1);  //(Button)이 casting 하는 것.
        buttons[0].setOnClickListener(click_ex);
        buttons[1] = (Button) findViewById(R.id.but_ex2);
        buttons[1].setOnClickListener(click_ex);
        buttons[2] = (Button) findViewById(R.id.but_ex3);
        buttons[2].setOnClickListener(click_ex);


        but_ex_continue = (Button) findViewById(R.id.but_ex_continue);
        but_ex_continue.setVisibility(View.INVISIBLE);
        but_ex_continue.setOnClickListener(click_ex_continue);
    }

    View.OnClickListener click_ex = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            but_ex_continue.setVisibility(View.VISIBLE);

            for(int i = 0; i<buttons.length; i++)
            {
                Button nowclickbut = (Button) view;
                if (buttons[i] == nowclickbut)
                {
                    buttons[i].setTextColor(getResources().getColor(R.color.yellow));
                }
                else
                    buttons[i].setTextColor(getResources().getColor(R.color.black));
            }



        }
    };

    View.OnClickListener click_ex_continue = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            Intent i = new Intent(experience.this, startbreathing.class);
            startActivity(i);
            finish();
        }
    };
}
