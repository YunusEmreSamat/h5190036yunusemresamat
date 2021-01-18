package com.h5190036.yunus_emre_samat_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.h5190036.yunus_emre_samat_final.R;
import com.h5190036.yunus_emre_samat_final.adapter.MarkaAdapterJavaClass;
import com.h5190036.yunus_emre_samat_final.model.MarkaModelJavaClass;
import com.h5190036.yunus_emre_samat_final.network.ServiceJavaClass;
import com.h5190036.yunus_emre_samat_final.util.AlertDialogUtilJavaClass;
import com.h5190036.yunus_emre_samat_final.util.ConstantsJavaClass;
import com.h5190036.yunus_emre_samat_final.util.ObjectUtilJavaClass;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.AEADBadTagException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListScreenActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylistscreen);

        markalariGetir();

    }

    public void onBackPressed() {

        AlertDialogUtilJavaClass alertUtil = new AlertDialogUtilJavaClass();
        alertUtil.alertDialog(this , ListScreenActivity.class , getString(R.string.alertTitle2) , getString(R.string.alertMessage2) , getString(R.string.alertPositive2) , getString(R.string.alertNegative2));

    }

    void  markalariGetir()
    {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.progressMessage));
        progressDialog.show();

        new ServiceJavaClass().getServiceApi().markalariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<MarkaModelJavaClass>>() {

                    List<MarkaModelJavaClass> markalar=new ArrayList<>();

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(List<MarkaModelJavaClass> markaList) {
                        markalar=markaList;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete()
                    {
                        if(markalar.size()>0) {

                            initRecycleView(markalar);
                            progressDialog.dismiss();
                        }
                    }
                });

    }

    private  void  initRecycleView(List<MarkaModelJavaClass> markaList)
    {
        recyclerView =findViewById(R.id.rcvMarkalar);
        MarkaAdapterJavaClass markaAdaptor =new MarkaAdapterJavaClass(markaList, getApplicationContext(), new MarkaAdapterJavaClass.OnItemClickListener() {
            @Override
            public void onClik(int position) {
                MarkaModelJavaClass tiklananMarka =markaList.get(position);
                openNextActivity(tiklananMarka);
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(markaAdaptor);
    }

    private void openNextActivity(MarkaModelJavaClass tiklananMarka){

        Intent detayActivityIntent=new Intent(getApplicationContext(),MarkaDetayScreenActivity.class);
        String tiklananMarkaString= ObjectUtilJavaClass.markaToJsonString(tiklananMarka);
        detayActivityIntent.putExtra(ConstantsJavaClass.TIKLANAN_MARKA_TASINAN_BASLIGI,tiklananMarkaString);
        startActivity(detayActivityIntent);

    }

}