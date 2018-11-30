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
    private TurtleWorld world;
    
    private Counter counter;
    
    private IUpgradeChain next;
    
    private boolean isDone;
    
    private int worldWidth,worldHeight;
    

    /**
     * Constructor for objects of class LevelOne
     */
    public LevelOne(TurtleWorld world,Counter counter)
    {
       this.world = world;
       isDone = false;
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
        
        //world.addObject(counter, 58, 26);
        
        Turtle turtle = new Turtle();
        world.addObject(turtle, 171, 168);
        turtle.addScoreObserver(counter);
        turtle.addLifeObserver(counter);
        
            
        Lettuce lettuce = new Lettuce();
      
         for(int i=0;i<5;i++)
        {
            world.addObject(lettuce.cloneActor(), Greenfoot.getRandomNumber(worldWidth),Greenfoot.getRandomNumber(worldHeight));
        }
       
        
        Snake snake = new Snake();
        
        for(int i=0;i<2;i++)
        {
            world.addObject(snake.cloneActor(), Greenfoot.getRandomNumber(worldWidth),Greenfoot.getRandomNumber(worldHeight));
        }
        
        for(Snake s : world.getObjects(Snake.class))
        {
            s.addLifeObserver(counter);
        }
        
        Bug bug = new Bug();
        
        for(int i=0;i<1;i++)
        {
            world.addObject(bug.cloneActor(), Greenfoot.getRandomNumber(worldWidth),Greenfoot.getRandomNumber(worldHeight));
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
