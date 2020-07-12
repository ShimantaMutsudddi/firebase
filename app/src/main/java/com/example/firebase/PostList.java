package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class PostList extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerviewid);

        //to show the listLinierly
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Post> options =
                new FirebaseRecyclerOptions.Builder<Post>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Post"), Post.class)
                        .build();

         adapter =new PostAdapter(options);
         recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
