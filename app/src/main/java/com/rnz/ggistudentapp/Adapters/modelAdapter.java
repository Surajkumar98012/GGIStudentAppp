package com.rnz.ggistudentapp.Adapters;

    import android.content.Context;
    import android.content.Intent;
    import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

    import com.rnz.ggistudentapp.AskActivity;
    import com.rnz.ggistudentapp.ChatFragment;
    import com.rnz.ggistudentapp.Models.model;
    import com.rnz.ggistudentapp.MstActivity;
    import com.rnz.ggistudentapp.NotesFragment;
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
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    switch (position){
/*                        case 0:
                            Intent intent= new Intent(context, NotesFragment.class);
                            context.startActivity(intent);
                            break;*/
                        case 1:
                            Intent intent1= new Intent(context, MstActivity.class);
                            context.startActivity(intent1);
                            break;
/*                        case 2:
                            Intent intent2= new Intent(context, ChatFragment.class);
                            context.startActivity(intent2);
                            break;*/
                    }

                }
            });
        }

        @Override
        public int getItemCount() {
            return horizontallist.size();
        }
    }



