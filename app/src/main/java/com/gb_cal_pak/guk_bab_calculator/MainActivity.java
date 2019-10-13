package com.gb_cal_pak.guk_bab_calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String input;
    double output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gb);
        Button btn = findViewById(R.id.GB_btn);

        final EditText edit_num = findViewById(R.id.GB_num_edit);
        final TextView GB_num = findViewById(R.id.GB_num);

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
                try{
                    output = Integer.valueOf(input) / 7000.0;
                }catch(NumberFormatException e){
                    Log.e("Error", e.toString());
                    Toast.makeText(MainActivity.this, "그 돈이면 국밥집을 차리겠다.", Toast.LENGTH_SHORT).show();
                }


                    GB_num.setText(String.valueOf(Math.round(output * 10) / 10.0));

            }

        });
    }
}




