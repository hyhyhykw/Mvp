package com.hy.mvp;

import com.hy.library.base.BaseFragment;
import com.hy.utils.LifecycleUtils;

import androidx.annotation.NonNull;

/**
 * Created time : 2019-09-28 10:46.
 *
 * @author HY
 */
public abstract class MvpFragment<V extends MvpView, P extends MvpPresenter<V>> extends BaseFragment implements MvpView {

    protected P presenter;

    @Override
    public void initMvp() {
        presenter = createPresenter();
        //noinspection unchecked
        presenter.attachView((V) this);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @NonNull
    protected abstract P createPresenter();

    @Override
    public boolean isActive() {
        return LifecycleUtils.canLoadImage(this);
    }
}
