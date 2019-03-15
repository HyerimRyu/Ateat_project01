package kr.co.teada.ateat_project01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class IntroActivity extends AppCompatActivity {

    ImageView iv_intro;

    ProgressBar progressBar;

    Timer timer=new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        iv_intro=findViewById(R.id.iv_intro);
        progressBar=findViewById(R.id.progress_bar);
        timer.schedule(task, 2000);

    }//end of onCreate

    //intro 2초 뒤 메인으로 이동해 메소드(함수)
    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            Intent intent=new Intent(IntroActivity.this, LoginActivity.class);
            startActivity(intent);

            finish();
        }
    };

    //화면에 보이는거


    @Override
    protected void onResume() {
        super.onResume();
        loadData();

    }//end of onResume

    //loadData 저장된 파일 읽어오기
    void loadData(){
        SharedPreferences pref=getSharedPreferences("Data",MODE_PRIVATE);

        //가져올 데이터 써

    }//end of loadData()














}//end of IntroActivity
