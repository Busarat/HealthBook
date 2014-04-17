package app.android.healthbook3.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import app.android.healthbook3.R;

public class EmergencyFragment extends Fragment {

	public EmergencyFragment(){
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_emergency, container, false);
          
        return rootView;
    }
	
}
