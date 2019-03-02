package com.ylbl.news.base;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;
import com.ylbl.news.R;
import butterknife.BindView;

public abstract class BaseSwipeRefreshAty extends BaseToolBarAty implements RecyclerArrayAdapter.OnLoadMoreListener,
        SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.easy_recycler_view)
    protected EasyRecyclerView easyRecyclerView;

    protected int page = 1;
    protected String pageSize = "10";
    protected List goodList;
    protected RecyclerArrayAdapter adapter;
    protected Handler handler = new Handler();
    @Override
    protected void initViewWithBack(boolean setBack) {
        super.initViewWithBack(setBack);
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        easyRecyclerView.setProgressView(R.layout.common_dialog_loading_layout);

        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
        adapter.setError(R.layout.view_error, new RecyclerArrayAdapter.OnErrorListener() {
            @Override
            public void onErrorShow() {
            }
            @Override
            public void onErrorClick() {
                adapter.resumeMore();
            }
        });
        easyRecyclerView.setRefreshListener(this);
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onRefresh() {

    }
}
