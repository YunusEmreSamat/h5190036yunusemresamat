package com.h5190036.yunus_emre_samat_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190036.yunus_emre_samat_final.R;
import com.h5190036.yunus_emre_samat_final.model.MarkaModelJavaClass;
import com.h5190036.yunus_emre_samat_final.util.ConstantsJavaClass;
import com.h5190036.yunus_emre_samat_final.util.GlideUtilJavaClass;
import com.h5190036.yunus_emre_samat_final.util.ObjectUtilJavaClass;

public class MarkaDetayScreenActivity extends AppCompatActivity {

    ImageView imgLogo;
    TextView txtBaslik;
    TextView txtKurulusTarihBilgi;
    TextView txtDegerBilgi;
    TextView txtDetay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymarkadetayscreen);

        markaDetayGetir();
    }

    private void markaDetayGetir()
    {
        String tasinanMarkaString =getIntent().getStringExtra(ConstantsJavaClass.TIKLANAN_MARKA_TASINAN_BASLIGI);
        MarkaModelJavaClass markaModel = ObjectUtilJavaClass.jsonStringToMarka(tasinanMarkaString);

        imgLogo = findViewById(R.id.imgLogo);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtKurulusTarihBilgi = findViewById(R.id.txtKurulusTarihBilgi);
        txtDegerBilgi = findViewById(R.id.txtDegerBilgi);
        txtDetay =findViewById(R.id.txtDetay);


        GlideUtilJavaClass.resmiIndiripGoster(getApplicationContext(),markaModel.getBuyukResimUrl(),imgLogo);
        txtBaslik.setText(markaModel.getMarkaAdi());
        txtKurulusTarihBilgi.setText(getString(R.string.textKurulusTar) + markaModel.getKurulusTarihi());
        txtDegerBilgi.setText(getString(R.string.textDeger) + markaModel.getDegeri());
        txtDetay.setText(markaModel.getHakkinda());

    }
}
