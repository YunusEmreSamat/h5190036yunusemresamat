package com.h5190036.yunus_emre_samat_final.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190036.yunus_emre_samat_final.R;
import com.h5190036.yunus_emre_samat_final.model.MarkaModelJavaClass;
import com.h5190036.yunus_emre_samat_final.util.GlideUtilJavaClass;

import java.util.List;

public class MarkaAdapterJavaClass extends RecyclerView.Adapter<MarkaViewHolderJavaClass> {

    List<MarkaModelJavaClass> markalar;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClik(int position);
    }

    public MarkaAdapterJavaClass(List<MarkaModelJavaClass> markalar, Context context, OnItemClickListener listener) {
        this.markalar = markalar;
        this.context = context;
        this.listener =listener;
    }

    @NonNull
    @Override
    public MarkaViewHolderJavaClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewmarka,parent,false);
        return new MarkaViewHolderJavaClass(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MarkaViewHolderJavaClass viewHolder, int position) {
        viewHolder.txtKurulusTarihi.setText(markalar.get(position).getKurulusTarihi());
        viewHolder.txtMarkaAdi.setText(markalar.get(position).getMarkaAdi());
        viewHolder.txtDegeri.setText(markalar.get(position).getDegeri());
        GlideUtilJavaClass.resmiIndiripGoster(context,markalar.get(position).getKucukLogoUrl(),viewHolder.imgMarkaLogo);
    }

    @Override
    public int getItemCount() {
        return markalar.size();
    }
}