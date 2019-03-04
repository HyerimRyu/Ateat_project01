package kr.co.teada.ateat_project01;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderLayout;

import java.util.ArrayList;

public class RecyvAdapter extends RecyclerView.Adapter {

    //1. 대량의 데이터 참조변수
    ArrayList<RecvItems> recvItems;
    AteFragment context;

    //생성자 alt + insert
    public RecyvAdapter(ArrayList<AteFragItem> recvItems, LayoutInflater context) {
        this.recvItems = recvItems;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        //recycler_item 을 View 객체로 만들기
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View itemView=inflater.inflate(R.layout.item_detail_frag_ate, viewGroup, false);

        //VH(뷰홀터) 객체 생성


        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        VH holder=(VH)viewHolder;
        holder.tv_res_name.setText("");
        holder.tv_main.setText("");
        holder.tv_hash.setText("");
        holder.iv_food_pic.setImageResource(R.drawable.bg_overlay);
    }

    @Override
    public int getItemCount() { return recvItems.size(); }


    //VH inner class
    class VH extends RecyclerView.ViewHolder{

        ImageView iv_food_pic;
        //SliderLayout imageSlider;
        TextView tv_res_name;
        TextView tv_main;
        TextView tv_hash;


        public VH(@NonNull View itemView) {
            super(itemView);

            iv_food_pic=itemView.findViewById(R.id.iv_food_pic);
            //imageSlider=itemView.findViewById(R.id.imageSlider);
            tv_res_name=itemView.findViewById(R.id.tv_res_name);
            tv_main=itemView.findViewById(R.id.tv_main);
            tv_hash=itemView.findViewById(R.id.tv_hash);

            //항목 클릭 리스너 추가
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //사진 눌렀을 때 상세 Activity 이동
                 //   Intent intent=new Intent(context,PicDetailActivity.class);
                }
            });

        }


    }//end of class VH


















}//end of RecyvAdapter
