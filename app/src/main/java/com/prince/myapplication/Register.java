package com.prince.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText edit_name, edit_username, edit_password;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edit_name = findViewById(R.id.edt_name);
        edit_password = findViewById(R.id.edt_password);
        edit_username = findViewById(R.id.edt_username);
        btn_register = findViewById(R.id.btn_reg);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strname = edit_name.getText().toString();
                String strpassword = edit_password.getText().toString();
                String strusername = edit_username.getText().toString();

                if (strname.isEmpty() || strpassword.isEmpty() || strusername.isEmpty()) {
                    Toast.makeText(Register.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    Bundle b = new Bundle();
                    b.putString("strname", strname);
                    b.putString("strpassword", strpassword);
                    b.putString("strusername", strusername);

                    Intent intent = new Intent(getApplicationContext(), FirstActivity.class);
                    intent.putExtras(b);
                    startActivity(intent);
                }
            }
        });

    }
}
