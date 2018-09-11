package com.zoomx.zoomx.networklogger;

import android.util.Log;

import com.zoomx.zoomx.config.ZoomX;
import com.zoomx.zoomx.model.RequestEntity;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Ahmed Fathallah on 1/11/2018.
 */

public class NetworkLogManager {

    public static void log(RequestEntity.Builder builder) {
        if (builder != null)
            insertRequest(builder).subscribe(() -> { }, Timber::e);
    }

    private static Completable insertRequest(RequestEntity.Builder builder) {
        return Completable
                .fromAction(() -> ZoomX.getRequestDao().insertRequest(builder.create()))
                .doOnError(Timber::e)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
