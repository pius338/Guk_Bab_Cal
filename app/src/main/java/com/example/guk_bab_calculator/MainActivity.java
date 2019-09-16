package com.example.guk_bab_calculator;

import androidx.appcompat.app.AppCompatActivity;

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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = edit_num.getText().toString();
                try{
                    output = Integer.valueOf(input) / 7000.0;
                }catch(NumberFormatException e){
                    Log.e("Error", e.toString());
                    Toast.makeText(MainActivity.this, "와 갑부 개발자 국밥 한 그릇만 사주십쇼.", Toast.LENGTH_SHORT).show();
                }


                    GB_num.setText(String.valueOf(Math.round(output * 10) / 10.0));

            }

        });
    }
}

