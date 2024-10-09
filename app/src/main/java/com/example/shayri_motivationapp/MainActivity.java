package com.example.shayri_motivationapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayri_motivationapp.Adapter.CategoryAdapter;
import com.example.shayri_motivationapp.Models.CategoryModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private CategoryAdapter categoryAdapter;
    private ArrayList<CategoryModel> categoryModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        rvCategory = findViewById(R.id.rv_category);

        categoryAdapter = new CategoryAdapter(MainActivity.this, categoryModelList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);

        categoryModelList.add(new CategoryModel("Attitude Status", R.drawable.sem));
        categoryModelList.add(new CategoryModel("Focus", R.drawable.sem));
        categoryModelList.add(new CategoryModel("Hard Work", R.drawable.sem));
        categoryModelList.add(new CategoryModel("Stay Clam", R.drawable.sem));

        rvCategory.setLayoutManager(layoutManager);
        rvCategory.setAdapter(categoryAdapter);


    }
}