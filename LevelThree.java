import greenfoot.*;

/**
 * Write a description of class LevelThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelThree implements IUpgradeChain
{
    // instance variables - replace the example below with your own
    private TurtleWorld world;
    
    private IUpgradeChain next;
    
    private boolean isDone;
    
    private Counter counter;
    
    private int worldWidth,worldHeight;

    /**
     * Constructor for objects of class LevelTwo
     */
    public LevelThree(TurtleWorld world,Counter counter)
    {
        this.world = world;
        isDone = false;
        this.worldWidth = world.getWidth();
        this.worldHeight = world.getHeight();
        this.counter=counter;
    }

    
    public void prepare()
    {
       isDone = true;
       
        world.setBackground("sand2.jpg");
        
        Turtle turtle = new Turtle();
        world.addObject(turtle, 171, 168);
        turtle.addScoreObserver(counter);
        turtle.addLifeObserver(counter);
        
            
        Lettuce lettuce = new Lettuce();
      
         for(int i=0;i<10;i++)
        {
            world.addObject(lettuce.cloneActor(), Greenfoot.getRandomNumber(worldWidth),Greenfoot.getRandomNumber(worldHeight));
        }
       
        
        Snake snake = new Snake();
        
        for(int i=0;i<3;i++)
        {
            world.addObject(snake.cloneActor(), Greenfoot.getRandomNumber(worldWidth),Greenfoot.getRandomNumber(worldHeight));
        }
        
        for(Snake s : world.getObjects(Snake.class))
        {
            s.addLifeObserver(counter);
        }
        
        Bug bug = new Bug();
        
        for(int i=0;i<2;i++)
        {
            world.addObject(bug.cloneActor(), Greenfoot.getRandomNumber(worldWidth),Greenfoot.getRandomNumber(worldHeight));
        }

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
    
    public IUpgradeChain getNext()
    {
     if(this.next != null)
     return next;
     else
     return null;
    }
}
