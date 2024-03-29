package com.nawoori.android.adapterbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> datas = new ArrayList<>();

    //다른 액티비티와 데이터를 주고 받을 때 받는 키를 상의해둔다.
    public static final String DATA_KEY = "ListActivityData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.listView);
        //1.데이터
        for(int i=0; i<100 ; i++){
            datas.add("데이터"+i);
        }

        //2.아답터
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,datas);
        //3.뷰 > 연결 < 아답터
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Activity에 값 전달하기
                // 1. 전달받을 목적지 intent에 생성
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                //2. putExtra 로 값 입력
               intent.putExtra(DATA_KEY, datas.get(position));
                //3. intent를 이용한 Activity 생성 요청
                startActivity(intent);
            }
        });
    }
}
