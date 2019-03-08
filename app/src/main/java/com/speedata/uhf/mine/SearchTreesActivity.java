package com.speedata.uhf.mine;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.speedata.uhf.Api;
import com.speedata.uhf.R;
import com.speedata.uhf.adapter.ShenpiAdapter;
import com.speedata.uhf.bean.FourtreeimgBean;
import com.speedata.uhf.bean.SearchTreeZhiwuinfoBean;
import com.speedata.uhf.bean.SearchTreesStateBean;
import com.speedata.uhf.bean.SearchTreesZhongzhiinfoBean;
import com.speedata.uhf.bean.SelectWorkBean;
import com.speedata.uhf.bean.ShenpijiluBean;
import com.speedata.uhf.bean.YanghuBean;
import com.speedata.uhf.tools.SharedPFUtils;
import com.speedata.uhf.tools.ToastUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

import static com.speedata.uhf.Api.fourimg;

/**
 * 植树信息
 */
public class SearchTreesActivity extends BaseActivity implements View.OnClickListener,View.OnTouchListener  {
    String danhao="",rfids="";
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
        if (!TextUtils.isEmpty(SharedPFUtils.getParam(this,"danhao","").toString())){
            danhao = SharedPFUtils.getParam(this,"danhao","").toString();
        }else if (!TextUtils.isEmpty(SharedPFUtils.getParam(this,"rfids","").toString())){
            danhao = SharedPFUtils.getParam(this,"rfids","").toString();
        }

