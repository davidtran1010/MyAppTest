package com.tatbt.myapptest;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by davidtran on 5/25/17.
 */

public class AdapterItems extends AppCompatActivity{
    public int ID;
    public String JobTitle;
    public String Description;

    public AdapterItems(int ID, String JobTitle, String Description) {
        this.ID = ID;
        this.JobTitle = JobTitle;
        this.Description = Description;


    }

}
