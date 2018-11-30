import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class O2 extends Habitant
{
    public O2(){
     GreenfootImage image = getImage ();
        image.scale (image.getWidth()/12, image.getHeight()/12);
        setImage (image);
    }
    public void act()
    {
        
        move(4);
        randomTurn(); 
        turnAtEdge();
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
}
