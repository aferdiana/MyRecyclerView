package io.github.aferdiana.myrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.aferdiana.myrecyclerview.CardView.CardViewDiscographyAdapter;
import io.github.aferdiana.myrecyclerview.GridView.GridDiscographyAdapter;
import io.github.aferdiana.myrecyclerview.ListView.ListDiscographyAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvCategory;
    private ArrayList<QueenDiscography> list;
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState == null) {
            setActionBarTitle("Mode List");
            list.addAll(DataDiscography.getListData());
            showRecyclerList();
            mode = R.id.action_list;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<QueenDiscography> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }

    }

    private void showSelectedAlbum(QueenDiscography discography) {
        Toast.makeText(this, "Kamu memilih " + discography.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private void showDetailAlbum(QueenDiscography discography) {
        QueenDiscography album = new QueenDiscography();
        album.setTitle(discography.getTitle());
        album.setAlbumDetail(discography.getAlbumDetail());
        album.setCover(discography.getCover());
        album.setCertification(discography.getCertification());
        Intent x = new Intent(this, ActivityDetail.class);
        x.putExtra("album_extra", album);
        startActivity(x);
    }


    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        final ListDiscographyAdapter listDiscographyAdapter = new ListDiscographyAdapter(this);
        listDiscographyAdapter.setListDiscography(list);
        rvCategory.setAdapter(listDiscographyAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showDetailAlbum(list.get(position));
            }
        });
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridDiscographyAdapter gridDiscographyAdapter = new GridDiscographyAdapter(this);
        gridDiscographyAdapter.setListDiscography(list);
        rvCategory.setAdapter(gridDiscographyAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedAlbum(list.get(position));
            }
        });
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewDiscographyAdapter cardViewDiscographyAdapter = new CardViewDiscographyAdapter(this);
        cardViewDiscographyAdapter.setListDiscography(list);
        rvCategory.setAdapter(cardViewDiscographyAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }

}
