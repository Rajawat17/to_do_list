package com.example.to_do_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends  AppCompatActivity implements View.OnClickListener {
    private EditText action;
    private Button add;
   private ArrayList<String> list;
   private ArrayAdapter<String> adt;
    private ListView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        action=(EditText)findViewById(R.id.etitem);
        add=(Button)findViewById(R.id.btnadd);
        ls=(ListView)findViewById(R.id.lvitem);
        list=new ArrayList<String>();
        adt=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        ls.setAdapter(adt);
        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    if(v==this.add){
        //add item to list
        this.additem(action.getText().toString());
    }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    private void additem(String item){
        if(item.length()>0){
            this.list.add(item);
            this.adt.notifyDataSetChanged();
            this.action.setText("");
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add("VIEW PROFILE");
        menu.add("ACHIEVEMENTS OF CLUB");
        menu.add("SETTINGS");
        menu.add("LOGOUT");
        return true;
    }
}
