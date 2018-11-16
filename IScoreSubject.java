import lang.stride.*;

/**
 * Write a description of class ICounterSubject here.
 * @author (your name) @version (a version number or a date)
 */
public interface IScoreSubject
{

    void addScoreObserver(IScoreObserver observer);
    void removeObserver(IScoreObserver observer);
    void updateScore(int val);
    
}
