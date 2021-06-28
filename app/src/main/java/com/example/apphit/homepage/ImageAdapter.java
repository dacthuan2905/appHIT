package com.example.apphit.homepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphit.R;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<Image> images;
    public void setData(List<Image> list){
        this.images=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_homepage,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Image image =images.get(position);
        if(image ==null){
            return;

        }
        holder.imageHP.setImageResource(image.getResourceID());
        holder.tvtitle.setText(image.getTitle());
    }

    @Override
    public int getItemCount() {
        if (images !=null){
            return images.size();
        }
        return 0;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageHP;
        private TextView tvtitle;

        public ImageViewHolder(@NonNull View itemView) {

            super(itemView);
            imageHP=itemView.findViewById(R.id.img_homepage);
            tvtitle=itemView.findViewById(R.id.tv_title);

        }
    }
}
