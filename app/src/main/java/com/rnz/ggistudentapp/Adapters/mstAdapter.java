package com.rnz.ggistudentapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rnz.ggistudentapp.Models.MstModel;
import com.rnz.ggistudentapp.Models.SpaceModel;
import com.rnz.ggistudentapp.R;

import java.util.List;

public class mstAdapter extends RecyclerView.Adapter<mstAdapter.MstHolder> {
    private Context context;
    private List<MstModel> list;

    public mstAdapter(Context context, List<MstModel> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public mstAdapter.MstHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.mstmodel,parent,false);
        return new mstAdapter.MstHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mstAdapter.MstHolder holder, int position) {

        holder.cardTitle.setText(list.get(position).getMstTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfUrl()));
                context.startActivity(intent);
                Toast.makeText(context, "Downloading", Toast.LENGTH_SHORT).show();
                /* Toast.makeText(context,list.get(position).getnotesTitle(), Toast.LENGTH_SHORT).show();*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MstHolder extends RecyclerView.ViewHolder {
        private TextView cardTitle;
        private ImageView cardImage;
        public MstHolder(@NonNull View itemView) {
            super(itemView);
            cardImage=itemView.findViewById(R.id.mstCardImage);
            cardTitle=itemView.findViewById(R.id.mstcardtitle);
        }
    }
}
