package kr.co.teada.ateat_project01;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }//end of onCreate


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
