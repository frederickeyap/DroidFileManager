package waffle.droidfilemanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity {
    
    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
    public static class SectionFragment extends Fragment {
        
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final int position = Integer.valueOf(this.getArguments().get(ARG_SECTION_NUMBER).toString());
            View view = null;
            switch (position) {
                case 0:
                    view = inflater.inflate(R.layout.view_local_directory, null);
                    break;
                case 1:
                    view = inflater.inflate(R.layout.view_remote_directory, null);
                    break;
            }
            return view;
        }
    }
    
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        
        @Override
        public int getCount() {
            return 2;
        }
        
        /**
         * getItem is called to instantiate the fragment for the given page. Return a DummySectionFragment (defined as a
         * static inner class below) with the page number as its lone argument.
         */
        @Override
        public Fragment getItem(int position) {
            final Fragment fragment = new SectionFragment();
            final Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, position);
            fragment.setArguments(args);
            return fragment;
        }
        
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return MainActivity.this.getString(R.string.title_section1);
                case 1:
                    return MainActivity.this.getString(R.string.title_section2);
            }
            return null;
        }
    }
    
    public static final String ARG_SECTION_NUMBER = "section_number";
    
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the sections. We use a
     * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which will keep every loaded fragment in memory.
     * If this becomes too memory intensive, it may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    
    /**
     * The {@link ViewPager} that will host the section contents. Inflate the menu; this adds items to the action bar if
     * it is present.
     */
    private ViewPager mViewPager;
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /**
     * Creates the adapter that will return a fragment for each of the three primary sections of the app. Then sets up
     * the ViewPager with the sections adapter.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.mSectionsPagerAdapter = new SectionsPagerAdapter(this.getSupportFragmentManager());
        this.mViewPager = (ViewPager) this.findViewById(R.id.pager);
        this.mViewPager.setAdapter(this.mSectionsPagerAdapter);
        
    }
    
}
