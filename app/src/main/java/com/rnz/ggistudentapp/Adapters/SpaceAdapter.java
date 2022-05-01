
package com.rnz.ggistudentapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.rnz.ggistudentapp.Models.AnnouncementModel;
import com.rnz.ggistudentapp.Models.SpaceModel;
import com.rnz.ggistudentapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SpaceAdapter extends RecyclerView.Adapter<SpaceHolder>{
    @NonNull
    ArrayList<SpaceModel> list = new ArrayList<>();
    Context context;
    public SpaceAdapter(ArrayList<SpaceModel> list, Context context) {
        this.list = list;
        this.context = context;
    }
    public SpaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.spacelmodelcard,parent,false);
        return new SpaceHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpaceHolder holder, int position) {
        SpaceModel data = list.get(position);// .....
        holder.image.setImageResource(data.getImage());//......
//        holder.txtview.setText(data.getImgname());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

//public class SpaceAdapter extends RecyclerView.Adapter<SpaceHolder> {
//    @NonNull
//    ArrayList<AnnouncementModel> list = new ArrayList<>();
//    Context context;
//
//    public SpaceAdapter(ArrayList<AnnouncementModel> list, Context context) {
//        this.list = list;
//        this.context = context;
//    }
//
//    @Override
//    public AnnouncementHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context)
//                .inflate(R.layout.announcementcard, parent, false);
//        return new AnnouncementHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull AnnouncementHolder holder, int position) {
//        AnnouncementModel model = list.get(position);
//        holder.date.setText(model.getDate());
//        holder.title.setText(model.getAnnouncementtitle());
//        holder.batch.setText(model.getBatch());
//        holder.announcement.setText(model.getAnnouncement());
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//    ArrayList<AnnouncementModel> list = new ArrayList<>();
//    Context context;
//
//    public AnnouncementAdapter(ArrayList<AnnouncementModel> list, Context context) {
//        this.list = list;
//        this.context = context;
//    }
//
//
//    @NonNull
//    @Override
//    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        we should inflate the layout that we have created using layout resource file and retturn the view using the obje
////        ct of viewholder class that we have created below
//        View v = LayoutInflater.from(context)
//                .inflate(R.layout.announcementcard, parent, false);
//        return new viewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
//        AnnouncementModel model = list.get(position);
//        holder.date.setText(model.getDate());
//        holder.title.setText(model.getAnnouncementtitle());
//        holder.batch.setText(model.getBatch());
//        holder.announcement.setText(model.getAnnouncement());
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public class viewHolder extends RecyclerView.ViewHolder {
//        TextView date, title, batch, announcement;
//
//        public viewHolder(@NonNull View itemView) {
//            super(itemView);
//            date = itemView.findViewById(R.id.CardDate);
//            title = itemView.findViewById(R.id.CardTitle);
//            batch = itemView.findViewById(R.id.CardBatch);
//            announcement = itemView.findViewById(R.id.CardAnnouncement);
//
//        }
//    }
}
