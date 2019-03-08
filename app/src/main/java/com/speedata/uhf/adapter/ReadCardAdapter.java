package com.speedata.uhf.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.speedata.uhf.Api;
import com.speedata.uhf.R;
import com.speedata.uhf.bean.EpcDataBases;
import com.speedata.uhf.bean.SelectRfidBean;
import com.speedata.uhf.dialog.SearchTagDialog;
import com.speedata.uhf.mine.SearchActivity;
import com.speedata.uhf.mine.SearchTreesActivity;
import com.speedata.uhf.mine.UpImgActivity;
import com.speedata.uhf.tools.SharedPFUtils;
import com.speedata.uhf.tools.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class ReadCardAdapter extends BaseAdapter {
    Context context;
    private List<SearchTagDialog.EpcDataBase> firm = new ArrayList<SearchTagDialog.EpcDataBase>();
    public ReadCardAdapter(Context context,List<SearchTagDialog.EpcDataBase> firm){
        this.context = context;
        this.firm = firm;
    }
    @Override
    public int getCount() {
        return firm.size();
    }

    @Override
    public Object getItem(int i) {
        return firm.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view ==null){
            view = LayoutInflater.from(context).inflate(R.layout.readcard_items,viewGroup,false);
            view.setTag(new ViewHolder(view));
        }
        SearchTagDialog.EpcDataBase epcDataBases = firm.get(i);
        viewHolder = (ViewHolder) view.getTag();
        viewHolder.tv_info.setText(epcDataBases.toString());
        viewHolder.tv_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkGo.post(Api.selectrfid)
                        .params("rfid", viewHolder.tv_info.getText().toString())
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Response response, Exception e) {
                                super.onError(call, response, e);
                                ToastUtils.shortToast(e+"");
                            }

                            @Override
                            public void onSuccess(String s, Call call, Response response) {
//                                Log.e("===", "onSuccess: "+s );
                                Gson gson = new Gson();
                                SelectRfidBean selectRfidBean = gson.fromJson(s,SelectRfidBean.class);
                                if (selectRfidBean.getState()==1){
                                    if (selectRfidBean.getData()!=null){
                                        if (SharedPFUtils.getParam(context,"searchid","").toString().equals("1")){
                                            Intent intent = new Intent(context, SearchTreesActivity.class);
                                            SharedPFUtils.setParam(context,"rfids",selectRfidBean.getData().getBLOCK_CODE());
                                            context.startActivity(intent);
                                        }else {
                                            Intent intent = new Intent(context, UpImgActivity.class);
                                            SharedPFUtils.setParam(context,"rfids",selectRfidBean.getData().getBLOCK_CODE());
                                            context.startActivity(intent);
                                        }
                                    }else {
                                        ToastUtils.shortToast("尚未绑定该RFID号码");
                                    }
                                }else {
                                    ToastUtils.shortToast(selectRfidBean.getMessage());
                                }
                            }
                        });

            }
        });
        return view;
    }
    class ViewHolder{
        TextView tv_info;
        public ViewHolder(View view){
            tv_info = (TextView) view.findViewById(R.id.readcard_textview);
        }
    }
}
