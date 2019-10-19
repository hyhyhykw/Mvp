package com.hy.mvp;

import com.hy.library.base.BaseActivity;
import com.hy.utils.LifecycleUtils;

/**
 * Created time : 2019-09-28 10:41.
 *
 * @author HY
 */
public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>> extends BaseActivity implements MvpView {


    protected P presenter;


    @Override
    protected void initMvp() {
        presenter = createPresenter();
        //noinspection unchecked
        presenter.attachView((V) this);

    }

    protected abstract P createPresenter();

    @Override
    public boolean isActive() {
        return LifecycleUtils.canLoadImage(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
