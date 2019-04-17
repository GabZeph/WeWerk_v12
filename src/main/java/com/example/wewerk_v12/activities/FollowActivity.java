package com.example.wewerk_v12.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.wewerk_v12.R;
import com.example.wewerk_v12.adapters.FollowRecyclerAdapter;
import com.example.wewerk_v12.adapters.WorkoutProgramRecyclerAdapter;
import com.example.wewerk_v12.models.User;
import com.example.wewerk_v12.models.WorkoutProgram;

import java.util.ArrayList;

public class FollowActivity extends AppCompatActivity implements FollowRecyclerAdapter.OnUserFollowListener {

    //ui components
    // private SearchView mFollow_searchView;
    private RecyclerView mFollow_recyclerView;
    private ImageView mBack_imageView, mSearch_imageView;
    private TextView mFollow_textView;

    //vars
    private FollowRecyclerAdapter mFollowRecyclerAdapter;
    private ArrayList<User> mUserArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);

        //initializing views
        mFollow_recyclerView = (RecyclerView) findViewById(R.id.follow_recyclerView);
        mFollow_textView = (TextView) findViewById(R.id.follow_activity_toolbarTitle_textView);
        mBack_imageView = (ImageView) findViewById(R.id.follow_activity_backButton_imageView);
        mSearch_imageView = (ImageView) findViewById(R.id.follow_activity_search_imageView);

        //  mFollow_searchView = (SearchView) findViewById(R.id.follow_searchView);

        //TODO: add tool bar button
        addToolbarButtonListener();

        //retrieving users list from activity
        Bundle extras = getIntent().getExtras();
//        mUserArrayList=(User)extras.getSerializable("follow_arrayList");

        genreatingFakeFollowing();


        initRecyclerView();

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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mFollow_recyclerView.setLayoutManager(linearLayoutManager);
        mFollowRecyclerAdapter = new FollowRecyclerAdapter(mUserArrayList, this);
        mFollow_recyclerView.setAdapter(mFollowRecyclerAdapter);
    }

    @Override
    public void onUserFollowClicked(int position) {
//        mUserArrayList.get(position)

        Intent intent = new Intent(this, ProfileStalkingActivity.class);
        startActivity(intent);
    }
//
//    @Override
//    public void onUserFollowClicked(int position) {
////        Intent intent=new Intent(this, ProfileStalkingActivity.class);
//
//      //  startActivity(intent);
//    }
}
