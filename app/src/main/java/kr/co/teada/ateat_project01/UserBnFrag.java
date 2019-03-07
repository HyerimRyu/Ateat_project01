package kr.co.teada.ateat_project01;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UserBnFrag extends Fragment {

    // frag  1. onCreateView
    //1-1/ return 에 inflate

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_bn,null);
    }


    //2. switching fragments:바텀네비 눌렀을 떄 프레그 바꾸기



}//end of UserBnFrag


