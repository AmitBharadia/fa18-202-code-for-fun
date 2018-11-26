
public interface IUpgradeChain  
{
    
    public void setNext(IUpgradeChain next);
    
    public IUpgradeChain getNext();
    
    public void handleUpgrade();
    
    public void prepare();
}
