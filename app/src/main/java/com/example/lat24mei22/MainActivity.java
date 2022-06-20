package com.example.lat24mei22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DBHandler mydb;
    DataModel usermodel;

    Button b1;

    ListView mylv;
    ArrayList thisId, thisName, thisPw;

    private View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch  (view.getId()){
                case R.id.button:
                    goToActivity2();
                    break;
            }
        }
    };



    private void goToActivity2() {
        Intent i  = new Intent( this, MainActivity2.class);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DBHandler(this);

        thisId = new ArrayList<>();
        thisName = new ArrayList<>();
        thisPw = new ArrayList<>();

        displayData();

        mylv = (ListView) findViewById(R.id.lv1);
        CustomAdapter cAdapter = new CustomAdapter(getApplicationContext(), thisId, thisName, thisPw);
        mylv.setAdapter(cAdapter);

        b1 = findViewById(R.id.button);
        b1.setOnClickListener(myClickListener);
    }

    private void displayData() {
        Cursor c = mydb.getAll();
        if(c.getCount() == 0){
            Toast.makeText(this, "No Data to Display!", Toast.LENGTH_SHORT).show();
        }
        else{
            while(c.moveToNext()){
                thisId.add(c.getString(0));
                thisName.add(c.getString(1));
                thisPw.add(c.getString(2));
            }
        }
    }
}