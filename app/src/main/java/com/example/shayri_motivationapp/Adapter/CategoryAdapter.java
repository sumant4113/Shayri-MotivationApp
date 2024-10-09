package com.example.shayri_motivationapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayri_motivationapp.Models.CategoryModel;
import com.example.shayri_motivationapp.R;
import com.example.shayri_motivationapp.ShayriActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<CategoryModel> categoryModelsList;

    public CategoryAdapter(Context context, ArrayList<CategoryModel> categoryModelsList) {
        this.context = context;
        this.categoryModelsList = categoryModelsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final CategoryModel categoryModel = categoryModelsList.get(position);

        holder.txt_name.setText(categoryModel.getName());
        holder.img_View.setImageResource(categoryModel.getImage());

        holder.img_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShayriActivity.class);
                intent.putExtra("name", categoryModel.getName());
//                intent.putExtra("image", categoryModel.getImage());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryModelsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img_View;
        TextView txt_name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_View = itemView.findViewById(R.id.img_profile);
            txt_name = itemView.findViewById(R.id.txt_title);
        }
    }
}
