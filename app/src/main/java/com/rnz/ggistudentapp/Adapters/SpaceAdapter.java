package com.rnz.ggistudentapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rnz.ggistudentapp.Models.SpaceModel;
import com.rnz.ggistudentapp.R;

import java.util.ArrayList;
import java.util.List;

public class SpaceAdapter extends RecyclerView.Adapter<SpaceAdapter.SpaceHolder> {

    private Context context;
    private List<SpaceModel> list;

    public SpaceAdapter(Context context, List<SpaceModel> list) {
        this.context = context;
        this.list = list;
    }

    public SpaceAdapter(ArrayList<SpaceModel> horizontallist, Context context) {

    }

    @NonNull
    @Override
    public SpaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.spacelmodelcard,parent,false);
        return new SpaceHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpaceHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.cardTitle.setText(list.get(position).getnotesTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,list.get(position).getnotesTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfUrl()));
                context.startActivity(intent);
                Toast.makeText(context, "Downloaded", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SpaceHolder extends RecyclerView.ViewHolder {

        private TextView cardTitle;
        private ImageView cardImage;

        public SpaceHolder(@NonNull View itemView) {
            super(itemView);
            cardImage=itemView.findViewById(R.id.CardImage);
            cardTitle=itemView.findViewById(R.id.spacecardtitle);
        }
    }





























   /* ArrayList<SpaceModel> horizontallist = new ArrayList<>();
    Context context;
    public SpaceAdapter(ArrayList<SpaceModel> horizontallist, Context context) {
    this.horizontallist = horizontallist;
    this.context = context;
    }

    @NonNull
    @Override
    public SpaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.spacelmodelcard, parent, false);
        return new SpaceHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull SpaceHolder holder, int position) {
        SpaceModel model = horizontallist.get(position);

        holder.cardimage.setImageResource(model.getCardimage());
holder.cardtitle.setText((CharSequence) model.getCardtitle());
    }

    @Override
    public int getItemCount() {
        return horizontallist.size();
    }*/
}
