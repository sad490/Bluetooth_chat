package com.example.sad490.cool_cv.ChatRoom;

import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sad490.cool_cv.R;

import java.util.List;

/**
 * Created by sad490 on 17-9-29.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Msg> mMsgLists;

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout left_layout;
        LinearLayout right_layhout;

        TextView leftMsg;
        TextView rightMsg;

        public ViewHolder(View view){
            super(view);
            left_layout = (LinearLayout)view.findViewById(R.id.left_layout);
            right_layhout = (LinearLayout)view.findViewById(R.id.right_layout);
            leftMsg = (TextView)view.findViewById(R.id.left_msg);
            rightMsg = (TextView)view.findViewById(R.id.right_msg);
        }
    }

    public MsgAdapter(List<Msg> msgList){
        mMsgLists = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.msg_item, parent, false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Msg msg = mMsgLists.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED) {
            holder.left_layout.setVisibility(View.VISIBLE);
            holder.right_layhout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        }else if (msg.getType() == Msg.TYPE_SENT) {
            holder.right_layhout.setVisibility(View.VISIBLE);
            holder.left_layout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgLists.size();
    }
}
