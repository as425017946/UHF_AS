package com.speedata.uhf.mine;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.tu.loadingdialog.LoadingDailog;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.speedata.uhf.Api;
import com.speedata.uhf.R;
import com.speedata.uhf.bean.LoginBean;
import com.speedata.uhf.tools.SharedPFUtils;
import com.speedata.uhf.tools.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 登录
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setinfo();
        if (!TextUtils.isEmpty(SharedPFUtils.getParam(this,"account","").toString())){
            OkGo.post(Api.login)
                    .tag(this)
                    .params("account",SharedPFUtils.getParam(this,"account","").toString())
                    .params("password",SharedPFUtils.getParam(this,"password","").toString())
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                            ToastUtils.shortToast(e+"");
                        }

                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            Gson gson = new Gson();
                            LoginBean loginBean = gson.fromJson(s,LoginBean.class);
                            LoadingDailog.Builder loadBuilder=new LoadingDailog.Builder(LoginActivity.this)
                                    .setMessage("登录成功...")
                                    .setCancelable(false)
                                    .setCancelOutside(false);
                            final LoadingDailog dialog=loadBuilder.create();
                            if (loginBean.getState()==1){
                                dialog.show();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(LoginActivity.this,ChooseActivity.class);
                                        startActivity(intent);
                                        dialog.dismiss();
                                        LoginActivity.this.finish();
                                    }
                                },2000);


                            }else {
                                dialog.dismiss();
                                ToastUtils.shortToast(loginBean.getMessage());
                            }
                        }
                    });
        }
    }
    @BindView(R.id.login_btn)
    Button btn_denglu;
    @BindView(R.id.login_zhanghao)
    EditText edt_zhanghao;
    @BindView(R.id.login_mima)
    EditText edt_mima;
    private void setinfo(){
        btn_denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(edt_zhanghao.getText().toString())||TextUtils.isEmpty(edt_mima.getText().toString())){
                    ToastUtils.shortToast("账号和密码不能为空");
                }else {
                    OkGo.post(Api.login)
                            .tag(this)
                            .params("account",edt_zhanghao.getText().toString())
                            .params("password",edt_mima.getText().toString())
                            .execute(new StringCallback() {
                                @Override
                                public void onError(Call call, Response response, Exception e) {
                                    super.onError(call, response, e);
                                    ToastUtils.shortToast(e+"");
                                }

                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    Gson gson = new Gson();
                                    LoginBean loginBean = gson.fromJson(s,LoginBean.class);
                                    LoadingDailog.Builder loadBuilder=new LoadingDailog.Builder(LoginActivity.this)
                                            .setMessage("登录成功...")
                                            .setCancelable(false)
                                            .setCancelOutside(false);
                                    final LoadingDailog dialog=loadBuilder.create();
                                    if (loginBean.getState()==1){
                                        dialog.show();
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                Intent intent = new Intent(LoginActivity.this,ChooseActivity.class);
                                                startActivity(intent);
                                                SharedPFUtils.setParam(LoginActivity.this,"account",edt_zhanghao.getText().toString());
                                                SharedPFUtils.setParam(LoginActivity.this,"password",edt_mima.getText().toString());
                                                LoginActivity.this.finish();
                                            }
                                        },2000);


                                    }else {
                                        dialog.dismiss();
                                        ToastUtils.shortToast(loginBean.getMessage());
                                    }
                                }
                            });
                }

//
            }
        });
    }

}
