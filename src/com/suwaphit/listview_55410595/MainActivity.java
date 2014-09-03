package com.suwaphit.listview_55410595;

import java.util.ArrayList;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.service.dreams.DreamService;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ListAdapter adapter;
	private ListView listview;
	private ArrayList<List_items> itemList;
	private int[] drawable = { R.drawable.facebook, R.drawable.google_plush,
			R.drawable.twitter, R.drawable.youtube };
	private String[] title = { "Facebook", "Google+", "Twitter", "Youtube" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		listview = (ListView) findViewById(R.id.listView1);		
		itemList = new ArrayList<List_items>();	
		
		
		//add data
		for (int i = 0; i < drawable.length; i++) {
			List_items listItems = new List_items();
			listItems.setTitle(title[i]);
			listItems.setDrawable(getResources().getDrawable(drawable[i]));
			itemList.add(listItems);

		}
				
		
		adapter = new Myadapter();
		listview.setAdapter(adapter);
			

	}// End OnCreate

	private class Myadapter extends BaseAdapter {
		private Holder holder;

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return itemList.size();
			
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			// TODO Auto-generated method stub
			view = LayoutInflater.from(getApplicationContext()).inflate
					(R.layout.listview_item, null);
			
			holder = new Holder();
			holder.imagerView = (ImageView)view.findViewById(R.id.item);
			holder.txt1 = (TextView)view.findViewById(R.id.item_txt1);
				
				if (itemList.get(position).getTitle()!= null) {
					 holder.txt1.setText(itemList.get(position).getTitle());
				 }
				 if (itemList.get(position).getDrawable()!= null) {
					 holder.imagerView.setImageDrawable(itemList.get(position).getDrawable());
			}
			
			return view;
		}

	}
	public class Holder {
		public ImageView imagerView ;
		public TextView txt1 ;
		
	}
	
}// End Class
