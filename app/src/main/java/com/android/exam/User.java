package com.android.exam;

public class User {
    /** Name of the user */
    private String mName;

    /** Username */
    private String mUsername;

    /** E-mail of user */
    private String mEmail;

    public User(String name,String username, String email){
        mName = name;
        mUsername = username;
        mEmail = email;
    }

    /**
     * Returns the name of the user
     */
    public String getName() {
        return mName;
    }

    /**
     * Returns the username
     */
    public String getUsername() {
        return mUsername;
    }

    /**
     * Returns the email of the user
     */
    public String getEmail() {
        return mEmail;
    }
}
