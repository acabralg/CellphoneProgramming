package com.uark.cellphoneprogramming.poolmanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private OnClickListener btnMapListener = new OnClickListener()
	{
		public void onClick(View arg0)
		{
				Intent mapIntent = new Intent(MainActivity.this, PoolsMapActivity.class);	
				startActivity(mapIntent);
				
		}
		
	};
	
	private OnClickListener btnAddNewPoolListener = new OnClickListener()
	{
		public void onClick(View arg0)
		{
				Intent newPoolIntent = new Intent(MainActivity.this, AddNewPoolActivity.class);	
				startActivity(newPoolIntent);
		}
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnMap = (Button)findViewById(R.id.btnPoolsInMap);
        btnMap.setOnClickListener(btnMapListener);
        
        Button btnAddNewPool = (Button)findViewById(R.id.btnAddNewPool);
        btnAddNewPool.setOnClickListener(btnAddNewPoolListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
