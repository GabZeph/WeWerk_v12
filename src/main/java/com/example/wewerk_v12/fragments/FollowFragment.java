package com.example.wewerk_v12.fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wewerk_v12.R;
import com.example.wewerk_v12.activities.ProfileStalkingActivity;
import com.example.wewerk_v12.adapters.FollowRecyclerAdapter;
import com.example.wewerk_v12.models.User;

import java.util.ArrayList;

public class FollowFragment extends Fragment implements FollowRecyclerAdapter.OnUserFollowListener {

    //ui components
    // private SearchView mFollow_searchView;
    private RecyclerView mFollow_recyclerView;
    private ImageView mBack_imageView, mSearch_imageView;
    private TextView mFollow_textView;

    //vars
    private FollowRecyclerAdapter mFollowRecyclerAdapter;
    private ArrayList<User> mUserArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_follow, container, false);

//initializing views
        mFollow_recyclerView = (RecyclerView) view.findViewById(R.id.follow_recyclerView);
        mFollow_textView = (TextView) view.findViewById(R.id.follow_activity_toolbarTitle_textView);
        mBack_imageView = (ImageView) view.findViewById(R.id.follow_activity_backButton_imageView);
        mSearch_imageView = (ImageView) view.findViewById(R.id.follow_activity_search_imageView);

        //  mFollow_searchView = (SearchView) findViewById(R.id.follow_searchView);

        //TODO: add tool bar button
        addToolbarButtonListener();

        //retrieving users list from activity
//        Bundle extras = getIntent().getExtras();
//        mUserArrayList=(User)extras.getSerializable("follow_arrayList");

        genreatingFakeFollowing();


        initRecyclerView();

        return view;
    }


    private void addToolbarButtonListener() {
        //back button


        //search button


    }

    private void genreatingFakeFollowing() {
        for (int i = 0; i < 100; i++) {
            User user = new User("jerry", "jerry123");
            mUserArrayList.add(user);
        }
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mFollow_recyclerView.setLayoutManager(linearLayoutManager);
        mFollowRecyclerAdapter = new FollowRecyclerAdapter(mUserArrayList, this);
        mFollow_recyclerView.setAdapter(mFollowRecyclerAdapter);
    }

    @Override
    public void onUserFollowClicked(int position) {
        ProfileStalkingFragment fragment = new ProfileStalkingFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
