    import greenfoot.*;

public class TurtleWorld extends World
{
    private Counter counter;

    /**
     * Create the turtle world. Our world has a size 
     * of 560x460 cells, where every cell is just 1 pixel.
     */
    public TurtleWorld() 
    {
        super(600, 480, 1); 
        prepare();  
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
        addObject(new ScoreBoard(560, 440), getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        counter = new Counter();
        addObject(counter, 58, 26);

        Turtle turtle = new Turtle();
        addObject(turtle, 171, 168);
        turtle.addScoreObserver(counter);
        turtle.addLifeObserver(counter);
        
        Lettuce lettuce = new Lettuce();
        addObject(lettuce, 419, 106);
        Lettuce lettuce2 = new Lettuce();
        addObject(lettuce2, 517, 210);
        Lettuce lettuce3 = new Lettuce();
        addObject(lettuce3, 529, 379);
        Lettuce lettuce4 = new Lettuce();
        addObject(lettuce4, 330, 426);
        Lettuce lettuce5 = new Lettuce();
        addObject(lettuce5, 405, 294);
        Lettuce lettuce6 = new Lettuce();
        addObject(lettuce6, 243, 61);
        Lettuce lettuce7 = new Lettuce();
        addObject(lettuce7, 103, 70);
        Lettuce lettuce8 = new Lettuce();
        addObject(lettuce8, 68, 335);
        Lettuce lettuce9 = new Lettuce();
        addObject(lettuce9, 218, 312);
        Lettuce lettuce10 = new Lettuce();
        addObject(lettuce10, 331, 205);
        Lettuce lettuce11 = new Lettuce();
        addObject(lettuce11, 129, 418);
        Lettuce lettuce12 = new Lettuce();
        addObject(lettuce12, 520, 453);
        Lettuce lettuce13 = new Lettuce();
        addObject(lettuce13, 568, 23);
        Lettuce lettuce14 = new Lettuce();
        addObject(lettuce14, 38, 237);
        Lettuce lettuce15 = new Lettuce();
        addObject(lettuce15, 345, 62);
        Lettuce lettuce16 = new Lettuce();
        addObject(lettuce16, 512, 94);
        Lettuce lettuce17 = new Lettuce();
        addObject(lettuce17, 458, 372);
        Snake snake = new Snake();
        addObject(snake, 456, 73);
        snake.addLifeObserver(counter);
        
        Snake snake2 = new Snake();
        addObject(snake2, 72, 396);
        snake2.addLifeObserver(counter);
        
        Snake snake3 = new Snake();
         //snake2.addLifeObserver(counter);
        //addObject(snake3, 484, 296);
        Snake snake4 = new Snake();
        //addObject(snake4, 45, 55);
        Bug bug = new Bug();
        addObject(bug, 361, 159);
        Bug bug2 = new Bug();
        addObject(bug2, 222, 402);
    }
}