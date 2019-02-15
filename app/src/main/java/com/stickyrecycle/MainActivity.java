package com.stickyrecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stickyrecycle.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.content_frame, new ItemFragment()).commit();

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
