package app.android.healthbook3;

import java.util.Date;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import app.android.healthbook3.db.UserDB;
import app.android.healthbook3.entry.UserDBEntry;
import app.android.healthbook3.fragments.BloodPressureFragment;
import app.android.healthbook3.fragments.BloodSugarFragment;
import app.android.healthbook3.fragments.DiseaseFragment;
import app.android.healthbook3.fragments.EmergencyFragment;
import app.android.healthbook3.fragments.FoodAllergyFragment;
import app.android.healthbook3.fragments.HeartRateFragment;
import app.android.healthbook3.fragments.MainFragment;
import app.android.healthbook3.fragments.MedicineAllergyFragment;
import app.android.healthbook3.fragments.ProfileAddFragment;
import app.android.healthbook3.fragments.ProfileFragment;

public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;
	
	private Context context;
	private UserDB udb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		
		context = this;
		udb = new UserDB(context);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.container,new MainFragment()).commit();
		mTitle = "Your Status";
		
		// View
		
		
		
		
		
		//if the DB don't have any record go to insert page
		checkDB(udb);
	}
	
	public void insert() {
		long record = udb.insert("bui", "jum", "female", "28", "B", "162", "sdkfjlskdf", "0334343", "49404040");
		Toast.makeText(context, "inserted record id " + record, Toast.LENGTH_SHORT).show();
		
		if(record != -1) {
			showRecord();
		}
	}
	
	public void showRecord() {
		UserDBEntry uinfo = udb.select();
		if(uinfo == null) {
			Toast.makeText(context, "dont have info", Toast.LENGTH_SHORT).show();
		}
		else {
			Log.i("user info", uinfo.getName() +"'s profile : gender > " + uinfo.getGender() + 
																" BD > " + uinfo.getBd() + 
																" Blooltype > " + uinfo.getBtype());
			Log.i("user info", "--------------------------------------------------------");
		}
	}
	
	public void checkDB(UserDB udb) {
		if(udb.select() == null) {
		Intent addinfo = new Intent(getApplicationContext(), ProfileAddFragment.class);
		startActivity(addinfo);
		}
		return ;
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments

		Fragment fragment = null;
		switch(position) {
		case 0:
			fragment = new MainFragment();
			mTitle = getString(R.string.title_section0);
			break;
		case 1:
			fragment = new ProfileFragment();
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			fragment = new EmergencyFragment();
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			fragment = new HeartRateFragment();
			mTitle = getString(R.string.title_section3);
			break;
		case 4:
			fragment = new BloodPressureFragment();
			mTitle = getString(R.string.title_section4);
			break;
		case 5:
			fragment = new BloodSugarFragment();
			mTitle = getString(R.string.title_section5);
			break;
		case 6:
			fragment = new DiseaseFragment();
			mTitle = getString(R.string.title_section6);
			break;
		case 7:
			fragment = new FoodAllergyFragment();
			mTitle = getString(R.string.title_section7);
			break;
		case 8:
			fragment = new MedicineAllergyFragment();
			mTitle = getString(R.string.title_section8);
			break;
		default:
			break;
		}
			
		if(fragment != null) {
			FragmentManager fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction().replace(R.id.container,fragment).commit();
			
			// update selected item and title, then close the drawer
//            mDrawerList.setItemChecked(position, true);
//            mDrawerList.setSelection(position);
//            setTitle(navMenuTitles[position]);
//            mDrawerLayout.closeDrawer(mDrawerList);
		}
		else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
		

	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 0:
			mTitle = getString(R.string.title_section0);
			break;
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		case 4:
			mTitle = getString(R.string.title_section4);
			break;
		case 5:
			mTitle = getString(R.string.title_section5);
			break;
		case 6:
			mTitle = getString(R.string.title_section6);
			break;
		case 7:
			mTitle = getString(R.string.title_section7);
			break;
		case 8:
			mTitle = getString(R.string.title_section8);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			TextView textView = (TextView) rootView
					.findViewById(R.id.section_label);
			textView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
	}

}
