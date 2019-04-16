package com.example.wewerk_v12.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wewerk_v12.R;

public class IntroSliderAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;

    private static final String TAG = "IntroSliderAdapter";

    public IntroSliderAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public int[] introSlide_images = {
            R.drawable.ic_barbell,
            R.drawable.ic_weight_intro,
            R.drawable.ic_notepad
    };

    public String[] introSlide_title = {
            "TRAIN",
            "SHARE",
            "CREATE"
    };

    public String[] introSlide_descriptions = {
            "Train as hard as you can",
            "Share your knowledge with the world",
            "Create your own programs",

    };

    @Override
    public int getCount() {

        return introSlide_title.length;
//        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (LinearLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        mLayoutInflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = mLayoutInflater.inflate(R.layout.layout_intro_slider_item, container, false);

        //initializing views
        ImageView introSlideIcon_imageView = (ImageView) view.findViewById(R.id.introSlideIcon_imageView);
        TextView introSlideTitle_textView = (TextView) view.findViewById(R.id.introSlideTitle_textView);
        TextView introSlideDescription_textView = (TextView) view.findViewById(R.id.introSlideDescription_textView);

        //setting values to views
        introSlideIcon_imageView.setImageResource(introSlide_images[position]);
        introSlideTitle_textView.setText(introSlide_title[position]);
        introSlideDescription_textView.setText(introSlide_descriptions[position]);


        //adding view to container
        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
