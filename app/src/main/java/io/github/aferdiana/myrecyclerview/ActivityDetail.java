package io.github.aferdiana.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ActivityDetail extends AppCompatActivity {
    private TextView title, detail, certification, story;
    private ImageView cover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title         = findViewById(R.id.tv_title);
        detail        = findViewById(R.id.tv_detail);
        cover         = findViewById(R.id.img_cover);
        certification = findViewById(R.id.tv_certification);
        story         = findViewById(R.id.tv_story);

        showIntentObject();
    }


    private void showIntentObject(){
        QueenDiscography queenDiscography = getIntent().getParcelableExtra("album_extra");

        String album_title  = queenDiscography.getTitle();
        String album_detail = queenDiscography.getAlbumDetail();
        String album_certification = queenDiscography.getCertification();
        String album_story = queenDiscography.getStory();

        title.setText(album_title);
        detail.setText(album_detail);
        certification.setText(album_certification);
        story.setText(album_story);
        setCoverAlbum();

    }

    private void setCoverAlbum(){
        QueenDiscography queenDiscography = getIntent().getParcelableExtra("album_extra");
        String img = queenDiscography.getCover();
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);

        Glide.with(this).load(img).apply(options).into(cover);
    }

}
