package kr.co.teada.ateat_project01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

   EditText email_edit_text;
   EditText password_edittext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //findViewbyId




    }//end of onCreate


    public void btn_email_login(View view) {

        Intent intent=new Intent(LoginActivity.this, WelcomeActivity.class);
        startActivity(intent);

        finish();

    }

    public void btn_google_login(View view) {
        Toast.makeText(this, "서비스 준비중\n위에 있는 [바로사용] 버튼을 눌러주세요", Toast.LENGTH_SHORT).show();
    }

    public void btn_kakao_login(View view) {
        Toast.makeText(this, "서비스 준비중\n위에 있는 [바로사용] 버튼을 눌러주세요", Toast.LENGTH_SHORT).show();
    }




}//end of loginActivity
