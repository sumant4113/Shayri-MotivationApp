package com.example.shayri_motivationapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayri_motivationapp.Adapter.ShayriAdapter;
import com.example.shayri_motivationapp.Models.ShayriModel;

import java.util.ArrayList;
import java.util.Objects;

public class ShayriActivity extends AppCompatActivity {

    private RecyclerView rvShayri;
    private ShayriAdapter shayriAdapter;
    private ArrayList<ShayriModel> shayriModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayri);
        initView();
    }

    private void initView() {
        String name = getIntent().getStringExtra("name");

        rvShayri = findViewById(R.id.rv_shayri);
        shayriAdapter = new ShayriAdapter(ShayriActivity.this, shayriModelList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ShayriActivity.this);
        rvShayri.setLayoutManager(layoutManager);
        rvShayri.setAdapter(shayriAdapter);

        if (name.equals("Attitude Status")) {
//            Objects.requireNonNull(getSupportActionBar()).setTitle(name);
            shayriModelList.add(new ShayriModel("Education is the most powerful weapon which you can use to change the world."));
            shayriModelList.add(new ShayriModel("The beautiful thing about learning is that no one can take it away from you."));
            shayriModelList.add(new ShayriModel("Education is not the filling of a pail, but the lighting of a fire."));
            shayriModelList.add(new ShayriModel("Education is the key that unlocks the golden door to freedom. —George Washington Carver"));
        } else if (name.equals("Focus")) {
            shayriModelList.add(new ShayriModel("DON'T Distrected "));
            shayriModelList.add(new ShayriModel("DON'T Distrected "));
            shayriModelList.add(new ShayriModel("DON'T Distrected "));
        } else if (name.equals("Hard Work")) {
            shayriModelList.add(new ShayriModel("Stay Hard "));
            shayriModelList.add(new ShayriModel("not YOU then WHOOOO?"));
        } else if (name.equals("Stay Clam")) {
            shayriModelList.add(new ShayriModel("Stay Hard "));
            shayriModelList.add(new ShayriModel("not YOU then WHOOOO?"));
        }


    }
}