package com.example.scrollertext;

import java.util.ArrayList;
import java.util.List;
import com.example.adapter.MyAdapter;
import com.example.scrollertext.FinalListView.OnRefreshListener;
import com.example.scrollertext.FinalListView.RemoveListener;
import com.example.translate.CircleBitmap;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements RemoveListener, OnRefreshListener 
{
	private static final String DEBUG_TAG = "MainActivity______";
	private int firstVisibleItem;
	private int visibleItemCount;
	
	
	List<String> userNmae = new ArrayList<String>();
	List<String> lastMsg = new ArrayList<String>();
	List<String> date = new ArrayList<String>();
	List<Bitmap> portrait = new ArrayList<Bitmap>();
	MyAdapter myAdapter = null;
	FinalListView finalListView = null;
	Bitmap bmp;
	Scroller scroller = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		finalListView = (FinalListView) super.findViewById(R.id.listview);
		finalListView.setRemoveListener(this);

		userNmae.add("1～欢乐百世客服酱～");
		userNmae.add("2恋绝世柔情");
		userNmae.add("3热爱生命");
		userNmae.add("4文艺青年");
		userNmae.add("5先生你凭什么那么帅气");
		userNmae.add("6艾利");
		userNmae.add("7爱在帝都");
		userNmae.add("8浅岸");
		userNmae.add("9Volim Te");
		userNmae.add("10和平使者");
		userNmae.add("11卡哇伊");
		userNmae.add("12情末末");
		userNmae.add("13珍惜");
		userNmae.add("14再见就再见");
		userNmae.add("15扯淡的青春～");
		userNmae.add("16～欢乐百世客服酱～");
		userNmae.add("17恋绝世柔情");
		userNmae.add("18热爱生命");
		userNmae.add("19文艺青年");
		userNmae.add("20先生你凭什么那么帅气");
		userNmae.add("21艾利");
		userNmae.add("22爱在帝都");
		userNmae.add("23浅岸");
		userNmae.add("24Volim Te");
		userNmae.add("25和平使者");
		userNmae.add("26卡哇伊");
		userNmae.add("27情末末");
		userNmae.add("28珍惜");
		userNmae.add("29再见就再见");
		userNmae.add("30扯淡的青春～");

		lastMsg.add("2月14日-2月25日休息");
		lastMsg.add("也许下个冬天,也许还十年");
		lastMsg.add("黄金时代");
		lastMsg.add("为什么QQ老是中毒");
		lastMsg.add("0 0");
		lastMsg.add("努力工作");
		lastMsg.add("我只不过让你毫无收敛地占据心而已");
		lastMsg.add("让阅读成为我生命中的一部分");
		lastMsg.add("新号 1580105640");
		lastMsg.add("找自己");
		lastMsg.add("又不能早起了");
		lastMsg.add("陪你到永久");
		lastMsg.add("衣带渐宽终不悔");
		lastMsg.add("两情相悦久长时");
		lastMsg.add("让我爱上你不是不可以,而是有点事情要处");
		lastMsg.add("2月14日-2月25日休息");
		lastMsg.add("也许下个冬天,也许还十年");
		lastMsg.add("黄金时代");
		lastMsg.add("为什么QQ老是中毒");
		lastMsg.add("0 0");
		lastMsg.add("努力工作");
		lastMsg.add("我只不过让你毫无收敛地占据心而已");
		lastMsg.add("让阅读成为我生命中的一部分");
		lastMsg.add("新号 1580105640");
		lastMsg.add("找自己");
		lastMsg.add("又不能早起了");
		lastMsg.add("陪你到永久");
		lastMsg.add("衣带渐宽终不悔");
		lastMsg.add("两情相悦久长时");
		lastMsg.add("让我爱上你不是不可以,而是有点事情要处");

		date.add("2015-02-01");
		date.add("2014-12-21");
		date.add("2013-07-09");
		date.add("2014-05-02");
		date.add("2013-02-13");
		date.add("2014-01-16");
		date.add("2013-07-09");
		date.add("2014-09-15");
		date.add("2015-07-15");
		date.add("2015-11-09");
		date.add("2014-12-09");
		date.add("2013-07-03");
		date.add("2014-11-29");
		date.add("2013-05-19");
		date.add("2014-03-09");
		date.add("2015-02-01");
		date.add("2014-12-21");
		date.add("2013-07-09");
		date.add("2014-05-02");
		date.add("2013-02-13");
		date.add("2014-01-16");
		date.add("2013-07-09");
		date.add("2014-09-15");
		date.add("2015-07-15");
		date.add("2015-11-09");
		date.add("2014-12-09");
		date.add("2013-07-03");
		date.add("2014-11-29");
		date.add("2013-05-19");
		date.add("2014-03-09");

		Resources res = getResources();
		bmp = BitmapFactory.decodeResource(res, R.drawable.www);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s1);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s2);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s3);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s4);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s5);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s6);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s7);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s8);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s9);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s10);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s11);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s12);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s13);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s14);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.www);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s1);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s2);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s3);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s4);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s5);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s6);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s7);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s8);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s9);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s10);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s11);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s12);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s13);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);
		bmp = BitmapFactory.decodeResource(res, R.drawable.s14);
		bmp = CircleBitmap.circleBitmap(bmp);
		portrait.add(bmp);

		myAdapter = new MyAdapter(this, userNmae, lastMsg, date, portrait);
		finalListView.setAdapter(myAdapter);
		this.finalListView.setOnItemClickListener(new OnItemClickListenerImpl());

		finalListView.setOnScrollListener(new OnScrollListener()
		{
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) 
			{
				if (scrollState == SCROLL_STATE_IDLE)
				{
					Log.i(DEBUG_TAG, "Idle");
					Log.i(DEBUG_TAG, "First visible item " + String.valueOf(firstVisibleItem));
					Log.i(DEBUG_TAG, "Visible item count " + String.valueOf(visibleItemCount));
					
					Intent intent = new Intent("firstVisibleItem");
					intent.putExtra("firstVisibleItem", firstVisibleItem);
					intent.putExtra("visibleItemCount", visibleItemCount);
					sendBroadcast(intent );
				}
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) 
			{
				MainActivity.this.firstVisibleItem = firstVisibleItem;
				MainActivity.this.visibleItemCount = visibleItemCount;
			}
		});
		
		finalListView.setonRefreshListener(new OnRefreshListener()
		{
			public void onRefresh()
			{
				new AsyncTask<Void, Void, Void>()
				{
					protected Void doInBackground(Void... params) 
					{
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
							e.printStackTrace();
						}

						return null;
					}

					@Override
					protected void onPostExecute(Void result)
					{
						myAdapter.notifyDataSetChanged();
						finalListView.Refresh();
					}
				}.execute(null, null, null);

				new AsyncTask<Void, Void, Void>()
				{
					protected Void doInBackground(Void... params) 
					{
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}

						return null;
					}

					@Override
					protected void onPostExecute(Void result) 
					{
						finalListView.onRefreshComplete();
					}
				}.execute(null, null, null);
			}
		});
	}

	public class OnItemClickListenerImpl implements OnItemClickListener
	{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			String ab = (String) myAdapter.getItem(position - 2);
			Intent it1 = new Intent(MainActivity.this, Talk.class);
			it1.putExtra("reveiewer", ab);
			MainActivity.this.startActivity(it1);
		}
	}

	public void removeItem(int position, int id)
	{
		if (id == 0)
			Toast.makeText(this, "没有呼叫功能", Toast.LENGTH_SHORT).show();
		else 
			myAdapter.remove(position - 2);
	}

	@Override
	public void onRefresh() { }
}