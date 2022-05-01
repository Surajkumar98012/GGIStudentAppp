package com.rnz.ggistudentapp.Adapters;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rnz.ggistudentapp.R;

public class AnnouncementHolder extends RecyclerView.ViewHolder {
    TextView date, title, batch, announcement;

    public AnnouncementHolder(View itemView) {
        super(itemView);
        date = itemView.findViewById(R.id.CardDate);
        title = itemView.findViewById(R.id.CardTitle);
        batch = itemView.findViewById(R.id.CardBatch);
        announcement = itemView.findViewById(R.id.CardAnnouncement);

    }
}


// ViewHolder code for RecyclerView
