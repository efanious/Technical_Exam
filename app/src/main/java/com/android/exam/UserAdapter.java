//package com.android.exam;
//
//
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import java.util.List;
//
//public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
//    private String[] mDataset;
//    private List<User> mUsers;
//
//    // Provide a suitable constructor (depends on the kind of dataset)
//    public UserAdapter(List<User> users) {
//        mUsers = users;
//    }
//
//    // Create new views (invoked by the layout manager)
//    @Override
//    public UserAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
//                                                       int viewType) {
//        // create a new view
//        View v = (TextView) LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_content_list, parent, false);
//
//        MyViewHolder vh = new MyViewHolder((TextView) v);
//        return vh;
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        // - get element from your dataset at this position
//        // - replace the contents of the view with that element
//        holder.mNameView.setText(mDataset[position]);
//
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    @Override
//    public int getItemCount() {
//        return (mUsers.size());
//    }
//
//    // Provide a reference to the views for each data item
//    // Complex data items may need more than one view per item, and
//    // you provide access to all the views for a data item in a view holder
//    public static class MyViewHolder extends RecyclerView.ViewHolder {
//        // each data item is just a string in this case
//        public TextView mNameView;
////        public TextView mUserView;
////        public TextView mEmailView;
//
//        public MyViewHolder(TextView v) {
//            super(v);
//            mNameView = (TextView) v.findViewById(R.id.name);
////            mUserView = username;
////            mEmailView = email;
//
//        }
//    }
//}
//
//
//

package com.android.exam;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends ArrayAdapter {

    public UserAdapter(Context context, List<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_content_list, parent, false);
        }

        User currentUser = (User) getItem(position);

        TextView nameView = (TextView) listItemView.findViewById(R.id.name_id);

        nameView.setText(currentUser.getName());

        TextView username = (TextView) listItemView.findViewById(R.id.user_name);

        username.setText(currentUser.getUsername());

        TextView email = (TextView) listItemView.findViewById(R.id.email_id);

        email.setText(currentUser.getEmail());



        return listItemView;

    }
}