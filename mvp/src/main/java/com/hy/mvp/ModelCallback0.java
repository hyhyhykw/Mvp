package com.hy.mvp;

import androidx.annotation.NonNull;

/**
 * Created time : 2019-09-29 11:24.
 * presenter请求的回调 单个参数
 *
 * @author HY
 * @param <T> 参数
 */
public interface ModelCallback0<T> {
    void onResult(@NonNull T t);
}
