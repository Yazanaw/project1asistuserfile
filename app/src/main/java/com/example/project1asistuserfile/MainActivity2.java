package com.example.project1asistuserfile;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
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
    ArrayAdapter<task> listAdapter ;
    ArrayAdapter<String> adapter;
    Gson gson=new Gson();


    //ArrayList<task>tas;
    public String Name ="Name";
    public String Date="Date";
    public String Namew="Namew";
    public String Phone="Phone";

    public String  Flag="Flag";
    public String  che1="che1";
    public boolean che2=false;
    private boolean flag=false;
    public String Data="Data";
    public int count=0;
    ArrayList<String> taskList = new ArrayList<>();



    private ListView list;
    private Button back;
    private CheckBox che;
    task tas;

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
        Intent intent = getIntent();
        System.out.println("teat");
        //tas=new task("ghhjh",5429,"hggh",574);
        setupSharedPrefs();
        setviews();

        //checkPrefs();
        // update();
        listAdapter = new ArrayAdapter<task>(this,
                android.R.layout.simple_list_item_1,task.tasks);
        String out=prefs.getString("tasks","");
        System.out.println(out);
        if(!out.equals("")) {
            List al = new ArrayList<task>();
            task[] tasksarray = gson.fromJson(out, task[].class);
            Collections.addAll(al, tasksarray);


            int u = prefs.getInt("countr", 0);
            //  List al = Arrays.asList(tasksarray);
            // taskList.add("Name: " + name + "\nDate: " + date + "\nNamew: " + namew + "\nPhone: " + phone);
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, al);
            list.setAdapter(adapter);
            adapter.notifyDataSetChanged();


        }
//        String name="",Datee="",namew="",phonee="";
//        Intent act1=getIntent();
//        Bundle b=act1.getExtras();
//        if(b!=null){
//            String newtask=(String) b.get("newTask");
//            String [] arr=newtask.split(",");
//            name = arr[0];
//            Datee = arr[1];
//            namew = arr[2];
////            phonee = arr[3];
//
//        }
//        taskList.add("Name: " + name + " Date: " + Datee + " Namew: " + namew + " Phone: " + phonee);
//        list.setAdapter(adapter);
        btnLoginOnClick();

    }
    private void setupSharedPrefs() {
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor=prefs.edit();

    }
    private void setviews(){


       // che=findViewById(R.id.che);
        list=findViewById(R.id.list);


    }



    public void btnLoginOnClick() {


        listAdapter = new ArrayAdapter<task>(this,
                android.R.layout.simple_list_item_1,task.tasks);

     //if(che.isChecked()){
//            if(!flag) {


                int id=count;


                String name="",Datee="",namew="",phonee="";
                Intent act1=getIntent();
                Bundle b=act1.getExtras();
                if(b!=null){
                    String newtask=(String) b.get("newTask");
                    String [] arr=newtask.split(",");
                     name = arr[0];
                     Datee = arr[1];
                     namew = arr[2];
                     //phonee = arr[3];

                }
                task tas = new task(name, Datee, namew, phonee, id);


                String taskString = gson.toJson(tas);

                String out=prefs.getString("tasks","");
                List al = new ArrayList<task>();
                System.out.println("out is: " + out);
                if(!out.equals("")) {
                    task[] tasksarray = gson.fromJson(out, task[].class);
                    Collections.addAll(al, tasksarray);
                }

                al.add(tas);
                String taskString2 = gson.toJson(al);

//                 editor.putString(Name, nametask.getText().toString());
//                editor.putString(Date, datetask.getText().toString());
//                editor.putString(Namew,nameworker.getText().toString());
//                editor.putString(Phone,phoneworker.getText().toString());

                    // editor.putBoolean(che1, che.isChecked());
                    taskList.add("Name: " + name + " Date: " + Datee + " Namew: " + namew + " Phone: " + phonee);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, al);
                    list.setAdapter(adapter);
                    adapter.notifyDataSetChanged();


                    editor.putString("tasks", taskString2);
                    editor.putInt("countr", count);
                    editor.apply();

                    //editor.putString(Data, taskString);
                    editor.commit();
                    Toast.makeText(MainActivity2.this, "helllllooo", Toast.LENGTH_LONG).show();
                    String out2 = prefs.getString("tasks", "");
                   // Toast.makeText(MainActivity2.this, out2, Toast.LENGTH_LONG).show();
                    System.out.println("out2 is: " + out2);

                    //nametask.setText(taskString);

        // }
                    // }

                    // authenticate the user
//             }
//            }
        }



}