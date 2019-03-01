package com.speedata.uhf.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.speedata.uhf.R;
import com.speedata.uhf.tools.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 搜索页面
 */
public class SearchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        setinfo();
    }

    @BindView(R.id.commoe_left)
    ImageView img_left;
    @BindView(R.id.search_search)
    Button btn_sousuo;
    @BindView(R.id.search_quxiao)
    Button btn_quxiao;
    @BindView(R.id.search_erweima)
    RelativeLayout img_erweima;
    @BindView(R.id.search_id)
    TextView edt_id;
    private void setinfo(){
        img_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchActivity.this.finish();
            }
        });
        btn_sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this,SearchTreesActivity.class);
                startActivity(intent);
            }
        });
        //扫描二维码
        img_erweima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this,SaomiaoActivity.class);
                startActivity(intent);
            }
        });
    }

}
