package com.example.primeiroprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView novoTxt;
    Button novoBtn1;
    Button novoBtn2;
    Button novoBtn3;
    Button novoBtn4;
    Button novoBtn5;
    Button novoBtn6;
    Button novoBtn7;
    Button novoBtn8;
    Button novoBtn9;
    Button novoBtn0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_valores);

        novoTxt = (TextView) findViewById(R.id.valores);
        novoBtn1 = (Button) findViewById(R.id.button_1);
        novoBtn2 = (Button) findViewById(R.id.button_2);
        novoBtn3 = (Button) findViewById(R.id.button_3);
        novoBtn4 = (Button) findViewById(R.id.button_4);
        novoBtn5 = (Button) findViewById(R.id.button_5);
        novoBtn6 = (Button) findViewById(R.id.button_6);
        novoBtn7 = (Button) findViewById(R.id.button_7);
        novoBtn8 = (Button) findViewById(R.id.button_8);
        novoBtn9 = (Button) findViewById(R.id.button_9);
        novoBtn0 = (Button) findViewById(R.id.button_0);



        novoBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoTxt.setText("1");
            }
        });

        novoBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoTxt.setText("2");
            }
        });
        novoBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoTxt.setText("3");
            }
        });
        novoBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoTxt.setText("4");
            }
        });
        novoBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoTxt.setText("5");
            }
        });

        novoBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoTxt.setText("6");
            }
        });
        novoBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoTxt.setText("7");
            }
        });
        novoBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoTxt.setText("8");
            }
        });
        novoBtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoTxt.setText("9");
            }
        });
        novoBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoTxt.setText("0");
            }
        });

    }

}