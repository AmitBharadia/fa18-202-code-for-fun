    import greenfoot.*;
    import java.util.*;

public class TurtleWorld extends World
{
    //public Counter counter;
    
    private IUpgradeChain current;
    private ScoreBoard score = new ScoreBoard(560, 440);
    private Counter counter=new Counter();
    private Stage stage = new Stage();
    private Notification nextStage = new Notification("nextStage.png",getWidth() / 2, getHeight() / 2);

    /**
     * Create the turtle world. Our world has a size 
     * of 560x460 cells, where every cell is just 1 pixel.
     */
    public TurtleWorld() 
    {
        super(600, 480, 1);
        IUpgradeChain c1 = new LevelOne(this,counter);
        IUpgradeChain c2 = new LevelTwo(this,counter);
        IUpgradeChain c3 = new LevelThree(this,counter);
        c1.setNext(c2);
        c2.setNext(c3);
        current = c1;
        addObject(counter, 58, 26);
        addObject(stage, getWidth() - 90, 26);
        prepare();
    }

    
    /**
     * Upgrade Game to next level
     */
    public void Upgrade()
    {
        stage.updateStage();
        removeObjects(getObjects(Turtle.class));
        removeObjects(getObjects(Snake.class)); 
        removeObjects(getObjects(Bug.class)); 
        addObject(nextStage, getWidth() / 2, getHeight() / 2);
        Greenfoot.delay(50);
        removeObject(nextStage); 
     
        //Greenfoot.stop();
        
       if(this.current != null)
       {
         this.current.handleUpgrade();
       }
       else
       {
           gameOver();
       }
    }
    
    /**
     * Game's over. Store the player score in the high score table if possible.
     */
    public void gameOver()
    {
        Greenfoot.playSound("game-over.wav");
        
        if(getObjects(Lettuce.class).size() == 0)
        {
        Notification gameOver = new Notification("win.jpg",getWidth()/2, getHeight()/2);
        addObject(gameOver,getWidth() / 2, getHeight() / 2 );
        }
        else
        {
         Notification gameOver = new Notification("lose.png",getWidth()/2, getHeight()/2);
        addObject(gameOver,getWidth() / 2, getHeight() / 2 );   
        }
        
        Greenfoot.stop();        
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
      this.current.handleUpgrade();
    }
}