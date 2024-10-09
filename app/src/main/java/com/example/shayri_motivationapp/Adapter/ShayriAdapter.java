package com.example.shayri_motivationapp.Adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayri_motivationapp.Models.ShayriModel;
import com.example.shayri_motivationapp.R;

import java.util.ArrayList;

public class ShayriAdapter extends RecyclerView.Adapter<ShayriAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<ShayriModel> shayriModelList = new ArrayList<>();

    public ShayriAdapter(Context context, ArrayList<ShayriModel> shayriModelList) {
        this.context = context;
        this.shayriModelList = shayriModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shayri, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ShayriModel shayriModel = shayriModelList.get(position);

        holder.txtShayri.setText(shayriModel.getShayri());
        holder.imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, shayriModel.getShayri());
                intent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(intent, null);
                context.startActivity(shareIntent);
            }
        });

        holder.imgArchive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Data", shayriModel.getShayri());
                assert clipboardManager != null;
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(context, "Shayri Copied", Toast.LENGTH_SHORT).show();
            }
        });

        holder.imgWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setType("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, shayriModel.getShayri());
                try {
                    context.startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return shayriModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtShayri;
        ImageView imgShare , imgArchive, imgWhatsapp;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtShayri = itemView.findViewById(R.id.txt_shayri);
            imgArchive = itemView.findViewById(R.id.img_archhive);
            imgShare = itemView.findViewById(R.id.img_share);
            imgWhatsapp = itemView.findViewById(R.id.img_whatsapp);

        }
    }


}
