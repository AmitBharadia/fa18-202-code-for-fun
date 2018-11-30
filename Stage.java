import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage extends Actor
{
    
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int stage;
    
    
    public Stage()
    {
        background = getImage();  // get image from class
        stage = 1;
        updateImage();   
    }
    
    public void updateStage()
    {
        stage++;
        updateImage();
    }
    
     private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage("Stage : " + stage, 14, Color.BLACK, transparent);
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}
