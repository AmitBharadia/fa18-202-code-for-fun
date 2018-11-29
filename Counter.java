import greenfoot.*;

/**
 * A simple counter with graphical representation as an actor on screen.
 * 
 * @author mik
 * @version 1.0
 */
public class Counter extends Actor implements IScoreObserver, ILifeObserver
{ 
    //Singleton instance for Counter
    private static Counter counter = null;
    
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int value;
    private int target;
    private int lives;
    private int oldLives;
    private ILifeLine currentLifeLine;
    private OneLifeLine oneLife;
    private TwoLifeLine twoLife;
    private ThreeLifeLine threeLife;

    void setTwoLifeLine(){
        currentLifeLine=twoLife;
    }
    
    void setThreeLifeLine(){
        currentLifeLine=threeLife;
    }
    
    
    void setOneLifeLine(){
        currentLifeLine=oneLife;
    }
   
    
    /**
     * Create a new counter, initialised to 0. 
     */
    private Counter()
    {
        background = getImage();  // get image from class
        value = 0;
        target = 0;
        lives=1;
        oldLives=1;
        oneLife=new OneLifeLine(this);
        twoLife=new TwoLifeLine(this);
        threeLife=new ThreeLifeLine(this);
        currentLifeLine=oneLife;
        updateImage();
        
    }
    
    /**
     * 
     * 
     */
    public static Counter getInstance()
    {
        if(counter == null)
        {
            counter = new Counter();
        }
        
        return counter;
        
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
      lives++;
    }

    public int getLives(){
        return lives;
    }
    
 

    public void reduceLife(){
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
    
    public void updateScoreOnKeyEvent(int val){
        target +=val;
    }
    
    public void updateLife(int val){
        if(val>0)
           currentLifeLine.addLife();
        
        if(val<0){
             currentLifeLine.reduceLife();
        }
        
    }
    
    public void endGame(){
        TurtleWorld world = (TurtleWorld) getWorld();
        world.gameOver();
    }
    
    public void createNewTurtle()
    {
        Turtle newTurtle= new Turtle();
        newTurtle.addScoreObserver(this.counter);
        newTurtle.addLifeObserver(this.counter);
        World world;
        world = getWorld();
        
        int worldWidth = world.getWidth();
        int worldHeight = world.getHeight();
        
        int x = Greenfoot.getRandomNumber(worldWidth);
        int y = Greenfoot.getRandomNumber(worldHeight);
        
        world.addObject(newTurtle, x, y);
    }
}
