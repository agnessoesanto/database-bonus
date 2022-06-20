package com.example.lat24mei22;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    DBHandler mydb;
    DataModel usermodel;

    TextView tvSub;
    Button b2, b3;
    EditText username;
    EditText password;

    private View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch  (view.getId()){
                case R.id.button2:
                    goToActivity();
                    break;
                case R.id.button3:
                    addUser();
                    break;
            }
        }
    };

    private void goToActivity() {
        Intent i  = new Intent( this, MainActivity.class);
        startActivity(i);
    }

    public void addUser() {
        mydb = new DBHandler(this);
        usermodel = new DataModel(1, username.getText().toString(), password.getText().toString());
        mydb.insertUser(usermodel);

        tvSub.setText("Berhasil Submit!");
        tvSub.setVisibility(View.VISIBLE);

        username.setText("");
        password.setText("");
        username.setVisibility(View.VISIBLE);
        password.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvSub = findViewById(R.id.tvSubmit);

        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(myClickListener);
        b3 = findViewById(R.id.button3);
        b3.setOnClickListener(myClickListener);

        username = findViewById(R.id.etUser);
        password = findViewById(R.id.etPw);
    }

}


