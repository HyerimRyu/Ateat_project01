package kr.co.teada.ateat_project01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddActivity extends AppCompatActivity {

    //권한요청 Manifest.permission.READ_EXTERNAL_STORAGE
    //앨범 열어서 사진 가져오고

    //DB에 바인딩


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
}
