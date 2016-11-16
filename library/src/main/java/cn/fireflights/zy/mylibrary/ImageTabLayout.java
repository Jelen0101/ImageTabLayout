package cn.fireflights.zy.mylibrary;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.fireflights.zy.mylibrary.ImageRes;
import cn.fireflights.zy.mylibrary.R;

/**
 * Created by ZY on 2016/4/24.
 */
public class ImageTabLayout extends LinearLayout implements OnClickListener {
    private ViewPager mViewPager;
    private int mCount;
    private Context mContext;
    private int normalTextColor = Color.BLACK;  //title被选中颜色
    private int selectTextColor = Color.BLUE;  //未被选中颜色
    private List<ImageRes> imageResList;

    public ImageTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.setOrientation(LinearLayout.HORIZONTAL);
    }

    private void initView() {
        for(int i = 0; i< mCount; i++) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item, this, false);
            view.setOnClickListener(this);
            view.setTag(i);
            ImageView imageView = (ImageView) view.findViewById(R.id.icon_iv);
            TextView textView = (TextView) view.findViewById(R.id.title_iv);
            imageView.setImageResource(imageResList.get(i).getImageDrawableRes());
            if(i == mViewPager.getCurrentItem()) {
                imageView.setSelected(true);
                textView.setTextColor(selectTextColor);
                textView.setText(imageResList.get(i).getTitle());
            } else {
                imageView.setSelected(false);
                textView.setTextColor(normalTextColor);
                textView.setText(imageResList.get(i).getTitle());
            }
            this.addView(view);
        }
    }

    public void setViewPager(ViewPager viewPager, List<ImageRes> list) {
        this.mViewPager = viewPager;
        this.imageResList = list;
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mCount = viewPager.getAdapter().getCount();
        initView();
    }

    public void notifyDataSetChanged() {
        for(int i = 0; i< mCount; i++) {
            TextView textView = (TextView) getChildAt(i).findViewById(R.id.title_iv);
            ImageView imageView = (ImageView) getChildAt(i).findViewById(R.id.icon_iv);
            if(i == mViewPager.getCurrentItem()) {
                imageView.setSelected(true);
                textView.setTextColor(selectTextColor);
            } else {
                imageView.setSelected(false);
                textView.setTextColor(normalTextColor);
            }
        }
    }

    @Override
    public void onClick(View v) {
        int tag = (int) v.getTag();
        mViewPager.setCurrentItem(tag);
        notifyDataSetChanged();
    }

    public int getNormalTextColor() {
        return normalTextColor;
    }

    public void setNormalTextColor(int normalTextColor) {
        this.normalTextColor = normalTextColor;
    }

    public int getSelectTextColor() {
        return selectTextColor;
    }

    public void setSelectTextColor(int selectTextColor) {
        this.selectTextColor = selectTextColor;
    }
}