        selectstate(danhao);
        relativeLayout1.setOnClickListener(this);
        relativeLayout2.setOnClickListener(this);
        relativeLayout3.setOnClickListener(this);
        relativeLayout4.setOnClickListener(this);
        setinfo();
        getfourimg();
        getshenpiinfo();
        //        Log.e("+++", "onCreate: "+danhao );
    }

    @BindView(R.id.search_tree_top_img)
    ImageView img_1;
    @BindView(R.id.search_tree_top_img2)
    ImageView img_2;
    @BindView(R.id.search_tree_top_img3)
    ImageView img_3;
    @BindView(R.id.search_tree_top_img4)
    ImageView img_4;
    private void getfourimg() {
        img_1.setVisibility(View.GONE);
        img_2.setVisibility(View.GONE);
        img_3.setVisibility(View.GONE);
        img_4.setVisibility(View.GONE);

        OkGo.post(Api.fourimg)
                .tag(this)
                .params("blockCode",danhao)
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.shortToast(e+"");
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
//                        Log.e("四个小图",s);
                        Gson gson = new Gson();
                        final FourtreeimgBean fourtreeimgBean = gson.fromJson(s,FourtreeimgBean.class);
                        if (fourtreeimgBean.getState()==1){
                            if (fourtreeimgBean.getData()!=null){
                                img_1.setOnClickListener(new View.OnClickListener() {
                                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(SearchTreesActivity.this, ImgActivity.class);
                                        intent.putExtra("imgurl",Api.ossurl+fourtreeimgBean.getData().get(0).getImg());
                                        startActivity(intent
                                                , ActivityOptions.makeSceneTransitionAnimation(SearchTreesActivity.this, v, "worksimg").toBundle()
                                        );
                                    }
                                });
                                img_2.setOnClickListener(new View.OnClickListener() {
                                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(SearchTreesActivity.this, ImgActivity.class);
                                        intent.putExtra("imgurl",Api.ossurl+fourtreeimgBean.getData().get(1).getImg());
                                        startActivity(intent
                                                , ActivityOptions.makeSceneTransitionAnimation(SearchTreesActivity.this, v, "worksimg").toBundle()
                                        );
                                    }
                                });
                                img_3.setOnClickListener(new View.OnClickListener() {
                                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(SearchTreesActivity.this, ImgActivity.class);
                                        intent.putExtra("imgurl",Api.ossurl+fourtreeimgBean.getData().get(2).getImg());
                                        startActivity(intent
                                                , ActivityOptions.makeSceneTransitionAnimation(SearchTreesActivity.this, v, "worksimg").toBundle()
                                        );
                                    }
                                });
                                img_4.setOnClickListener(new View.OnClickListener() {
                                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(SearchTreesActivity.this, ImgActivity.class);
                                        intent.putExtra("imgurl",Api.ossurl+fourtreeimgBean.getData().get(3).getImg());
                                        startActivity(intent
                                                , ActivityOptions.makeSceneTransitionAnimation(SearchTreesActivity.this, v, "worksimg").toBundle()
                                        );
                                    }
                                });
                                if (fourtreeimgBean.getData().size()==1){
                                    img_1.setVisibility(View.VISIBLE);
                                    Glide.with(SearchTreesActivity.this)
                                            .load(Api.ossurl+fourtreeimgBean.getData().get(0).getImg())
                                            .into(img_1);
                                }
                                if (fourtreeimgBean.getData().size()==2){
                                    img_1.setVisibility(View.VISIBLE);
                                    img_2.setVisibility(View.VISIBLE);
                                    Glide.with(SearchTreesActivity.this)
                                            .load(Api.ossurl+fourtreeimgBean.getData().get(0).getImg())
                                            .into(img_1);
                                    Glide.with(SearchTreesActivity.this)
                                            .load(Api.ossurl+fourtreeimgBean.getData().get(1).getImg())
                                            .into(img_2);
                                }
                                if (fourtreeimgBean.getData().size()==3){
                                    img_1.setVisibility(View.VISIBLE);
                                    img_2.setVisibility(View.VISIBLE);
                                    img_3.setVisibility(View.VISIBLE);
                                    Glide.with(SearchTreesActivity.this)
                                            .load(Api.ossurl+fourtreeimgBean.getData().get(0).getImg())
                                            .into(img_1);
                                    Glide.with(SearchTreesActivity.this)
                                            .load(Api.ossurl+fourtreeimgBean.getData().get(1).getImg())
                                            .into(img_2);
                                    Glide.with(SearchTreesActivity.this)
                                            .load(Api.ossurl+fourtreeimgBean.getData().get(2).getImg())
                                            .into(img_3);
                                }
                                if (fourtreeimgBean.getData().size()==4){
                                    img_1.setVisibility(View.VISIBLE);
                                    img_2.setVisibility(View.VISIBLE);
                                    img_3.setVisibility(View.VISIBLE);
                                    img_4.setVisibility(View.VISIBLE);
                                    Glide.with(SearchTreesActivity.this)
                                            .load(Api.ossurl+fourtreeimgBean.getData().get(0).getImg())
                                            .into(img_1);
                                    Glide.with(SearchTreesActivity.this)
                                            .load(Api.ossurl+fourtreeimgBean.getData().get(1).getImg())
                                            .into(img_2);
                                    Glide.with(SearchTreesActivity.this)
                                            .load(Api.ossurl+fourtreeimgBean.getData().get(2).getImg())
                                            .into(img_3);
                                    Glide.with(SearchTreesActivity.this)
                                            .load(Api.ossurl+fourtreeimgBean.getData().get(3).getImg())
                                            .into(img_4);
                                }
                            }else {
                                //没有信息，不展示
                            }
                        }else {
                            ToastUtils.shortToast(fourtreeimgBean.getMessage());
                        }
                    }
                });
    }

    @BindView(R.id.commoe_left)
    ImageView img_left;
    @BindView(R.id.trees_starwork)
    LinearLayout layout_starwork;
    @BindView(R.id.seatch_main)
    LinearLayout layout_main;
    private void setinfo() {
        img_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchTreesActivity.this.finish();
            }
        });
        layout_starwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkGo.post(Api.selectwork)
                        .tag(this)
                        .params("page",1)
                        .params("pageSize",8)
                        .params("blockCode",SharedPFUtils.getParam(SearchTreesActivity.this,"danhao","").toString())
                        .params("groupCode",SharedPFUtils.getParam(SearchTreesActivity.this,"groupno","").toString())
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Response response, Exception e) {
                                super.onError(call, response, e);
                                ToastUtils.shortToast(e+"");
                            }

                            @Override
                            public void onSuccess(String s, Call call, Response response) {
//                                Log.e("测试sss",s);
                                Gson gson = new Gson();
                                SelectWorkBean workBean = gson.fromJson(s,SelectWorkBean.class);
                                if (workBean.getState()==1){
                                    if (workBean.getData().getPageInfo().getList().size()>0){
                                        for (int i = 0; i < workBean.getData().getPageInfo().getList().size(); i++) {
                                            if (workBean.getData().getPageInfo().getList().get(i).getSTATUS().equals("0")||workBean.getData().getPageInfo().getList().get(i).getSTATUS().equals("3")){
                                                ToastUtils.shortToast("暂无任务");
                                            }else {
                                                Intent intent = new Intent(SearchTreesActivity.this,SearchTreesZuoyeActivity.class);
                                                startActivity(intent);
                                                break;
                                            }
                                        }

                                    }else {
                                        ToastUtils.shortToast("暂无任务可做");
                                    }
                                }else {
                                    ToastUtils.shortToast(workBean.getMessage());
                                }
                            }
                        });

            }
        });
