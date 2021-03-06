package cn.fireflights.zy.imagetablayout.sample.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cn.fireflights.zy.imagetablayout.R;
import cn.fireflights.zy.imagetablayout.sample.adapter.MyViewPagerAdapter;
import cn.fireflights.zy.imagetablayout.sample.fragment.FirstFragment;
import cn.fireflights.zy.imagetablayout.sample.fragment.FourthFragment;
import cn.fireflights.zy.imagetablayout.sample.fragment.SecondFragment;
import cn.fireflights.zy.imagetablayout.sample.fragment.ThirdFragment;
import cn.fireflights.zy.mylibrary.ImageRes;
import cn.fireflights.zy.mylibrary.ImageTabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    ImageTabLayout imageTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        imageTabLayout = (ImageTabLayout) findViewById(R.id.imageTabLayout);

        //init Fragments
        FirstFragment firstFragment = new FirstFragment();
        SecondFragment secondFragment = new SecondFragment();
        ThirdFragment thirdFragment = new ThirdFragment();
        FourthFragment fourthFragment = new FourthFragment();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(firstFragment);
        fragments.add(secondFragment);
        fragments.add(thirdFragment);
        fragments.add(fourthFragment);

        MyViewPagerAdapter pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(pagerAdapter);

        //image & title
        List<ImageRes> imageResList = new ArrayList<>();
        imageResList.add(new ImageRes("第一页", R.drawable.tab_selector));
        imageResList.add(new ImageRes("第二页", R.drawable.tab_selector));
        imageResList.add(new ImageRes("第三页", R.drawable.tab_selector));
        imageResList.add(new ImageRes("第四页", R.drawable.tab_selector));
        //after ViewPager.setAdapter()
        imageTabLayout.setViewPager(viewPager, imageResList);
    }

}
