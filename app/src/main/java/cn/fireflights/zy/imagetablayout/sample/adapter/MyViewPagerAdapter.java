package cn.fireflights.zy.imagetablayout.sample.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Archer on 2016/10/17.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mSelectFragList;
    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyViewPagerAdapter(FragmentManager fm, List<Fragment> mSelectFragList) {
        super(fm);
        this.mSelectFragList = mSelectFragList;
    }

    @Override
    public Fragment getItem(int position) {
        return mSelectFragList.get(position);
    }

    @Override
    public int getCount() {
        return mSelectFragList.size();
    }
}
