package kr.co.teada.ateat_project01;

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

import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class AteFragment extends Fragment {
    //Ex56 recyclerview2_advancerversion: 원피스 상디조로 참고

    //대량의 데이터 준비
    ArrayList<RecvItems> recvItems=new ArrayList<>();

    RecyclerView recyclerView;
    RecyvAdapter recyvAdapter;

    SwipeRefreshLayout swipeRefreshLayout;


   // SliderLayout sliderLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_ate, container, false);

        recyclerView=view.findViewById(R.id.detail_frag_ate_recycler);
        swipeRefreshLayout=view.findViewById(R.id.swipeRefreshLayout);

//       sliderLayout=view.findViewById(R.id.imageSlider);
//       sliderLayout.setScrollTimeInSec(1);//set scroll delay in seconds

        //리사이클러뷰 어댑터 연결
        recyclerView=view.findViewById(R.id.detail_frag_ate_recycler);
        recyvAdapter=new RecyvAdapter(recvItems, this);
        recyclerView.setAdapter(recyvAdapter);

        return view;

    }//end of onCreateView




















}//end of AteFragment
