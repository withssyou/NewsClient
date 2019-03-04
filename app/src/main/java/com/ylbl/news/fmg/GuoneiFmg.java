package com.ylbl.news.fmg;

import android.content.Intent;
import android.view.View;

import com.ylbl.news.R;
import com.ylbl.news.adapter.NewsAdapter;
import com.ylbl.news.base.BaseRecyclerArrayAdapter;
import com.ylbl.news.base.BaseSwipeRefreshFmg;
import com.ylbl.news.bean.NewsInfo;
import com.ylbl.news.bean.ResultInfo;
import com.ylbl.news.net.AppDbCtrl;
import com.ylbl.news.net.Constants;
import com.ylbl.news.ui.NewsInfoAty;
import com.ylbl.news.utils.FastJsonUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 国内
 */
public class GuoneiFmg extends BaseSwipeRefreshFmg implements BaseRecyclerArrayAdapter.OnClickListener {

    @Override
    protected int getLayoutId() {
        return R.layout.fmg_top;
    }

    @Override
    protected void setMonitor() {
        super.setMonitor();
        goodList = new ArrayList();
        adapter = new NewsAdapter(context , goodList , this);
        easyRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void initViewWithBack(boolean setBack) {
        super.initViewWithBack(setBack);
        queryGoods();
    }


    private void queryGoods() {
        Map<String ,String > params = new HashMap<>();
        params.put("type" , "guonei");
        params.put("key" , Constants.KEY);
        newAsyncTaskExecute(Constants.HTTP_ACTION_1 , params);
    }

    @Override
    public void onRefresh() {
        page = 1;
        queryGoods();
    }

    @Override
    public void onLoadMore() {
        page++;
        queryGoods();
    }

    @Override
    protected void doInBackgroundTask(int asyncid, Map params, Callback callback) {
        AppDbCtrl.getServer(Constants.HTTP_ACTION_1 , params ,callback ,context);
    }

    @Override
    protected void onPostExecuteTask(int asyncid, ResultInfo resultInfo) {
        List<NewsInfo> goodInfoList = FastJsonUtils.toList(resultInfo.getResult().getData().toString() , NewsInfo.class);
        if (goodInfoList == null || goodInfoList.size() <= 0) {
            goodInfoList = new ArrayList<>();
            if (page == 1) {
                adapter.clear();
                adapter.addAll(goodInfoList);
            } else {
                page--;
                adapter.stopMore();
            }
        } else {
            if (page == 1) {
                adapter.clear();
                adapter.addAll(goodInfoList);
            } else {
                adapter.addAll(goodInfoList);
            }
        }
        adapter.stopMore();
    }

    @Override
    public void onRecyclerArrayClick(View view, Object data, int position) {
        NewsInfo news = (NewsInfo) data;
        Intent intent = new Intent(context ,NewsInfoAty.class);
        intent.putExtra("link" , news.getUrl());
        startActivity(intent);
    }
}
