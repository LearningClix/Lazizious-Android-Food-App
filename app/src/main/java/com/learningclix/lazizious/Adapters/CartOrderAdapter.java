package com.learningclix.lazizious.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learningclix.lazizious.Models.CartOrderModel;
import com.learningclix.lazizious.Models.MainModel;
import com.learningclix.lazizious.R;

import java.util.ArrayList;

public class CartOrderAdapter extends RecyclerView.Adapter<CartOrderAdapter.viewHolder>{
    ArrayList<CartOrderModel> orderList;
    Context context;

    public CartOrderAdapter(ArrayList<CartOrderModel> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_cart, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartOrderAdapter.viewHolder holder, int position) {
        final CartOrderModel model = orderList.get(position);
        holder.orderImage.setImageResource((int) model.getOrderImage());
        holder.soldProductName.setText(model.getSoldProductName());
        holder.soldProductPrice.setText(model.getSoldProductPrice());
        holder.soldProductNumber.setText(model.getSoldProductNumber() + "");
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView orderImage;
        TextView soldProductName, soldProductPrice, soldProductNumber;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderImage = itemView.findViewById(R.id.cartImage);
            soldProductName = itemView.findViewById(R.id.cartProductName);
            soldProductPrice = itemView.findViewById(R.id.cartOrderPrice);
            soldProductNumber = itemView.findViewById(R.id.cartOrderNumber);
        }
    }
}
