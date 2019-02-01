package com.android.exam;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<User>>{

    private UserAdapter mAdapter;

    public static final String LOG_TAG = MainActivity.class.getName();

    /** URL for data  */
    private static final String REQUEST_URL =
            "https://jsonplaceholder.typicode.com/users";

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        mRecyclerView = (RecyclerView) findViewById(R.id.list_users);
//
//        LinearLayoutManager layoutManager =
//                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//
//        mRecyclerView.setLayoutManager(layoutManager);
//
//
//        mRecyclerView.setHasFixedSize(true);
//
//        // Create a new adapter that takes an empty list of users as input
//        mAdapter = new UserAdapter(this, new UserAdapter<users>);

        // Find a reference to the {@link ListView} in the layout
        ListView userListView = (ListView) findViewById(R.id.list_new);

        mAdapter = new UserAdapter(this, new ArrayList<User>());

        userListView.setAdapter(mAdapter);

        getSupportLoaderManager().initLoader(1, null, this);


    }

    @Override
    public Loader<List<User>> onCreateLoader(int id, Bundle args) {

        return new UserLoader(MainActivity.this,REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<User>> loader, List<User> data) {

        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Book}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {

            mAdapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<User>> loader) {
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();

    }
}
