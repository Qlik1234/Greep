package de.hrw.actor.greep;

public class StateCarryngTomato implements State
{
	
	@Override /* Abstrakte Methode wird durch die konkrete überschrieben */
	public State doAction(Greep g) {
		if (g.getMemory() == 0)
		{
			g.setMemory(1);
		}
		
		if (g.atShip()) 
		{
			g.dropTomato();
			g.turn(180);
			g.move();
		}
		else if (g.atWater() || g.atWorldEdge())
		{
			g.turn(85);
			g.move();	
		}
		else 
		{
			g.turnHome();
			g.move();
			
			if (g.getMemory() > 1)
			{
				g.setMemory(g.getMemory()-1);
			}
			else if ((g.getMemory() == 1) && !g.atWater() && !g.atWorldEdge())
			{
				g.spit("red");
				g.setMemory(7);
			}	
		}	
		return new StateRoaming();
	}

}
