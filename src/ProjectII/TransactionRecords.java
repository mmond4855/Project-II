
package ProjectII;

import java.util.*;

public class TransactionRecords extends Town
{
    private int tranCode = 0;
    //for the transaction code
    private ArrayList<Town> towns = new ArrayList<Town>();
   
  
    public void update()
    {
    
    
    
    }
    
    public void add(Town t)
    {
        towns.add(t);
    
    }
    
    public Town get(int i)
    {
        return towns.get(i);
        //gets the object
    }
    
    public int size ()
    {
        return towns.size();
    }
  
    public int getTranCode() 
    {
        return tranCode;
    }

    
    public void setTranCode(int tranCode) 
    {
        this.tranCode = tranCode;
    }
    
    
    
}
