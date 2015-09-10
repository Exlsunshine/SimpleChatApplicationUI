package com.example.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.scrollertext.R;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Interpolator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private static final String DEBUG_TAG = "MyAdapter______";
	private List<String> list = null;
	private Context mContext;
	private LayoutInflater inflater = null;
	private List<String> list1 = new ArrayList<String>();
	private List<String> list2 = new ArrayList<String>();
	private List<Bitmap> list3 = new ArrayList<Bitmap>();
	private  int viewWidth = 0; 
	private int firstVisibleItem;
	private int visibleItemCount;
	private int lastIndex = -1;
	
	
	public MyAdapter(Context context, List<String> list, List<String> list1,
			List<String> list2, List<Bitmap> list3) {

		this.mContext = context;
		this.list = list;
		this.list1 = list1;
		this.list2 = list2;
		this.list3 = list3;
		inflater = LayoutInflater.from(context);
		
		this.mContext.registerReceiver(broadcastReceiver, intentFilter());
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
		list1.remove(position);
		list2.remove(position);
		list3.remove(position);
		notifyDataSetChanged();

	}
	
	public int viewWidth() {
		// TODO Auto-generated method stub
		return this.viewWidth;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		ViewHolder holder = null;

		if (convertView == null) {

			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.list_text, null);
			holder.tvTitle = (TextView) convertView
					.findViewById(R.id.list_item);
			holder.tvTitle1 = (TextView) convertView
					.findViewById(R.id.list_item1);
			holder.tvTitle2 = (TextView) convertView
					.findViewById(R.id.list_item2);
			holder.btnIM = (ImageView) convertView.findViewById(R.id.picture);
			holder.btnDel = (ImageView) convertView.findViewById(R.id.button);
			holder.btnDel1 = (ImageView) convertView.findViewById(R.id.button1);
			holder.ll = (LinearLayout) convertView.findViewById(R.id.list1);
			viewWidth =holder.btnDel.getWidth();
			holder.ll.scrollTo(0, 0);
			convertView.setTag(holder);

		} else {

			holder = (ViewHolder) convertView.getTag();
		}

		holder.tvTitle.setText(this.list.get(position));
		holder.tvTitle1.setText(this.list1.get(position));
		holder.tvTitle2.setText(this.list2.get(position));
		holder.btnIM.setImageBitmap(this.list3.get(position));

		
		int innerAnimationDuration = 100;
		if (position > firstVisibleItem || (position == 0 && firstVisibleItem == 0))
		{
			TranslateAnimation translate = new TranslateAnimation(-3000, 0, 0, 0);
			
			int delay = (position - firstVisibleItem - visibleItemCount + 3) * innerAnimationDuration;
			
			if (delay <= 0)
				delay = 800;
			else
				delay += 800;

			Log.i(DEBUG_TAG, "Delay is " + String.valueOf(delay) + "Position is " + String.valueOf(position - firstVisibleItem - visibleItemCount + 1));

			translate.setDuration(delay);
			convertView.startAnimation(translate);
		}
		else
		{
			TranslateAnimation translate = new TranslateAnimation(3000, 0, 0, 0);
			
			int delay = (firstVisibleItem - position) * innerAnimationDuration;
			
			if (delay <= 0)
				delay = 800;
			else
				delay += 800;

			Log.i(DEBUG_TAG, "Delay is " + String.valueOf(delay) + "Position is " + String.valueOf(position - firstVisibleItem - visibleItemCount + 1));

			translate.setDuration(delay);
			convertView.startAnimation(translate);
		}
		
		return convertView;
	}

	final static class ViewHolder {

		TextView tvTitle;
		TextView tvTitle1;
		TextView tvTitle2;
		ImageView btnIM;
		ImageView btnDel;
		ImageView btnDel1;
		LinearLayout ll;

	}
	
	private IntentFilter intentFilter()
	{
		IntentFilter filter = new IntentFilter();
		filter.addAction("firstVisibleItem");
		
		return filter;		
	}
	
	private BroadcastReceiver broadcastReceiver = new BroadcastReceiver()
	{
		@Override
		public void onReceive(Context context, Intent intent)
		{
			if ((intent.getAction().equals("firstVisibleItem")))
			{
				firstVisibleItem = intent.getIntExtra("firstVisibleItem", 0);
				visibleItemCount = intent.getIntExtra("visibleItemCount", 0);
			}
		}
	};
}
