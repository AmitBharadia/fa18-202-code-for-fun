/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
import greenfoot.*;

public class LevelOne implements IUpgradeChain
{
    // instance variables - replace the example below with your own
    private Mars world;
    
    private Counter counter;
    
    private IUpgradeChain next;
    
    private boolean isDone;
    
    private int worldWidth,worldHeight;
    

    /**
     * Constructor for objects of class LevelOne
     */
    public LevelOne(Mars world,Counter counter)
    {
       this.world = world;
       isDone = false;
       world.setBackground("corkboard.jpg");
       this.worldWidth = world.getWidth();
       this.worldHeight = world.getHeight();
       this.counter=counter;
    }

    public void setNext(IUpgradeChain next)
    {
     this.next = next;   
    }
    
    public void handleUpgrade()
    {
        if(isDone)
        {
            if(next != null)
            next.handleUpgrade();
            else
            world.gameOver();
        }
        else
        {
        prepare();
        }
        
     }
    
    public void prepare()
    {
        isDone = true;
        
        Rover rover = new Rover();
        world.addObject(rover, 171, 168);
        rover.addScoreObserver(counter);
        rover.addLifeObserver(counter);
        
            
        Drink drink = new Drink();
      
         for(int i=0;i<6;i++)
        {
            world.addObject(drink.cloneActor(), Greenfoot.getRandomNumber(worldWidth),Greenfoot.getRandomNumber(worldHeight));
        }
       
        
        Alien alien = new Alien();
        
        for(int i=0;i<3;i++)
        {
            world.addObject(alien.cloneActor(), Greenfoot.getRandomNumber(worldWidth),Greenfoot.getRandomNumber(worldHeight));
        }
        
        for(Alien s : world.getObjects(Alien.class))
        {
            s.addLifeObserver(counter);
        }
        
        O2 o2 = new O2();
        
        for(int i=0;i<2;i++)
        {
            world.addObject(o2.cloneActor(), Greenfoot.getRandomNumber(worldWidth),Greenfoot.getRandomNumber(worldHeight));
        }
        
        
    }
    
    
    
    
    public IUpgradeChain getNext()
    {
     if(this.next != null)
     return next;
     else
     return null;
    }
    
}
