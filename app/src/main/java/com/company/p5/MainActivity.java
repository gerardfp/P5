package com.company.p5;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.item_list);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new ItemsAdapter());
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView name, desc;
        RatingBar rating;

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.item_name);
            desc = itemView.findViewById(R.id.item_desc);
            rating = itemView.findViewById(R.id.item_rating);
        }
    }

    class ItemsAdapter extends RecyclerView.Adapter<ItemViewHolder>{

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {

            final Item item = Dataset.itemList.get(position);

            holder.name.setText(item.name);
            holder.desc.setText(item.desc);
            holder.rating.setRating(item.rating);

            holder.rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                    item.rating = v;
                }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("ITEM_POSITION", position);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return Dataset.itemList.size();
        }
    }
}
