import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A snake in my game that can eat turtles.
 * 
 * @author mik
 * @version 1.0
 */
public class Snake extends Animal
{
    private Counter counter;
   
    public void act()
    {
        // vhfj vhfdkvbhd vbhdfj
        move(4);
        randomTurn();
        turnAtEdge();
        tryToEatTurtle();
    }

    public Snake(Counter pointCounter)
    {
        counter = pointCounter;
    }
    
    /**
     * With a 10% probability, turn a bit right or left.
     */
    public void randomTurn()
    {
        if ( Greenfoot.getRandomNumber(100) < 10 )
        {
            turn( Greenfoot.getRandomNumber(40)-20 );
        }        
    }
    
    /**
     * If we reach the edge of the world, turn a little bit.
     */
    public void turnAtEdge()
    {
        if (atWorldEdge())
        {
            turn(7);
        }
    }
    
    /**
     * Check whether we can see Lettuce. If we can, eat it.
     */
    public void tryToEatTurtle()
    {
        if (canSee(Turtle.class) )
        {
            
            if(counter.getLives()>1){
                counter.reduceLife();
                eat(Turtle.class);
                createNewTurtle();
            }else{
                TurtleWorld world = (TurtleWorld) getWorld();
                eat(Turtle.class);
                world.gameOver();
            }
         }
    }
    
    private void createNewTurtle()
    {
        Turtle newTurtle= new Turtle(counter);
        
        World world;
        world = getWorld();
        
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        
        int x = Greenfoot.getRandomNumber(worldWidth);
        int y = Greenfoot.getRandomNumber(worldHeight);
        
        world.addObject(newTurtle, x, y);
    }
}
