package com.speedata.uhf.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.speedata.uhf.Api;
import com.speedata.uhf.R;
import com.speedata.uhf.bean.SearchTreeZhiwuinfoBean;
import com.speedata.uhf.bean.SearchTreesStateBean;
import com.speedata.uhf.tools.SharedPFUtils;
import com.speedata.uhf.tools.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 植树信息
 */
public class SearchTreesActivity extends BaseActivity implements View.OnClickListener {
    String danhao="";
    @BindView(R.id.tree_1_1_layout)
    RelativeLayout relativeLayout1;
    @BindView(R.id.tree_2_1_layout)
    RelativeLayout relativeLayout2;
    @BindView(R.id.tree_3_1_layout)
    RelativeLayout relativeLayout3;
    @BindView(R.id.tree_4_1_layout)
    RelativeLayout relativeLayout4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_trees);
        ButterKnife.bind(this);
        danhao = SharedPFUtils.getParam(this,"danhao","").toString();
        selectstate(danhao);
        relativeLayout1.setOnClickListener(this);
        relativeLayout2.setOnClickListener(this);
        relativeLayout3.setOnClickListener(this);
        relativeLayout4.setOnClickListener(this);
        setinfo();
        //        Log.e("+++", "onCreate: "+danhao );
    }

    @BindView(R.id.commoe_left)
    ImageView img_left;
    private void setinfo() {
        img_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchTreesActivity.this.finish();
            }
        });
    }

    /**
     * 查询种植人头像和植物生长状态
     */
    private void selectstate(String zhi) {
        OkGo.post(Api.state_peoson)
                .tag(this)
                .params("blockCode",zhi)
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.shortToast(e+"");
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = new Gson();
                        SearchTreesStateBean stateBean = gson.fromJson(s,SearchTreesStateBean.class);
                        if (stateBean.getState()==1){
                            //请求植物信息接口
                            getzhiwuinfo(danhao,stateBean.getData().getGROWTH_STATE(),"");
                        }else {
                            ToastUtils.shortToast(stateBean.getMessage());
                        }
                    }
                });
    }

    /**
     * 获取植物信息
     */
    @BindView(R.id.trees_type)
    TextView tv_type;
    @BindView(R.id.trees_guanfu)
    TextView tv_guanfu;
    @BindView(R.id.trees_address)
    TextView tv_address;
    @BindView(R.id.trees_weizhi)
    TextView tv_weizhi;
    @BindView(R.id.trees_xiongjing)
    TextView tv_xiongjing;

    private void getzhiwuinfo(final String zhi, final int zhi2, String zhi3) {
        OkGo.post(Api.zhiwu_info)
                .tag(this)
                .params("blockCode",zhi)
                .params("growthState",zhi2)
                .params("rfid",zhi3)
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.shortToast(e+"");
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
//                        Log.e("测试",s);
                        Gson gson = new Gson();
                        SearchTreeZhiwuinfoBean zhiwuinfoBean = gson.fromJson(s,SearchTreeZhiwuinfoBean.class);
                        if (zhiwuinfoBean.getState()==1){
                            tv_type.setText(zhiwuinfoBean.getData().getTREE_NAME());
                            tv_guanfu.setText(zhiwuinfoBean.getData().getTREE_MMCD());
                            tv_address.setText(zhiwuinfoBean.getData().getPRODUCE_CITY());
                            tv_weizhi.setText("");
                            tv_xiongjing.setText(zhiwuinfoBean.getData().getTREE_DBH());
                            //获取植物信息后，改变植物选中的状态
                            showstate(zhi2,zhiwuinfoBean.getData().getTREE_NAME());
                        }else{
                            ToastUtils.shortToast(zhiwuinfoBean.getMessage());
                        }
                    }
                });
    }
    //获取植物信息后，改变植物选中的状态及展示的10种状态数
    @BindView(R.id.tree_1_1_img)
    ImageView img_tree1;
    @BindView(R.id.tree_2_1_img)
    ImageView img_tree2;
    @BindView(R.id.tree_3_1_img)
    ImageView img_tree3;
    @BindView(R.id.tree_4_1_img)
    ImageView img_tree4;

    @BindView(R.id.tree_1_1_img_show)
    ImageView img_tree1_show;
    @BindView(R.id.tree_2_1_img_show)
    ImageView img_tree2_show;
    @BindView(R.id.tree_3_1_img_show)
    ImageView img_tree3_show;
    @BindView(R.id.tree_4_1_img_show)
    ImageView img_tree4_show;

    @BindView(R.id.tree_1_1)
    TextView tv_main_1_1;
    @BindView(R.id.tree_1_2)
    TextView tv_bottom_1_2;
    @BindView(R.id.tree_2_1)
    TextView tv_main_2_1;
    @BindView(R.id.tree_2_2)
    TextView tv_bottom_2_2;
    @BindView(R.id.tree_3_1)
    TextView tv_main_3_1;
    @BindView(R.id.tree_3_2)
    TextView tv_bottom_3_2;
    @BindView(R.id.tree_4_1)
    TextView tv_main_4_1;
    @BindView(R.id.tree_4_2)
    TextView tv_bottom_4_2;
    private void showstate(int state,String name) {
//        Log.e("现在的状态",state+"");
        //展示状态
        //1幼苗2苗木3发育4成熟
        if (state==1){
            chooseChioce(4);
        }else if (state==2){
            chooseChioce(3);
        }else if (state==3){
            chooseChioce(2);
        }else if (state==4){
            chooseChioce(1);
        }
        switch (name){
            case "红叶桃":
                img_tree1_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_1_1));
                img_tree2_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_1_2));
                img_tree3_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_1_3));
                img_tree4_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_1_4));
                break;
            case "矮接金叶榆":
                img_tree1_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_2_1));
                img_tree2_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_2_2));
                img_tree3_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_2_3));
                img_tree4_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_2_4));
                break;
            case "白蜡":
                img_tree1_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_3_1));
                img_tree2_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_3_2));
                img_tree3_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_3_3));
                img_tree4_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_3_4));
                break;
            case "臭椿":
                img_tree1_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_4_1));
                img_tree2_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_4_2));
                img_tree3_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_4_3));
                img_tree4_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_4_4));
                break;
            case "国槐":
                img_tree1_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_5_1));
                img_tree2_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_5_2));
                img_tree3_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_5_3));
                img_tree4_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_5_4));
                break;
            case "金枝槐":
                img_tree1_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_6_1));
                img_tree2_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_6_2));
                img_tree3_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_6_3));
                img_tree4_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_6_4));
                break;
            case "柳树":
                img_tree1_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_7_1));
                img_tree2_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_7_2));
                img_tree3_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_7_3));
                img_tree4_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_7_4));
                break;
            case "太阳李":
                img_tree1_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_8_1));
                img_tree2_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_8_2));
                img_tree3_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_8_3));
                img_tree4_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_8_4));
                break;
            case "洋槐":
                img_tree1_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_9_1));
                img_tree2_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_9_2));
                img_tree3_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_9_3));
                img_tree4_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_9_4));
                break;
            case "紫叶矮樱":
                img_tree1_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_10_1));
                img_tree2_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_10_2));
                img_tree3_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_10_3));
                img_tree4_show.setImageDrawable(SearchTreesActivity.this.getResources().getDrawable(R.mipmap.plant_icon_10_4));
                break;
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tree_1_1_layout:
                chooseChioce(1);
                break;
            case R.id.tree_2_1_layout:
                chooseChioce(2);
                break;
            case R.id.tree_3_1_layout:
                chooseChioce(3);
                break;
            case R.id.tree_4_1_layout:
                chooseChioce(4);
                break;
        }
    }
    //点击选中
    private void chooseChioce(int index) {
        clearChioce(); //清空所有的选中

        switch(index){
            case 1:
                img_tree1.setVisibility(View.GONE);
                img_tree1_show.setVisibility(View.VISIBLE);
                tv_main_1_1.setVisibility(View.GONE);
                tv_bottom_1_2.setVisibility(View.VISIBLE);
                break;
            case 2:
                img_tree2.setVisibility(View.GONE);
                img_tree2_show.setVisibility(View.VISIBLE);
                tv_main_2_1.setVisibility(View.GONE);
                tv_bottom_2_2.setVisibility(View.VISIBLE);
                break;
            case 3:
                img_tree3.setVisibility(View.GONE);
                img_tree3_show.setVisibility(View.VISIBLE);
                tv_main_3_1.setVisibility(View.GONE);
                tv_bottom_3_2.setVisibility(View.VISIBLE);
                break;
            case 4:
                img_tree4.setVisibility(View.GONE);
                img_tree4_show.setVisibility(View.VISIBLE);
                tv_main_4_1.setVisibility(View.GONE);
                tv_bottom_4_2.setVisibility(View.VISIBLE);
                break;

        }

    }
    //清空
    private void clearChioce() {
        img_tree1.setVisibility(View.VISIBLE);
        img_tree1_show.setVisibility(View.VISIBLE);
        tv_main_1_1.setVisibility(View.VISIBLE);
        tv_bottom_1_2.setVisibility(View.GONE);

        img_tree2.setVisibility(View.VISIBLE);
        img_tree2_show.setVisibility(View.VISIBLE);
        tv_main_2_1.setVisibility(View.VISIBLE);
        tv_bottom_2_2.setVisibility(View.GONE);

        img_tree3.setVisibility(View.VISIBLE);
        img_tree3_show.setVisibility(View.VISIBLE);
        tv_main_3_1.setVisibility(View.VISIBLE);
        tv_bottom_3_2.setVisibility(View.GONE);

        img_tree4.setVisibility(View.VISIBLE);
        img_tree4_show.setVisibility(View.VISIBLE);
        tv_main_4_1.setVisibility(View.VISIBLE);
        tv_bottom_4_2.setVisibility(View.GONE);
    }


}
