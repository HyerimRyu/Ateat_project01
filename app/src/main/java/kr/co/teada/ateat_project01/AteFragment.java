package kr.co.teada.ateat_project01;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class AteFragment extends Fragment {

    ListView ate_listview;
    AteAdapter ateAdapter;

    //대량의 데이터 준비
    ArrayList<AteFragItem> ateFragItems=new ArrayList<>();

    DatabaseReference ateRef;

    SwipeRefreshLayout swipeRefreshLayout;


   // SliderLayout sliderLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_ate, container, false);

//       sliderLayout=view.findViewById(R.id.imageSlider);
//       sliderLayout.setScrollTimeInSec(1);//set scroll delay in seconds

        //리스트뷰 어댑터 연결
        ate_listview=view.findViewById(R.id.ate_listview);
        ateAdapter=new AteAdapter(ateFragItems, getLayoutInflater());
        ate_listview.setAdapter(ateAdapter);

        swipeRefreshLayout=view.findViewById(R.id.swipeRefreshLayout);

        //'ate' 노드의 참조객체 얻어오기
        ateRef= FirebaseDatabase.getInstance().getReference("ate");

        //ate 노드에 저장된 데이터 읽어오기
        ateRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                AteFragItem ateFragItem=dataSnapshot.getValue(AteFragItem.class);
                ateFragItems.add(ateFragItem);

                ateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //loadData();  //return 전

        return view;
    }//end of onCreateView


    //onCreateView()가 종료된 후 자동으로 실행되는 메소드 뷰 제어는 여기서
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}//end of AteFragment
