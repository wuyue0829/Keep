package com.keep.wuyue.keep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_forget_password)
    TextView tv_forget_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({ R.id.tv_forget_password})
    public void onClick(){
        Toast.makeText(getApplicationContext(),"测试",Toast.LENGTH_LONG).show();
    }
}
