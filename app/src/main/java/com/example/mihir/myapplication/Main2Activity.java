package com.example.mihir.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

public class Main2Activity extends AppCompatActivity implements DialogBox.DialogInter {
    private static  MyAdapter adapter;
    private static EditText editText;
    private static TextView[] totaledits;
    private static Matrix matrix;
    private static Button proceed;
    private static Runnable r;
    public Main2Activity(){


    }



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private static int[] editIds;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private static Dialog mDialog;
    private static ViewGroup rootView;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    static float[][] savedMatrix;
    private static SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        totaledits = new TextView[3];





    /**/ /*   getWindow().setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, android.R.drawable.ic_dialog_alert);*/
  //      System.out.println("why is this");
        /*getSupportActionBar().setDisplayShowHomeEnabled(true);*/
/*        getSupportActionBar().setIcon(R.drawable.star_cement);*/
//        System.out.println("why is this");
  /*      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        // Create the adapter that will return a fragment for each of the three
        // primary sections o                                                                                                                                                                                                                                                                                                                                  f the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        System.out.println("why is this1");

/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }
    @Override
    public void onResume(){
        matrix = new Matrix(10,9);
        prefs = getPreferences(MODE_PRIVATE);
        String savedString = prefs.getString("string", "");
        StringTokenizer st = new StringTokenizer(savedString, ",");
        System.out.println("not okay "+ savedString);
        savedMatrix = new float[10][9];
        try {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    savedMatrix[i][j] = Float.parseFloat(st.nextToken());
                }
            }
            matrix.initArr(savedMatrix);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("YaaaYeeh");
        }
        super.onResume();
    }
    @Override
    public void onPositive(DialogFragment dialogfragment) {
        DialogBox dialogBox = (DialogBox)dialogfragment;
        dialogBox.getArguments();
        System.out.println("lol");
        editText.setText("hello");
    }





    public static class PlaceholderFragment extends Fragment {
 /*       public PlaceholderFragment() {
        }*/

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public float[] getFData(){
            float consumptionAdbHcv = matrix.consumptionAdbHcv();
            float consumptionAdbMcv = matrix.consumptionAdbMcv();
            float consumptionAdbLcv = matrix.consumptionAdbLcv();
            float consumptionAdbPetCoke = matrix.consumptionAdbPetCoke();
            float consumptionAdbTyreChips = matrix.consumptionAdbTyreChips();
            float consumptionAdbOtherAf = matrix.consumptionAdbOtherAf();

            float consumptionArbHcv =matrix.consumptionArbHcv(consumptionAdbHcv);
            float consumptionArbMcv = matrix.consumptionArbMcv(consumptionAdbMcv );
            float consumptionArbLcv = matrix.consumptionArbLcv(consumptionAdbLcv);
            float consumptionArbPetCoke = matrix.consumptionArbPetCoke(consumptionAdbPetCoke);
            float consumptionArbTyreChips =matrix.consumptionArbTyreChips(consumptionAdbTyreChips);
            float consumptionArbOtherAf = matrix.consumptionArbOtherAf(consumptionAdbOtherAf);

            float consumptionArbSum =  matrix.consumptionArbSum(consumptionArbHcv,consumptionArbMcv,consumptionArbLcv,consumptionArbTyreChips,consumptionArbPetCoke,consumptionArbOtherAf);


            float consumptionAdbSum =  matrix.consumptionAdbSum(consumptionAdbHcv,consumptionAdbMcv,consumptionAdbLcv,consumptionAdbTyreChips,consumptionAdbPetCoke,consumptionAdbOtherAf);


            float fuelCostHcv = matrix.fuelCostHcv(consumptionArbHcv);
            float fuelCostMcv = matrix.fuelCostMcv(consumptionArbMcv);
            float fuelCostLcv = matrix.fuelCostLcv(consumptionArbLcv);
            float fuelCostPetCoke = matrix.fuelCostPetCoke(consumptionArbPetCoke);
            float fuelCostTyreChips = matrix.fuelCostTyreChips(consumptionArbTyreChips);
            float fuelCostOtherAf = matrix.fuelCostOtherAf(consumptionArbOtherAf);


            float fuelCostSum = matrix.fuelCostSum(fuelCostHcv,fuelCostMcv,fuelCostLcv,fuelCostPetCoke,fuelCostTyreChips,fuelCostOtherAf);

            float rawMaterialCost = matrix.rawMaterialCost();


            float clinkerProduction = matrix.clinkerProduction();
            float rawMixCost = matrix.rawMixCost(rawMaterialCost);
            float fuelCost = matrix.fuelCost(fuelCostSum,clinkerProduction);
            float clinkerCost = matrix.clinkerCost(fuelCost,rawMixCost);
            float[] consumptionAdbArray = {consumptionAdbHcv,consumptionAdbMcv,consumptionAdbLcv,consumptionAdbPetCoke,consumptionAdbTyreChips,consumptionAdbOtherAf};

            float specificHeat = matrix.specificHeat(consumptionAdbArray,clinkerProduction);



            float[] data = {rawMaterialCost,rawMixCost,fuelCost,clinkerCost,specificHeat};
            return  data;
        }

