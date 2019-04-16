package com.example.wewerk_v12.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wewerk_v12.R;
import com.example.wewerk_v12.adapters.IntroSliderAdapter;

public class IntroSliderActivity extends AppCompatActivity {

    private ViewPager mIntroSlide_viewPager;
    private LinearLayout mDots_linearLayout;
    private TextView mLeft_textView, mRight_textView;

    private IntroSliderAdapter mIntroSliderAdapter;

    private TextView[] mDots;
    private int mCurrentPage, mPageNumber=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_slider);

        //intializing the views
        mIntroSlide_viewPager = (ViewPager) findViewById(R.id.introSlide_viewPager);
        mDots_linearLayout = (LinearLayout) findViewById(R.id.dots_linearLayout);
        mLeft_textView = (TextView) findViewById(R.id.left_textView);
        mRight_textView = (TextView) findViewById(R.id.right_textView);

        //attaching adapter to activity
        mIntroSliderAdapter = new IntroSliderAdapter(this);
        mIntroSlide_viewPager.setAdapter(mIntroSliderAdapter);

        //make the dots white according to page
        addDotsIndicators(0);

        //change the viewpager according to the current page
        mIntroSlide_viewPager.addOnPageChangeListener(onPageChangeListener);

        //changing page when we click on the button
        addTextViewListener();

    }

    private void addTextViewListener() {
        //listener for back button
        mLeft_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntroSlide_viewPager.setCurrentItem(mCurrentPage-1);
            }
        });

        //listener for right button
        mRight_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIntroSlide_viewPager.setCurrentItem(mCurrentPage+1);

            }
        });
    }

    public void addDotsIndicators(int position) {
         mPageNumber = 3;
        mDots = new TextView[mPageNumber];
        mDots_linearLayout.removeAllViews();

        for (int i = 0; i < mPageNumber; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.white_transparent));

            mDots_linearLayout.addView(mDots[i]);
        }
        mDots[position].setTextColor(getResources().getColor(R.color.white));


    }


    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            mCurrentPage = i;
            changeTextButton(i);
            addDotsIndicators(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    private void changeTextButton(int pagePosition) {
        if (pagePosition == 0) {
            //at the beggining
            mRight_textView.setEnabled(true);
            mRight_textView.setText("Next");
            mLeft_textView.setEnabled(false);
            mLeft_textView.setVisibility(View.INVISIBLE);

        } else if(pagePosition==mPageNumber-1){
           //on the last page
            mRight_textView.setEnabled(true);
            mRight_textView.setText("Finish");
            mLeft_textView.setEnabled(true);
            mLeft_textView.setText("Back");
            mLeft_textView.setVisibility(View.VISIBLE);
            //TODO: when we click on the finish button, we go to the discover page aka main activity

        } else{
            //at the second page
            mRight_textView.setEnabled(true);
            mRight_textView.setText("Next");
            mLeft_textView.setEnabled(true);
            mLeft_textView.setText("Back");
            mLeft_textView.setVisibility(View.VISIBLE);

        }

    }

}
