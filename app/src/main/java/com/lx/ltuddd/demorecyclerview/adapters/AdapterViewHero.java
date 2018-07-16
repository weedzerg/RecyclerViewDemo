package com.lx.ltuddd.demorecyclerview.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lx.ltuddd.demorecyclerview.R;
import com.lx.ltuddd.demorecyclerview.objects.HeroObject;

import java.util.ArrayList;

/**
 * Created by DaiPhongPC on 7/16/2018.
 */

public class AdapterViewHero extends RecyclerView.Adapter<AdapterViewHero.ViewHolderHero> {
    private Context mContext;
    private ArrayList<HeroObject> mArrHero;

    public AdapterViewHero(Context mContext, ArrayList<HeroObject> mArrHero) {
        this.mContext = mContext;
        this.mArrHero = mArrHero;
    }

    @NonNull
    @Override
    public ViewHolderHero onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_hero, parent, false);
        return new ViewHolderHero(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderHero holder, int position) {
        HeroObject heroObject = getItem(position);
        holder.nameHero.setText(heroObject.getName());
        Glide.with(mContext)
                .load(heroObject.getIdAvatar())
                .into(holder.avatarHero);
    }

    @Override
    public int getItemCount() {
        return mArrHero.size();
    }

    public HeroObject getItem(int position) {
        return mArrHero.get(position);
    }

    public class ViewHolderHero extends RecyclerView.ViewHolder {
        TextView nameHero;
        ImageView avatarHero;

        public ViewHolderHero(View itemView) {
            super(itemView);
            nameHero = (TextView) itemView.findViewById(R.id.name);
            avatarHero = (ImageView) itemView.findViewById(R.id.avatar);
        }
    }
}
