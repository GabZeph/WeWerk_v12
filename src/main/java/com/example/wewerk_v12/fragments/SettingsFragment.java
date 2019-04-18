package com.example.wewerk_v12.fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.wewerk_v12.R;

public class SettingsFragment extends Fragment {

    private ImageView mSettings_imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        mSettings_imageView = (ImageView) view.findViewById(R.id.settings_settings_imageButton);

        mSettings_imageView.setOnClickListener(onSettingsButtonClickedListener);

        return view;
    }

    private View.OnClickListener onSettingsButtonClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager().popBackStackImmediate();
        }
    };
}
