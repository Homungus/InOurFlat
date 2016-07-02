package com.wlf.inourflat;

import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PointOfInterestActivity extends AppCompatActivity {

    private ViewPager pager = null;
    private ImagePagerAdapter pagerAdapter = null;

    public final static Integer[] imageResIds = new Integer[] {
            R.drawable.herd, R.drawable.kaffeemaschine
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_of_interest);

        pagerAdapter = new ImagePagerAdapter(getSupportFragmentManager(), imageResIds.length);
        pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        pager.setVisibility(View.VISIBLE);
        findViewById(R.id.progressBar).setVisibility(View.GONE);
        findViewById(R.id.textViewPoi).setVisibility(View.GONE);
        findViewById(R.id.textViewSearching).setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_locate:
                showMap();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showMap() {
        Intent intent = new Intent(this, IndoorsActivity.class);
        startActivity(intent);
    }

    public static class ImagePagerAdapter extends FragmentStatePagerAdapter {

        private final int size;

        public ImagePagerAdapter(FragmentManager fragmentManager, int size) {
            super(fragmentManager);
            this.size = size;
        }

        @Override
        public Fragment getItem(int position) {
            return ImageDetailFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return size;
        }
    }
}
