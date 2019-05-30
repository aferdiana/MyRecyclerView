package io.github.aferdiana.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ActivityDetail extends AppCompatActivity {
    private TextView title, detail, certification, story, song;
    private ImageView cover;
    private Button share;
    final String STATE_TITLE = "state_string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title         = findViewById(R.id.tv_title);
        detail        = findViewById(R.id.tv_detail);
        cover         = findViewById(R.id.img_cover);
        certification = findViewById(R.id.tv_certification);
        story         = findViewById(R.id.tv_story);
        song          = findViewById(R.id.tv_song);

        share = findViewById(R.id.btn_share);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "SHARE", Toast.LENGTH_SHORT).show();
            }
        });

        showIntentObject();
    }


    private void showIntentObject(){
        QueenDiscography queenDiscography = getIntent().getParcelableExtra("album_extra");

        String album_title          = queenDiscography.getTitle();
        String album_detail         = queenDiscography.getAlbumDetail();
        String album_certification  = queenDiscography.getCertification();
        String album_story          = queenDiscography.getStory();
        String album_song           = queenDiscography.getSong();

        title.setText(album_title);
        setActionBarTitle(album_title);
        detail.setText(album_detail);
        certification.setText(album_certification);
        story.setText(album_story);
        setCoverAlbum();
        song.setText(album_song);

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

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


}
