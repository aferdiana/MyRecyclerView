package io.github.aferdiana.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import io.github.aferdiana.myrecyclerview.GridView.GridDiscographyAdapter;
import io.github.aferdiana.myrecyclerview.ListView.ListDiscographyAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<QueenDiscography> list = new ArrayList<>();
    private String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(DataDiscography.getListData());
        showRecyclerList();


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListDiscographyAdapter listDiscographyAdapter = new ListDiscographyAdapter(this);
        listDiscographyAdapter.setListDiscography(list);
        rvCategory.setAdapter(listDiscographyAdapter);
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridDiscographyAdapter gridDiscographyAdapter = new GridDiscographyAdapter(this);
        gridDiscographyAdapter.setListDiscography(list);
        rvCategory.setAdapter(gridDiscographyAdapter);
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewDiscographyAdapter cardViewPresidentAdapter = new CardViewDiscographyAdapter(this);
        cardViewPresidentAdapter.setListDiscography(list);
        rvCategory.setAdapter(cardViewPresidentAdapter);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list:
                setActionBarTitle("Mode List");
                showRecyclerList();
                break;
            case R.id.action_grid:
                setActionBarTitle("Mode List");
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                setActionBarTitle("Mode List");
                showRecyclerCardView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
