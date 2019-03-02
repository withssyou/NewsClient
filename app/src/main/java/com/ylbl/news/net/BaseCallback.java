package com.ylbl.news.net;

import com.ylbl.news.utils.FastJsonUtils;
import com.ylbl.news.bean.ResultInfo;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

public abstract class BaseCallback extends Callback<ResultInfo> {
    @Override
    public ResultInfo parseNetworkResponse(Response response, int id) throws Exception {

        ResultInfo resultInfo = FastJsonUtils.toBean(response.body().string(), ResultInfo.class);
//        if(resultInfo !=null){
//            resultInfo.setJsonData(sb.toString());
//        }
        return resultInfo;
    }
}
