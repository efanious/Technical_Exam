package com.android.exam;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

public class UserLoader extends AsyncTaskLoader<List<User>> {
    /** Query URL */
    private String mUrl;

    public UserLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }


    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<User> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of users.
        List<User> users = UserUtils.fetchUserData(mUrl);
        return users;
    }
}
