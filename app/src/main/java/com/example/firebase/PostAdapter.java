package com.example.firebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class PostAdapter extends FirebaseRecyclerAdapter<Post, PostAdapter.PostViewholder>
{

    public PostAdapter(@NonNull FirebaseRecyclerOptions<Post> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostViewholder holder, int position, @NonNull Post model)
    {
        holder.title.setText(model.getTitle());
        holder.auther.setText(model.getAuther());
        holder.description.setText(model.getDescription());

    }

    @NonNull
    @Override
    public PostViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post, parent, false);

        return new PostViewholder(view);
    }

    class PostViewholder extends RecyclerView.ViewHolder
    {
        TextView title,auther,description;

        public PostViewholder(@NonNull View itemView)
        {
            super(itemView);

            title=(TextView) itemView.findViewById(R.id.titleid);
            auther=(TextView) itemView.findViewById(R.id.autherid);
            description=(TextView) itemView.findViewById(R.id.descid);
        }
    }
}
