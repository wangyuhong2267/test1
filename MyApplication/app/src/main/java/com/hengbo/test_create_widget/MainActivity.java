package com.hengbo.test_create_widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int wyh;
    private Context context = this;
    private RelativeLayout rl_root;
    private TextView tv;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 最外层的控件 RelativeLayout
        rl_root = new RelativeLayout(context);

        // 添加一个TextView
        tv = new TextView(context);
        RelativeLayout.LayoutParams tvLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        // 设置 margin
        tvLayoutParams.leftMargin = 100;
        // 设置 padding
        tv.setPadding(10, 10, 10, 10);
        tv.setText("textView");
        tv.setLayoutParams(tvLayoutParams);
        rl_root.addView(tv);

        //////////////////////////////////////////////////////////////////////////////
        //添加一个文本框
        EditText editText = new EditText(context);
        editText.setText("my edittext");
        editText.setSingleLine(true);
        editText.setPadding(10,5,5,20);
        editText.setBackground(getResources().getDrawable(R.drawable.shape1));
        RelativeLayout.LayoutParams edtLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        edtLayoutParams.leftMargin = 50;
        edtLayoutParams.topMargin = 110;
        edtLayoutParams.width = 300;
        edtLayoutParams.addRule(RelativeLayout.BELOW, tv.getId());
        editText.setLayoutParams(edtLayoutParams);
        rl_root.addView(editText);




        //////////////////////////////////////////////////////////////////////////////////////
        //添加一个按钮
        Button btn = new Button(context);
        btn.setText("button");
        // 设置规则 : 在TextView 的下方
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = 100;
        layoutParams.leftMargin = 450;
        layoutParams.rightMargin = 50;
        layoutParams.width = 300;
        layoutParams.addRule(RelativeLayout.BELOW, tv.getId());
        btn.setLayoutParams(layoutParams);
        rl_root.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                tv.setText("my textview......");
            }
        });

        // 在Button 下面添加一个LinearLayout,里面水平放4个Button
//        LinearLayout ll = new LinearLayout(context);
//        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        layoutParams1.addRule(RelativeLayout.BELOW, btn.getId());
//        ll.setLayoutParams(layoutParams1);
//        ll.setBackgroundColor(Color.GREEN);
//        ll.setPadding(10, 50, 0, 0);
//        rl_root.addView(ll);
//
//
//        final Button button = new Button(context);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT));
//        params.weight = 1;
//        button.setText("button" + 1);
//        ll.addView(button, params);
//        button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, button.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });

//        ll.setOrientation(LinearLayout.HORIZONTAL);
//        int btnCount = 4;
//        for (int i = 0; i < btnCount; i++) {
//            final Button button = new Button(context);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT));
//            params.weight = 1;
//            button.setText("button" + i);
//            ll.addView(button, params);
//            button.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(context, button.getText(), Toast.LENGTH_SHORT).show();
//                }
//            });
//        }

//        ListView lv = new ListView(context);
//        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        layoutParams2.addRule(RelativeLayout.BELOW, ll.getId());
//        lv.setLayoutParams(layoutParams2);
//        rl_root.addView(lv);
//        List<String> datas = new ArrayList<String>();
//        for (int i = 0; i < 20; i++) {
//            datas.add("name" + i);
//        }
//        lv.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, android.R.id.text1, datas));
//
       setContentView(rl_root);



    }

    public String getChild() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rl_root.getChildCount(); i++) {
            sb.append(rl_root.getChildAt(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
