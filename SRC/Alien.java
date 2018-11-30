import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A snake in my game that can eat turtles.
 * 
 * @author mik
 * @version 1.0
 */
public class Alien extends Habitant implements ILifeSubject
{
    private ILifeObserver lifeObserver;
    Alien(){
        GreenfootImage image = getImage ();
        image.scale (image.getWidth ()/22, image.getHeight()/22);
        setImage (image);
    }
    public void act()
    {
        // vhfj vhfdkvbhd vbhdfj
        move(4);
        randomTurn();
        turnAtEdge();
        tryToEatTurtle();
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
        if (canSee(Rover.class) )
        {
            
            /*if(counter.getLives()>1){
                counter.reduceLife();
                eat(Turtle.class);
                createNewTurtle();
            }else{
                TurtleWorld world = (TurtleWorld) getWorld();
                eat(Turtle.class);
                world.gameOver();
            }*/
            
            eat(Rover.class);
            updateLife(-1);
         }
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
