package com.learning.basicfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Nazmul Idris
 * @version 1.0
 * @since 1/9/15, 11:14 AM
 */
public class Fragment1 extends Fragment {

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

  return inflater.inflate(R.layout.fragment1, container, false);
}
}