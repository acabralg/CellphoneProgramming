package com.uark.cellphoneprogramming.poolmanagement;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import Model.CustomLocationListener;
import Model.LoadPools;
import Model.PoolItemizedOverlay;
import Model.PoolLocation;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class PoolsMapActivity extends MapActivity {
	
	 private LocationManager myLocationManager;
	 private LocationListener listener;
	 
     private MapView mapView; // Display map
	 private MapController myMapController; // For zoom
	 
	 private ArrayList<PoolLocation> poolLocationList;

	 @Override
	 public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.poolsinmaplayout);
		  
		  mapView = (MapView)findViewById(R.id.mapview);
		  mapView.setSatellite(true); //Set satellite view
		  myMapController = mapView.getController();
		  myMapController.setZoom(17); //Fixed Zoom Level
		  
		
		  
		  /*LoadPools pools = new LoadPools();
		  
		  try {
	    		poolLocationList = pools.execute().get(); // connect to database in another thread and wait for response (places)
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  for(PoolLocation pl : poolLocationList)
		    {
		    	int latitude = pl.GetLatitude();
		    	int longitude = pl.GetLongitude();
		    	String name = pl.GetName();
		    	String comment = pl.GetComments();
		    	
		    	GeoPoint point = new GeoPoint(latitude, longitude);
		    	
		    	OverlayItem overlayitem = new OverlayItem(point, name, comment);
		    	itemizedoverlay.addOverlay(overlayitem);
			    mapOverlays.add(itemizedoverlay);
		    }
		    */
		  
		 // GeoPoint point = new GeoPoint(19240000,-99120000);
		 // OverlayItem overlayitem = new OverlayItem(point, "Hola, Mundo!", "I'm in Mexico City!");
		 // itemizedoverlay.addOverlay(overlayitem);
		  
		  //mapOverlays.add(itemizedoverlay);  
		  //itemizedoverlay.Populate();
		  
		    
		//CenterMapInMyLocation(initGeoPoint);
		  
	 }
	 
	 @SuppressLint("NewApi")
	@Override
	    protected void onStart() {
	        super.onStart();
	        
	     // Check if the GPS setting is currently enabled on the device.
	        // This verification should be done during onStart() because the system calls this method
	        // when the user returns to the activity, which ensures the desired location provider is
	        // enabled each time the activity resumes from the stopped state.
	        LocationManager locationManager =
	                (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	        final boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

	 if (!gpsEnabled) {
         // Build an alert dialog here that requests that the user enable
         // the location services, then when the user clicks the "OK" button,
         // call enableLocationSettings()
         new EnableGpsDialogFragment().show(getFragmentManager(), "enableGpsDialog");
     }
	 
	 if(gpsEnabled)
	 {
		// Implementing the pool overlays
		  List<Overlay> mapOverlays = mapView.getOverlays();
		  Drawable drawable = this.getResources().getDrawable(R.drawable.androidmarker);
		  PoolItemizedOverlay itemizedoverlay = new PoolItemizedOverlay(drawable, this);		  
		  
		  myLocationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		  
		  listener = new CustomLocationListener();
		  if (myLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			  
			  myLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
	          
			//Get the current location in start-up
			  GeoPoint initGeoPoint = new GeoPoint((int)(myLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLatitude()*1000000),
			   (int)(myLocationManager.getLastKnownLocation(
			    LocationManager.GPS_PROVIDER)
			    .getLongitude()*1000000));
			  
			  GeoPoint point = new GeoPoint(19240000,-99120000);
			  OverlayItem overlayitem = new OverlayItem(point, "Hola, Mundo!", "I'm in Mexico City!");
			  itemizedoverlay.addOverlay(overlayitem);
			  
			  mapOverlays.add(itemizedoverlay);  
			  itemizedoverlay.Populate();
			  
			    
			CenterMapInMyLocation(initGeoPoint);
			  
	        } else {
	            Toast.makeText(this, R.string.not_support_gps, Toast.LENGTH_LONG).show();
	        }
	        
	 }
	 
	 }
	 // Display map centered in my current position
	 private void CenterMapInMyLocation(GeoPoint myLocationPoint)
	 {
		 myMapController.animateTo(myLocationPoint);
	 }
	 
	    /**
	     * Dialog to prompt users to enable GPS on the device.
	     */
	    @SuppressLint("NewApi")
		private class EnableGpsDialogFragment extends DialogFragment {

	        @SuppressLint("NewApi")
			@Override
	        public Dialog onCreateDialog(Bundle savedInstanceState) {
	            return new AlertDialog.Builder(getActivity())
	                    .setTitle(R.string.enable_gps)
	                    .setMessage(R.string.enable_gps_dialog)
	                    .setNegativeButton(R.string.enable_gps, new DialogInterface.OnClickListener() {
	                        public void onClick(DialogInterface dialog, int which) {
	                            enableLocationSettings();
	                        }
	                    })
	                    .create();
	        }
	    }
	 
	 // Method to launch Settings
	    private void enableLocationSettings() {
	        Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
	        startActivity(settingsIntent);
	    }
	    
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	


}
