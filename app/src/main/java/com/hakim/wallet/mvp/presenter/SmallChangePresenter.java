package com.hakim.wallet.mvp.presenter;

import android.util.Log;

import com.hakim.wallet.R;
import com.hakim.wallet.domain.SmallChangeUserCase;
import com.hakim.wallet.injector.PerActivity;
import com.hakim.wallet.mvp.views.SmallChangeView;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/22
 *
 *  Summary  :
 *
 */

@PerActivity
public class SmallChangePresenter implements Presenter {
    private final static String KEY_AMOUNT = "amount";
    private static final String TAG = "SmallChangePresenter";
    private SmallChangeView view;
    private CompositeSubscription subscription;

    private SmallChangeUserCase userCase;

    @Inject
    public SmallChangePresenter(SmallChangeUserCase userCase ){
        this.userCase = userCase;
    }


    @Override
    public void onCreate() {

    }

    public void attachView(SmallChangeView view) {
        this.view = view;
    }

    private void getAmount() {
        showLoading();
        if (subscription == null) {
            subscription = new CompositeSubscription();
        }
        Log.d(TAG, " UserCase == null ? " + (userCase == null));

        rx.Subscription sub = userCase.execute(KEY_AMOUNT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideLoading();
                        showError(view.getContext().getString(R.string.fail_to_get_data));
                    }

                    @Override
                    public void onNext(String s) {
                        showAmount(s);
                    }
                });

        subscription.add(sub);

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {
        getAmount();
    }

    @Override
    public void onDestroy() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
        subscription = null;
    }

    private void showLoading(){
        view.showLoading();
    }

    private void hideLoading(){
        view.hideLoading();
    }

    private void showAmount(String amount){
        view.showAmount(amount);
    }

    private void showError(String message){
        view.showError(message);
    }

}
