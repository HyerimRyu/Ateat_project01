package kr.co.teada.ateat_project01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Toolbar my_toolbar;
    TabLayout tabLayout;
    ViewPager pager;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_toolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(my_toolbar);

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
                Fragment fragment=null;

                //어떤 메뉴 아이템이 터치되었는지 확인
                switch (menuItem.getItemId()){
                    case R.id.action_home:
                        Intent intentMain=new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intentMain);
                        return true;

                    case R.id.action_view_all_photos:
                        //탭바 없애고 프레그가 전체 다 먹기
                        //사진 전체보기 프레그 이동
                        Toast.makeText(MainActivity.this, "사진 전체보기 프레그 이동", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.action_like:
                        //탭바 없애고 프레그가 전체 다 먹기
                        //좋아요 프레그 이동
                        Toast.makeText(MainActivity.this, "좋아요 프레그 이동", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.action_camera:
                        Intent intentCamera=new Intent(MainActivity.this, CameraActivity.class);
                        startActivity(intentCamera);
                        return true;

                    case R.id.action_account:
                        //전체 화면 사용하기: 상태바, 액션바 숨기기->메소드로 빼자
                        hideSystemUI();

                        fragment=new UserBnFrag();
                        break;
                }
                return loadFragment(fragment);
                //return false;
            }//end of onNavigationItemSelected
        });//end of setOnNavigationItemSelectedListener


    }//end of onCreate()




    //액션바 버튼 control
    public void btn_search(View view) {
        Intent intent=new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);
    }

    public void btn_add(View view) {
        Intent intent=new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }


    //바텀네비 누르면 프레그 실행 메소
    private boolean loadFragment(Fragment fragment){
        //Switching fragment
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
            return true;
        }
        return false;

    }

    public void hideSystemUI(){
        //밧데리, 시간 등 안보이게
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


    }

    public void useFullScreen(){
        //hide toolbar in specific fragment
    }



}//end of MainActivity
