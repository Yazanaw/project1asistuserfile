package com.example.project1asistuserfile;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainActivity2 extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    Gson gson=new Gson();
    public int count=0;
    private ListView list;
    List al;
    private Button back;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        System.out.println("teat");

        setupSharedPrefs();
        setviews();

        btnLoginOnClick();

    }
    private void setupSharedPrefs() {
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor=prefs.edit();

    }
    private void setviews(){

        list=findViewById(R.id.list);

    }



    public void btnLoginOnClick() {

        String name="",Datee="",stat="";
        Intent act1=getIntent();
        Bundle b=act1.getExtras();
        if(b!=null){
            String newtask=(String) b.get("newTask");
            String [] arr=newtask.split(",");
            name = arr[0];
            Datee = arr[1];
            stat = arr[2];


        }
        task tas = new task(name, Datee, stat);


        String out=prefs.getString("tasks","");
         al = new ArrayList<task>();
        System.out.println("out is: " + out);
        if(!out.equals("")) {
            task[] tasksarray = gson.fromJson(out, task[].class);
            Collections.addAll(al, tasksarray);

        }



        al.add(tas);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, al);

        list.setAdapter(adapter);
        AdapterView.OnItemClickListener item=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(al.get(position));
                task tas2= (task) al.get(position);
                tas2.setStat("done");


                System.out.println(list.getAdapter().getItem(position));
                al.remove(position);
                adapter.notifyDataSetChanged();



            }

        };

        list.setOnItemClickListener(item);
        save();


        Toast.makeText(MainActivity2.this, "helllllooo", Toast.LENGTH_LONG).show();
        String out2 = prefs.getString("tasks", "");
        Toast.makeText(MainActivity2.this, out2, Toast.LENGTH_LONG).show();
        System.out.println("out2 is: " + out2);

    }
    public void save(){
        String taskString2 = gson.toJson(al);
        editor.putString("tasks", taskString2);

        editor.putInt("countr", count);
        editor.apply();


        editor.commit();
    }


    @Override
    protected void onStop() {
        save();
        super.onStop();
    }

    @Override
    protected void onPause() {
        save();
        super.onPause();
    }
}