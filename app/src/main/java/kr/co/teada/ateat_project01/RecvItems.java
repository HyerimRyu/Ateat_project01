package kr.co.teada.ateat_project01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

public class RecvItems extends AppCompatActivity {

    //AteFragment에 붙이는 파일

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

//    int iv_food_pic;
//    String tv_res_name;
//    String tv_main;
//    String tv_hash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_frag_ate);

        recyclerView=findViewById(R.id.detail_frag_ate_recycler);
        swipeRefreshLayout=findViewById(R.id.swipeRefreshLayout);

        Intent intent=getIntent();

    }//end of onCreate

//    public RecvItems(int iv_food_pic, String tv_res_name, String tv_main, String tv_hash) {
//        this.iv_food_pic = iv_food_pic;
//        this.tv_res_name = tv_res_name;
//        this.tv_main = tv_main;
//        this.tv_hash = tv_hash;
//    }//end of constructor : alt + insert




}//end of RecvItems
