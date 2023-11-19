package com.example.project1asistuserfile;

import java.util.Date;

public class task {
    String taskname;
    String Dateput;
    String stat;


    public task() {
    }

    public task(String taskname, String dateput, String stat) {
        this.taskname=taskname;
        this.Dateput=dateput;
        this.stat=stat;


    }
    public static final task[] tasks = {
            new task("Lukukatte", "5894", "ry7rthur"),
            new task("Layujukutte", "5894", "ry7rthur"),
            new task("Laggggggggggggggggggtte", "5894", "ry7rthur"),
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

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return
                "taskname='" + taskname + '\'' +
                ", Dateput=" + Dateput +
                ", the stat='" + stat
                ;
    }
}
