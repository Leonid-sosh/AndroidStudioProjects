package com.example.myapplication_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener{

    TextView tv;
    Button button1;
    EditText edit;

    ListView listView;
    ArrayList nameList = new ArrayList();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.text_view);
        tv.setText(getString(R.string.hellojava));

        button1 = findViewById(R.id.btn1);
        button1.setOnClickListener(this);
        edit = findViewById(R.id.edtx);

        listView = findViewById(R.id.listview);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //tv.setText(getString(R.string.Text_updated));
        if(!nameList.contains(edit.getText().toString())) {
            nameList.add(edit.getText().toString());
            Collections.sort(nameList);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tv.setText(nameList.get(position).toString());
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        nameList.remove(nameList.get(position));
        adapter.notifyDataSetChanged();
        return false;
    }
}
