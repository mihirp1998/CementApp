package com.example.mihir.myapplication;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.view.LayoutInflater;
/**
 * Created by mihir on 04/09/17.
 */

public class MyAdapter extends BaseAdapter {
    private Activity activity;
    private String[] data;
    private int position;
    private EditText edit0;
    private Runnable r ;
    private static LayoutInflater inflater=null;

    public MyAdapter(Activity a,String[] data,int position) {
    activity = a;

    this.data = data;
    this.position = position;
    inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.listelement, viewGroup, false);
        }

        System.out.println("item nos " + i +" " +position);
        ViewGroup group = null;
        TextView t = (TextView) view.findViewById(R.id.textview);
        View spaceView1 = (View)view.findViewById(R.id.mview1);
        EditText edit1 = (EditText)view.findViewById(R.id.medit1);
        View spaceView2 = (View)view.findViewById(R.id.mview2);
        EditText edit2 = (EditText)view.findViewById(R.id.medit2);
        View spaceView3 = (View)view.findViewById(R.id.mview3);
        EditText edit3 = (EditText)view.findViewById(R.id.medit3);
        edit0 = (EditText)view.findViewById(R.id.medit0);
        ViewGroup.LayoutParams layoutParams = t.getLayoutParams();


        if(edit1 != null) {
            group = (ViewGroup) edit1.getParent();

        }
         r = new Runnable() {
            @Override
            public void run() {
                edit0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                /*        DialogFragment newFragment = new DialogBox();
                        newFragment.show(activity.getFragmentManager(), "missiles");*/
                        System.out.println("dialog box");

                    }
                });
            }
        };
        Thread a = new Thread(r);
        a.start();

        System.out.println("this is the data " + position + data[0]);
        t.setText(data[i]);
        if(position != 2 && group != null){
            group.removeView(spaceView1);
            group.removeView(edit1);
            group.removeView(spaceView1);
            group.removeView(edit2);
            if(position == 0) {
                group.removeView(spaceView3);
                group.removeView(edit3);
            }
        }
        else if(position == 2){
            layoutParams.width = 200;
            t.setLayoutParams(layoutParams);
        }

        if(i == (data.length -1)){

        }
        return view;
    }



    public void onPositive(DialogFragment fragment) {
        System.out.println("hello");
    }
}

