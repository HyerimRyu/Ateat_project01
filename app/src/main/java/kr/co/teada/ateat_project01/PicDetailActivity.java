package kr.co.teada.ateat_project01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PicDetailActivity extends AppCompatActivity {

    //Ex56 DetailActivity.java 참고

    //사진 이미지
    ImageView iv_pic_detail;

    //수정 버튼들
    ImageView btn_like;
    ImageView btn_share;
    ImageView btn_modify;
    ImageView btn_delete;

    //텍스트
    TextView tv_res_name;
    TextView tv_main;
    TextView tv_content;
    TextView tv_hash;
    TextView tv_date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_detail);

        iv_pic_detail=findViewById(R.id.iv_pic_detail);

        btn_like=findViewById(R.id.btn_like);
        btn_share=findViewById(R.id.btn_share);
        btn_modify=findViewById(R.id.btn_modify);
        btn_delete=findViewById(R.id.btn_delete);

        tv_res_name=findViewById(R.id.tv_res_name);
        tv_main=findViewById(R.id.tv_main);
        tv_content=findViewById(R.id.tv_content);
        tv_hash=findViewById(R.id.tv_hash);
        tv_date=findViewById(R.id.tv_date);

        //클릭했을 때 디테일한거는 Adapter로 따로 작업

        Intent intent=getIntent();


    }//end of onCreate

    //좋아요 버튼 눌렀을 때
    public void clickLike(View view) {


    }


    //공유하기
    public void clickShare(View view) {
    }


    //수정하기
    public void clickModify(View view) {
    }

    //삭제하기
    public void clickDelete(View view) {
    }
}//end of PicDetailActivity
