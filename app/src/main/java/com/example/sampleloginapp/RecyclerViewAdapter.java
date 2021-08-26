package com.example.sampleloginapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampleloginapp.databinding.ItemBinding;

import java.text.MessageFormat;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Post> list;

    public RecyclerViewAdapter(List<Post> list) {
        if(list!= null){
            Utils.orderList(list);
        }
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mItem = list.get(position);
        holder.tvPostId.setText(MessageFormat.format("Post #{0}", String.valueOf(holder.mItem.getId())));
        holder.tvUserId.setText(MessageFormat.format("Posted by user #{0}", String.valueOf(holder.mItem.getUserId())));
        holder.tvMessage.setText(holder.mItem.getTitle());
        if(holder.mItem.getCompleted()){
            holder.ivCheck.setImageResource(R.drawable.ic_check_box);
        } else{
            holder.ivCheck.setImageResource(R.drawable.iccheck_box_outline);
        }
    }

    @Override
    public int getItemCount() {
        if(list != null)
            return list.size();
        else
            return 0;
    }

    public void setData(List<Post> postsList){
        this.list = postsList;

        notifyItemInserted(postsList.size() + 1);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final View mView;
        public final TextView tvPostId;
        public final TextView tvUserId;
        public final TextView tvMessage;
        public final ImageView ivCheck;
        public Post mItem;
        public ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            mView = binding.item;
            tvPostId = binding.textViewPostId;
            tvUserId = binding.textViewUserId;
            tvMessage = binding.textViewMessage;
            ivCheck = binding.imageViewCheckmark;


        }
    }

}
