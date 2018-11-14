package com.example.user.citiesinfo;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;


public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> implements ItemTouchHelperAdapter{
    private List<CitiesData> list;

    public RecViewAdapter(List<CitiesData > list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder recViewHolder, final int i) {
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


    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(list, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(list, i, i - 1);
            }
        }
        // уведомляем адаптер, что эл-т передвинут
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        list.remove(position);
        // Уведомляем адаптер, что эл-т удалили
        notifyItemRemoved(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView userImage;
        private TextView userText;

        public ViewHolder(final View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.userImage);
            userText = itemView.findViewById(R.id.userText);
        }
    }
}
