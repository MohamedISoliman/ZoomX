package com.zoomx.zoomx.networklogger;

import android.support.annotation.NonNull;
import com.zoomx.zoomx.config.ZoomX;
import com.zoomx.zoomx.model.RequestEntity;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

import java.util.Objects;

/**
 * Created by Ahmed Fathallah on 1/11/2018.
 */

public class NetworkLogManager {

    public static void log(@NonNull RequestEntity requestEntity) {
        Objects.requireNonNull(requestEntity);
        insertRequest(requestEntity).subscribe();
    }

    private static Completable insertRequest(RequestEntity requestEntity) {
        return Completable
                .fromAction(() -> ZoomX.getRequestDao().insertRequest(requestEntity))
                .doOnError(Timber::e)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
