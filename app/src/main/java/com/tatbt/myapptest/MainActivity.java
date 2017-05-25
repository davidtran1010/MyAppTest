package com.tatbt.myapptest;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //TextView txtDisplay;
    Button button;
    EditText edittext;
    TextView txtDisplay;
    ListView listView;
    ArrayList<AdapterItems> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();

        Log.i("my log:","fsgfffffffffffff");
        listView = (ListView) findViewById(R.id.listView);

        arrayList = new ArrayList<AdapterItems>();
        MyCustomAdapter myCustomAdapter;

        arrayList.add(new AdapterItems(123,"lap trinh vien","code nua code mai"));
        arrayList.add(new AdapterItems(456,"nhan vien cua hang","phuc vu mon an"));
        arrayList.add(new AdapterItems(786,"phi cong","lai may bay"));

        for (AdapterItems a:arrayList) {
            Log.i("Log: item:",a.ID + ":" + a.JobTitle + ":"+a.Description);
        }
        myCustomAdapter = new MyCustomAdapter(arrayList);

        listView.setAdapter(myCustomAdapter);




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
    public void butClick2(View view){
        LayoutInflater layoutInflater = getLayoutInflater();
        View view1 = layoutInflater.inflate(R.layout.showedlayout,null);
        Toast toast = new Toast(getApplicationContext());
        toast.setView(view1);
        toast.setDuration(Toast.LENGTH_LONG);
        //toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.show();





    }
    public void butClick1(View view) {
        String message = getResources().getString(R.string.message);
        String[] numbers = getResources().getStringArray(R.array.array_test);
        //int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        //int birthYear = Integer.parseInt(edittext.getText().toString());
        //Toast.makeText(this,String.valueOf(currentYear-birthYear),Toast.LENGTH_LONG).show();

        Toast.makeText(this,numbers[0]+numbers[1]+numbers[2]+numbers[3],Toast.LENGTH_LONG).show();

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
    private class MyCustomAdapter extends BaseAdapter{
        public ArrayList<AdapterItems> listnewsDataAdapter;



        public MyCustomAdapter(ArrayList<AdapterItems> listnewsDataAdapter){
            this.listnewsDataAdapter = listnewsDataAdapter;


        }
        @Override
        public int getCount() {
            return listnewsDataAdapter.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_ticket,null);

            final AdapterItems s = listnewsDataAdapter.get(position);

            TextView tvID = (TextView) myView.findViewById(R.id.txtID);
            tvID.setText(""+s.ID);

            TextView txtJobTitle = (TextView) myView.findViewById(R.id.txtJobTitle);
            txtJobTitle.setText(s.JobTitle);

            TextView txtDes = (TextView) myView.findViewById(R.id.txtjobDescription);
            txtDes.setText(s.Description);
            return myView;
        }
    }
}
