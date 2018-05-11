package com.example.mihir.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.content.DialogInterface;
import android.widget.EditText;

/**
 * Created by mihir on 18/09/17.
 */

public class DialogBox extends DialogFragment {
private EditText editText;
    public interface DialogInter{
        public void onPositive(DialogFragment dialogfragment);
    }
    public void setEdit(EditText newEdit){
        editText = newEdit;
    }
   /* public static DialogBox newInstance(MyAdapter adapter) {

        Bundle args = new Bundle();
        args.putParcelable("adapter");
        DialogBox fragment = new DialogBox();
        fragment.setArguments(args);
        return fragment;
    }*/
    DialogInter dialogInterface;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
             dialogInterface= (DialogInter) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener");
        }
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Build the dialog and set up the button click handlers
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Awesome")
                .setPositiveButton("fuck yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the positive button event back to the host activity
                        dialogInterface.onPositive(DialogBox.this);
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the negative button event back to the host activity
                        //dialogInterface.onDialogNegativeClick(DialogBox.this);
                    }
                });
        return builder.create();
    }
}


















