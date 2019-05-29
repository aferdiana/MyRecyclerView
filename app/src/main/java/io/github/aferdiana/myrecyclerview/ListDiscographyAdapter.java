package io.github.aferdiana.myrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListDiscographyAdapter extends RecyclerView.Adapter<ListDiscographyAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<QueenDiscography> listDiscography;

    public ListDiscographyAdapter(Context context) {
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
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_queen, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvTitle.setText(getListDiscography().get(position).getTitle());
        categoryViewHolder.tvDetail.setText(getListDiscography().get(position).getAlbumDetail());
        Glide.with(context)
                .load(getListDiscography().get(position).getCover())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListDiscography().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDetail;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            imgPhoto = itemView.findViewById(R.id.img_item_cover);
        }
    }


}
