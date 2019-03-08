package com.speedata.uhf.mine;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.android.tu.loadingdialog.LoadingDailog;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.speedata.uhf.Api;
import com.speedata.uhf.R;
import com.speedata.uhf.bean.UpimgBean;
import com.speedata.uhf.tools.SharedPFUtils;
import com.speedata.uhf.tools.ToastUtils;
import com.speedata.uhf.tools.UiUtils;
import com.wildma.pictureselector.ImageUtils;
import com.wildma.pictureselector.PictureSelector;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * 上传图片
 */
public class UpImgActivity extends BaseActivity {
    String qukuaiid="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_img);
        ButterKnife.bind(this);
        if (!TextUtils.isEmpty(SharedPFUtils.getParam(this,"danhao","").toString())){
            qukuaiid =  SharedPFUtils.getParam(this,"danhao","").toString();
        }else {
            qukuaiid =  SharedPFUtils.getParam(this,"rfids","").toString();
        }
        setinfo();
    }

    private LoadingDailog loadBuilder;
    private void showMyDialog(){
        if (loadBuilder==null){
            loadBuilder=new LoadingDailog.Builder(UpImgActivity.this)
                    .setMessage("信息上传中...")
                    .setCancelable(false)
                    .setCancelOutside(false).create();
            loadBuilder.show();
        }

    }
    private void dissDialog(){
        if (loadBuilder!=null){
            loadBuilder.dismiss();
        }
    }
    @BindView(R.id.login_btn)
    Button btn_tijiao;
    @BindView(R.id.commoe_left)
    ImageView img_left;
    @BindView(R.id.upimg_id)
    TextView  tv_id;
    @BindView(R.id.upimg_show)
    ImageView img_show1;
    @BindView(R.id.upimg_show_delete)
    ImageView img_show_delete1;
    @BindView(R.id.upimg_show2)
    ImageView img_show2;
    @BindView(R.id.upimg_show_delete2)
    ImageView img_show_delete2;
    @BindView(R.id.upimg_show3)
    ImageView img_show3;
    @BindView(R.id.upimg_show_delete3)
    ImageView img_show_delete3;
    @BindView(R.id.upimg_show4)
    ImageView img_show4;
    @BindView(R.id.upimg_show_delete4)
    ImageView img_show_delete4;
    private int select1=1,select2=2,select3=3,select4=4;
    ArrayList<String> imglist = new ArrayList<>();
    private void setinfo() {
        img_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpImgActivity.this.finish();
            }
        });
        tv_id.setText("ID："+ qukuaiid);
        img_show1.setVisibility(View.VISIBLE);
        img_show2.setVisibility(View.GONE);
        img_show3.setVisibility(View.GONE);
        img_show4.setVisibility(View.GONE);
        img_show_delete1.setVisibility(View.GONE);
        img_show_delete2.setVisibility(View.GONE);
        img_show_delete3.setVisibility(View.GONE);
        img_show_delete4.setVisibility(View.GONE);
        img_show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureSelector
                        .create(UpImgActivity.this, select1)
                        .selectPicture(true, 200, 200, 1, 1);
            }
        });
        img_show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureSelector
                        .create(UpImgActivity.this, select2)
                        .selectPicture(true, 200, 200, 1, 1);
            }
        });
        img_show3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureSelector
                        .create(UpImgActivity.this, select3)
                        .selectPicture(true, 200, 200, 1, 1);
            }
        });
        img_show4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureSelector
                        .create(UpImgActivity.this, select4)
                        .selectPicture(true, 200, 200, 1, 1);
            }
        });

        //提交
        btn_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imglist.size()==0){
                   ToastUtils.shortToast("请上传照片");
                }else {
                    showMyDialog();
                    for (int i = 0; i < imglist.size(); i++) {

                                Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), ImageUtils.getBitmap(imglist.get(i)), null,null));

                                beginupload(uri,i+1);
                    }
                }

            }
        });
    }
    String imgs="";
    private void upimg(){
        imgs = imgs.substring(0,imgs.length()-1);
        OkGo.post(Api.uptreeimg)
                .tag(this)
                .params("blockCode",qukuaiid)
                .params("treeImg",imgs)
                .params("ownerPhoto",SharedPFUtils.getParam(this,"ownerimg","").toString())
                .params("treeOwner",SharedPFUtils.getParam(this,"owner","").toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
//                        Log.e("***", "onSuccess: 测试"+s );
                        Gson gson = new Gson();
                        UpimgBean upimgBean = gson.fromJson(s,UpimgBean.class);
                        if (upimgBean.getState()==1){
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    UpImgActivity.this.finish();
                                }
                            },500);
                            ToastUtils.shortToast("上传成功");
                            dissDialog();
                        }else {
                            ToastUtils.shortToast(upimgBean.getMessage());
                        }
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /*结果回调*/
        if (requestCode == select1) {
            if (data != null) {
                String picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);
//                Log.e("测试图片222", "onActivityResult: "+picturePath );
                File file=new File(picturePath);
                File f=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+System.currentTimeMillis()+".png");
                file.renameTo(f);
                if (imglist.size()>0){
                    imglist.remove(0);
                }
                imglist.add(0,f.getAbsolutePath());//存到集合
                img_show1.setImageBitmap(ImageUtils.getBitmap(imglist.get(0)));
                getimg();
            }
        }else  if (requestCode == select2) {
            if (data != null) {
                String picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);
//                Log.e("测试图片222", "onActivityResult: "+picturePath );
                File file=new File(picturePath);
                File f=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+System.currentTimeMillis()+".png");
                file.renameTo(f);
                if (imglist.size()>=2){
                    imglist.remove(1);
                }
                imglist.add(1,f.getAbsolutePath());//存到集合
                img_show2.setImageBitmap(ImageUtils.getBitmap(imglist.get(1)));
                getimg();
            }
        }else  if (requestCode == select3) {
            if (data != null) {
                String picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);
//                Log.e("测试图片222", "onActivityResult: "+picturePath );
                File file=new File(picturePath);
                File f=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+System.currentTimeMillis()+".png");
                file.renameTo(f);
                if (imglist.size()>=3){
                    imglist.remove(2);
                }
                imglist.add(2,f.getAbsolutePath());//存到集合
                img_show3.setImageBitmap(ImageUtils.getBitmap(imglist.get(2)));
                getimg();
            }
        }else  if (requestCode == select4) {
            if (data != null) {
                String picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);
//                Log.e("测试图片222", "onActivityResult: "+picturePath );
                File file=new File(picturePath);
                File f=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+System.currentTimeMillis()+".png");
                file.renameTo(f);
                if (imglist.size()>=4){
                    imglist.remove(3);
                }
                imglist.add(3,f.getAbsolutePath());//存到集合
                img_show4.setImageBitmap(ImageUtils.getBitmap(imglist.get(3)));
                getimg();
            }
        }
    }
    private void getimg(){
        if (imglist.size()==0){
            img_show1.setVisibility(View.VISIBLE);
        }else {
            for (int i = 0; i <imglist.size() ; i++) {

                if (imglist.size()==1){
                    img_show1.setImageBitmap(ImageUtils.getBitmap(imglist.get(i)));
                    img_show2.setVisibility(View.GONE);
                    img_show3.setVisibility(View.GONE);
                    img_show4.setVisibility(View.GONE);
                    img_show_delete1.setVisibility(View.VISIBLE);
                    img_show_delete2.setVisibility(View.GONE);
                    img_show_delete3.setVisibility(View.GONE);
                    img_show_delete4.setVisibility(View.GONE);
                    final int finalI = i;
                    img_show_delete1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imglist.remove(finalI);
                           if (imglist.size()==0){
                               img_show1.setImageDrawable(UpImgActivity.this.getResources().getDrawable(R.mipmap.upload_btn_pho));
                               img_show1.setVisibility(View.VISIBLE);
                               img_show2.setVisibility(View.GONE);
                               img_show3.setVisibility(View.GONE);
                               img_show4.setVisibility(View.GONE);
                               img_show_delete1.setVisibility(View.GONE);
                               img_show_delete2.setVisibility(View.GONE);
                               img_show_delete3.setVisibility(View.GONE);
                               img_show_delete4.setVisibility(View.GONE);
                           }else {
                               getimg();
                           }
                        }
                    });
                    //第一个显示了，说明第一个应经有图了，要把第二个图显示出来
                    img_show2.setVisibility(View.VISIBLE);
                    img_show2.setImageDrawable(UpImgActivity.this.getResources().getDrawable(R.mipmap.upload_btn_pho));
                }else if (imglist.size()==2){
                    img_show2.setImageDrawable(UpImgActivity.this.getResources().getDrawable(R.mipmap.upload_btn_pho));
                    img_show2.setImageBitmap(ImageUtils.getBitmap(imglist.get(i)));
                    img_show2.setVisibility(View.VISIBLE);
                    img_show3.setVisibility(View.GONE);
                    img_show4.setVisibility(View.GONE);
                    img_show_delete1.setVisibility(View.VISIBLE);
                    img_show_delete2.setVisibility(View.VISIBLE);
                    img_show_delete3.setVisibility(View.GONE);
                    img_show_delete4.setVisibility(View.GONE);
                    final int finalI = i;
                    img_show_delete2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imglist.remove(finalI);
                            getimg();
                        }
                    });
                    //第2个显示了，说明第一个应经有图了，要把第3个图显示出来
                    img_show3.setVisibility(View.VISIBLE);
                    img_show3.setImageDrawable(UpImgActivity.this.getResources().getDrawable(R.mipmap.upload_btn_pho));
                }else if (imglist.size()==3){
                    img_show3.setImageBitmap(ImageUtils.getBitmap(imglist.get(i)));
                    img_show2.setVisibility(View.VISIBLE);
                    img_show3.setVisibility(View.VISIBLE);
                    img_show4.setVisibility(View.GONE);
                    img_show_delete1.setVisibility(View.VISIBLE);
                    img_show_delete2.setVisibility(View.VISIBLE);
                    img_show_delete3.setVisibility(View.VISIBLE);
                    img_show_delete4.setVisibility(View.GONE);
                    final int finalI = i;
                    img_show_delete3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imglist.remove(finalI);
                            getimg();
                        }
                    });
                    //第3个显示了，说明第一个应经有图了，要把第4个图显示出来
                    img_show4.setVisibility(View.VISIBLE);
                    img_show4.setImageDrawable(UpImgActivity.this.getResources().getDrawable(R.mipmap.upload_btn_pho));
                }else if (imglist.size()==4){
                    img_show4.setImageBitmap(ImageUtils.getBitmap(imglist.get(i)));
                    img_show2.setVisibility(View.VISIBLE);
                    img_show3.setVisibility(View.VISIBLE);
                    img_show4.setVisibility(View.VISIBLE);
                    img_show_delete1.setVisibility(View.VISIBLE);
                    img_show_delete2.setVisibility(View.VISIBLE);
                    img_show_delete3.setVisibility(View.VISIBLE);
                    img_show_delete4.setVisibility(View.VISIBLE);
                    final int finalI = i;
                    img_show_delete4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imglist.remove(finalI);
                            getimg();
                        }
                    });

                }
            }
        }

    }

    /**上传图片**/
    public void beginupload(Uri photourl, final int newzhi) {
//        Log.e("测试图片11", photourl+"");
        final String endpoint = "oss-cn-beijing.aliyuncs.com";
        final String startpoint = "back-green";
        //     明文设置secret的方式建议只在测试时使用，更多鉴权模式请参考后面的`访问控制`章节
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider("LTAI8ygujYgDvLJ9", "nLrO1bpn9IOpEu0tt0zyAaChc22j0c");
        OSS oss = new OSSClient(getApplicationContext(), endpoint, credentialProvider);
        //通过填写文件名形成objectname,通过这个名字指定上传和下载的文件
        // 构造上传请求
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        final String objectname =df.format(new Date())+newzhi+ ".png";

        PutObjectRequest put = new PutObjectRequest(startpoint, objectname, UiUtils.getImageAbsolutePath(UpImgActivity.this,photourl) );
        // 异步上传时可以设置进度回调
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
            }
        });
        OSSAsyncTask task = oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(PutObjectRequest request, PutObjectResult result) {

//                arrayList.remove(i);
//                Log.e("测试图片", Api.ossurl +objectname);
                imgs = imgs+objectname+",";
                if (newzhi==imglist.size()){
                    imglist.clear();
                    upimg();
                }
            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                ToastUtils.shortToast("图片上传失败导致信息无法发布");
                dissDialog();
                // 请求异常
                if (clientExcepion != null) {
                    // 本地异常如网络异常等
                    clientExcepion.printStackTrace();
                    ToastUtils.shortToast("图片上传失败导致信息无法发布");
                }
                if (serviceException != null) {
                }
            }
        });

    }
}
