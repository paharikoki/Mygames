package com.example.mygames.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygames.Model.DataModel;
import com.example.mygames.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{
    private List<DataModel> modelList;

    public AdapterData(List<DataModel> modelList){
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new HolderData(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = modelList.get(position);

        holder.tvid.setText(String.valueOf(dm.getId()));
        holder.tvnama.setText(dm.getNama());
        holder.tvgenre.setText(dm.getGenre());
        holder.tvplatform.setText(dm.getPlatform());
        holder.tvpembuat.setText(dm.getPembuat());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class HolderData extends RecyclerView.ViewHolder {
        TextView tvid,tvnama,tvgenre,tvplatform,tvpembuat;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvid = itemView.findViewById(R.id.tv_id);
            tvnama = itemView.findViewById(R.id.tv_nama);
            tvgenre = itemView.findViewById(R.id.tv_genre);
            tvplatform = itemView.findViewById(R.id.tv_platform);
            tvpembuat = itemView.findViewById(R.id.tv_pembuat);

        }
    }
}
