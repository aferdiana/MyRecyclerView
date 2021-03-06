package io.github.aferdiana.myrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class QueenDiscography implements Parcelable {
    private String title, albumDetail, cover, certification, story, song;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbumDetail() {
        return albumDetail;
    }

    public void setAlbumDetail(String albumDetail) {
        this.albumDetail = albumDetail;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.albumDetail);
        dest.writeString(this.cover);
        dest.writeString(this.certification);
        dest.writeString(this.story);
        dest.writeString(this.song);
    }

    public QueenDiscography() {
    }

    protected QueenDiscography(Parcel in) {
        this.title = in.readString();
        this.albumDetail = in.readString();
        this.cover = in.readString();
        this.certification = in.readString();
        this.story = in.readString();
        this.song = in.readString();
    }

    public static final Creator<QueenDiscography> CREATOR = new Creator<QueenDiscography>() {
        @Override
        public QueenDiscography createFromParcel(Parcel source) {
            return new QueenDiscography(source);
        }

        @Override
        public QueenDiscography[] newArray(int size) {
            return new QueenDiscography[size];
        }
    };
}
