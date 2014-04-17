package app.android.healthbook3.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.android.healthbook3.R;

public class HeartRateFragment extends Fragment {

	public HeartRateFragment() {
		
	}	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_heartrate, container, false);
          
        return rootView;
    }
	
}
