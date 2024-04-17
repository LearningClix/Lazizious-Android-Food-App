package com.learningclix.lazizious.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learningclix.lazizious.Models.MainModel;
import com.learningclix.lazizious.OrderDetailsActivity;
import com.learningclix.lazizious.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder>{

    ArrayList<MainModel> modelList;
    Context context;

    public MainAdapter(ArrayList<MainModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_main, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.viewHolder holder, int position) {
        final MainModel mainModel = modelList.get(position);
        holder.foodImage.setImageResource(mainModel.getImage());
        holder.foodName.setText(mainModel.getFoodName());
        holder.foodPrice.setText(mainModel.getFoodPrice());
        holder.foodDescription.setText(mainModel.getFoodDescription());

        Intent intent = new Intent(context, OrderDetailsActivity.class);

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                intent.putExtra("image", mainModel.getImage());
                intent.putExtra("price", mainModel.getFoodPrice());
                intent.putExtra("name", mainModel.getFoodName());
                intent.putExtra("desc", mainModel.getFoodDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView foodName, foodPrice, foodDescription;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.foodImage);
            foodName = itemView.findViewById(R.id.foodName);
            foodPrice = itemView.findViewById(R.id.foodPrice);
            foodDescription = itemView.findViewById(R.id.foodDescription);


        }
    }
}
