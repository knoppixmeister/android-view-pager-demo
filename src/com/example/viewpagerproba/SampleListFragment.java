package com.example.viewpagerproba;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SampleListFragment extends ListFragment {
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		setListAdapter(new SampleListAdapter(getActivity()));
	}

	class SampleListAdapter extends BaseAdapter {
		protected Context ctx;
		protected LayoutInflater inflater;

		public SampleListAdapter(Context ctx) {
			this.ctx = ctx;
			this.inflater = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			return 20;
		}

		@Override
		public Object getItem(int id) {
			return id;
		}

		@Override
		public long getItemId(int id) {
			return id;
		}

		@Override
		public View getView(int id, View view, ViewGroup viewGroup) {
			view = this.inflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);

			((TextView)view.findViewById(android.R.id.text1)).setText("POS: "+id);

			return view;
		}
	}
}
