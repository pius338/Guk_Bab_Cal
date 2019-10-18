package com.gb_cal_pak.guk_bab_calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String input;
    int output_0;
    int output_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gb);
        Button btn = findViewById(R.id.GB_btn);

        final EditText edit_num = findViewById(R.id.GB_num_edit);
        final TextView GB_num_0 = findViewById(R.id.GB_num_0);
        final TextView GB_num_1 = findViewById(R.id.GB_num_1);
        final TextView GB_Text_1 = findViewById(R.id.GB_Text_1);
        final TextView GB_Text_2 = findViewById(R.id.GB_Text_2);
        final TextView GB_Text_3 = findViewById(R.id.GB_text_3);


        View view = getWindow().getDecorView();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (view != null) {
                // 23 버전 이상일 때 상태바 하얀 색상에 회색 아이콘 색상을 설정
                view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                getWindow().setStatusBarColor(Color.parseColor("#f2f2f2"));
            }
        }else if (Build.VERSION.SDK_INT >= 21) {
            // 21 버전 이상일 때
            getWindow().setStatusBarColor(Color.BLACK);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                input = edit_num.getText().toString();
                if(input.equals("")){
                    Toast.makeText(MainActivity.this, "뭐요 왜요", Toast.LENGTH_SHORT).show();
                }else {

                    try {
                        output_0 = Integer.valueOf(input) / 6000;
                        output_1 = Integer.valueOf(input) % 6000;
                    } catch (NumberFormatException e) {
                        Log.e("Error", e.toString());
                        Toast.makeText(MainActivity.this, "그 돈이면 국밥집을 차리겠다.", Toast.LENGTH_SHORT).show();
                    }
                }


                if (output_0 == 0) {
                    GB_num_0.setText(String.valueOf(6000 - output_1));
                    GB_num_1.setText(null);
                    GB_Text_1.setText(null);
                    GB_Text_1.setTextSize(0);
                    GB_Text_2.setText("원만 더 모아서");
                    GB_Text_3.setText("국밥 사 먹겠다.");
                } else {
                    GB_Text_1.setTextSize(23);
                    GB_Text_1.setText("뜨끈~하고 든든~한 국밥을");
                    GB_Text_2.setText("그릇 먹고도");
                    GB_Text_3.setText("원이 남는데?");
                    GB_num_0.setText(String.valueOf(output_0));
                    GB_num_1.setText(String.valueOf(output_1));
                }


            }

        });
    }

    /*public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }*/


}




