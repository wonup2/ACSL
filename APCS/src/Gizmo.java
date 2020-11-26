import java.util.ArrayList;

public class Gizmo {

	 String getMaker(){}
	 boolean isElectronic() {}
	 boolean equals(Object other) {}
}


class OnlinePurchaseManager
{
	private ArrayList<Gizmo> purchases;

	id:ap1101010
	JL
	public int countElectronicsByMaker(String maker)
    { /* to be implemented in part (a) */ 
		int ans=0;
		for(Gizmo g: purchases)
		{
			if(g.getMaker().equals(maker) && g.isElectronic())
			{
				ans++;
			}
		}
		return ans;
    }

	public boolean hasAdjacentEqualPair()
	{ /* to be implemented in part (b) */ 
		
	}
	
	public Gizmo getCheapestGizmoByMaker(String maker)
	{
		
	}
}