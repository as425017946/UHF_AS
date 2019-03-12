package com.speedata.uhf.mine;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.speedata.uhf.R;
import com.speedata.uhf.tools.ToastUtils;
import com.speedata.uhf.tools.UiUtils;
import com.speedata.uhf.tools.UriUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 登录后选择页面
 */
public class ChooseActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ButterKnife.bind(this);
        setinfo();
    }

    @BindView(R.id.choose_zhishu)
    LinearLayout layout_zhishu;
    @BindView(R.id.choose_zhongshu)
    LinearLayout layout_zhongshu;
    @BindView(R.id.choose_address)
    LinearLayout layout_address;
    @BindView(R.id.choose_messages)
    LinearLayout layout_messages;
    private void setinfo() {
        layout_zhishu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UriUtil.isFastClick2()==true){
                    ToastUtils.shortToast("短时间内请勿点击");
                }else {
                    Intent intent = new Intent(ChooseActivity.this,SearchActivity.class);
                    intent.putExtra("searchid","1");
                    startActivity(intent);
                }

            }
        });
        layout_zhongshu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UriUtil.isFastClick2()==true){
                    ToastUtils.shortToast("短时间内请勿点击");
                }else {
                    Intent intent = new Intent(ChooseActivity.this,SearchActivity.class);
                    intent.putExtra("searchid","2");
                    startActivity(intent);
                }

            }
        });
        layout_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
//        layout_messages.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ChooseActivity.this,MessageActivity.class);
//                startActivity(intent);
//            }
//        });
    }
    private long mkeyTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
            case KeyEvent.ACTION_DOWN:
                if ((System.currentTimeMillis() - mkeyTime) > 2000) {
                    mkeyTime = System.currentTimeMillis();
                    boolean cn = getApplicationContext().getResources().getConfiguration().locale.getCountry().equals("CN");
                    if (cn) {
                        Toast.makeText(getApplicationContext(), "再按一次退出", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Click again to exit", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
