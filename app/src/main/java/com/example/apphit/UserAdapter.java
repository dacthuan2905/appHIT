//package com.example.apphit;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.ramotion.foldingcell.FoldingCell;
//
//import java.util.List;
//
//public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
//    List<User> list;
//
//    public void setData(List<User> list){
//        this.list = list;
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        User user = list.get(position);
//        if(user == null){
//            return;
//        }
//
//
//        holder.Name.setText(user.getName());
//        holder.StudentCode.setText(user.getStudentCode());
//        holder.PhoneNumber.setText(user.getPhoneNumber());
//        holder.Permission.setText(user.getPermission());
//        holder.Email.setText(user.getEmail());
//
//
//        //
//        holder.foldingCell.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                holder.foldingCell.toggle(false);
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        if(list != null)
//            return list.size();
//        return 0;
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        FoldingCell foldingCell;
//        TextView Name;
//        TextView StudentCode,Permission,PhoneNumber,Email,PassWord;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            foldingCell = itemView.findViewById(R.id.folding_cell);
//
//        }
//    }
//
//}