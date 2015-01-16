package com.learning.basicfragments;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import zen.core.localevent.*;

/**
 * @author Nazmul Idris
 * @version 1.0
 * @since 1/12/15, 10:19 AM
 */
public class FragmentButtonBar extends Fragment {

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
  return inflater.inflate(R.layout.fragment_buttonbar, container, false);
}

@Override
public void onActivityCreated(Bundle savedInstanceState) {
  super.onActivityCreated(savedInstanceState);
  _bindButtons();
}

private void _bindButtons() {
  Button btn1 = (Button) getActivity().findViewById(R.id.btn1);
  btn1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
      Toast.makeText(getActivity(), "fired local_event_id1", Toast.LENGTH_SHORT).show();
      LocalEventsManager.fireEvent(getActivity(), R.id.evt_local1, null, null);
    }
  });

  Button btn2 = (Button) getActivity().findViewById(R.id.btn2);
  btn2.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
      Toast.makeText(getActivity(), "fired local_event_id2", Toast.LENGTH_SHORT).show();
      LocalEventsManager.fireEvent(getActivity(), R.id.evt_local2, null, null);
    }
  });
}

}//end class