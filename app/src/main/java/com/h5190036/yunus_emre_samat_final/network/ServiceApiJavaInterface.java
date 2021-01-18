package com.h5190036.yunus_emre_samat_final.network;

import com.h5190036.yunus_emre_samat_final.model.MarkaModelJavaClass;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApiJavaInterface {
    //base url
    //
    @GET("MarkaBilgi.json")
    Observable<List<MarkaModelJavaClass>> markalariGetir();
}