package kr.co.teada.ateat_project01;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }//end of onCreate

    //액션바에 메뉴 달때


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search_actionbar,menu);

        //검색창 만들기 겟메뉴인플레이터(원래 있는애 기본적으로 앱에 거의 다 있으니까)
        //menu 객체로 부터 searchView 를 갖고 있는 MenuItem 객체 가져오기
        MenuItem item=menu.findItem(R.id.menu_search);
        searchView= (SearchView) item.getActionView();

        //힌트적용
        searchView.setQueryHint("검색하기");

        //서치뷰에 작성한 글씨 얻어오기
        //서치뷰에 글씨를 변경할 때마다 자동으로 호출되는 리스너
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //서치뷰에 글씨 작성할 때 사용하는 소프트키패드에 돋보기 모양의 완료 버튼 누르면 발동하는 메소드
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(SearchActivity.this, s+"를 검색합니다.", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });



        return super.onCreateOptionsMenu(menu);
    }

    public void clickByFoodSearch(View view) {

        //1.버튼다이얼로그 객체 생성
        final BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);

        //3. 보여질 뷰 설정 xml
        View v=getLayoutInflater().inflate(R.layout.search_bottom_dialog_foods, null);
        bottomSheetDialog.setContentView(v);

        bottomSheetDialog.setCanceledOnTouchOutside(true);

        //2. 다이얼로그 보이기
        bottomSheetDialog.show();

        //4. 다이얼로그 안에 있는 리스트뷰의 아이템 클릭 반응: 푸드랑 시튜랑 구분
        ListView listView=v.findViewById(R.id.search_bottomSheet_listView_foods);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] datas=getResources().getStringArray(R.array.foods);
                Toast.makeText(SearchActivity.this, datas[position], Toast.LENGTH_SHORT).show();

                bottomSheetDialog.dismiss();
            }
        });

    }

    public void clickBySituationSearch(View view) {

        //버텀네비 리스트뷰 큰 풍선 그리기
        final BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);
        View v=getLayoutInflater().inflate(R.layout.search_bottom_dialog_situations, null);
        bottomSheetDialog.setContentView(v);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.show();

        //큰 풍선에 세부 아이템 넣기
        ListView listView=v.findViewById(R.id.search_bottomSheet_listView_situations);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] datas=getResources().getStringArray(R.array.situations);
                Toast.makeText(SearchActivity.this, datas[position], Toast.LENGTH_SHORT).show();

                bottomSheetDialog.dismiss();
            }
        });
    }
}//end of SearchActivity
