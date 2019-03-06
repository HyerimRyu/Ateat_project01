package kr.co.teada.ateat_project01;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    ViewPager pager;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //툴바를 액션바로 설정
        Toolbar toolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true); //뒤로가기 버튼, 디폴트로 true하면 백버튼 생겨


        //탭버튼 객체 추가하기
        tabLayout=findViewById(R.id.layout_tab);


        //뷰페이저와 아답터 연결
        pager=findViewById(R.id.pager);
        adapter=new MyAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        //뷰페이저와 TabLayout 연동
        tabLayout.setupWithViewPager(pager);

/////////////////////////////////////////////////////////////////////////////////////


        //바텀네비 클릭시 사용되는 리스너 구현
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //어떤 메뉴 아이템이 터치되었는지 확인
                switch (menuItem.getItemId()){
                    case R.id.action_home:
                        Intent intentMain=new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intentMain);
                        return true;

                    case R.id.action_view_all_photos:
                        //사진 전체보기 프레그 이동
                        Toast.makeText(MainActivity.this, "사진 전체보기 프레그 이동", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.action_like:
                        //좋아요 프레그 이동
                        Toast.makeText(MainActivity.this, "좋아요 프레그 이동", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.action_camera:
                        Intent intentCamera=new Intent(MainActivity.this, CameraActivity.class);
                        startActivity(intentCamera);
                        return true;

                    case R.id.action_account:
                        //내 계정 프래그 이동
                        Toast.makeText(MainActivity.this, "내계정/프레/이동", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }//end of onNavigationItemSelected
        });//end of setOnNavigationItemSelectedListener


    }//end of onCreate()




    public void setSupportActionBar(Toolbar toolbar) {
    }



    //액션바 버튼 control
    public void btn_search(View view) {
        Intent intent=new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);
    }

    public void btn_add(View view) {
        Intent intent=new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }



}//end of MainActivity
