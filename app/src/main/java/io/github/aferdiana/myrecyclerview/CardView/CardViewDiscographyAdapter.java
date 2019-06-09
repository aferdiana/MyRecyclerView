package io.github.aferdiana.myrecyclerview.CardView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import io.github.aferdiana.myrecyclerview.CustomOnItemClickListener;
import io.github.aferdiana.myrecyclerview.QueenDiscography;
import io.github.aferdiana.myrecyclerview.R;

public class CardViewDiscographyAdapter extends RecyclerView.Adapter<CardViewDiscographyAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<QueenDiscography> listDiscography;

    public CardViewDiscographyAdapter(Context context) {
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
    public CardViewDiscographyAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_queen, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewDiscographyAdapter.CardViewViewHolder cardViewViewHolder, int i) {
        QueenDiscography p = getListDiscography().get(i);
        Glide.with(context)
                .load(p.getCover())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);
        cardViewViewHolder.tvTitle.setText(p.getTitle());
        cardViewViewHolder.tvDetail.setText(p.getAlbumDetail());
        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite "+getListDiscography().get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        }));
        cardViewViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListDiscography().get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListDiscography().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvTitle, tvDetail;
        Button btnFavorite, btnShare;
        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);;
        }
    }
}
