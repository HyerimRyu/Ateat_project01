package kr.co.teada.ateat_project01;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    Fragment[] frags=new Fragment[2];
    String[] titles=new String[]{"먹은거","먹을거"};

    public MyAdapter(FragmentManager fm) {
        super(fm);

        frags[0]=new AteFragment();
        frags[1]=new EatFragment();
    }//end of MyAdapter


    @Override
    public Fragment getItem(int position) { return frags[position]; }

    @Override
    public int getCount() { return frags.length; }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) { return titles [position];
    }
}//end of MyAdapter
