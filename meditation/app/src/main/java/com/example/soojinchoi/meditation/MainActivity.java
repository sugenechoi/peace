package com.example.soojinchoi.meditation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Array;
import java.util.Objects;

public class MainActivity extends AppCompatActivity
{
    int count=0; // 무조건 초기화 해줘야 함

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but_mode1 = (Button) findViewById(R.id.but_mode1);  //(Button)이 casting 하는 것.
        but_mode1.setOnClickListener(click_mode1);
        Button but_mode2 = (Button) findViewById(R.id.but_mode2);
        but_mode2.setOnClickListener(click_mode1);
        Button but_mode3 = (Button) findViewById(R.id.but_mode3);
        but_mode3.setOnClickListener(click_mode1);
        Button but_mode4 = (Button) findViewById(R.id.but_mode4);
        but_mode4.setOnClickListener(click_mode1);
        Button but_mode5 = (Button) findViewById(R.id.but_mode5);
        but_mode5.setOnClickListener(click_mode1);
        Button but_mode6 = (Button) findViewById(R.id.but_mode6);
        but_mode6.setOnClickListener(click_mode1);
        Button but_mode7 = (Button) findViewById(R.id.but_mode7);
        but_mode7.setOnClickListener(click_mode1);
        Button but_mode8 = (Button) findViewById(R.id.but_mode8);
        but_mode8.setOnClickListener(click_mode1);
        Button but_main_continue = (Button) findViewById(R.id.but_main_continue);
        but_main_continue.setOnClickListener(click_maincontinue);




//        String[] array = new String[2]; //여기는 2라고 해야 됨.2가지 공간이 필요하다.
//        array[0]="sofkaints@naver.com";
//        array[1]="choi@naver.com";
//        String email = funcTesttwo(array);
//        Log.d("apple",email);
//        int sum = funcTest(3,4);

    }

    View.OnClickListener click_mode1 = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            switch (view.getId())
            {
                case R.id.but_mode1:
                    Button but_mode1 = (Button) view;  // 캐스팅 한 것.
                    funcModeChange(but_mode1, R.color.color_mode1);
                    break;

                case R.id.but_mode2:
                    Button but_mode2 = (Button) view;  // 캐스팅 한 것.
                    funcModeChange(but_mode2, R.color.color_mode2);
                    break;

                case R.id.but_mode3:
                    Button but_mode3 = (Button) view;  // 캐스팅 한 것.
                    funcModeChange(but_mode3, R.color.color_mode3);
                    break;

                case R.id.but_mode4:
                    Button but_mode4 = (Button) view;  // 캐스팅 한 것.
                    funcModeChange(but_mode4, R.color.color_mode4);
                    break;

                case R.id.but_mode5:
                    Button but_mode5 = (Button) view;  // 캐스팅 한 것.
                    funcModeChange(but_mode5, R.color.color_mode5);
                    break;

                case R.id.but_mode6:
                    Button but_mode6 = (Button) view;  // 캐스팅 한 것.
                    funcModeChange(but_mode6, R.color.color_mode6);
                    break;

                case R.id.but_mode7:
                    Button but_mode7 = (Button) view;  // 캐스팅 한 것.
                    funcModeChange(but_mode7, R.color.color_mode7);
                    break;

                case R.id.but_mode8:
                    Button but_mode8 = (Button) view;  // 캐스팅 한 것.
                    funcModeChange(but_mode8, R.color.color_mode8);
                    break;
            }

        }
    };

    void funcModeChange(Button button, int color)  //빈 것을 반환 하는 것이 void ,  func를 앞에 붙이는 이유:내가 만든 함수임을 표시하려고
    {
        if (button.getTextColors().getDefaultColor() == getResources().getColor(color))
        {
            button.setTextColor(getResources().getColor(R.color.black));
            count--;
        }
        else
        {
            if (count < 3)
            {
                button.setTextColor(getResources().getColor(color));
                count++;
            }

        }
    }

//    int funcTest(int a, int b)
//    {
//        int c = a + b ;
//        return c; // return은 반환할 때 쓰는 것
//    }
//
//    String funcTesttwo(String[] array)
//    {
////        String[] array1 = email.split(""); //split 반환 값은 string[],  []는 배열을 의미
////        String[] array2= array1[1].split("/");  //자른 것을 또 자르기. array1중에서 뒤에꺼니까 [1]
////        String a = email.substring(0, 9);
////        String b = email.substring(18, 22);
//        String email="";
//        for (int i = 0; i < array.length; i++)
//        {
//            String[] array2 = array[i].split("@");
//            String[] array3 = array2[1].split("\\.");
//
//            if (Objects.equals(array3[0], "gmail"))
//            {
//                email = array[i];
//            }
//
//        }
////        return email;  // array[0]은 @를 기준으로 자른 것 중 제일 앞의 값. 그것을 반환해라
//
//    }

    View.OnClickListener click_maincontinue = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            Intent i = new Intent(MainActivity.this, experience.class);
            startActivity(i);
        }
    };
}
