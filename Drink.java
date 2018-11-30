import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lettuce here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Drink extends Actor implements ActorClone
{
    /**
     * Act - do whatever the Lettuce wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Drink(){
         GreenfootImage image = getImage ();
        image.scale (image.getWidth ()/13, image.getHeight()/13);
        setImage (image);}
    public void act() 
    {
        // Add your action code here.
    }
    
    public Drink cloneActor()
    { 
        Drink clone = null; 
        try 
        { 
            clone = (Drink)super.clone(); 
        }  
        catch (CloneNotSupportedException e)  
        { 
            e.printStackTrace(); 
        } 
        return clone; 
    } 
}
