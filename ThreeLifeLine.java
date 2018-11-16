/**
 * Write a description of class ThreeLifeLine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThreeLifeLine implements ILifeLine
{
    Counter counter;
    
    public ThreeLifeLine(Counter counter){
         this.counter=counter;
    }
    
    public void addLife(){
        
    }
    
    public void reduceLife(){
        counter.reduceLife();
        counter.setTwoLifeLine();
        counter.createNewTurtle();
    }
}
