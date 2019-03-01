package com.speedata.uhf.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.speedata.uhf.R;
import com.speedata.uhf.bean.MessagesBean;

import java.util.ArrayList;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {
    Context context;
    ArrayList<MessagesBean> arrayList;
    public MessagesAdapter(Context context,ArrayList<MessagesBean> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }
   /**
    * 箱单与getview方法中的创建view和viewholder
    */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.messages_items,null);
        return new ViewHolder(view);
    }

    /**
     * 相当于getview绑定数据部分
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MessagesBean messagesBean = arrayList.get(position);
        holder.tv_type.setText(messagesBean.getData().getPageInfo().getList().get(position).getCONSERVATION_NAME());
        holder.tv_startime.setText(messagesBean.getData().getPageInfo().getList().get(position).getSTART_TIME());
        holder.tv_endtime.setText(messagesBean.getData().getPageInfo().getList().get(position).getEND_TIME());
        holder.tv_beizhu.setText(messagesBean.getData().getPageInfo().getList().get(position).getNOTES());
        holder.tv_zhixingzu.setText(messagesBean.getData().getPageInfo().getList().get(position).getGROUP_NAME());
        holder.tv_zhixingduixiang.setText(messagesBean.getData().getPageInfo().getList().get(position).getTENDERS());

    }

    /**
     * 得到总条数
     * @return
     */
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends  RecyclerView.ViewHolder{
        TextView tv_type;
        TextView tv_startime;
        TextView tv_endtime;
        TextView tv_beizhu;
        TextView tv_zhixingzu;
        TextView tv_zhixingduixiang;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_type = (TextView) itemView.findViewById(R.id.messages_type);
            tv_startime = (TextView) itemView.findViewById(R.id.messages_startime);
            tv_endtime = (TextView) itemView.findViewById(R.id.messages_endtime);
            tv_beizhu = (TextView) itemView.findViewById(R.id.messages_beizhu);
            tv_zhixingzu = (TextView) itemView.findViewById(R.id.messages_zhixingzu);
            tv_zhixingduixiang = (TextView) itemView.findViewById(R.id.messages_zhixingduixing);
        }
    }
}
