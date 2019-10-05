package com.shifthackz.testamconsoft.utils

import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class RxUtils {
    companion object {
        fun <T> singleTransformer(): SingleTransformer<T, T> = SingleTransformer {
            it.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(Constants.DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .retry(Constants.DEFAULT_RETRY_ATTEMPTS)
        }
    }
}
