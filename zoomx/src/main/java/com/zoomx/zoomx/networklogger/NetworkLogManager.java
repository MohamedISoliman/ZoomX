package com.zoomx.zoomx.networklogger;

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

    public static void log(RequestEntity requestEntity) {
        if (requestEntity != null)
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
