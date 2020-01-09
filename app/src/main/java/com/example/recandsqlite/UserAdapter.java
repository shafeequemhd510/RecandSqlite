package com.example.recandsqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    List<Users> users;

    public UserAdapter(List<Users> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.userlayout, parent, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        holder.tv.setText(users.get(position).name);
        holder.tv2.setText(users.get(position).place);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        TextView tv;
        TextView tv2;


        public UserHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.textView);
            tv2=itemView.findViewById(R.id.textView2);

        }


    }
}

