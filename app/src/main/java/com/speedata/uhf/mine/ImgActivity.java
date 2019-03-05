package com.speedata.uhf.mine;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.speedata.uhf.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImgActivity extends AppCompatActivity {

    @BindView(R.id.search_tree_headimgs)
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        ButterKnife.bind(this);
        Glide.with(this).load(getIntent().getStringExtra("imgurl")).into(iv);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.finishAfterTransition(ImgActivity.this);
            }
        });
    }
}
