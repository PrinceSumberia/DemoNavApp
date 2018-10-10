package com.prince.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    EditText edtUser, edtPass;
    Button btn;
    TextView txtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        edtUser = findViewById(R.id.edt_user);
        edtPass = findViewById(R.id.edt_pass);
        btn = findViewById(R.id.btn);
        txtv = findViewById(R.id.txtv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUser = edtUser.getText().toString();
                String strPass = edtPass.getText().toString();
                if (strUser.isEmpty() || strPass.isEmpty()) {
                    Toast.makeText(FirstActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = getIntent();
                    Bundle b = intent.getExtras();
                    String username = b.getString("strusername");
                    String password = b.getString("strpassword");
                    String name = b.getString("strname");

                    if (strUser.equals(username) && strPass.equals(password)){
                        Bundle b2 = new Bundle();
                        b2.putString("name", name);
                        Intent intent2 = new Intent(getApplicationContext(), Welcome.class);
                        intent2.putExtras(b2);
                        startActivity(intent2);
                    } else {
                        Toast.makeText(FirstActivity.this, "Login Details are Invalid", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        txtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }
}
