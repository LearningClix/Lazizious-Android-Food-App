package com.learningclix.lazizious;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.learningclix.lazizious.Adapters.MainAdapter;
import com.learningclix.lazizious.Models.MainModel;
import com.learningclix.lazizious.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.pop_2, "Burger", "350", "Delicious double petty burger"));
        list.add(new MainModel(R.drawable.pop_3, "Pizza", "1350", "Delicious Pizza with extra Cheese"));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "1200", "Delicious Pizza with Cheese"));
        list.add(new MainModel(R.drawable.pop_1, "Pizza", "1000", "Delicious normal Pizza"));
        list.add(new MainModel(R.drawable.pop_2, "Burger", "350", "Delicious double petty burger"));
        list.add(new MainModel(R.drawable.pop_3, "Pizza", "1350", "Delicious Pizza with extra Cheese"));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "1200", "Delicious Pizza with Cheese"));
        list.add(new MainModel(R.drawable.pop_1, "Pizza", "1000", "Delicious normal Pizza"));
        list.add(new MainModel(R.drawable.pop_2, "Burger", "350", "Delicious double petty burger"));
        list.add(new MainModel(R.drawable.pop_3, "Pizza", "1350", "Delicious Pizza with extra Cheese"));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "1200", "Delicious Pizza with Cheese"));
        list.add(new MainModel(R.drawable.pop_1, "Pizza", "1000", "Delicious normal Pizza"));

        MainAdapter mainAdapter = new MainAdapter(list, this);
        activityMainBinding.recyclerViewProducts.setAdapter(mainAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        activityMainBinding.recyclerViewProducts.setLayoutManager(linearLayoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, ProductCart.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}