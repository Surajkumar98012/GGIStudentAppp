package com.rnz.ggistudentapp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rnz.ggistudentapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewadapter> {

    private Context context;
    private ArrayList<NoticeData> list;

    public NoticeAdapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout,parent,false);
        return new NoticeViewadapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewadapter holder, int position) {

        NoticeData currentItem=list.get(position);
        holder.NoticeTitle.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getDate());
        holder.time.setText(currentItem.getTime());
        try {
            if (currentItem.getImage()!=null)
                  Picasso.get().load(currentItem.getImage()).into(holder.NoticeImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewadapter extends RecyclerView.ViewHolder {

        private TextView NoticeTitle,date,time;
        private ImageView NoticeImage;

        public NoticeViewadapter(@NonNull View itemView) {
            super(itemView);
            NoticeTitle=itemView.findViewById(R.id.noticeTitle);
            NoticeImage=itemView.findViewById(R.id.noticeImage);
            date=itemView.findViewById(R.id.noticeDate);
            time=itemView.findViewById(R.id.noticeTime);


        }
    }
}
