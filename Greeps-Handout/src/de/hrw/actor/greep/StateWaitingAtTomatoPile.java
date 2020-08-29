package de.hrw.actor.greep;

import de.hrw.actor.TomatoPile;
import de.hrw.actor.greep.Greep;


public class StateWaitingAtTomatoPile implements State {

	@Override
	public State doAction(Greep g) {
		// check whether there's a tomato pile here
		TomatoPile tomatoes = (TomatoPile) g.getOneIntersectingObject(TomatoPile.class);
		if (tomatoes != null) {
			g.loadTomato();
			// Note: this attempts to load a tomato onto *another* Greep. It
			// won't
			// do anything if we are alone here.
			return this;
		}
		else
		{
			return new StateRoaming();
		}
	}

}
