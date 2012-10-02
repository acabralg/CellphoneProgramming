package Model;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.OverlayItem;



public class PoolItemizedOverlay extends com.google.android.maps.ItemizedOverlay<OverlayItem> {
	
	private Context context;
	
	private ArrayList<OverlayItem> myOverlays = new ArrayList<OverlayItem>();

	public PoolItemizedOverlay(Drawable arg0) {
		super(boundCenterBottom(arg0));
		// TODO Auto-generated constructor stub
	}
	
	public PoolItemizedOverlay(Drawable defaultMarker, Context context) {
		  super(boundCenterBottom(defaultMarker));
		  this.context = context;
		}

	@Override
	protected OverlayItem createItem(int arg0) {
		return myOverlays.get(arg0);
	}

	@Override
	public int size() {
		return myOverlays.size();
	}

	public void addOverlay(OverlayItem overlay) {
	    myOverlays.add(overlay);
	    //populate();
	}
	
	public void Populate()
	{
		populate();
	}
	
	// TODO: Implement functionality so when user clicks in pool location info is displayed
	@Override
	protected boolean onTap(int index) {
	  OverlayItem item = myOverlays.get(index);
	  AlertDialog.Builder dialog = new AlertDialog.Builder(this.context);
	  dialog.setTitle(item.getTitle());
	  dialog.setMessage(item.getSnippet());
	  dialog.show();
	  return true;
	}
}
