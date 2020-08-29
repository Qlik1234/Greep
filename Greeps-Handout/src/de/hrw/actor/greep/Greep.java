package de.hrw.actor.greep;

import de.hrw.actor.Ship;
import de.hrw.actor.TomatoPile;
import greenfoot.Actor;

// (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A Greep is an alien creature that likes to collect tomatoes.
 *
 * @author TODO (your name here)
 * @version 0.1
 */
public class Greep extends Creature {
	// Remember: you cannot extend the Greep's memory. So:
	// no additional fields (other than final fields) allowed in this class!

	private State state = new StateRoaming();
	
	/**
	 * Default constructor for testing purposes.
	 */
	public Greep() {
		this(null);
	}

	/**
	 * Create a Greep with its home space ship.
	 */
	public Greep(Ship ship) {
		super(ship);
		setImage("images/greep.png");
	}

	/**
	 * Do what a greep's gotta do.
	 */
	public void act() 
	{
		super.act(); // do not delete! leave as first statement in act().

		state = state.doAction(this); 

/*		
		if (carryingTomato()) {
			
			if (getMemory() == 0)
			{
				setMemory(1);
			}
			
			if (atShip()) 
			{
				dropTomato();
				turn(180);
				move();
			}
			else if (atWater() || atWorldEdge())
			{
				turn(35);
				move();	
			}
			else 
			{
				turnHome();
				move();
				
				if (getMemory() > 1)
				{
					setMemory(getMemory()-1);
				}
				else if ((getMemory() == 1) && !atWater() && !atWorldEdge())
				{
					spit("red");
					setMemory(7);
				}	
			}			
		} 
		
		else 
		{
			checkFood();
		}
*/		
	}

	/**
	 * Is there any food here where we are? If so, try to load some!
	 */
	public void checkFood() {
		// check whether there's a tomato pile here
		TomatoPile tomatoes = (TomatoPile) getOneIntersectingObject(TomatoPile.class);
		if (tomatoes != null) {
			loadTomato();
			// Note: this attempts to load a tomato onto *another* Greep. It
			// won't
			// do anything if we are alone here.
		}
		else
		{
			if (atWater() || atWorldEdge())
			{
				turn(35);	
			}
			else if (seePaint("red"))
			{
				turnHome();
				turn(180);
			}
			move();
		}
	}

	public Actor getOneIntersectingObject (Class cls)
	{
		return super.getOneIntersectingObject(cls);
	}
	
	/**
	 * This method specifies the name of the author (for display on the result
	 * board).
	 */
	public static String getAuthorName() {
		return "matrikelnummer_Elena"; // write your name here!
										// (matrikelnummer_prename)
	}

	/**
	 * This method specifies the image we want displayed at any time. (No need
	 * to change this for the competition.)
	 */
	public String getCurrentImage() {
		if (carryingTomato())
			return "images/greep-with-food.png";
		else
			return "images/greep.png";
	}
}