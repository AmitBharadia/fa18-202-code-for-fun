    import greenfoot.*; 
    
    /**
     * This is a turtle in a first, simple video game. It can be controlled 
     * with the cursor keys and likes to eat lettuce.
     */
    public class Rover extends Habitant implements IScoreSubject, ILifeSubject
    {
        private IScoreObserver scoreObserver;
        private ILifeObserver lifeObserver;
       public Rover(){
        GreenfootImage image = getImage ();
        image.scale (image.getWidth ()-60, image.getHeight()-60);
        setImage (image);
    }
      
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
        if (canSee(Drink.class) )
        {
            eat(Drink.class);
            updateScore(15);   
            Greenfoot.playSound("slurp.wav");
            if(getWorld().getObjects(Drink.class).size() == 0) 
            {
                    Mars world = (Mars) getWorld();
                    world.Upgrade();
                    return;
                    
            }
        }
        
        if (canSee(O2.class) )
        {
            eat(O2.class);
            updateLife(1);
            Greenfoot.playSound("slurp.wav");
           
        }
 
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
