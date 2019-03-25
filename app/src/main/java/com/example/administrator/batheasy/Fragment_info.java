package com.example.administrator.batheasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;

public class Fragment_info extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_info,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myinfoEventInit();
    }
    //给myinfo页面设置监听器
    public void myinfoEventInit(){
        TableRow tr_info = getActivity().findViewById(R.id.tablerow_info);
        tr_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MyinfoActivity.class);
                startActivity(intent);
            }
        });

        TableRow tr_cardinfo = getActivity().findViewById(R.id.tablerow_cardinfo);
        tr_cardinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MycardActivity.class);
                startActivity(intent);
            }
        });

        TableRow tr_bilinfo = getActivity().findViewById(R.id.tablerow_billinfo);
        tr_bilinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MybillinfoAcitvity.class);
                startActivity(intent);
            }
        });

        TableRow tr_creditinfo = getActivity().findViewById(R.id.tablerow_credit);
        tr_creditinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MyCreditActivity.class);
                startActivity(intent);
            }
        });

        TableRow tr_question = getActivity().findViewById(R.id.tablerow_question);
        tr_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MyquestionActivity.class);
                startActivity(intent);
            }
        });

        TableRow tr_setting = getActivity().findViewById(R.id.tablerow_setting);
        tr_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MysettingActivity.class);
                startActivity(intent);
            }
        });

        TableRow tr_option = getActivity().findViewById(R.id.tablerow_option);
        tr_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MyoptionActivity.class);
                startActivity(intent);
            }
        });
    }
}
