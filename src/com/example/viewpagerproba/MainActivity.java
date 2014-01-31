package com.example.viewpagerproba;

import android.os.*;
import android.support.v4.app.*;
import android.support.v4.view.*;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.*;

public class MainActivity extends ActionBarActivity {
	private static final int NUM_PAGES = 5;

	private PagerAdapter mPagerAdapter;
	private ViewPager mPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mPager = (ViewPager)findViewById(R.id.pager);
		mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());	
		mPager.setAdapter(mPagerAdapter);

		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case R.id.action_prev:		if(mPager.getCurrentItem() > 0) {
											mPager.setCurrentItem(mPager.getCurrentItem()-1);
										}
										return true;

			case R.id.action_next:		if(mPager.getCurrentItem() < NUM_PAGES) {
											mPager.setCurrentItem(mPager.getCurrentItem()+1);
										}
										return true;

			default:					return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected void onStop() {
		super.onStop();

		Log.e(this.getClass().getSimpleName(), "on STOP");
	}

	@Override
	protected void onResume() {
		super.onResume();

		Log.e(getClass().getSimpleName(), "on RESUME");
	}

	@Override
	protected void onDestroy() {
		Log.e(getClass().getSimpleName(), "on DESTROY");

		super.onDestroy();
	}

	@Override
	protected void onRestart() {
		super.onRestart();

		Log.e(getClass().getSimpleName(), "ON RESTART");
	}

	public void onBackPressed() {
		if(mPager.getCurrentItem() == 0) super.onBackPressed();
		else mPager.setCurrentItem(mPager.getCurrentItem()-1);
	}

	private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
		public ScreenSlidePagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
        public Fragment getItem(int position) {
			if(position == 2) return new SampleListFragment();
			else return new PageFragment("POS: "+position);
        }

		@Override
		public int getCount() {
			return NUM_PAGES;
		}
    }
}
