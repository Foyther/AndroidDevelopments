package com.example.nurislam.norrisproj;

/**
 * Created by Nurislam on 23.12.2016.
 */

public interface TaskListenner {
    public void onTaskFinish();
    public boolean onTaskStart(String start);

}
