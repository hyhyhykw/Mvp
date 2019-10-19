package com.hy.mvp;

import java.lang.ref.WeakReference;

import androidx.annotation.NonNull;

/**
 * Created time : 2019-09-28 10:32.
 *
 * @author HY
 */
public class MvpPresenter<T extends MvpView> {

    private WeakReference<T> mReference;

    protected void attachView(T mvpView) {
        mReference = new WeakReference<>(mvpView);
    }


    protected final boolean isViewAttach() {
        if (mReference == null) return false;
        T t = mReference.get();
        if (t == null) return false;
        return t.isActive();
    }

    @NonNull
    protected final T getView() {
        try {
            return mReference.get();
        } catch (Exception ignore) {
            throw new RuntimeException("no view attached");
        }
    }

    protected void detachView() {
        mReference.clear();
        mReference = null;
    }
}
