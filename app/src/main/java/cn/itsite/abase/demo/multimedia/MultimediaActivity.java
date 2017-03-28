package cn.itsite.abase.demo.multimedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.itsite.abase.demo.R;
import cn.itsite.abase.mvp.view.base.BaseActivity;

public class MultimediaActivity extends BaseActivity {

    @BindView(R.id.toolbar_toolbar)
    Toolbar toolbar;
    @BindView(R.id.bt_audio)
    Button btAudio;
    @BindView(R.id.bt_video)
    Button btVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);
        ButterKnife.bind(this);
        initToolbar(toolbar);
    }

    @OnClick({R.id.bt_audio, R.id.bt_video})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_audio:
                startActivity(new Intent(this, AudioActivity.class));
                break;
            case R.id.bt_video:
                startActivity(new Intent(this, VideoActivity.class));
                break;
        }
    }

    protected void initToolbar(Toolbar toolbar) {
        toolbar.setTitle("多媒体");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressedSupport();
            }
        });
    }
}
