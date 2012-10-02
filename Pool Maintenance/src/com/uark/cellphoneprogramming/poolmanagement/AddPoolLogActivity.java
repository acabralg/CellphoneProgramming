package com.uark.cellphoneprogramming.poolmanagement;

import java.text.DateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class AddPoolLogActivity extends Activity{
	
	private Calendar c;
	private int year;
	private int month;
	private int day;
	
	private OnClickListener btnAddLogListener = new OnClickListener()
	{
		public void onClick(View arg0)
		{
			// TODO: Add code to save new log associate it with created ID of new pool.
		
		}
	};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pool_log);
        
        c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        
        String dateNow = month + "/" + day + "/" + year; 
        
        EditText date = (EditText)findViewById(R.id.tbDate);
        date.setText(dateNow);
        
        EditText ph = (EditText)findViewById(R.id.tbPH);
        
        EditText freeAvailableChlorine = (EditText)findViewById(R.id.tbFreeAvailableChlorine);
        
        EditText combinedChlorine = (EditText)findViewById(R.id.tbCombinedChlorine);
        
        EditText calciumHardness = (EditText)findViewById(R.id.tbCalciumHardness);
        
        EditText stabilizerConditioner = (EditText)findViewById(R.id.tbStabilizerConditioner);
        
        EditText stabilizerConditionerForSalt = (EditText)findViewById(R.id.tbStabilizerConditionerForSalt);
        
        EditText totalDissolvedSolids = (EditText)findViewById(R.id.tbTotalDissolvedSolids);
        
        EditText salt = (EditText)findViewById(R.id.tbSalt);
        
        EditText phosphate = (EditText)findViewById(R.id.tbPhosphates);
        
        EditText alkalinity = (EditText)findViewById(R.id.tbAlkalinity);
        
        EditText cianuricAcid = (EditText)findViewById(R.id.tbCyanuricAcid);
        
        EditText waterTemperature = (EditText)findViewById(R.id.tbWaterTemperature);
        
        EditText pumpPressure = (EditText)findViewById(R.id.tbPumpPressure);
        
        EditText powderChlorine = (EditText)findViewById(R.id.tbPowderedChlorine);
        
        EditText liquidChlorine = (EditText)findViewById(R.id.tbLiquidChlorine);
        
        EditText note = (EditText)findViewById(R.id.tbNote);
        
        Button btnAddLog = (Button)findViewById(R.id.btnAddLog);
        btnAddLog.setOnClickListener(btnAddLogListener);
        
        //Button btnAddNewPool = (Button)findViewById(R.id.btnAddNewPool);
        //btnAddNewPool.setOnClickListener(btnAddNewPoolListener);
    }
}
