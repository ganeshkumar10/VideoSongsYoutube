package com.example.myapplicationcodegama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplicationcodegama.pojo.VideoItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements YoutubeVideosAdapter.ClickManager {

    @BindView(R.id.rv_videos)
    RecyclerView rvVideos;
    private List<VideoItem> videoItems = new ArrayList<>();
    private YoutubeVideosAdapter youtubeVideosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        videoItems.add(new VideoItem("Oh My Kadavule - Kadhaippoma", "10", "DScFlfN9vDk", "https://file-examples-com.github.io/uploads/2017/10/file_example_JPG_100kB.jpg"));
        videoItems.add(new VideoItem("Oh My Kadavule - Marappadhilai Nenje", "11", "W6XAQBNmICI", "https://file-examples-com.github.io/uploads/2017/10/file_example_JPG_100kB.jpg"));
        videoItems.add(new VideoItem("Kanave Nee Naan - Kannum Kannum Kollaiyadithaal", "12", "ZUcvKWegSGw", "https://file-examples-com.github.io/uploads/2017/10/file_example_JPG_100kB.jpg"));
        videoItems.add(new VideoItem("Yelo Pullelo - Kannum Kannum Kollaiyadithaal", "13", "nfH0pa0VSBI", "https://file-examples-com.github.io/uploads/2017/10/file_example_JPG_100kB.jpg"));
        videoItems.add(new VideoItem("Sirikkalam Parakkalam - Kannum Kannum Kollaiyadithaal", "14", "vlYv7Ri-GQU", "https://file-examples-com.github.io/uploads/2017/10/file_example_JPG_100kB.jpg"));
        videoItems.add(new VideoItem("Dharala prabhu - Title track", "15", "3cqtq_f_v7w", "https://file-examples-com.github.io/uploads/2017/10/file_example_JPG_100kB.jpg"));
        videoItems.add(new VideoItem("Raavanan - Usure Pogudhey", "16", "yCKO5KUDcVs", "https://file-examples-com.github.io/uploads/2017/10/file_example_JPG_100kB.jpg"));
        videoItems.add(new VideoItem("Kaatru Veliyidai - Azhagiye", "17", "CFj1HXUGhaY", "https://file-examples-com.github.io/uploads/2017/10/file_example_JPG_100kB.jpg"));
        videoItems.add(new VideoItem("Vinnaithaandi Varuvaayaa - Omana Penne", "18", "vj2_z1GYXcU", "https://file-examples-com.github.io/uploads/2017/10/file_example_JPG_100kB.jpg"));
        videoItems.add(new VideoItem("Neethaane En Ponvasantham - Vaanam Mella", "19", "PzBrCSiwYGM", "https://file-examples-com.github.io/uploads/2017/10/file_example_JPG_100kB.jpg"));
        videoItems.add(new VideoItem("Karutha Penne", "10", "ppQPpShemEE", "https://file-examples-com.github.io/uploads/2017/10/file_example_JPG_100kB.jpg"));
        youtubeVideosAdapter = new YoutubeVideosAdapter(MainActivity.this, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvVideos.setLayoutManager(mLayoutManager);
        rvVideos.setItemAnimator(new DefaultItemAnimator());
        rvVideos.setAdapter(youtubeVideosAdapter);
        youtubeVideosAdapter.setList(videoItems);
    }

    @Override
    public void onItemClick(VideoItem videoItem, int pos) {
        Intent intent = new Intent(getApplicationContext(), VideoPlayingActivity.class);
        intent.putExtra("path", videoItem.getVideoId());
        startActivity(intent);
    }
}
