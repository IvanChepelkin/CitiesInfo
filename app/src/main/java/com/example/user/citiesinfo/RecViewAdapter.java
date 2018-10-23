package com.example.user.citiesinfo;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.RecViewHolder> {
    private List<CitiesData> list;

    public RecViewAdapter(List<CitiesData > list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_layout, viewGroup, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder recViewHolder, final int i) {
        CitiesData  citiesData = list.get(i);
        recViewHolder.userImage.setImageResource(citiesData.getImg());
        recViewHolder.userText.setText(citiesData.getTxt());
        recViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),SecondActivity.class);
                intent.putExtra("KEY", i);
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecViewHolder extends RecyclerView.ViewHolder {
        private ImageView userImage;
        private TextView userText;

        public RecViewHolder(final View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.userImage);
            userText = itemView.findViewById(R.id.userText);
        }
    }
}
