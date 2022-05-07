package com.rnz.ggistudentapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rnz.ggistudentapp.Models.SpaceModel;
import com.rnz.ggistudentapp.R;

import java.util.ArrayList;

public class SpaceAdapter extends RecyclerView.Adapter<SpaceHolder> {
    ArrayList<SpaceModel> horizontallist = new ArrayList<>();
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
    }
}
