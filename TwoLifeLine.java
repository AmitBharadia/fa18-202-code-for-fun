/**
 * Write a description of class TwoLifeLine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwoLifeLine implements ILifeLine 
{
     Counter counter;
    
    public TwoLifeLine(Counter counter){
         this.counter=counter;
    }
    public void addLife(){
        counter.addLife();
        counter.setThreeLifeLine();
    }
    
    public void reduceLife(){
        counter.reduceLife();
        counter.setOneLifeLine();
        counter.createNewTurtle();
    }
}
