package hongliang.com.mydouyinsuosou.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import hongliang.com.mydouyinsuosou.R;

public class VideoActivity extends AppCompatActivity {

    private JCVideoPlayerStandard videoplayer;
    private String videoName;
    private String videoUrl;
    private String videoImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Intent intent = getIntent();
        videoUrl = intent.getStringExtra("videoUrl");
        videoName = intent.getStringExtra("videoName");
        videoImg = intent.getStringExtra("videoImg");
        videoplayer = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);
        /**
         * 使用WebView对url地址进行请求
         * 返回重定向的地址
         */
        WebView webView = new WebView(this);
        webView.loadUrl(videoUrl);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            //页面加载开始
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
            //页面加载完成
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                String realUrl = url;
                Log.i("aaaaa","urlurlurl"+url.toString()+"realUrlrealUrlrealUrl"+realUrl.toString());
                boolean setUp = videoplayer.setUp(realUrl, JCVideoPlayer.SCREEN_LAYOUT_LIST,videoName );
                if (setUp) {
                    videoplayer.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Glide.with(VideoActivity.this).load(videoImg).into(videoplayer.thumbImageView);
                }
            }
        });
    }
}
