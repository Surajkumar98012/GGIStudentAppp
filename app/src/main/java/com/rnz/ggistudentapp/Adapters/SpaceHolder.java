package com.rnz.ggistudentapp.Adapters;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rnz.ggistudentapp.R;

public class SpaceHolder extends RecyclerView.ViewHolder {
    TextView cardtitle;
    ImageView cardimage;
    public SpaceHolder(@NonNull View itemView) {
        super(itemView);
  cardtitle = itemView.findViewById(R.id.spacecardtitle);
  cardimage = itemView.findViewById(R.id.CardImage);

    }
}
