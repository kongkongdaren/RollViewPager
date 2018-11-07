package com.example.wen.rollviewpager;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

public class MainActivity extends AppCompatActivity {

    private RollPagerView mRollViewPager;
    private int[] imgs = {R.drawable.ggwsfw01, R.drawable.ggwsfw02, R.drawable.ggwsfw03};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        aboutRollPagerView();
    }

    private void aboutRollPagerView() {
        //设置播放时间间隔
        mRollViewPager.setPlayDelay(2000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter(mRollViewPager));
        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(this, Color.YELLOW, Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);
    }

    private void initView() {
        mRollViewPager = findViewById(R.id.rpv_roll);
    }

    //    private class TestNormalAdapter extends StaticPagerAdapter {
//
//        @Override
//        public View getView(ViewGroup container, int position) {
//            ImageView view=new ImageView(container.getContext());
//            view.setImageResource(imgs[position]);
//            view.setScaleType(ImageView.ScaleType.FIT_XY);
//            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
//                    , ViewGroup.LayoutParams.MATCH_PARENT));
//            view.setOnClickListener(new OnClick(position));
//            return view;
//        }
//
//        @Override
//        public int getCount() {
//            return imgs.length;
//        }
//    }
//
//    class OnClick implements View.OnClickListener{
//        int index;
//
//        OnClick(int index){
//            this.index=index+1;
//        }
//
//        @Override
//        public void onClick(View view) {
//            System.out.println("第"+index+"张");
//        }
//    }
    private class TestNormalAdapter extends LoopPagerAdapter {


        public TestNormalAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }
    }
}
