package com.speedata.uhf.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.speedata.uhf.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 点击开始作业进入的页面
 */
public class SearchTreesZuoyeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_trees_zuoye);
        ButterKnife.bind(this);
        setinfo();
    }

    @BindView(R.id.commoe_left)
    ImageView img_left;
    @BindView(R.id.search_search)
    Button btn_sousuo;
    @BindView(R.id.search_quxiao)
    Button btn_quxiao;
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
                SearchTreesZuoyeActivity.this.finish();
            }
        });
    }
}
