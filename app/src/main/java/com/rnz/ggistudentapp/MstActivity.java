package com.rnz.ggistudentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rnz.ggistudentapp.Adapters.SpaceAdapter;
import com.rnz.ggistudentapp.Adapters.mstAdapter;
import com.rnz.ggistudentapp.Models.MstModel;
import com.rnz.ggistudentapp.Models.SpaceModel;

import java.util.ArrayList;
import java.util.List;

public class MstActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private RecyclerView recyclerView1;
    private DatabaseReference reference;
    private List<MstModel> list;
    private mstAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mst);

        recyclerView1 = findViewById(R.id.homerecycler2);
        progressBar=findViewById(R.id.progressBar);
        reference= FirebaseDatabase.getInstance().getReference().child("MstPaper");

        getData();
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    MstModel data=snapshot1.getValue(MstModel.class);
                    list.add(data);

                    adapter=new mstAdapter(MstActivity.this,list);
                    //adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                    recyclerView1.setLayoutManager(new GridLayoutManager(MstActivity.this, 2));
                    recyclerView1.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MstActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}