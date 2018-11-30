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
        background.scale (background.getWidth ()*2, background.getHeight()*2);
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
        GreenfootImage text;
        if(stage==1){
            text = new GreenfootImage("Valles Marineris", 20, Color.BLACK, transparent);
        }else if(stage==2){
            text = new GreenfootImage("Olympus Mons", 20, Color.BLACK, transparent);
        }else{
            text = new GreenfootImage("The Great Red Spot", 20, Color.BLACK, transparent);
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}
