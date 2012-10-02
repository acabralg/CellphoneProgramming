package Model;

import java.util.Date;

public class PoolLog {
	
	private float ph, freeAvailableClorine, combinedChlorine, calciumHardness, stabilizerConditioner, stabCondForSalt, totalDissolvedSolids;
	private float salt, phosphates, alkalinity, cyanuricAcid, waterTemp, pumpPressure, powderedChlorine, liquidChlorine;
	private String note;
	private Date dateTime;
	
	PoolLog(float ph, float freeAvailableClorine, float combinedChlorine, float calciumHardness, float stabilizerConditioner, 
			float stabCondForSalt, float totalDissolvedSolids, float salt, float phosphates, float alkalinity, float cyanuricAcid, float waterTemp, float pumpPressure, String note, Date dateTime, float powderedChlorine, float liquidChlorine)
	{
		this.ph = ph;
		this.freeAvailableClorine = freeAvailableClorine;
		this.combinedChlorine = combinedChlorine;
		this.calciumHardness = calciumHardness;
		this.stabilizerConditioner = stabilizerConditioner;
		this.stabCondForSalt = stabCondForSalt;
		this.totalDissolvedSolids = totalDissolvedSolids;
		this.salt = salt;
		this.phosphates = phosphates;
		this.alkalinity = alkalinity;
		this.cyanuricAcid = cyanuricAcid;
		this.waterTemp = waterTemp;
		this.pumpPressure = pumpPressure;
		this.powderedChlorine = powderedChlorine;
		this.liquidChlorine = liquidChlorine;
		this.note = note;
		this.dateTime = dateTime;		
	}
	

		
	public float GetPH()
	{
		return this.ph;
	}
	public float GetFreeAvailableClorine()
	{
		return this.freeAvailableClorine;
	}
	public float GetCombinedChlorine()
	{
		return this.combinedChlorine;
	}
	public float GetCalciumHardness()
	{
		return this.calciumHardness;
	}
	public float GetStabilizerConditioner()
	{
		return this.stabilizerConditioner;
	}
	public float GetStabilizerConditionerForSalt()
	{
		return this.stabCondForSalt;
	}
	public float GetTotalDissolvedSolids()
	{
		return this.totalDissolvedSolids;
	}
	public float GetSalt()
	{
		return this.salt;
	}
	public float GetPhosphates()
	{
		return this.phosphates;
	}
	public float GetAlkalinity()
	{
		return this.alkalinity;
	}
	public float GetCyanuricAcid()
	{
		return this.cyanuricAcid;
	}
	public float GetWaterTemperature()
	{
		return this.waterTemp;
	}
	public float GetPumpPressure()
	{
		return this.pumpPressure;
	}
	public float GetPowderedChlorine()
	{
		return this.powderedChlorine;
	}
	public float GetLiquidChlorine()
	{
		return this.liquidChlorine;
	}
	public String GetNote()
	{
		return this.note;
	}
	public Date GetDateTime()
	{
		return this.dateTime;
	}
}
