package com.speedata.uhf.mine;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.speedata.uhf.Api;
import com.speedata.uhf.R;
import com.speedata.uhf.adapter.MessagesAdapter;
import com.speedata.uhf.bean.MessagesBean;
import com.speedata.uhf.tools.RecyclerViewSpacesItemDecoration;
import com.speedata.uhf.tools.SharedPFUtils;
import com.speedata.uhf.tools.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 消息页面
 */
public class MessageActivity extends BaseActivity {
    ArrayList<MessagesBean> arrayList = new ArrayList<>();
    MessagesAdapter messagesAdapter ;
    int page = 1,pagesize=4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        setinfo();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        //设置边距
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.TOP_DECORATION,0);//top间距

        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.BOTTOM_DECORATION,60);//底部间距

        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.LEFT_DECORATION,0);//左间距

        stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.RIGHT_DECORATION,0);//右间距

        xRecyclerView.addItemDecoration(new RecyclerViewSpacesItemDecoration(stringIntegerHashMap));
        //允许上拉加载
        xRecyclerView.setLoadingMoreEnabled(true);
        //允许下拉刷新
        xRecyclerView.setPullRefreshEnabled(true);
        /**
         *    可以设置加载更多的样式，很多种
         */
        //这个是下拉加载展示
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.SysProgress);
        //这个是上拉加载更多展示
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallGridBeat);
        //下载加载的时候展示
        xRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);
        // 如果设置上这个，下拉刷新的时候会显示上次刷新的时间
        xRecyclerView
                .getDefaultRefreshHeaderView()
                .setRefreshTimeVisible(true);
//        //自定义文字
//        xRecyclerView.getDefaultFootView().setLoadingHint("加载中");
//        xRecyclerView.getDefaultFootView().setNoMoreHint("加载完毕");
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //当下拉刷新的时候，重新获取数据，所有curr要变回0，并且把集合list清空
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page=1;
                        pagesize = 4;
                        arrayList.clear();
                        getinfo(page,pagesize);
                        messagesAdapter.notifyDataSetChanged();
                        xRecyclerView.refreshComplete();
                    }
                },1000);
            }

            @Override
            public void onLoadMore() {
                //当上拉加载的时候，因为一次获取是30个数据，所也在获取的时候就要在加10的地方开始获取
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pagesize = pagesize+4;
                        getinfo(page,pagesize);
                        messagesAdapter.notifyDataSetChanged();
                        xRecyclerView.loadMoreComplete();
                    }
                },2000);
            }
        });
    }

    @BindView(R.id.commoe_left)
    ImageView img_left;
    @BindView(R.id.messages_xrv)
    XRecyclerView xRecyclerView;
    private void setinfo() {
        img_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessageActivity.this.finish();
            }
        });
        getinfo(1,4);
    }
    private void getinfo(int page1,int pagesize1) {
        OkGo.post(Api.messages)
                .tag(this)
                .params("page",page1)
                .params("pageSize",pagesize1)
                .params("groupCode", SharedPFUtils.getParam(this,"groupno","").toString())
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.shortToast(e+"");
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = new Gson();
                        arrayList.clear();
                        MessagesBean messagesBean = gson.fromJson(s,MessagesBean.class);
                        if(messagesBean.getState()==1){
                            Log.e("***", "onSuccess: 长度"+messagesBean.getData().getPageInfo().getTotal() );
                            if (messagesBean.getData().getPageInfo().getList().size()>0){

                                for (int i = 0; i <messagesBean.getData().getPageInfo().getList().size() ; i++) {
                                    arrayList.add(messagesBean);
                                }
                                if (messagesAdapter==null){
                                    messagesAdapter = new MessagesAdapter(MessageActivity.this,arrayList);
                                    xRecyclerView.setAdapter(messagesAdapter);
                                }else {
                                    messagesAdapter.notifyDataSetChanged();
                                }

                            }
                        }else {
                            ToastUtils.shortToast(messagesBean.getMessage());
                        }
                    }
                });
    }

}