        public static PlaceholderFragment newInstance(String[] strList,int position) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putStringArray(PASS_STRING, strList);
            args.putInt(PASS_POSITION,position);
            fragment.setArguments(args);
            return fragment;
        }

        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String PASS_STRING = "array_pass";
        private static final String PASS_POSITION = "position";

        public PlaceholderFragment(){

        }

        @Override
        public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            int position = getArguments().getInt(PASS_POSITION);
            switch (position) {
                case 0: {
                     rootView = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);
                    totaledits[0] = (TextView)rootView.findViewById(R.id.e100);
                    totaledits[1] = (TextView)rootView.findViewById(R.id.e101);

                        float sum = matrix.pcSum();
                        totaledits[0].setText(Float.toString(sum));

                         sum = matrix.klinSum();
                        totaledits[1].setText(Float.toString(sum));




                    break;
                }
                case 1:{ rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main2, container, false);
                   /* totaledits[3] = (EditText)rootView.findViewById(R.id.e73);
                    totaledits[4] = (EditText)rootView.findViewById(R.id.e74);
                    totaledits[5] = (EditText)rootView.findViewById(R.id.e75);*/
                  /*  totaledits[6] = (EditText)rootView.findViewById(R.id.e76);*/



                    break;}
                case 2:{
                    rootView = (ViewGroup) inflater.inflate(R.layout.fragment_2, container, false);
                    totaledits[2] = (TextView) rootView.findViewById(R.id.e71);
                    float sum = matrix.conPSum();
                    totaledits[2].setText(Float.toString(sum));
                    if(matrix.pcSum()!=100 && matrix.klinSum() !=100){
                        Toast.makeText(getActivity(),"PC & Klin not 100",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if(matrix.pcSum()!=100){
                        Toast.makeText(getActivity(),"Section 1 PC not 100",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if(matrix.klinSum() !=100){

                        Toast.makeText(getActivity(),"Section 1 Klin not 100",
                                Toast.LENGTH_SHORT).show();

                    }

  /*                  totaledits[1] = (EditText)rootView.findViewById(R.id.e71);
                    totaledits[2] = (EditText) rootView.findViewById(R.id.e72);*/
                    proceed = (Button) rootView.findViewById(R.id.buttonclick);
                    Thread calculate = new Thread(r);
                    calculate.start();
                    break;}



            }

            r= new Runnable() {
                @Override
                public void run() {

                    proceed.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            float abc[][] =matrix.getInputMatrix();
                            StringBuilder str = new StringBuilder();
                            for(int i =0;i<10;i++){
                            for (int j = 0; j < 9; j++) {

                                str.append(abc[i][j]).append(",");
                            }
                            }
                            SharedPreferences.Editor editor = getActivity().getPreferences(Context.MODE_PRIVATE).edit();



                            editor.putString("string", str.toString());
                            editor.commit();
                            System.out.println("okayyy "+ str.toString());


                            float[] data = getFData();
                            final Intent result = new Intent(getContext(), result.class);
                            result.putExtra("data",data);
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if(matrix.conPSum()!=100){
                                        Toast.makeText(getActivity(),"Consumpiton is not 100",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                    else if(matrix.klinSum() !=100){

                                        Toast.makeText(getActivity(),"Klin is not 100",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                    else if(matrix.pcSum() != 100){

                                        Toast.makeText(getActivity(),"PC is not 100",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        startActivity(result);
                                    }
                                }
                            });
                        }
                    });

                }
            };

            String[] listStr = getArguments().getStringArray(PASS_STRING);
            System.out.println( " child count " + rootView.getChildCount() + " " + rootView.toString());


            ViewGroup viewGroup = (ViewGroup)rootView.findViewById(R.id.vertilayout);
            System.out.println("these many "+ viewGroup.getChildCount());
            for (int i =0;i<viewGroup.getChildCount();i++){
                ViewGroup linearViews = (ViewGroup) viewGroup.getChildAt(i);
                for(int j = 0;j<linearViews.getChildCount();j++){
                    View insideView = linearViews.getChildAt(j);
                    if(insideView instanceof EditText){
                        editText = (EditText)insideView;
                        String idString = editText.getResources().getResourceEntryName(editText.getId());
                        String[] idval = idString.split("");
                        int row = Integer.parseInt(idval[2]);
                        int col = Integer.parseInt(idval[3]);
                       editText.setText(Float.toString(savedMatrix[row][col]));
                        editText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                                final View dialogview   = inflater.inflate(R.layout.dialogbox,null);
                                final EditText mainEdit = (EditText)view;
                                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                builder
                                        .setView(dialogview)
                                        .setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                // Send the positive button event back to the host activity
                                                EditText dialogedit = (EditText)dialogview.findViewById(R.id.username);
                                                String val = dialogedit.getText().toString();
                                                String idString = mainEdit.getResources().getResourceEntryName(mainEdit.getId());
                                                String[] idval = idString.split("");
                                                System.out.println("idstring is"+ idval[2] + idval[3]);

                                                int row = Integer.parseInt(idval[2]);
                                                int col = Integer.parseInt(idval[3]);
                           //                     int total_id = getActivity().getResources().getIdentifier("e00", "id",getActivity().getPackageName());
                                                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                                                //totaledit.setText("finally");
                                                float data =0;
                                                try {
                                                    data = Float.parseFloat(val);
                                                    System.out.println("data is "+ val);
                                                    matrix.inputData(row,col,data);
                                                    if(col ==1 && row<7){
                                                        float sum = matrix.conPSum();
                                                        System.out.println("consumption");
                                                        totaledits[2].setText(Float.toString(sum));
                                                    }
                                                    else if(col ==0 && row<10 && row !=6 && row>4){
                                                        float sum = matrix.pcSum();
                                                        System.out.println("pc");
                                                        totaledits[0].setText(Float.toString(sum));
                                                    }
                                                    else if((row == 0 && col<9 && col >5) || (row == 6 && col ==0)){
                                                        float sum = matrix.klinSum();
                                                        System.out.println("klin");
                                                        totaledits[1].setText(Float.toString(sum));
                                                    }
                                                    //float sum = matrix.computeSumAt(col);
                                                    mainEdit.setText(val);
                                    /*                totaledits[col].setText(Float.toString(sum));
                                                    Log.d("iditis",idString);
                                                    mainEdit.setText(val);*/
                                                }
                                                catch (Exception e){
                                                    e.printStackTrace();
                                                    System.out.println("error is there");
                                                }


                                            }
                                        })
                                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                                                // Send the negative button event back to the host activity
                                                //dialogInterface.onDialogNegativeClick(DialogBox.this);
                                            }
                                        });
                                if(mDialog != null){
                                    mDialog.dismiss();
                                }
                                mDialog = builder.show();


                            }
                        });
                    }
                }
                System.out.println("scroll view childs " + viewGroup.getChildAt(i).toString());
            }


            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position){

          String[][] list = {{"CLinker production","Specific heat consumption","Tyre chips consumption Input","Raw meal to clinker conversion factor","Total"},{"Limestone","Shale","Shale SRC","Dune sand","Iron ore","Copper slag","SPL","Total"},{"HCV Coal ","MCV coal","LCV coal","Petcoke","Tyre chips","Shredded wood","Total"}};


            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(list[position],position);

        }

        @Override
        public int getCount() {

            // Show 3 total pages.
            return 3;

        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
