package com.example.wewerk_v12.fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.wewerk_v12.R;

public class DiscoverFragment extends Fragment {

    private LinearLayout fatlossLinearLayout;
    private LinearLayout cardioLinearLayout;
    private LinearLayout hypertrophyLinearLayout;
    private LinearLayout strengthLinearLayout;
    private LinearLayout stretchingLinearLayout;
    private LinearLayout plyometryLinearLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        //initializing views
        fatlossLinearLayout = (LinearLayout) view.findViewById(R.id.fatLossLayout);
        cardioLinearLayout = (LinearLayout) view.findViewById(R.id.cardioLayout);
        plyometryLinearLayout = (LinearLayout) view.findViewById(R.id.plyometryLayout);
        strengthLinearLayout = (LinearLayout) view.findViewById(R.id.strengthLayout);
        stretchingLinearLayout = (LinearLayout) view.findViewById(R.id.stretchingLayout);
        hypertrophyLinearLayout = (LinearLayout) view.findViewById(R.id.hypertrophyLayout);

        //making layout clickable
        fatlossLinearLayout.setOnClickListener(onLayoutClickedListener);
        cardioLinearLayout.setOnClickListener(onLayoutClickedListener);
        plyometryLinearLayout.setOnClickListener(onLayoutClickedListener);
        strengthLinearLayout.setOnClickListener(onLayoutClickedListener);
        stretchingLinearLayout.setOnClickListener(onLayoutClickedListener);
        hypertrophyLinearLayout.setOnClickListener(onLayoutClickedListener);


        return view;
    }


    private View.OnClickListener onLayoutClickedListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.fatLossLayout:
                    Toast.makeText(getContext(), R.string.text_fatloss, Toast.LENGTH_SHORT).show();

                    break;
                case R.id.cardioLayout:
                    Toast.makeText(getContext(), R.string.text_cardio, Toast.LENGTH_SHORT).show();

                    break;
                case R.id.hypertrophyLayout:
                    Toast.makeText(getContext(), R.string.text_hypertrophy, Toast.LENGTH_SHORT).show();

                    break;
                case R.id.strengthLayout:
                    Toast.makeText(getContext(), R.string.text_strength, Toast.LENGTH_SHORT).show();

                    break;
                case R.id.stretchingLayout:
                    Toast.makeText(getContext(), R.string.text_stretching, Toast.LENGTH_SHORT).show();

                    break;
                case R.id.plyometryLayout:
                    Toast.makeText(getContext(), R.string.text_stretching, Toast.LENGTH_SHORT).show();

                    break;
                default:
                    break;
            }

            //replace discover fragment with discovery activity to see programs
            replaceDiscoverFragmentWithDiscoveryFragment();
        }
    };

//TODO: when we press back button, we go back to discover page, not exiting the app

    private void replaceDiscoverFragmentWithDiscoveryFragment() {
        WorkoutProgramListFragment workoutProgramListFragment = new WorkoutProgramListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, workoutProgramListFragment);

        fragmentTransaction.commit();
    }




}
