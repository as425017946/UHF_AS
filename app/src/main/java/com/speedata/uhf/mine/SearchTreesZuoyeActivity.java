package com.speedata.uhf.mine;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.speedata.uhf.Api;
import com.speedata.uhf.R;
import com.speedata.uhf.bean.SelectWorkBean;
import com.speedata.uhf.bean.UpimgBean;
import com.speedata.uhf.tools.SharedPFUtils;
import com.speedata.uhf.tools.ToastUtils;
import com.wildma.pictureselector.ImageUtils;
import com.wildma.pictureselector.PictureSelector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 点击开始作业进入的页面
 */
public class SearchTreesZuoyeActivity extends BaseActivity implements View.OnClickListener {
    String bianhao="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_trees_zuoye);
        ButterKnife.bind(this);
        setinfo();
        OkGo.post(Api.selectwork)
                .tag(this)
                .params("page",1)
                .params("pageSize",8)
                .params("blockCode", SharedPFUtils.getParam(SearchTreesZuoyeActivity.this,"danhao","").toString())
                .params("groupCode",SharedPFUtils.getParam(SearchTreesZuoyeActivity.this,"groupno","").toString())
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
                        SelectWorkBean workBean = gson.fromJson(s,SelectWorkBean.class);
                        if (workBean.getState()==1){
                            if (workBean.getData().getPageInfo().getList().size()>0){
                                for (int i = 0; i <workBean.getData().getPageInfo().getList().size() ; i++) {
                                    bianhao = bianhao+workBean.getData().getPageInfo().getList().get(i).getCONSERVATION_CODE()+",";
                                    if (workBean.getData().getPageInfo().getList().get(i).getWORK_NAME().equals("浇水")){
                                        btn1.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                                        btn1.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                                    }
                                    if (workBean.getData().getPageInfo().getList().get(i).getWORK_NAME().equals("排涝")){
                                        btn2.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                                        btn2.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                                    }
                                    if (workBean.getData().getPageInfo().getList().get(i).getWORK_NAME().equals("除草")){
                                        btn3.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                                        btn3.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                                    }
                                    if (workBean.getData().getPageInfo().getList().get(i).getWORK_NAME().equals("修剪")){
                                        btn4.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                                        btn4.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                                    }
                                    if (workBean.getData().getPageInfo().getList().get(i).getWORK_NAME().equals("施肥")){
                                        btn5.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                                        btn5.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                                    }
                                    if (workBean.getData().getPageInfo().getList().get(i).getWORK_NAME().equals("病虫危害防治")){
                                        btn6.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                                        btn6.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                                    }
                                    if (workBean.getData().getPageInfo().getList().get(i).getWORK_NAME().equals("补植")){
                                        btn7.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                                        btn7.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                                    }
                                    if (workBean.getData().getPageInfo().getList().get(i).getWORK_NAME().equals("其他")){
                                        btn8.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                                        btn8.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                                    }

                                    //查询状态

                                }
                            }else {
                                ToastUtils.shortToast("暂无任务可做");
                            }
                        }else {
                            ToastUtils.shortToast(workBean.getMessage());
                        }
                    }
                });
