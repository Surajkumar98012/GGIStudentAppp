package com.rnz.ggistudentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rnz.ggistudentapp.Adapters.AnsViewholder;
import com.rnz.ggistudentapp.Adapters.Viewholder_Question;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReplyActivity extends AppCompatActivity {

    String uid,question,key,privacy,cuid,name,url,time;
    EditText editText;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference reference,reference2,reference3;
    AnswerMember member;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference Allquestions,votesref;
    TextView nametv,questiontv;
    RecyclerView recyclerView;
    ImageView imageViewQue,imageViewUser,sendButton;

    Boolean votechecker=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        member =new AnswerMember();

         nametv=findViewById(R.id.name_reply_tv);
         questiontv=findViewById(R.id.que_reply_tv);
         imageViewQue=findViewById(R.id.iv_que_user);
         imageViewUser=findViewById(R.id.iv_reply_user);
         editText=findViewById(R.id.answer_tv);
         sendButton=findViewById(R.id.post_answer_tv);
         recyclerView=findViewById(R.id.rv_ans);
         recyclerView.setLayoutManager(new LinearLayoutManager(ReplyActivity.this));


        Bundle extra=getIntent().getExtras();
        if(extra != null){
            cuid=extra.getString("cuid");
            name=extra.getString("name");
            url=extra.getString("url");
            uid=extra.getString("uid");
            key=extra.getString("key");
            question=extra.getString("q");
            privacy=extra.getString("privacy");

        }else{
            Toast.makeText(this, "oops", Toast.LENGTH_SHORT).show();
        }

        Allquestions=database.getReference("All Questions").child(key).child("Answer");

         sendButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 saveAnswer();

             }
         });

        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        String currentuid=user.getUid();


        Allquestions=database.getReference("All Questions").child(key).child("Answer");
        votesref=database.getReference("votes");


        reference = db.collection("user").document(cuid);
        reference2= db.collection("user").document(currentuid);
        reference3= db.collection("user").document(currentuid);


 /*       tvreply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/


    }

    void saveAnswer(){

        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        String userid=user.getUid();
        String answer=editText.getText().toString();
        if(answer!=null){

            Calendar cdate=Calendar.getInstance();
            SimpleDateFormat currentdate = new SimpleDateFormat("dd-MMMM-yyyy");
            final String savedate=currentdate.format(cdate.getTime());

            Calendar ctime=Calendar.getInstance();
            SimpleDateFormat currenttime = new SimpleDateFormat("HH:mm:ss");
            final String savetime=currenttime.format(ctime.getTime());

            time = savedate +":"+ savetime;

            member.setAnswer(answer);
            member.setTime(time);
            member.setName(name);
            member.setUid(userid);
            member.setUrl(url);

            String id=Allquestions.push().getKey();
            Allquestions.child(id).setValue(member);

            Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Please write Something", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();


        reference.get()
                .addOnCompleteListener((task) ->{
                    if (task.getResult().exists()){
                        Picasso.get().load(url).into(imageViewQue);
                        questiontv.setText(question);
                        nametv.setText(name);
                    }else{
                        Toast.makeText(ReplyActivity.this,"Error on getting question",Toast.LENGTH_SHORT).show();
                    }
                } );

        reference2.get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        {
                            if (task.getResult().exists()){
                                String url =task.getResult().getString("url");
                                Picasso.get().load(url).into(imageViewUser);
                            }else{
                                Toast.makeText(ReplyActivity.this,"Error",Toast.LENGTH_SHORT).show();
                            }
                    }
                }
                } );

        reference3.get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        {
                            if (task.getResult().exists()){
                                url =task.getResult().getString("url");
                                name=task.getResult().getString("name");
                            }else{
                                Toast.makeText(ReplyActivity.this,"Error",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                } );



        FirebaseRecyclerOptions<AnswerMember> options=
                new FirebaseRecyclerOptions.Builder<AnswerMember>()
                        .setQuery(Allquestions,AnswerMember.class)
                        .build();

        FirebaseRecyclerAdapter<AnswerMember, AnsViewholder> firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<AnswerMember,AnsViewholder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull AnsViewholder holder, int position, @NonNull AnswerMember model) {
                        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                        String currentUserid=user.getUid();

                        final String key=getRef(position).getKey();

                        holder.setAnswer(getApplication(),model.getName(),model.getAnswer(),model.getUid(),model.getTime(),model.getUrl());

                        holder.upvoteChecker(key);
                        holder.upvoteTv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                votechecker=true;
                                votesref.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                       if (votechecker.equals(true)){
                                           if (snapshot.child(key).hasChild(currentUserid)){
                                               votesref.child(key).child(currentUserid).removeValue();
                                               votechecker=false;
                                           }else{
                                               votesref.child(key).child(currentUserid).setValue(true);
                                               votechecker=false;
                                           }
                                       }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });

                            }
                        });

                    }

                    @NonNull
                    @Override
                    public AnsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                        View view= LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.ans_layout,parent,false);

                        return new AnsViewholder(view);
                    }
                };

        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }
}
