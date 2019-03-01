package com.speedata.uhf.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.speedata.uhf.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 上传图片
 */
public class UpImgActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_img);
        ButterKnife.bind(this);
        setinfo();
    }

    @BindView(R.id.commoe_left)
    ImageView img_left;
    private void setinfo() {
        img_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpImgActivity.this.finish();
            }
        });
    }
}
