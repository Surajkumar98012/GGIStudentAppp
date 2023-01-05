package com.rnz.ggistudentapp.Adapters;

    import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rnz.ggistudentapp.Models.model;
import com.rnz.ggistudentapp.R;

import java.util.ArrayList;

    public class modelAdapter extends RecyclerView.Adapter<SpaceHolder> {
        ArrayList<model> horizontallist = new ArrayList<>();
        Context context;
        public modelAdapter(ArrayList<model> horizontallist, Context context) {
            this.horizontallist = horizontallist;
            this.context = context;
        }

        @NonNull
        @Override
        public SpaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(context)
                    .inflate(R.layout.modelcard, parent, false);
            return new SpaceHolder(v);

        }

        @Override
        public void onBindViewHolder(@NonNull SpaceHolder holder, int position) {
            model model = horizontallist.get(position);

            holder.cardimage.setImageResource(model.getCardimage());
            holder.cardtitle.setText((CharSequence) model.getCardtitle());
        }

        @Override
        public int getItemCount() {
            return horizontallist.size();
        }
    }



