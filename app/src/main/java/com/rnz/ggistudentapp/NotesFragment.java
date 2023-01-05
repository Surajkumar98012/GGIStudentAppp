package com.rnz.ggistudentapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rnz.ggistudentapp.Adapters.NoticeAdapter;
import com.rnz.ggistudentapp.Adapters.NoticeData;
import com.rnz.ggistudentapp.Adapters.SpaceAdapter;
import com.rnz.ggistudentapp.Models.SpaceModel;

import java.util.ArrayList;
import java.util.List;

public class NotesFragment extends Fragment {

    private ProgressBar progressBar;
    private RecyclerView recyclerView1;
    private DatabaseReference reference;
    private List<SpaceModel> list;
    private SpaceAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_blank, container, false);
      //  ArrayList<SpaceModel> horizontallist = new ArrayList<>();

        recyclerView1 = view.findViewById(R.id.homerecycler1);
        progressBar=view.findViewById(R.id.progressBar);
        reference= FirebaseDatabase.getInstance().getReference().child("Notes");
        
        getData();

      //  recyclerView1.setHasFixedSize(true);
   //     recyclerView1.setLayoutManager(new LinearLayoutManager(view.getContext()));

//        GridLayoutManager layoutManager=new GridLayoutManager(this,2);

       // recyclerView1.setAdapter(new SpaceAdapter(horizontallist,getContext()));
        return view;

//        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    SpaceModel data=snapshot1.getValue(SpaceModel.class);
                    list.add(data);

                    adapter=new SpaceAdapter(getContext(),list);
                    //adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                    recyclerView1.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    recyclerView1.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}