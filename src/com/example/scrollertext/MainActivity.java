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

		userNmae.add("1�����ְ����ͷ�����");
		userNmae.add("2����������");
		userNmae.add("3�Ȱ�����");
		userNmae.add("4��������");
		userNmae.add("5������ƾʲô��ô˧��");
		userNmae.add("6����");
		userNmae.add("7���ڵ۶�");
		userNmae.add("8ǳ��");
		userNmae.add("9Volim Te");
		userNmae.add("10��ƽʹ��");
		userNmae.add("11������");
		userNmae.add("12��ĩĩ");
		userNmae.add("13��ϧ");
		userNmae.add("14�ټ����ټ�");
		userNmae.add("15�������ഺ��");
		userNmae.add("16�����ְ����ͷ�����");
		userNmae.add("17����������");
		userNmae.add("18�Ȱ�����");
		userNmae.add("19��������");
		userNmae.add("20������ƾʲô��ô˧��");
		userNmae.add("21����");
		userNmae.add("22���ڵ۶�");
		userNmae.add("23ǳ��");
		userNmae.add("24Volim Te");
		userNmae.add("25��ƽʹ��");
		userNmae.add("26������");
		userNmae.add("27��ĩĩ");
		userNmae.add("28��ϧ");
		userNmae.add("29�ټ����ټ�");
		userNmae.add("30�������ഺ��");

		lastMsg.add("2��14��-2��25����Ϣ");
		lastMsg.add("Ҳ���¸�����,Ҳ��ʮ��");
		lastMsg.add("�ƽ�ʱ��");
		lastMsg.add("ΪʲôQQ�����ж�");
		lastMsg.add("0 0");
		lastMsg.add("Ŭ������");
		lastMsg.add("��ֻ�����������������ռ���Ķ���");
		lastMsg.add("���Ķ���Ϊ�������е�һ����");
		lastMsg.add("�º� 1580105640");
		lastMsg.add("���Լ�");
		lastMsg.add("�ֲ���������");
		lastMsg.add("���㵽����");
		lastMsg.add("�´������ղ���");
		lastMsg.add("�������þó�ʱ");
		lastMsg.add("���Ұ����㲻�ǲ�����,�����е�����Ҫ��");
		lastMsg.add("2��14��-2��25����Ϣ");
		lastMsg.add("Ҳ���¸�����,Ҳ��ʮ��");
		lastMsg.add("�ƽ�ʱ��");
		lastMsg.add("ΪʲôQQ�����ж�");
		lastMsg.add("0 0");
		lastMsg.add("Ŭ������");
		lastMsg.add("��ֻ�����������������ռ���Ķ���");
		lastMsg.add("���Ķ���Ϊ�������е�һ����");
		lastMsg.add("�º� 1580105640");
		lastMsg.add("���Լ�");
		lastMsg.add("�ֲ���������");
		lastMsg.add("���㵽����");
		lastMsg.add("�´������ղ���");
		lastMsg.add("�������þó�ʱ");
		lastMsg.add("���Ұ����㲻�ǲ�����,�����е�����Ҫ��");

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
			Toast.makeText(this, "û�к��й���", Toast.LENGTH_SHORT).show();
		else 
			myAdapter.remove(position - 2);
	}

	@Override
	public void onRefresh() { }
}