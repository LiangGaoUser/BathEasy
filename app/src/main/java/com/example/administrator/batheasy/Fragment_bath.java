package com.example.administrator.batheasy;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class Fragment_bath extends Fragment {
    private int[] picture = new int[]{
        R.drawable.icon_bath,R.drawable.icon_bath,R.drawable.icon_bath,R.drawable.icon_bath,
            R.drawable.icon_bath,R.drawable.icon_bath,R.drawable.icon_bath,R.drawable.icon_bath
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_bath,null);
        GridView gridView = view.findViewById(R.id.bath_gridview);
        gridView.setAdapter(new ImageAdapter(getActivity(),picture));
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GridView gridView = getActivity().findViewById(R.id.bath_gridview);
        gridView.setAdapter(new ImageAdapter(getActivity(),picture));
    }*/
}
