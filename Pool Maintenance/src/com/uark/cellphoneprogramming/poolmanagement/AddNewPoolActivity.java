package com.uark.cellphoneprogramming.poolmanagement;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class AddNewPoolActivity extends Activity {
	
	static final int DIALOG_UNSUCCESSFUL_CREATION = 0; // If user was not added to db.
	static final int DIALOG_SUCCESSFUL_CREATION = 1; // If user was added to db.
	
	@SuppressWarnings("deprecation")
	private OnClickListener btnAddNewPoolListener = new OnClickListener()
	{
		public void onClick(View arg0)
		{
			// TODO: Add code to save new pool.
			
				//Intent newPoolIntent = new Intent(AddNewPoolActivity.this, AddNewPoolActivity.class);	
				//startActivity(newPoolIntent);
			showDialog(DIALOG_SUCCESSFUL_CREATION); // TODO: check if pool was successfully added and call correct dialog
		}
	};
	
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_pool);
        
        EditText tbContactName = (EditText)findViewById(R.id.tbContactName);
        EditText tbContactPhone = (EditText)findViewById(R.id.tbContactPhone);
        EditText tbContactEmail = (EditText)findViewById(R.id.tbContactEmail);
        EditText tbContactAddress = (EditText)findViewById(R.id.tbContactAddress);
        
        Button btnAddNewPool = (Button)findViewById(R.id.btnAddPool);
        btnAddNewPool.setOnClickListener(btnAddNewPoolListener);
        
        
        
    }
	
	protected Dialog onCreateDialog(int id) {
	    Dialog dialog;
	    switch(id) {
	    case DIALOG_UNSUCCESSFUL_CREATION:

	    	AlertDialog.Builder builder0 = new AlertDialog.Builder(this);
	    	
	    	builder0.setMessage("The Pool was not Created!")
	    	       .setCancelable(false)
	    	       //.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	    	       //    public void onClick(DialogInterface dialog, int id) {
	    	                //MyActivity.this.finish();
	    	       //    }
	    	      // })
	    	       .setNegativeButton("Close", new DialogInterface.OnClickListener() {
	    	           public void onClick(DialogInterface dialog, int id) {
	    	                dialog.cancel();
	    	           }
	    	       });
	    	
	    	dialog = builder0.create();
	    	
	        break;
	    case DIALOG_SUCCESSFUL_CREATION:
	    	// Dialog to be displayed if pool is added to db.
	    	// In this case it will ask if user wants to add a new log.
	    	AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
	    	
	    	builder1.setMessage("The Pool was Created! Do you want to add a new log?")
	    	       .setCancelable(false)
	    	       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	    	           public void onClick(DialogInterface dialog, int id) {
	    	               // TODO: call activity that adds logs.
	    	        	   Intent newPoolLogIntent = new Intent(AddNewPoolActivity.this, AddPoolLogActivity.class);	
	    					startActivity(newPoolLogIntent);
	    	           }
	    	       })
	    	       .setNegativeButton("No", new DialogInterface.OnClickListener() {
	    	           public void onClick(DialogInterface dialog, int id) {
	    	                dialog.cancel();
	    	           }
	    	       });
	    	
	    	dialog = builder1.create();
	    	
	        break;
	    default:
	        dialog = null;
	    }
	    return dialog;
	}

}
