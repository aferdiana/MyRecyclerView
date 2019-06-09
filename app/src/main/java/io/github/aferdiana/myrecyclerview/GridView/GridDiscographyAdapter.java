package io.github.aferdiana.myrecyclerview.GridView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import io.github.aferdiana.myrecyclerview.QueenDiscography;
import io.github.aferdiana.myrecyclerview.R;

public class GridDiscographyAdapter extends RecyclerView.Adapter<GridDiscographyAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<QueenDiscography> listDiscography;

    public GridDiscographyAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<QueenDiscography> getListDiscography() {
        return listDiscography;
    }

    public void setListDiscography(ArrayList<QueenDiscography> listDiscography) {
        this.listDiscography = listDiscography;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_queen, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListDiscography().get(position).getCover())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListDiscography().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
