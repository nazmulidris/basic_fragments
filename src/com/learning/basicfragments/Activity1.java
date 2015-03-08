package com.learning.basicfragments;

import android.app.*;
import android.os.*;
import android.util.*;
import zen.base.*;
import zen.core.localevent.*;

public class Activity1 extends SimpleActivity {

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState)
{
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity1);

  getLifecycleHelper().addResource(new LocalEventsListener() {
    public int getLocalEventId() {
      return R.id.evt_local1;
    }
    public String getName() {
      return "local event 1";
    }
    public void onReceive(String stringPayload, Object objectPayload, Bundle extras) {
      _someBtnPressed(R.id.evt_local1);
    }
  });

  getLifecycleHelper().addResource(new LocalEventsListener() {
    public int getLocalEventId() {
      return R.id.evt_local2;
    }
    public String getName() {
      return "local event 2";
    }
    public void onReceive(String stringPayload, Object objectPayload, Bundle extras) {
      _someBtnPressed(R.id.evt_local2);
    }
  });
}

private void _someBtnPressed(int id) {
  if (id == R.id.evt_local1) {
    Log.d("app", "responding to local event id1");
    _btn1Pressed();
  }
  else if (id == R.id.evt_local2) {
    Log.d("app", "responding to local event id2");
    _btn2Pressed();
  }
}// end _someBtnPressed

private void _btn1Pressed() {
  getFragmentManager()
      .beginTransaction()
      .replace(R.id.fragment1, new Fragment2())
      .addToBackStack(null)
      .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
      .commit();
  showToastShort("close anim");
}

private void _btn2Pressed() {
  getFragmentManager()
      .beginTransaction()
      .replace(R.id.fragment2, new Fragment1())
      .addToBackStack(null)
      .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
      .commit();
  showToastShort("open anim");
}

}//end class
