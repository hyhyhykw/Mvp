package com.hy.mvp;

import androidx.annotation.NonNull;

/**
 * Created time : 2019-09-29 11:24.
 * presenter请求的回调 3个参数
 *
 * @author HY
 * @param <T> 参数1
 * @param <P> 参数2
 * @param <R> 参数3
 */
public interface ModelCallback2<T, P, R> {
    void onResult(@NonNull T t, @NonNull P p, @NonNull R r);
}
