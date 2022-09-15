package com.example.bt4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  Button singup,singin;
    private EditText edtname,edtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        singup=(Button) findViewById(R.id.btsingup);
        edtname=(EditText) findViewById(R.id.name) ;
        edtpassword=(EditText)  findViewById(R.id.password);

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent ( MainActivity.this,Singup.class);
                startActivity(intent) ;
            }

        });
        String passUname = getIntent().getStringExtra("edtname");
        String passPword = getIntent().getStringExtra("edtpassword");
        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtname.getText().toString().equals("") || edtpassword.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập thông tin!", Toast.LENGTH_SHORT).show();
                } else if((edtname.getText().toString().equals("admin") && edtpassword.getText().toString().equals("123"))
                        || (edtname.getText().toString().equals(passUname) && edtpassword.getText().toString().equals(passPword)))         {
                    Intent intent = new Intent(MainActivity.this, profile.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Tài khoản hoặc mật khẩu chưa chính xác!", Toast.LENGTH_SHORT).show();
                }

            }


        });



    }
}