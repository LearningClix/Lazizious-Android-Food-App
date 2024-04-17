package com.learningclix.lazizious;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.learningclix.lazizious.databinding.ActivityMainBinding;
import com.learningclix.lazizious.databinding.ActivityOrderDetailsBinding;

public class OrderDetailsActivity extends AppCompatActivity {

    ActivityOrderDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final int image = getIntent().getIntExtra("image",0);
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));
        final String name = getIntent().getStringExtra("name");
        final String desc = getIntent().getStringExtra("desc");

        binding.orderDetailImage.setImageResource(image);
        binding.detailPrice.setText(String.format("%d", price));
        binding.orderDetailFoodName.setText(name);
        binding.foodDesc.setText(desc);

        final DBHelper helper = new DBHelper(this);
        binding.addOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = helper.addOrder(
                        binding.editTextTextPersonName.getText().toString(),
                        binding.editTextPhone.getText().toString(),
                        name,
                        Integer.parseInt(binding.quantity.getText().toString()),
                        price,
                        image,
                        desc
                );

                if (isInserted){
                    Toast.makeText(OrderDetailsActivity.this, "Order Added Successfully..", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(OrderDetailsActivity.this, "Error in Adding food order..", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}