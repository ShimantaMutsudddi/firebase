package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText title,auther,desc;
    private Button save,read;
    private TextView write;
    private DatabaseReference Post;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                savef();

            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readOnetime();
            }
        });
    }

    private void readOnetime()
    {
        Post.child("-MBxzhAmhHZgNP3Lo-9B").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                String post= "Title :"+snapshot.child("Title").getValue(String.class)+"\n"+
                        "Description :"+snapshot.child("description").getValue(String.class)+"\n"+
                        "Auther :"+snapshot.child("auther").getValue(String.class);

                write.setText(post);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void savef()
    {
        HashMap<String,Object> map=new HashMap<>();
        map.put("title",title.getText().toString());
        map.put("description",desc.getText().toString());
        map.put("auther",auther.getText().toString());
        Post.push().setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task)
            {
                Log.i("hhh", "onComplete: ");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                Log.i("jjjj", "onFailure: "+e.toString());

            }
        });
    }

    private void init()
    {
        Post=FirebaseDatabase.getInstance().getReference().child("Post");
        title=(EditText) findViewById(R.id.title);
        auther=(EditText) findViewById(R.id.auther);
        desc=(EditText)findViewById(R.id.desc);
        save=(Button) findViewById(R.id.button);
        read=(Button) findViewById(R.id.buttonread);
        write=(TextView) findViewById(R.id.write);
    }
}
