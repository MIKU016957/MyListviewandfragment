package com.example.mylistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener,View.OnClickListener {
    private Button button;
    private TextView textView;
    private List<Anima> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initFruit();
        AnimaAdapter fruitAdapter = new AnimaAdapter(MainActivity.this, R.layout.anima_item, fruitList);
        ListView listView = findViewById(R.id.list_item);
        listView.setAdapter(fruitAdapter);
    }


    private void initFruit() {
        for (int i = 0; i < 13; i++) {
            Anima a = new Anima("啊哈哈哈哈哈哈", R.drawable.a);
            fruitList.add(a);
            Anima b = new Anima("啊哈哈哈哈哈", R.drawable.b);
            fruitList.add(b);
            Anima c = new Anima("啊哈哈哈哈", R.drawable.c);
            fruitList.add(c);
            Anima d = new Anima("啊哈哈哈", R.drawable.d);
            fruitList.add(d);
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ahhh, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aaaa:
                Toast.makeText(this, "点什么点", Toast.LENGTH_SHORT).show();
            case R.id.bbbb:
                Toast.makeText(this, "点什么点", Toast.LENGTH_SHORT).show();
            case R.id.cccc:
                Toast.makeText(this, "点什么点", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private void init() {
        button = findViewById(R.id.but_1);
        textView = findViewById(R.id.text_1);
        button.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Fragment_MainActivity.class);
        startActivity(intent);
    }
}

