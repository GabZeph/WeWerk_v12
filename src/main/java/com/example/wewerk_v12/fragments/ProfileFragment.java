package com.example.wewerk_v12.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wewerk_v12.R;
import com.example.wewerk_v12.activities.CalendarActivity;
import com.example.wewerk_v12.activities.TimerActivity;
import com.example.wewerk_v12.activities.ViewMessageActivity;
import com.example.wewerk_v12.models.User;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private TextView mRealName_textView, mUsername_textView, mProgramsNumber_textView,
            mFollowersNumber_textView, mFollowingNumber_textView;
    private Button mMessage_button, mCalendar_button, mTimer_button, mCalculateBMR_button, mCalculateIMC_button,
            mFindOneRepMax_button, mTrainingRessources_button;

    //, mSendFeedback_button

    private ImageView mSettings_imageView;

    private Fragment mFragment;

//    private Button mFollow_button, mMessage_button;

    //private FrameLayout mProfileContrainer_frameLayout;

    private ArrayList<User> mUserArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //initializing views
        mRealName_textView = (TextView) view.findViewById(R.id.realNameTextView);
        mUsername_textView = (TextView) view.findViewById(R.id.username_textView);
        mProgramsNumber_textView = (TextView) view.findViewById(R.id.programNumberTextView);
        mFollowersNumber_textView = (TextView) view.findViewById(R.id.followerNumberTextView);
        mFollowingNumber_textView = (TextView) view.findViewById(R.id.followingNumbertextView);

        mSettings_imageView = (ImageView) view.findViewById(R.id.profile_settings_imageButton);

        mMessage_button = (Button) view.findViewById(R.id.profile_message_button);
        mCalendar_button = (Button) view.findViewById(R.id.profile_calendar_button);
        mTimer_button = (Button) view.findViewById(R.id.profile_timer_button);
        mCalculateBMR_button = (Button) view.findViewById(R.id.profile_calculate_bmr_button);
        mCalculateIMC_button = (Button) view.findViewById(R.id.profile_calculate_imc);
        mFindOneRepMax_button = (Button) view.findViewById(R.id.profile_findOneRepMax_button);
        mTrainingRessources_button = (Button) view.findViewById(R.id.profile_training_ressources_button);

        // mSendFeedback_button = (Button) view.findViewById(R.id.sendfeedback_button);

        //TODO: add button listener
        addButtonListener();

//        mFollow_button = (Button) view.findViewById(R.id.followButton);
//        mMessage_button = (Button) view.findViewById(R.id.messageButton);

        mFollowingNumber_textView.setOnClickListener(onTextViewClickedListener);
        mFollowersNumber_textView.setOnClickListener(onTextViewClickedListener);


        //  mProfileContrainer_frameLayout = (FrameLayout) view.findViewById(R.id.profileContainer_frameLayout);


        //TODO: change text in views according to user infos
        setUserInfos();
        //TODO: view user saved workout using pager adapter
        //addWorkoutsProgramsToFrameLayout();

        return view;
    }

    private void addButtonListener() {
        mSettings_imageView.setOnClickListener(onSettingClickedListener);
        mMessage_button.setOnClickListener(onMessageClickedListener);
        mCalendar_button.setOnClickListener(onCalendarClickedListener);
        mTimer_button.setOnClickListener(onTimerClickedListener);
        mCalculateBMR_button.setOnClickListener(onCalculateBmrClickedListener);
        mCalculateIMC_button.setOnClickListener(onCalculateBMIClickedListener);
        mFindOneRepMax_button.setOnClickListener(onFindOneRepMaxClickedListener);
        mTrainingRessources_button.setOnClickListener(onTrainingRessourcesClickedListener);
        // mSendFeedback_button.setOnClickListener(onSendFeedbackClickedListener);
    }

    private View.OnClickListener onSettingClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO; setting listener
            mFragment = new SettingsFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, mFragment);
            fragmentTransaction.addToBackStack(null).commit();
        }
    };

    View.OnClickListener onMessageClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO: message listener
            Intent intent = new Intent(getContext(), ViewMessageActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener onCalendarClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO: calendar listener
            Intent intent = new Intent(getContext(), CalendarActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener onTimerClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//TODO: timer listener

            Intent intent = new Intent(getContext(), TimerActivity.class);
            startActivity(intent);

        }
    };

    //TODO: clean up les button listener

    private View.OnClickListener onCalculateBmrClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//TODO: calculate bmr listener
            mFragment = new CalculateBMRFragment();

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, mFragment);
            fragmentTransaction.addToBackStack(null).commit();
        }
    };


    private View.OnClickListener onCalculateBMIClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//TODO: calculate imc listener
            mFragment = new CalculateBMIFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, mFragment);
            fragmentTransaction.addToBackStack(null).commit();
        }
    };


    private View.OnClickListener onFindOneRepMaxClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//TODO: find one rep max listener
            mFragment = new FindOneRepMaxFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, mFragment);
            fragmentTransaction.addToBackStack(null).commit();
        }
    };


    private View.OnClickListener onTrainingRessourcesClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//TODO: training ressource listener
            mFragment = new TrainingRessourceFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, mFragment);
            fragmentTransaction.addToBackStack(null).commit();

        }
    };


//    private View.OnClickListener onSendFeedbackClickedListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//
////            Intent intent = new Intent(v.getContext(), SendFeedbackActivity.class);
////
//
//        }
//    };

    private View.OnClickListener onTextViewClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

//            ArrayList<User> userArrayList = new ArrayList<>();
//mUserArrayList.clear();

            switch (view.getId()) {
                case R.id.followerNumberTextView:
                    Toast.makeText(getContext(), R.string.text_followers, Toast.LENGTH_SHORT).show();

                    //TODO: retrieve user followers from firebase
                    //generating fake folllowers
                    generatingFakeFollowers();

                    break;
                case R.id.followingNumbertextView:
                    Toast.makeText(getContext(), R.string.text_following, Toast.LENGTH_SHORT).show();

                    //TODO: retrieve user following from firebase

                    //generating fake follloings
                    genreatingFakeFollowing();

                    break;

                default:
                    break;
            }

            //showing followers or following users page
            goToFollowPage();

        }
    };

    private void genreatingFakeFollowing() {
        for (int i = 0; i < 100; i++) {
            User user = new User("jerry", "jerry123");
            mUserArrayList.add(user);
        }
    }

    private void generatingFakeFollowers() {
        for (int i = 0; i < 100; i++) {
            User user = new User("bob", "bobby123");
            mUserArrayList.add(user);
        }
    }

    private void goToFollowPage() {

//
//        Intent intent = new Intent(getContext(), FollowActivity.class);
//        intent.putExtra("follow_arrayList", mUserArrayList);
//        startActivity(intent);

        mFragment = new FollowFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, mFragment);
        fragmentTransaction.addToBackStack(null).commit();

    }


//    private void addWorkoutsProgramsToFrameLayout() {
//        //set pager adapter to get infos...
//
//    }

    private void setUserInfos() {
        //retrieve data from firebase

        //change textviews according to user info


    }
}
