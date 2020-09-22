package com.example.myapplicationcodegama.pojo;

public class VideoItem {
    private String videoTitle;
    private String id;
    private String videoId;
    private String imageUrl;

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public VideoItem(String videoTitle, String id, String videoId, String imageUrl) {
        this.videoTitle = videoTitle;
        this.id = id;
        this.videoId = videoId;
        this.imageUrl = imageUrl;
    }
}
