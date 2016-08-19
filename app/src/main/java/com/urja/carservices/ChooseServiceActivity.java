package com.urja.carservices;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.urja.carservices.fragment.AccessoriesFragment;
import com.urja.carservices.fragment.DentPaintFragment;
import com.urja.carservices.fragment.RecyclerViewFragment;
import com.urja.carservices.fragment.ServiceRepairFragment;
import com.urja.carservices.fragment.TyreWheelFragment;
import com.urja.carservices.fragment.WashDetailingFragment;

public class ChooseServiceActivity extends AppCompatActivity {
    private static final String TAG = ChooseServiceActivity.class.getSimpleName();
    private MaterialViewPager mViewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_service);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);


        toolbar = mViewPager.getToolbar();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }




        mViewPager.getViewPager().setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                Log.e(TAG, "getItem: position="+position );
                switch (position % 5) {
                    case 0:
                        fragment = WashDetailingFragment.newInstance();
                        break;
                    case 1:
                        fragment = ServiceRepairFragment.newInstance();
                        break;
                    case 2:
                        fragment = TyreWheelFragment.newInstance();
                        break;
                    case 3:
                        fragment = DentPaintFragment.newInstance();
                        break;
                    case 4:
                        fragment = AccessoriesFragment.newInstance();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 5) {
                    case 0:
                        return getString(R.string.tab_wash_detailing);
                    case 1:
                        return getString(R.string.tab_service_repairs);
                    case 2:
                        return getString(R.string.tab_tyre_wheel);
                    case 3:
                        return getString(R.string.tab_dent_paint);
                    case 4:
                        return getString(R.string.tab_accessories);
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                    case 4:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        View logo = findViewById(R.id.logo_white);
        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
