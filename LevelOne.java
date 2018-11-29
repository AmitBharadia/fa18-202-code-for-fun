/**
 * Write a description of class LevelOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne implements IUpgradeChain
{
    // instance variables - replace the example below with your own
    private TurtleWorld world;
    
    private Counter counter = Counter.getInstance();
    
    private IUpgradeChain next;
    
    private boolean isDone;
    

    /**
     * Constructor for objects of class LevelOne
     */
    public LevelOne(TurtleWorld world)
    {
       this.world = world;
       isDone = false;
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
        
        world.addObject(counter, 58, 26);
        Turtle turtle = new Turtle();
        world.addObject(turtle, 171, 168);
        turtle.addScoreObserver(counter);
        turtle.addLifeObserver(counter);
        
        Lettuce lettuce = new Lettuce();
        world.addObject(lettuce, 419, 106);
        Lettuce lettuce2 = new Lettuce();
        world.addObject(lettuce2, 517, 210);
        Lettuce lettuce3 = new Lettuce();
        world.addObject(lettuce3, 529, 379);
        Lettuce lettuce4 = new Lettuce();
        //world.addObject(lettuce4, 330, 426);
        Lettuce lettuce5 = new Lettuce();
        ///world.addObject(lettuce5, 405, 294);
        Lettuce lettuce6 = new Lettuce();
        //world.addObject(lettuce6, 243, 61);
        Lettuce lettuce7 = new Lettuce();
        //world.addObject(lettuce7, 103, 70);
        Lettuce lettuce8 = new Lettuce();
        //world.addObject(lettuce8, 68, 335);
        Lettuce lettuce9 = new Lettuce();
        //world.addObject(lettuce9, 218, 312);
        Lettuce lettuce10 = new Lettuce();
        //world.addObject(lettuce10, 331, 205);
       
        
        Snake snake = new Snake();
        //world.addObject(snake, 456, 73);
        snake.addLifeObserver(counter);
        Snake snake2 = new Snake();
        //world.addObject(snake2, 72, 396);
        snake2.addLifeObserver(counter);
        
     
        Bug bug = new Bug();
        world.addObject(bug, 361, 159);
        Bug bug2 = new Bug();
        world.addObject(bug2, 222, 402);   
    }
    
    public IUpgradeChain getNext()
    {
     if(this.next != null)
     return next;
     else
     return null;
    }
    
    
    
    
}
