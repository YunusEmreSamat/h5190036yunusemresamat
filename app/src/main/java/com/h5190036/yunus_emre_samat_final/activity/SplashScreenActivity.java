package com.h5190036.yunus_emre_samat_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.h5190036.yunus_emre_samat_final.R;
import com.h5190036.yunus_emre_samat_final.util.AlertDialogUtilJavaClass;
import com.h5190036.yunus_emre_samat_final.util.NetworkUtilJavaClass;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysplashscreen);

        timer();
    }

    private void timer()
    {
        CountDownTimer countDownTimer = new CountDownTimer(3000 , 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                internetControlAndNextPage();
            }
        };

        countDownTimer.start();
    }


    private void internetControlAndNextPage() {
        if(NetworkUtilJavaClass.networkKontrol(getApplicationContext()))
        {
            Intent listActivityIntent = new Intent(getApplicationContext() , ListScreenActivity.class);
            startActivity(listActivityIntent);
            finish();
        }
        else
        {
            noInternetErrorDialog();
        }
    }


    private void noInternetErrorDialog()
    {

        AlertDialogUtilJavaClass alertUtil = new AlertDialogUtilJavaClass();
        alertUtil.alertDialog(this , SplashScreenActivity.class , getString(R.string.alertTitle) , getString(R.string.alertMessage) , getString(R.string.alertPositive) , getString(R.string.alertNegative));

    }

}