package com.h5190036.yunus_emre_samat_final.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

import androidx.appcompat.app.AlertDialog;

import com.h5190036.yunus_emre_samat_final.R;
import com.h5190036.yunus_emre_samat_final.activity.SplashScreenActivity;
import com.h5190036.yunus_emre_samat_final.model.MarkaModelJavaClass;

import java.util.List;

import io.reactivex.Observer;

public class AlertDialogUtilJavaClass {

    public void alertDialog(Context context , Class screen , String title , String message , String positive , String negative){

        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface mesaj, int i) {

                if(screen == SplashScreenActivity.class){

                    context.startActivity(new Intent(Settings.ACTION_SETTINGS));
                    ((Activity)context).finish();

                }
                else {

                    ((Activity)context).finish();

                }

            }
        });

        builder.setNegativeButton(negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface mesaj, int i) {

                if(screen == SplashScreenActivity.class){

                    mesaj.dismiss();
                    ((Activity)context).finish();
                }
                else {
                    mesaj.dismiss();
                }

            }
        });

        builder.show();
    }

}