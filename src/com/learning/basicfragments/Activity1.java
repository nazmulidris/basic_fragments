package com.learning.basicfragments;

import android.app.*;
import android.content.*;
import android.os.*;
import android.support.v4.content.*;
import android.util.*;
import android.widget.*;

public class Activity1 extends Activity {

private BroadcastReceiver broadcastReceiver;

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState)
{
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity1);

  // bind to local event 1
  broadcastReceiver = new BroadcastReceiver() {
    public void onReceive(Context context, Intent intent) {
      _someBtnPressed(intent);
    }
  };
  LocalBroadcastManager.getInstance(this).registerReceiver(
      broadcastReceiver, new IntentFilter(String.valueOf(R.id.local_event_id1)));
  LocalBroadcastManager.getInstance(this).registerReceiver(
      broadcastReceiver, new IntentFilter(String.valueOf(R.id.local_event_id2)));

}

@Override
protected void onDestroy() {
  super.onDestroy();
  // unbind from local events
  LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
}

private void _someBtnPressed(Intent intent) {
  if (intent.getAction().equals(String.valueOf(R.id.local_event_id1))) {
    Log.d("app", "responding to local event id1");
    _btn1Pressed();
  }
  else if (intent.getAction().equals(String.valueOf(R.id.local_event_id2))) {
    Log.d("app", "responding to local event id2");
    _btn2Pressed();
  }
  else {

  }
}// end _someBtnPressed

private void _btn1Pressed() {
  FragmentTransaction xact = getFragmentManager().beginTransaction();
  Fragment frag = new Fragment2();
  xact.replace(R.id.fragment1, frag);
  xact.addToBackStack(null);
  xact.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
  xact.commit();
  Toast.makeText(this, "close anim", Toast.LENGTH_SHORT).show();
}

private void _btn2Pressed() {
  FragmentTransaction xact = getFragmentManager().beginTransaction();
  Fragment frag = new Fragment1();
  xact.replace(R.id.fragment2, frag);
  xact.addToBackStack(null);
  xact.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
  xact.commit();
  Toast.makeText(this, "open anim", Toast.LENGTH_SHORT).show();
}

}//end class
