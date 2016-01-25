package com.hakim.wallet.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hakim.wallet.R;
import com.hakim.wallet.mvp.presenter.SmallChangePresenter;
import com.hakim.wallet.mvp.views.SmallChangeView;
import com.hakim.wallet.ui.activity.HomeActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 *  Author   ：	Hakim Shi
 *  Email    :  hakim.shi@qq.com
 *  CreatedAt：	2016/1/21
 *
 *  Summary  :
 *
 */
public class SmallChangeFragment extends BaseFragment implements SmallChangeView{
    @Bind(R.id.progress_circle)
    ProgressBar progressBar;
    @Bind(R.id.tv_amount)
    TextView tvAmount;

    @Inject
    SmallChangePresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HomeActivity activity = (HomeActivity) getActivity();
        activity.getActivityComponent().inject(this);
        presenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_smallchange, container,false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showAmount(String amount) {
        tvAmount.setText(amount);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {

    }


}
