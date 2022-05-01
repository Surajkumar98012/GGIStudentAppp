package com.rnz.ggistudentapp.Adapters;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.rnz.ggistudentapp.R;

public class SpaceHolder extends RecyclerView.ViewHolder {
    ImageView image;

    public SpaceHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.CardImage);
    /*    title = itemView.findViewById(R.id.CardTitle);
        batch = itemView.findViewById(R.id.CardBatch);
        announcement = itemView.findViewById(R.id.CardAnnouncement);*/

    }
}



