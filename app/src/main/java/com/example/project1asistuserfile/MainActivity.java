package com.example.project1asistuserfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private EditText test;
    private Button Add;
    private EditText nametask;
    private EditText datetask;
    private EditText nameworker;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Add=findViewById(R.id.Add);
        setviews();

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                String nameoftask=nametask.getText().toString();
                String dateoftask=datetask.getText().toString();

                String res="";

                 res=  nameoftask +
                        "," + dateoftask+","+"due" ;
                intent.putExtra("newTask",res);
                startActivity(intent);
            }
        });
    }
    private void setviews(){
        nametask=findViewById(R.id.nametask);
        datetask=findViewById(R.id.datetask);






    }

}