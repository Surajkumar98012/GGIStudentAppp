package com.rnz.ggistudentapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class AccountFragment extends Fragment implements View.OnClickListener{


    ImageView imageView;
    TextView nameEt,rollEt,courseEt,phoneEt,emailEt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView=getActivity().findViewById(R.id.iv_f1);
        nameEt=getActivity().findViewById(R.id.tv_name_f1);
        rollEt=getActivity().findViewById(R.id.tv_roll_f1);
        courseEt=getActivity().findViewById(R.id.tv_course_f1);
        phoneEt=getActivity().findViewById(R.id.tv_phone_f1);
        emailEt=getActivity().findViewById(R.id.tv_email_f1);

        TextView textView=getActivity().findViewById(R.id.tv_prof);
        textView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_prof:
                Intent intent= new Intent(getActivity(),CreateProfile.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String currentuid=user.getUid();
        DocumentReference reference;
        FirebaseFirestore firestore=FirebaseFirestore.getInstance();

        reference=firestore.collection("user").document(currentuid);

        reference.get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.getResult().exists()){
                            String nameResult=task.getResult().getString("name");
                            String rollResult=task.getResult().getString("roll");
                            String url=task.getResult().getString("url");
                            String courseResult=task.getResult().getString("course");
                            String phoneResult=task.getResult().getString("phone");
                            String emailResult=task.getResult().getString("email");

                            Picasso.get().load(url).into(imageView);
                            nameEt.setText(nameResult);
                            rollEt.setText(rollResult);
                            courseEt.setText(courseResult);
                            phoneEt.setText(phoneResult);
                            emailEt.setText(emailResult);


                        }else{
                            Intent intent=new Intent(getActivity(),CreateProfile.class);
                            startActivity(intent);
                        }
                    }
                });

    }
}