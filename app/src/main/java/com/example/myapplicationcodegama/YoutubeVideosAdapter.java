package com.example.myapplicationcodegama;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplicationcodegama.pojo.VideoItem;
import com.pierfrancescosoffritti.youtubeplayer.player.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class YoutubeVideosAdapter extends RecyclerView.Adapter<YoutubeVideosAdapter.MyVideosViewHolder> {
    private List<VideoItem> videoItemsList;
    public static final int TYPE_NORMAL = 1;
    DisplayMetrics displayMetrics = new DisplayMetrics();
    private ClickManager clickManager;
    private Context context;

    public YoutubeVideosAdapter(Context context, ClickManager clickManager) {
        this.clickManager = clickManager;
        this.context = context;
        videoItemsList = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyVideosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyVideosViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_youtube_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyVideosViewHolder holder, int position) {
        holder.setBindData(videoItemsList.get(position));
    }

    @Override
    public int getItemCount() {
        return videoItemsList.size();
    }

    public interface ClickManager {
        void onItemClick(VideoItem videoItem, int pos);
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_NORMAL;
    }

    public void setList(List<VideoItem> youtubeVideos) {
        if (youtubeVideos == null) {
            return;
        }
        videoItemsList.clear();
        videoItemsList.addAll(youtubeVideos);
        notifyDataSetChanged();

    }

    public class MyVideosViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewTitle)
        TextView textWaveTitle;
        @BindView(R.id.btnPlay)
        ImageView playButton;

        @BindView(R.id.imageViewItem)
        ImageView imageViewItems;
        @BindView(R.id.youtube_view)
        YouTubePlayerView youTubePlayerView;

        public MyVideosViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (clickManager != null) {
                        clickManager.onItemClick(videoItemsList.get(pos), pos);
                    }
                }
            });
        }

        public void setBindData(VideoItem videoItem) {
            final VideoItem mYoutubeVideo = videoItem;
            ((Activity) itemView.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels;
            if (mYoutubeVideo.getVideoTitle() != null)
                textWaveTitle.setText(mYoutubeVideo.getVideoTitle());

            if (mYoutubeVideo.getImageUrl() != null) {
                Glide.with(itemView.getContext())
                        .load(mYoutubeVideo.getImageUrl()).thumbnail(0.5f)
                        .apply(new RequestOptions().override(width - 36, 200))
                        .into(imageViewItems);
            }
            imageViewItems.setVisibility(View.VISIBLE);
            playButton.setVisibility(View.VISIBLE);
            youTubePlayerView.setVisibility(View.GONE);

//            playButton.setOnClickListener(view -> {
//                imageViewItems.setVisibility(View.GONE);
//                youTubePlayerView.setVisibility(View.VISIBLE);
//                playButton.setVisibility(View.GONE);
//                youTubePlayerView.initialize(initializedYouTubePlayer -> initializedYouTubePlayer.addListener(new AbstractYouTubePlayerListener() {
//                    @Override
//                    public void onReady() {
//                        initializedYouTubePlayer.loadVideo(mYoutubeVideo.getVideoId(), 0);
//                    }
//                }), true);
//            });
        }
    }
}
