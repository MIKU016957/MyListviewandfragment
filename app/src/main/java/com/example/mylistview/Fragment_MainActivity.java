package com.example.mylistview;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Fragment_MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonone, buttontwo, buttonthree, buttonfour;  //按钮
    private FragmentManager fragmentManager;  //Fragment 管理器
    private FragmentTransaction fragmentTransaction;  // Fragment事务处理


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_zhuanjie);
        initView();

    }

    private void initView() {
        buttonone = findViewById(R.id.but_1);
        buttontwo = findViewById(R.id.but_2);
        buttonthree = findViewById(R.id.but_3);
        buttonfour = findViewById(R.id.but_4);

        buttonone.setOnClickListener(this);
        buttontwo.setOnClickListener(this);
        buttonthree.setOnClickListener(this);
        buttonfour.setOnClickListener(this);

        fragmentManager = getFragmentManager();  //得到Fragment 管理器对象

        fragmentTransaction = fragmentManager.beginTransaction();
        //初始化一个 fragment
        FragmentOne fragment = new FragmentOne();
        fragmentTransaction.add(R.id.fragment_id, fragment); //fragment_id 是布局中给fragment 占位置的控件
        fragmentTransaction.commit(); //提交事务

    }

    @Override
    public void onClick(View v) {
        fragmentTransaction = fragmentManager.beginTransaction(); //开始fragmnet 的事务处理
        switch (v.getId()) {
            case R.id.but_1:
                fragmentTransaction.replace(R.id.fragment_id, new FragmentOne());  //加载第一个 fragment
                fragmentTransaction.addToBackStack(null);  //把 fragment one放到 栈队里  跳转后 返回键可返回
                break;
            case R.id.but_2:
                fragmentTransaction.replace(R.id.fragment_id, new FragmentTwo());  //加载第二个 fragment
                fragmentTransaction.addToBackStack(null);  //把 fragment two放到 栈队里 跳转后返回键 可返回
                break;
            case R.id.but_3:
                fragmentTransaction.replace(R.id.fragment_id, new FragmentThree());  //加载 第三个 fragment
                fragmentTransaction.addToBackStack(null);  //把 fragment three放到 栈队里 跳转后返回键 可返回
                break;
            case R.id.but_4:
                fragmentTransaction.replace(R.id.fragment_id, new FragmentFour());  //加载 第四个 fragment
                fragmentTransaction.addToBackStack(null);  //把 fragment three放到 栈队里 跳转后返回键 可返回
                break;
            default:
                break;
        }

        fragmentTransaction.commit();//提交事务
    }
}
