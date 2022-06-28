package com.example.myapplication;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
