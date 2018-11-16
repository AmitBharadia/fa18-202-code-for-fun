/**
 * Write a description of class OneLifeLine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OneLifeLine implements ILifeLine
{
    Counter counter;
    
    public OneLifeLine(Counter counter){
         this.counter=counter;
    }
    public void addLife(){
        counter.addLife();
        counter.setTwoLifeLine();
        
    }
    
    public void reduceLife(){
        counter.reduceLife();
        counter.endGame();
    }
}
