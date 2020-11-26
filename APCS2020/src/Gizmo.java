import java.util.ArrayList;

public class Gizmo {
	private double cost;
	public String getMaker() {}
	public double getCost() {}
	public boolean isElectronic() {}
	public boolean equals(Object other) {}
}

class  OnlinePurchaseManager{
	private ArrayList<Gizmo> purchases;

	public int countElectronicsByMaker(String maker) 
	{
		int ans = 0;
		for(Gizmo g:purchases)
		{
			if(g.getMaker().equals(maker) && g.isElectronic())
				ans++;
		}
		return ans;
	}
	
	
	public boolean hasAdjacentEqualPair()
	{ /* to be implemented in part (b) */ 
		for(int i = 0; i<purchases.size()-1; i++)
		{
			if(purchases.get(i).equals(purchases.get(i+1)))
			{
				return true;
			}
		}
		return false;
	}
	
	
	public Gizmo getCheapestGizmoByMaker(String maker) {
		
	}
}
