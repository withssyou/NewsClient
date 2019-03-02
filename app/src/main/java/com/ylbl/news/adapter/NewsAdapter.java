package com.ylbl.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.ylbl.news.R;
import com.ylbl.news.base.BaseRecyclerArrayAdapter;
import com.ylbl.news.bean.NewsInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends BaseRecyclerArrayAdapter<NewsInfo> {
    private Context context;
    private List<NewsInfo> datas;
    private OnClickListener onClickListener;

    public NewsAdapter(Context context, List<NewsInfo> objects, OnClickListener onClickListener) {
        super(context, objects, onClickListener);
        this.context = context;
        this.datas = objects;
        this.onClickListener = onClickListener;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news , parent ,false);
        return new ViewHolder(view);
    }
    class ViewHolder extends BaseViewHolder<NewsInfo>{
        @BindView(R.id.item_news_icon)
        ImageView icon;
        @BindView(R.id.item_news_title)
        TextView title;
        @BindView(R.id.item_news_time)
        TextView time;
        @BindView(R.id.item_news_author)
        TextView author;
        @BindView(R.id.item_news_info)
        LinearLayout info;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this ,itemView);

        }

        @Override
        public void setData(NewsInfo data) {
            super.setData(data);
            Picasso.with(context).load(data.getThumbnail_pic_s()).into(icon);
            time.setText(data.getDate());
            title.setText(data.getTitle());
            author.setText(data.getAuthor_name());
            getOnClickListener(getAdapterPosition()).onClick(info);
        }
    }
}
