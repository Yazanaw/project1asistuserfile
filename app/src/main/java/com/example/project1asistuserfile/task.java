package com.example.project1asistuserfile;

import java.util.Date;

public class task {
    String taskname;
    String Dateput;
    String nameworker;
    String phoneworker;
    int id;

    public task() {
    }

    public task(String taskname, String dateput, String nameworker, String phoneworker,int id) {
        this.taskname=taskname;
        this.Dateput=dateput;
        this.nameworker=nameworker;
        this.phoneworker=phoneworker;
        this.id=id;


    }
    public static final task[] tasks = {
            new task("Lukukatte", "5894", "ry7rthur","45448",6),
            new task("Layujukutte", "5894", "ry7rthur","45448",7),
            new task("Laggggggggggggggggggtte", "5894", "ry7rthur","45448",8),
    };



    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getDateput() {
        return Dateput;
    }

    public void setDateput(String dateput) {
        Dateput = dateput;
    }

    public String getPhoneworker() {
        return phoneworker;
    }

    public void setPhoneworker(String phoneworker) {
        this.phoneworker = phoneworker;
    }

    public String getNameworker() {
        return nameworker;
    }

    public void setNameworker(String nameworker) {
        this.nameworker = nameworker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "taskname='" + taskname + '\'' +
                ", Dateput=" + Dateput +
                ", the stat='" + nameworker
                ;
    }
}
