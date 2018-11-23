    import greenfoot.*;
    import java.util.*;

public class TurtleWorld extends World
{
    private Counter counter;
    
    private ArrayList<ILevelStrategy> levels;
    
    private ScoreBoard score = new ScoreBoard(560, 440);
    
    

    /**
     * Create the turtle world. Our world has a size 
     * of 560x460 cells, where every cell is just 1 pixel.
     */
    public TurtleWorld() 
    {
        super(600, 480, 1);
        ILevelStrategy l1 = new LevelOne(this);
        ILevelStrategy l2 = new LevelTwo(this);
        ILevelStrategy l3 = new LevelThree(this);
        levels = new ArrayList<ILevelStrategy>();
        levels.add(l1);
        //levels.add(l2);
        //levels.add(l3);
        prepare();  
    }

    
    /**
     * Upgrade Game to next level
     */
    public void Upgrade()
    {
        removeObjects(getObjects(Turtle.class));
        removeObjects(getObjects(Counter.class));
        removeObjects(getObjects(Snake.class));        
        addObject(score, getWidth() / 2, getHeight() / 2);
        Greenfoot.delay(50);
        removeObject(score); 
        levels.remove(0);
        
        if(levels.size()>0)
        {
            prepare();
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
        
        
        /*if(UserInfo.isStorageAvailable()) {
            UserInfo myData = UserInfo.getMyInfo();
            if (myData != null) {
                int newScore = counter.getValue();
                if (newScore > myData.getScore()) {
                    myData.setScore (newScore);
                    myData.store();  // write back to server
                }
            }
        }*/
         
        addObject(score, getWidth() / 2, getHeight() / 2);
        
        Greenfoot.stop();        
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
      levels.get(0).prepare();
    }
}