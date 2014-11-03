package org.jimmy.swiperefreshlayoutdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity implements
		SwipeRefreshLayout.OnRefreshListener {

	private SwipeRefreshLayout swipeLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);

		swipeLayout.setOnRefreshListener(this);
		System.out.println(swipeLayout.isRefreshing());

		swipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
				android.R.color.holo_green_light,
				android.R.color.holo_orange_light,
				android.R.color.holo_red_light);

	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		if (swipeLayout.isRefreshing()) {
			System.out.println("isRefreshing");
			return;
		}
		System.out.println("onRefresh");
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				swipeLayout.setRefreshing(false);
			}
		}, 5000);

	}
}
