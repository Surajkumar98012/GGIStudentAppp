package com.rnz.ggistudentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rnz.ggistudentapp.Adapters.SpaceAdapter;
import com.rnz.ggistudentapp.Models.SpaceModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotesFragment extends Fragment {
    private RecyclerView recyclerView1;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NotesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotesFragment newInstance(String param1, String param2) {
        NotesFragment fragment = new NotesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        ArrayList<SpaceModel> horizontallist = new ArrayList<>();

        recyclerView1 = view.findViewById(R.id.homerecycler1);
        horizontallist.add(new SpaceModel(R.drawable.notes,"subject1"));
        horizontallist.add(new SpaceModel(R.drawable.notes,"subject1"));
        horizontallist.add(new SpaceModel(R.drawable.exam,"subject1 subject1"));
        horizontallist.add(new SpaceModel(R.drawable.doubt,"subject1 subject1"));
        horizontallist.add(new SpaceModel(R.drawable.ic_add,"subject1"));
        horizontallist.add(new SpaceModel(R.drawable.notes,"subject1"));
        horizontallist.add(new SpaceModel(R.drawable.notes,"subject1"));
        horizontallist.add(new SpaceModel(R.drawable.exam,"subject1 subject1"));
        horizontallist.add(new SpaceModel(R.drawable.doubt,"subject1 subject1"));
        horizontallist.add(new SpaceModel(R.drawable.ic_add,"subject1"));


        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(view.getContext()));

//        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView1.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView1.setAdapter(new SpaceAdapter(horizontallist,getContext()));
        return view;

//        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
}