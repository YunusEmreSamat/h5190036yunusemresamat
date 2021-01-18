package com.h5190036.yunus_emre_samat_final.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190036.yunus_emre_samat_final.R;

public class MarkaViewHolderJavaClass extends RecyclerView.ViewHolder {

    ImageView imgMarkaLogo;
    TextView txtMarkaAdi;
    TextView txtKurulusTarihi;
    TextView txtDegeri;

    public MarkaViewHolderJavaClass(@NonNull View cardView, MarkaAdapterJavaClass.OnItemClickListener listener) {
        super(cardView);

        imgMarkaLogo=cardView.findViewById(R.id.imgMarkaLogo);
        txtMarkaAdi =cardView.findViewById(R.id.txtMarkaAdi);
        txtKurulusTarihi =cardView.findViewById(R.id.txtKurulusTarihi);
        txtDegeri =cardView.findViewById(R.id.txtDegeri);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onClik(getAdapterPosition());
            }
        });

    }
}