//        layout_main.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(SearchTreesActivity.this,SearchTreesMoreActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    /**
     * 查询种植人头像和植物生长状态
     */
    @BindView(R.id.trees_topname)
    TextView tv_topname;
    @BindView(R.id.search_tree_headimg)
    ImageView img_tophead;
    String statezhi="";
    private void selectstate(String zhi) {
        Log.e("返回", "selectstate() returned: " +zhi);
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
                        Log.e("返回", "onSuccess: 头像"+s );
                        Gson gson = new Gson();
                        final SearchTreesStateBean stateBean = gson.fromJson(s,SearchTreesStateBean.class);
                        if (stateBean.getState()==1){
                            //查询出来了信息
                            if (stateBean.getData()!=null){
                                if (stateBean.getData().getOWNER_PHOTO()!=null){
                                    Glide.with(SearchTreesActivity.this)
                                            .load(Api.ossurl+stateBean.getData().getOWNER_PHOTO())
                                            .into(img_tophead);

                                }else {

                                }

                                img_tophead.setOnClickListener(new View.OnClickListener() {
                                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(SearchTreesActivity.this, ImgActivity.class);
                                        intent.putExtra("imgurl",Api.ossurl+stateBean.getData().getOWNER_PHOTO());
                                        startActivity(intent
                                                , ActivityOptions.makeSceneTransitionAnimation(SearchTreesActivity.this, v, "worksimg").toBundle()
                                        );
                                    }
                                });


                                tv_topname.setText(stateBean.getData().getTREE_OWNER());
                                if (stateBean.getData().getGROWTH_STATE()==1){
                                    relativeLayout1.setEnabled(false);
                                    relativeLayout2.setEnabled(false);
                                    relativeLayout3.setEnabled(false);
                                    relativeLayout4.setEnabled(true);
                                }else  if (stateBean.getData().getGROWTH_STATE()==2){
                                    relativeLayout1.setEnabled(false);
                                    relativeLayout2.setEnabled(false);
                                    relativeLayout3.setEnabled(true);
                                    relativeLayout4.setEnabled(true);
                                }else  if (stateBean.getData().getGROWTH_STATE()==3){
                                    relativeLayout1.setEnabled(false);
                                    relativeLayout2.setEnabled(true);
                                    relativeLayout3.setEnabled(true);
                                    relativeLayout4.setEnabled(true);
                                }else  if (stateBean.getData().getGROWTH_STATE()==4){
                                    relativeLayout1.setEnabled(true);
                                    relativeLayout2.setEnabled(true);
                                    relativeLayout3.setEnabled(true);
                                    relativeLayout4.setEnabled(true);
                                }
                                //请求植物信息接口
                                getzhiwuinfo(danhao,stateBean.getData().getGROWTH_STATE(),"");
                                getzhongzhiinfo(danhao,stateBean.getData().getGROWTH_STATE(),"");
                                getyanghuinfo(danhao,stateBean.getData().getGROWTH_STATE(),"");

                            }
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
                        Gson gson = new Gson();
                        SearchTreeZhiwuinfoBean zhiwuinfoBean = gson.fromJson(s,SearchTreeZhiwuinfoBean.class);
                        if (zhiwuinfoBean.getState()==1){
                           if (zhiwuinfoBean.getData()!=null){
                               tv_type.setText(zhiwuinfoBean.getData().getTREE_NAME());
                               tv_guanfu.setText(zhiwuinfoBean.getData().getTREE_MMCD());
                               tv_address.setText(zhiwuinfoBean.getData().getPRODUCE_CITY());
                               tv_xiongjing.setText(zhiwuinfoBean.getData().getTREE_DBH());
                               //获取植物信息后，改变植物选中的状态
                               showstate(zhi2,zhiwuinfoBean.getData().getTREE_NAME());
                           }
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
                //请求植物信息接口
                getzhiwuinfo(danhao,4,"");
                getzhongzhiinfo(danhao,4,"");
                getyanghuinfo(danhao,4,"");
                break;
            case R.id.tree_2_1_layout:
                chooseChioce(2);
                getzhiwuinfo(danhao,3,"");
                getzhongzhiinfo(danhao,3,"");
                getyanghuinfo(danhao,3,"");
                break;
            case R.id.tree_3_1_layout:
                chooseChioce(3);
                getzhiwuinfo(danhao,2,"");
                getzhongzhiinfo(danhao,2,"");
                getyanghuinfo(danhao,2,"");
                break;
            case R.id.tree_4_1_layout:
                chooseChioce(4);
                getzhiwuinfo(danhao,1,"");
                getzhongzhiinfo(danhao,1,"");
                getyanghuinfo(danhao,1,"");
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

    /**
     * 种植情况
     */
    @BindView(R.id.trees_people)
    TextView tv_people;
    @BindView(R.id.trees_biaoduan)
    TextView tv_biaoduan;
    @BindView(R.id.trees_quyu)
    TextView tv_quyu;
    @BindView(R.id.trees_qukuai)
    TextView tv_qukuai;
    @BindView(R.id.trees_zhongzhitimte)
    TextView tv_zhongzhitime;
    private void getzhongzhiinfo(final String zhi, final int zhi2, String zhi3){
        OkGo.post(Api.zhongzhi_state)
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
                        Gson gson = new Gson();
                        SearchTreesZhongzhiinfoBean zhongzhiinfoBean = gson.fromJson(s,SearchTreesZhongzhiinfoBean.class);
                        if (zhongzhiinfoBean.getState()==1){
                           if (zhongzhiinfoBean.getData()!=null){
                               tv_people.setText(zhongzhiinfoBean.getData().getTREE_OWNER());
                               tv_biaoduan.setText(zhongzhiinfoBean.getData().getTENDERS());
                               tv_quyu.setText(zhongzhiinfoBean.getData().getAREAS_NAME());
                               tv_qukuai.setText(zhongzhiinfoBean.getData().getBLOCK_NAME());
                               tv_zhongzhitime.setText(zhongzhiinfoBean.getData().getCREATE_TIME());
                           }
                        }else {
                            ToastUtils.shortToast(zhongzhiinfoBean.getMessage());
                        }
                    }
                });
    }

    /**
     * 养护记录
     * @param zhi
     * @param zhi2
     * @param zhi3
     */
    @BindView(R.id.trees_chucao)
    TextView tv_chucao;
    @BindView(R.id.trees_jiaoshui)
    TextView tv_jiaoshui;
    @BindView(R.id.trees_shifei)
    TextView tv_shifei;
    @BindView(R.id.trees_buzhi)
    TextView tv_buzhi;
    @BindView(R.id.trees_pailao)
    TextView tv_pailao;
    @BindView(R.id.trees_xiujian)
    TextView tv_xiujian;
    @BindView(R.id.trees_fangzhi)
    TextView tv_fangzhi;
    @BindView(R.id.trees_qita)
    TextView tv_qita;
    private void getyanghuinfo(final String zhi, final int zhi2, String zhi3){
        OkGo.post(Api.yanghujilu)
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

                        Gson gson = new Gson();
                        YanghuBean yanghuBean = gson.fromJson(s,YanghuBean.class);
                        if (yanghuBean.getState()==1){
                            if (yanghuBean.getData()!=null){

                                for (int i = 0; i < yanghuBean.getData().size() ; i++) {
                                    if (yanghuBean.getData().get(i).getWORK_NAME().equals("除草")){
                                        tv_chucao.setText(yanghuBean.getData().get(i).getNUM()+"");
                                    }else  if (yanghuBean.getData().get(i).getWORK_NAME().equals("浇水")){
                                        tv_jiaoshui.setText(yanghuBean.getData().get(i).getNUM()+"");
                                    }else  if (yanghuBean.getData().get(i).getWORK_NAME().equals("施肥")){
                                        tv_shifei.setText(yanghuBean.getData().get(i).getNUM()+"");
                                    }else  if (yanghuBean.getData().get(i).getWORK_NAME().equals("补植")){
                                        tv_buzhi.setText(yanghuBean.getData().get(i).getNUM()+"");
                                    }else  if (yanghuBean.getData().get(i).getWORK_NAME().equals("排涝")){
                                        tv_pailao.setText(yanghuBean.getData().get(i).getNUM()+"");
                                    }else  if (yanghuBean.getData().get(i).getWORK_NAME().equals("修剪")){
                                        tv_xiujian.setText(yanghuBean.getData().get(i).getNUM()+"");
                                    }else  if (yanghuBean.getData().get(i).getWORK_NAME().equals("病虫危害防治")){
                                        tv_fangzhi.setText(yanghuBean.getData().get(i).getNUM()+"");
                                    }else  if (yanghuBean.getData().get(i).getWORK_NAME().equals("其他")){
                                        tv_qita.setText(yanghuBean.getData().get(i).getNUM()+"");
                                    }
                                }
                            }
                        }else {
                            ToastUtils.shortToast(yanghuBean.getMessage());
                        }
                    }
                });
    }

    /**
     * 审批记录
     */
    @BindView(R.id.trees_scroview)
    ScrollView scrollView;
    @BindView(R.id.trees_shenpijilu)
    ListView listView;
    ShenpiAdapter adapter;
    ArrayList<ShenpijiluBean> arrayList = new ArrayList<>();
    private void getshenpiinfo(){
        scrollView.smoothScrollTo(0,0);
        OkGo.post(Api.shenpijiliu)
                .tag(this)
                .params("page",1)
                .params("pageSize",100)
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.shortToast(e+"");
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
//                        Log.e("哈哈", "onSuccess: "+s );
                        Gson gson = new Gson();
                        ShenpijiluBean shenpijiluBean = gson.fromJson(s,ShenpijiluBean.class);
                        if (shenpijiluBean.getState()==1){
                            if (shenpijiluBean.getData()!=null){
                                for (int i = 0; i < shenpijiluBean.getData().getPageInfo().getList().size() ; i++) {
                                    arrayList.add(shenpijiluBean);
                                }
                                adapter = new ShenpiAdapter(SearchTreesActivity.this,arrayList);
                                listView.setAdapter(adapter);
                            }
                        }else {
                            ToastUtils.shortToast(shenpijiluBean.getMessage());
                        }
                    }
                });


    }

    // 縮放控制
    private Matrix matrix = new Matrix();
    private Matrix savedMatrix = new Matrix();

    // 不同状态的表示：
    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    private int mode = NONE;

    // 定义第一个按下的点，两只接触点的重点，以及出事的两指按下的距离：
    private PointF startPoint = new PointF();
    private PointF midPoint = new PointF();
    private float oriDis = 1f;
    // 计算两个触摸点之间的距离
    private float distance(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return Float.valueOf(String.valueOf(Math.sqrt(x * x + y * y))) ;
    }

    // 计算两个触摸点的中点
    private PointF middle(MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        return new PointF(x / 2, y / 2);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ImageView view = (ImageView) v;
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            // 单指
            case MotionEvent.ACTION_DOWN:
                matrix.set(view.getImageMatrix());
                savedMatrix.set(matrix);
                startPoint.set(event.getX(), event.getY());
                mode = DRAG;
                break;
            // 双指
            case MotionEvent.ACTION_POINTER_DOWN:
                oriDis = distance(event);
                if (oriDis > 10f) {
                    savedMatrix.set(matrix);
                    midPoint = middle(event);
                    mode = ZOOM;
                }
                break;
            // 手指放开
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                mode = NONE;
                break;
            // 单指滑动事件
            case MotionEvent.ACTION_MOVE:
                if (mode == DRAG) {
                    // 是一个手指拖动
                    matrix.set(savedMatrix);
                    matrix.postTranslate(event.getX() - startPoint.x, event.getY() - startPoint.y);
                } else if (mode == ZOOM) {
                    // 两个手指滑动
                    float newDist = distance(event);
                    if (newDist > 10f) {
                        matrix.set(savedMatrix);
                        float scale = newDist / oriDis;
                        matrix.postScale(scale, scale, midPoint.x, midPoint.y);
                    }
                }
                break;
        }
        // 设置ImageView的Matrix
        view.setImageMatrix(matrix);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        selectstate(danhao);
    }
}
