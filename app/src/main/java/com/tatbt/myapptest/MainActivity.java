package com.tatbt.myapptest;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //TextView txtDisplay;
    Button button;
    EditText edittext;
    TextView txtDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();

        Log.i("my log:","fsgfffffffffffff");



    }


    /*@Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop",Toast.LENGTH_LONG).show();
    }
*/
    public void butClick1(View view) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int birthYear = Integer.parseInt(edittext.getText().toString());
        Toast.makeText(this,String.valueOf(currentYear-birthYear),Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);
        MenuItem searchItem = menu.findItem(R.id.Search);

        try {

            SearchView searchView = (SearchView) searchItem.getActionView();
            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Toast.makeText(getApplicationContext(),query,Toast.LENGTH_LONG).show();
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }
        catch (Exception e){
            Log.i("My log:",e.toString());

        }


        // SearchView searchView = (SearchView) menu.findItem(R.id.Search).getActionView();

        // return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Search:
                Toast.makeText(getApplicationContext(),"Open Search",Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.Camera:
                Toast.makeText(getApplicationContext(),"Open Camera",Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.Settings:
                Toast.makeText(getApplicationContext(),"Open Settings",Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.About:
                Toast.makeText(getApplicationContext(),"Open About",Toast.LENGTH_SHORT).show();
                return  true;
            default:return super.onOptionsItemSelected(item);

        }

    }
}
