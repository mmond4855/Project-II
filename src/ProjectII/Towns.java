package ProjectII;

import java.util.ArrayList;

public class Towns 
{
    private ArrayList <Town> towns = new ArrayList <Town> ();
    
    public void add(Town town)
    {
        towns.add(town);
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
    
    public void sort()
    {
        towns.sort(null);
        //Uses comparable
    }
    
}
