package com.example.viewpagerproba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class PageFragment extends Fragment {
	private String text;

	public PageFragment(String text) {
		this.text = text;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.page, container, false);

		TextView tv = (TextView)rootView.findViewById(R.id.page_text);
		tv.setText(this.text);

		return rootView;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		Log.e(getClass().getSimpleName(), "ON DESTROY");
	}
}
