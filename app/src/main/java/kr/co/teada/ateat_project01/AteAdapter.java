package kr.co.teada.ateat_project01;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

//ex88 ChatAdapter 참고

public class AteAdapter extends RecyclerView.Adapter {

    ArrayList<AteFragItem> ateFragItems;
    LayoutInflater layoutInflater;

    //생성자:  커맨드+n
    public AteAdapter(ArrayList<AteFragItem> ateFragItems, LayoutInflater layoutInflater) {
        this.ateFragItems = ateFragItems;
        this.layoutInflater = layoutInflater;
    }



//    @Override
//    public int getCount() { return ateFragItems.size();}
//
//    @Override
//    public Object getItem(int position) { return ateFragItems.get(position); }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View itemView=layoutInflater.inflate(R.layout.item_detail_frag_ate, viewGroup, false);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public long getItemId(int position) { return position;}

    @Override
    public int getItemCount() {
        return 0;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        AteFragItem item=ateFragItems.get(position);
//
//        View itemView=null;
//
//        //바인드 연결
//        ImageView iv_food_pic=itemView.findViewById(R.id.iv_food_pic);
//        TextView tv_res_name=itemView.findViewById(R.id.tv_res_name);
//        TextView tv_main=itemView.findViewById(R.id.tv_main);
//        TextView tv_hash=itemView.findViewById(R.id.tv_hash);
//
//        tv_res_name.setText(item.getResName());
//        tv_main.setText(item.getMsg());
//        tv_hash.setText(item.getHash());
//
//        Glide.with(itemView).load(item.getFoodPic_Url()).into(iv_food_pic);
//
//        return itemView;
//    }
}