//        btn1.setOnClickListener(this);
//        btn2.setOnClickListener(this);
//        btn3.setOnClickListener(this);
//        btn4.setOnClickListener(this);
//        btn5.setOnClickListener(this);
//        btn6.setOnClickListener(this);
//        btn7.setOnClickListener(this);
//        btn8.setOnClickListener(this);
    }

    @BindView(R.id.commoe_left)
    ImageView img_left;
    @BindView(R.id.wancheng)
    Button btn_sousuo;
    @BindView(R.id.zuoye_img)
    ImageView img_zuoye;
    int zuoyezhi=1;
    @BindView(R.id.zuoye_btn_1)
    Button btn1;
    @BindView(R.id.zuoye_btn_2)
    Button btn2;
    @BindView(R.id.zuoye_btn_3)
    Button btn3;
    @BindView(R.id.zuoye_btn_4)
    Button btn4;
    @BindView(R.id.zuoye_btn_5)
    Button btn5;
    @BindView(R.id.zuoye_btn_6)
    Button btn6;
    @BindView(R.id.zuoye_btn_7)
    Button btn7;
    @BindView(R.id.zuoye_btn_8)
    Button btn8;
    private void setinfo() {
        img_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchTreesZuoyeActivity.this.finish();
            }
        });
        btn_sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(picturePath)){
                    ToastUtils.shortToast("请上传图片");
                }else {

                    upinfo(bianhao);
                    SearchTreesZuoyeActivity.this.finish();
                }
            }
        });
        img_zuoye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureSelector
                        .create(SearchTreesZuoyeActivity.this, zuoyezhi)
                        .selectPicture(false, 400, 200, 2, 1);
            }
        });
    }

    /**
     * 上传
     */
    private void upinfo(final String bianhao) {
        String bianhaos = bianhao.substring(0,bianhao.length()-1);
        OkGo.post(Api.starwork)
                .tag(this)
                .params("conservationCode",bianhaos)
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        ToastUtils.shortToast(e+"");
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Gson gson = new Gson();
                        UpimgBean upimgBean = gson.fromJson(s,UpimgBean.class);
                        if (upimgBean.getState()==1){
                            OkGo.post(Api.stopwork)
                                    .tag(this)
                                    .params("conservationCode",bianhao)
                                    .params("conservationPhoto",picturePath)
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onSuccess(String s, Call call, Response response) {
                                            Log.e("编码",s);
                                            Gson gson = new Gson();
                                            UpimgBean upimgBean = gson.fromJson(s,UpimgBean.class);
                                            if (upimgBean.getState()==1){
                                               SearchTreesZuoyeActivity.this.finish();
                                               ToastUtils.shortToast("作业完成");
                                            }else {
                                                ToastUtils.shortToast(upimgBean.getMessage());
                                            }
                                        }
                                    });
                        }else {
                            ToastUtils.shortToast(upimgBean.getMessage());
                        }
                    }
                });
    }

    String picturePath;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*结果回调*/
        if (requestCode == zuoyezhi) {
            if (data != null) {
                picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);
                img_zuoye.setImageBitmap(ImageUtils.getBitmap(picturePath));
                btn_sousuo.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.upload_btn_complete_highlight));
            }
        }
    }


    @Override
    public void onClick(View view) {
        clears();
        switch (view.getId()){
            case R.id.zuoye_btn_1:
                btn1.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                btn1.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                break;
            case R.id.zuoye_btn_2:
                btn2.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                btn2.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                break;
            case R.id.zuoye_btn_3:
                btn3.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                btn3.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                break;
            case R.id.zuoye_btn_4:
                btn4.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                btn4.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                break;
            case R.id.zuoye_btn_5:
                btn5.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                btn5.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                break;
            case R.id.zuoye_btn_6:
                btn6.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                btn6.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                break;
            case R.id.zuoye_btn_7:
                btn7.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                btn7.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                break;
            case R.id.zuoye_btn_8:
                btn8.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.zuoye_yellow));
                btn8.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.yellows));
                break;
        }
    }
    private void clears(){
        btn1.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.btn_work_highlight));
        btn1.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.text_green));
        btn2.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.btn_work_highlight));
        btn2.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.text_green));
        btn3.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.btn_work_highlight));
        btn3.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.text_green));
        btn4.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.btn_work_highlight));
        btn4.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.text_green));
        btn5.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.btn_work_highlight));
        btn5.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.text_green));
        btn6.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.btn_work_highlight));
        btn6.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.text_green));
        btn7.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.btn_work_highlight));
        btn7.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.text_green));
        btn8.setBackgroundDrawable(SearchTreesZuoyeActivity.this.getResources().getDrawable(R.mipmap.btn_work_highlight));
        btn8.setTextColor(SearchTreesZuoyeActivity.this.getResources().getColor(R.color.text_green));
    }
}
