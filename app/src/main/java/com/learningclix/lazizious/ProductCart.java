package com.learningclix.lazizious;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.learningclix.lazizious.Adapters.CartOrderAdapter;
import com.learningclix.lazizious.Adapters.MainAdapter;
import com.learningclix.lazizious.Models.CartOrderModel;
import com.learningclix.lazizious.databinding.ActivityProductCartBinding;

import java.util.ArrayList;

public class ProductCart extends AppCompatActivity {

    ActivityProductCartBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);
        ArrayList<CartOrderModel> list = helper.getOrderDetails();

        CartOrderAdapter adapter = new CartOrderAdapter(list, this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(linearLayoutManager);

    }
}