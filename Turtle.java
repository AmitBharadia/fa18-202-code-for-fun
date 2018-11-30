import greenfoot.*; 

/**
 * This is a turtle in a first, simple video game. It can be controlled 
 * with the cursor keys and likes to eat lettuce.
 */
public class Turtle extends Animal implements IScoreSubject, ILifeSubject
{
    private IScoreObserver scoreObserver;
    private ILifeObserver lifeObserver;

  
    public void act()
    {
        move(4);
        checkKeys();
        tryToEat();
    }

    /**
     * Check whether the control keys are being pressed, and turn
     * if they are.
     */
    public void checkKeys()
    {
        if ( Greenfoot.isKeyDown("left") )
        {
            turn(-5);
        }
        if ( Greenfoot.isKeyDown("right") )
        {
            turn(5);
        }
    }

    /**
     * Check whether we can see Lettuce or bugs. If we can, eat it.
     */
    public void tryToEat()
    {
        if (canSee(Lettuce.class) )
        {
            eat(Lettuce.class);
            updateScore(15);   
            Greenfoot.playSound("slurp.wav");
            if(getWorld().getObjects(Lettuce.class).size() == 0) 
            {
                    TurtleWorld world = (TurtleWorld) getWorld();
                    world.Upgrade();
                    return;
                    
            }
        }
        
        if (canSee(Bug.class) )
        {
            eat(Bug.class);
            updateLife(1);
            Greenfoot.playSound("slurp.wav");
            //createNewBug();
        }
 
    }

    /**
     * Create a new bug and insert it at a random location in the world.
     */
    private void createNewBug()
    {
        Bug newBug;
        newBug = new Bug();
        
        World world;
        world = getWorld();
        
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        
        int x = Greenfoot.getRandomNumber(worldWidth);
        int y = Greenfoot.getRandomNumber(worldHeight);
        
        world.addObject(newBug, x, y);
    }
    
    /**
     * We have won the game.
     */
    public void gameOver()
    {
       Greenfoot.playSound("fanfare.wav");
       Greenfoot.stop();
       
       //TurtleWorld world = (TurtleWorld) getWorld();
       //world.gameOver();
       
    }
    
    public void addScoreObserver(IScoreObserver observer){
        this.scoreObserver=observer;
    }
    
    public void removeObserver(IScoreObserver observer){
        this.scoreObserver=null;
    }
    public void updateScore(int val){
       scoreObserver.updateScoreOnKeyEvent(val);
    }
    
    
    public void addLifeObserver(ILifeObserver observer){
        this.lifeObserver=observer;
    }
    
    public void removeObserver(ILifeObserver observer){
        this.lifeObserver=null;
    }
    public void updateLife(int val){
        lifeObserver.updateLife(val);
    }
    
}
