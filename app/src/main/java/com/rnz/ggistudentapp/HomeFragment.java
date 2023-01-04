package com.rnz.ggistudentapp;



import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private ProgressBar progressBar;
    private ArrayList<NoticeData> list;
    private NoticeAdapter adapter;
    private DatabaseReference reference;
    private RecyclerView recyclerView1,deleteNoticeRecycler;
/*

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor

    }

    *//**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment HomeFragment.
     *//*
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

/*    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  *//*      if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*//*



        //error

    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment




        deleteNoticeRecycler=view.findViewById(R.id.homerecycler);
        recyclerView1 = view.findViewById(R.id.homerecycler1);
        progressBar=view.findViewById(R.id.progressBar);

        reference= FirebaseDatabase.getInstance().getReference().child("Notice");

        deleteNoticeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        deleteNoticeRecycler.setHasFixedSize(true);








        ArrayList<SpaceModel> horizontallist = new ArrayList<>();

        horizontallist.add(new SpaceModel(R.drawable.notes,"Notes"));
        horizontallist.add(new SpaceModel(R.drawable.exam,"Previous Paper"));
        horizontallist.add(new SpaceModel(R.drawable.doubt,"Ask doubt"));
        horizontallist.add(new SpaceModel(R.drawable.ic_add,"Add"));

        recyclerView1.setHasFixedSize(true);

        recyclerView1.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,
                false));

        recyclerView1.setAdapter(new SpaceAdapter(horizontallist,getContext()));









        getNotice();
        return view;
    }

    private void getNotice() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    NoticeData data=snapshot1.getValue(NoticeData.class);
                    list.add(data);
                }
                adapter=new NoticeAdapter(getContext(),list);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                deleteNoticeRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(),"database Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

}

