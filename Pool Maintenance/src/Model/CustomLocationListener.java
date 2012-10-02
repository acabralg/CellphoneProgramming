package Model;


import com.google.android.maps.GeoPoint;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class CustomLocationListener implements LocationListener {

	private GeoPoint myGeoPoint;
	
	
	public void onLocationChanged(Location location) {
		myGeoPoint = new GeoPoint((int)(location.getLatitude()*1000000),
			    (int)(location.getLongitude()*1000000));		
	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	
	public GeoPoint GetGeoPoint()
	{
		return this.myGeoPoint;
	}

}
