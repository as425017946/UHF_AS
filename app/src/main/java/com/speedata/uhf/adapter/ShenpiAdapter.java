package com.speedata.uhf.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.speedata.uhf.R;
import com.speedata.uhf.bean.ShenpijiluBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShenpiAdapter extends BaseAdapter {
    Context context;
    ArrayList<ShenpijiluBean> arrayList;
    public ShenpiAdapter(Context context,ArrayList<ShenpijiluBean> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh;
        if (view==null){
          view = LayoutInflater.from(context).inflate(R.layout.shenpijilu_items,viewGroup,false);
          view.setTag(new ViewHolder(view));
        }
        vh = (ViewHolder)view.getTag();
        ShenpijiluBean shenpijiluBean = arrayList.get(i);
//        Log.e("8888", "getView: "+shenpijiluBean.getData().getPageInfo().getList().get(i).getAPPROVE_CONTENT() );
        vh.tv_name.setText(shenpijiluBean.getData().getPageInfo().getList().get(i).getAPPROVE_CONTENT());
        vh.tv_user.setText(shenpijiluBean.getData().getPageInfo().getList().get(i).getAPPROVE_NAME());
        vh.tv_time.setText(shenpijiluBean.getData().getPageInfo().getList().get(i).getCREATE_TIME());
        return view;
    }
    class ViewHolder{
        @BindView(R.id.shenpi_name)
        TextView tv_name;
        @BindView(R.id.shenpi_user)
        TextView tv_user;
        @BindView(R.id.shenpi_time)
        TextView tv_time;
        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
