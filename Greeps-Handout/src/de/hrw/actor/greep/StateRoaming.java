package de.hrw.actor.greep;

import de.hrw.actor.TomatoPile;
import de.hrw.actor.greep.*;

public class StateRoaming implements State
{
	@Override
	public State doAction(Greep g) 
	{
		TomatoPile tomatoes = (TomatoPile) g.getOneIntersectingObject(TomatoPile.class);
		
		if (g.carryingTomato())
		{
			return new StateCarryngTomato();
		}
		else if (tomatoes != null)
		{
			return new StateWaitingAtTomatoPile();
		}		
		else
		{
			if (g.atWater() || g.atWorldEdge())
			{
				g.turn(85);
			}
			else if (g.seePaint("red"))
			{
				g.turnHome();
				g.turn(180);
			}
			g.move();

			return this;
		}
	}
}
