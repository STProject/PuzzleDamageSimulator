package jp.sodas.puzzledamagesimulator;

import jp.sodas.puzzledamagesimulator.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PanelFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View  view = inflater.inflate(R.layout.fragment_panel, container, false);
		return view;
	}

}
