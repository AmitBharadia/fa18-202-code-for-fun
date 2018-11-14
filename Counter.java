import greenfoot.*;

/**
 * A simple counter with graphical representation as an actor on screen.
 * 
 * @author mik
 * @version 1.0
 */
public class Counter extends Actor
{ 
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int value;
    private int target;
    private int lives;
    private int oldLives;

    /**
     * Create a new counter, initialised to 0. 
     */
    public Counter()
    {
        background = getImage();  // get image from class
        value = 0;
        target = 0;
        lives=1;
        oldLives=1;
        updateImage();
    }
    
    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() 
    {
        if (value < target) {
            value++;
            updateImage();
        }
        else if (value > target) {
            value--;
            updateImage();
        }

        if(oldLives !=lives){
            oldLives=lives;
            updateImage();   
        }

    }

    /**
     * Add a new score to the current counter value.
     */
    public void add(int score)
    {
        target += score;
    }


        /**
     * Add a life to turtle.
     */
    public void addLife()
    {
        if(lives<3){
            lives++;
        }
    }

    public int getLives(){
        return lives;
    }

    public void reduceLife(){
        if(lives>1)
         lives--;
    }



    /**
     * Return the current counter value.
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Set a new counter value.
     */
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        updateImage();
    }

    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage("S : " + value + " |  L : " +oldLives, 14, Color.BLACK, transparent);
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
}
