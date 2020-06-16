package com.example.moaleminternsip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class VedioAdapter extends RecyclerView.Adapter<VedioAdapter.ViewHolder> {
    private Context context;
    private List<VedioModel> videoList;
    private ViewHolder.OnVideoListener onVideoListener;
    VedioAdapter(Context context, List<VedioModel> videoList, ViewHolder.OnVideoListener onVideoListener) {
        this.context = context;
        this.videoList = videoList;
        this.onVideoListener=onVideoListener;
    }

    @NonNull
    @Override
    public VedioAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.video_item,parent,false);
        return new ViewHolder(view,onVideoListener);
    }

    @Override
    public void onBindViewHolder(@NonNull VedioAdapter.ViewHolder holder, int position) {
        VedioModel vedioModel=videoList.get(position);
        holder.linearLayout.setBackgroundResource(vedioModel.getBackGround());
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private OnVideoListener onVideoListener;
        LinearLayout linearLayout;
        ViewHolder(@NonNull View itemView,OnVideoListener onVideoListener) {
            super(itemView);
            linearLayout =itemView.findViewById(R.id.background);
            this.onVideoListener=onVideoListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onVideoListener.onVideoClick(getAdapterPosition());
        }

        public interface OnVideoListener{
            void onVideoClick(int position);
        }
    }
}
