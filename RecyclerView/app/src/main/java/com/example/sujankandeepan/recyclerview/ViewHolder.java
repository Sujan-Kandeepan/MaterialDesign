package com.example.sujankandeepan.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView name;
    public TextView description;
    public LinearLayout linearLayout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.image_view);
        name = itemView.findViewById(R.id.name_text_view);
        description = itemView.findViewById(R.id.desc_text_view);
        linearLayout = itemView.findViewById(R.id.recycler_item);
    }
}
