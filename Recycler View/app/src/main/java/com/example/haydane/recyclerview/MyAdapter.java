package com.example.haydane.recyclerview;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder> {
    String[] title;
    int[] image;
    public MyAdapter(int[] image,String[] title)
    {
        this.image=image;
        this.title=title;
    }
    @NonNull
    @Override
    public MyAdapter.MyAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.activity_list_item,viewGroup,false);
        return new MyAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyAdapter.MyAdapterViewHolder myAdapterViewHolder, int i) {
        final String tt = title[i];
        final int img = image[i];
        myAdapterViewHolder.title.setText(tt);
        myAdapterViewHolder.icon.setImageResource(img);
        myAdapterViewHolder.linearLayoutList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context.getApplicationContext(),ItemActivity.class);
                intent.putExtra("title_name" , tt);
                intent.putExtra("image",img);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class MyAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;
        LinearLayout linearLayoutList;
        public MyAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
            linearLayoutList = itemView.findViewById(R.id.linearLayoutList);
        }
    }
}
