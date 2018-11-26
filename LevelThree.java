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

    /**
     * Constructor for objects of class LevelTwo
     */
    public LevelThree(TurtleWorld world)
    {
        this.world = world;
    }

    
    public void prepare()
    {
        Counter counter = new Counter();
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
        world.addObject(lettuce4, 330, 426);
        Lettuce lettuce5 = new Lettuce();
        world.addObject(lettuce5, 405, 294);
        Lettuce lettuce6 = new Lettuce();
        world.addObject(lettuce6, 243, 61);
        Lettuce lettuce7 = new Lettuce();
        world.addObject(lettuce7, 103, 70);
        Lettuce lettuce8 = new Lettuce();
        world.addObject(lettuce8, 68, 335);
        Lettuce lettuce9 = new Lettuce();
        world.addObject(lettuce9, 218, 312);
        Lettuce lettuce10 = new Lettuce();
        world.addObject(lettuce10, 331, 205);
        Lettuce lettuce11 = new Lettuce();
        world.addObject(lettuce11, 129, 418);
        Lettuce lettuce12 = new Lettuce();
        world.addObject(lettuce12, 520, 453);
        Lettuce lettuce13 = new Lettuce();
        world.addObject(lettuce13, 568, 23);
        Lettuce lettuce14 = new Lettuce();
        world.addObject(lettuce14, 38, 237);
        Lettuce lettuce15 = new Lettuce();
        world.addObject(lettuce15, 345, 62);
        Lettuce lettuce16 = new Lettuce();
        world.addObject(lettuce16, 512, 94);
        Lettuce lettuce17 = new Lettuce();
        world.addObject(lettuce17, 458, 372);
        Snake snake = new Snake();
        world.addObject(snake, 456, 73);
        snake.addLifeObserver(counter);
        
        Snake snake2 = new Snake();
        world.addObject(snake2, 72, 396);
        snake2.addLifeObserver(counter);
        
     
        Bug bug = new Bug();
        world.addObject(bug, 361, 159);
        Bug bug2 = new Bug();
        world.addObject(bug2, 222, 402);
        
        Snake snake3 = new Snake();
        world.addObject(snake3, 484, 296);
        snake3.addLifeObserver(counter);
        Snake snake4 = new Snake();
        world.addObject(snake4, 45, 55);   
        snake4.addLifeObserver(counter);

    }
    
    
    public void setNext(IUpgradeChain next)
    {
     this.next = next;   
    }
    
    public void handleUpgrade()
    {
        next.prepare();
     }
    
    public IUpgradeChain getNext()
    {
     if(this.next != null)
     return next;
     else
     return null;
    }
}
