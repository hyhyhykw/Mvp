package com.hy.mvp;


import com.hy.library.base.BaseToolbarActivity;
import com.hy.utils.LifecycleUtils;

/**
 * Created time : 2019-09-28 11:02.
 *
 * @author HY
 */
public abstract class ToolbarMvpActivity<V extends MvpView ,P extends MvpPresenter<V>> extends BaseToolbarActivity implements MvpView {


    protected P presenter;


    @Override
    protected void initMvp() {
        presenter = createPresenter();
        //noinspection unchecked
        presenter.attachView((V) this);

    }

    protected abstract P createPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public boolean isActive() {
        return LifecycleUtils.canLoadImage(this);
    }
}
