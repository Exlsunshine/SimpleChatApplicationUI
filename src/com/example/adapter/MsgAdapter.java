package com.example.adapter;

import java.util.List;

import com.example.msg.msgtext;
import com.example.scrollertext.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MsgAdapter extends BaseAdapter {

	private static final String DEBUG_TAG = "MsgAdapter______";
	private List<msgtext> list = null;
	private Context mContext;
	private LayoutInflater inflater = null;
	private String realSender = null;

	public MsgAdapter(Context context, List<msgtext> list, String realSender) {

		this.mContext = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
		this.realSender = realSender;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public void remove(int position) {
		list.remove(position);
		notifyDataSetChanged();

	}

	public void add(msgtext msg) {
		list.add(msg);
		notifyDataSetChanged();

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;

		if (convertView == null) {

			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.talklist, null);
			holder.getterItem = (TextView) convertView
					.findViewById(R.id.getterItem);
			holder.senderItem = (TextView) convertView
					.findViewById(R.id.senderItem);
			holder.getterImage = (ImageView) convertView
					.findViewById(R.id.getterImage);
			holder.senderImage = (ImageView) convertView
					.findViewById(R.id.senderImage);
			holder.left_layout = (RelativeLayout) convertView
					.findViewById(R.id.left_layout);
			holder.right_layout = (RelativeLayout) convertView
					.findViewById(R.id.right_layout);
			holder.talk_time = (TextView) convertView.findViewById(R.id.talk_time);
			convertView.setTag(holder);

		} else {

			holder = (ViewHolder) convertView.getTag();
		}

		holder.right_layout.setVisibility(View.VISIBLE);
		holder.left_layout.setVisibility(View.VISIBLE);
		holder.talk_time.setVisibility(View.VISIBLE);

		if (realSender.equals(list.get(position).getreceiver())) {
			holder.left_layout.setVisibility(View.GONE);
			holder.senderItem.setText("  "
					+ this.list.get(position).getmsg().toString() + "  ");
			holder.senderImage.setImageBitmap(this.list.get(position)
					.getsenderView());
			holder.talk_time
			.setText(this.list.get(position).gettime().toString());
		} else if (realSender.equals(list.get(position).getsender())) {
			holder.right_layout.setVisibility(View.GONE);
			holder.getterItem.setText("  "
					+ this.list.get(position).getmsg().toString() + "  ");
			holder.getterImage.setImageBitmap(this.list.get(position)
					.getreceiverView());
			holder.talk_time
					.setText(this.list.get(position).gettime().toString());
		} else {
			holder.right_layout.setVisibility(View.GONE);
			holder.left_layout.setVisibility(View.GONE);
			holder.talk_time.setVisibility(View.GONE);
		}

		AlphaAnimation alpha = new AlphaAnimation(0, 1);
		alpha.setDuration(1000);
		
		return convertView;
	}

	final static class ViewHolder {

		TextView getterItem;
		TextView senderItem;
		ImageView getterImage;
		ImageView senderImage;
		RelativeLayout right_layout;
		RelativeLayout left_layout;
		TextView talk_time;

	}

}
