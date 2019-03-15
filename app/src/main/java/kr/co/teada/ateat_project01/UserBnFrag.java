package kr.co.teada.ateat_project01;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

public class UserBnFrag extends Fragment {

    AppBarLayout appBarLayout;
    // frag  1. onCreateView
    //1-1/ return 에 inflate

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_user_bn,container,false);

        appBarLayout=v.findViewById(R.id.appBarLayout);
        return v;
    }


    //2. switching fragments:바텀네비 눌렀을 떄 프레그 바꾸기->메인에서 작업

    //3. hide toolbar in specific fragment
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();

    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }



}//end of UserBnFrag


