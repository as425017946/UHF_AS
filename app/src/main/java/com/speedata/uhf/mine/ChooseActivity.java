package com.speedata.uhf.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.speedata.uhf.R;
import com.speedata.uhf.tools.ToastUtils;

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
                Intent intent = new Intent(ChooseActivity.this,SearchActivity.class);
                intent.putExtra("searchid","1");
                startActivity(intent);
            }
        });
        layout_zhongshu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this,SearchActivity.class);
                intent.putExtra("searchid","2");
                startActivity(intent);
            }
        });
        layout_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(ChooseActivity.this,MessageActivity.class);
//                startActivity(intent);
                ToastUtils.shortToast("待开发");
            }
        });
        layout_messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
    }
}
