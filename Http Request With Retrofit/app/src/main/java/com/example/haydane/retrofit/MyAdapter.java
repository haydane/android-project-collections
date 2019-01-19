package com.example.haydane.retrofit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdapterViewHolder> {

    String[] image;
    String[] title;
    String[] content;

    public MyAdapter(String[] image, String[] title, String[] content)
    {
        this.image=image;
        this.title=title;
        this.content=content;
    }


    @NonNull
    @Override
    public MyAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.activity_list_item,viewGroup,false);
        return new MyAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterViewHolder myAdapterViewHolder, int i) {
        final String img = image[i];
        final String tt = title[i];
        final String cont = content[i];
        Uri uri = Uri.parse(img);
        Context context = myAdapterViewHolder.image.getContext();
        Picasso.with(context).load(uri).into(myAdapterViewHolder.image);
        myAdapterViewHolder.title.setText(tt);
        myAdapterViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context con = v.getContext();
                Intent intent = new Intent(con.getApplicationContext(),ItemDetailActivity.class);
                intent.putExtra("title",tt);
                intent.putExtra("image",img);
                intent.putExtra("content",cont);
                con.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class MyAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        LinearLayout linearLayout;
        public MyAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
