/**
 * Write a description of class ILifeSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ILifeSubject  
{
   
    void addLifeObserver(ILifeObserver observer);
    void removeObserver(ILifeObserver observer);
    void updateLife(int life);
    
}
