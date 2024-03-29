package viewpager.example;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewPagerExampleActivity extends Activity {
	 private ViewPager awesomePager;
     private static int NUM_AWESOME_VIEWS = 20;
     private Context ctx;
     private AwesomePagerAdapter awesomeAdapter;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    	ctx = this;
    	
    	
        awesomeAdapter = new AwesomePagerAdapter();
//        awesomeAdapter.instantiateItem(layout, 0);
//        awesomeAdapter.instantiateItem(layout, 1);
        
        awesomePager = (ViewPager) findViewById(R.id.pager);
        
        awesomePager.setAdapter(awesomeAdapter);
        
        
    }
    
    
    private class AwesomePagerAdapter extends PagerAdapter{

        
        @Override
        public int getCount() {
                return NUM_AWESOME_VIEWS;
        }

    /**
     * Create the page for the given position.  The adapter is responsible
     * for adding the view to the container given here, although it only
     * must ensure this is done by the time it returns from
     * {@link #finishUpdate()}.
     *
     * @param container The containing View in which the page will be shown.
     * @param position The page position to be instantiated.
     * @return Returns an Object representing the new page.  This does not
     * need to be a View, but can be some other container of the page.
     */
        @Override
        public Object instantiateItem(View collection, int position) {
//                TextView tv = new TextView(cxt);
//                tv.setText("Bonjour PAUG " + position);
//                tv.setTextColor(Color.WHITE);
//                tv.setTextSize(30);
	        	LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
	    		ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.viewpager, null);
	    		TextView txt = (TextView) layout.findViewById(R.id.txt1);
	    		txt.setText(txt.getText() + " " + position);
	    		
                ((ViewPager) collection).addView(layout,0);
                
                return layout;
        }

    /**
     * Remove a page for the given position.  The adapter is responsible
     * for removing the view from its container, although it only must ensure
     * this is done by the time it returns from {@link #finishUpdate()}.
     *
     * @param container The containing View from which the page will be removed.
     * @param position The page position to be removed.
     * @param object The same object that was returned by
     * {@link #instantiateItem(View, int)}.
     */
        @Override
        public void destroyItem(View collection, int position, Object view) {
                ((ViewPager) collection).removeView((View) view);
        }

        
        
        @Override
        public boolean isViewFromObject(View view, Object object) {
                return view==(object);
        }

        
    /**
     * Called when the a change in the shown pages has been completed.  At this
     * point you must ensure that all of the pages have actually been added or
     * removed from the container as appropriate.
     * @param container The containing View which is displaying this adapter's
     * page views.
     */
        @Override
        public void finishUpdate(View arg0) {}
        

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {}

        @Override
        public Parcelable saveState() {
                return null;
        }

        @Override
        public void startUpdate(View arg0) {}

}
}