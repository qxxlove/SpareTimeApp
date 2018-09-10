package com.tjbool.httpwww.androiddaggermvp.mvp.view;

import android.os.Bundle;
import android.widget.TextView;

import com.tjbool.httpwww.androiddaggermvp.R;
import com.tjbool.httpwww.androiddaggermvp.base.BaseActivity;

import javax.inject.Inject;

public class SecondActivity extends BaseActivity {

    private TextView textView;

    @Inject
    String className;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    private void initView() {
        textView = ((TextView) findViewById(R.id.tv_content_two));
        textView.setText(className);
    }
}
