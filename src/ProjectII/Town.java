package ProjectII;

public class Town
{
    private int townNumber;
    private String townName;
    private int countyNumber;
    private int regionNumber;
    private int population;
    private String allInformation;

    public int getTownNumber()
    {
        return townNumber;
    }

    public void setTownNumber(int townNumber)
    {
        this.townNumber = townNumber;
    }

    public String getTownName()
    {
        return townName;
    }

    public void setTownName(String townName) 
    {
        this.townName = townName;
    }

    public int getCountyNumber() 
    {
        return countyNumber;
    }

    public void setCountyNumber(int countyNumber)
    {
        this.countyNumber = countyNumber;
    }

    public int getRegionNumber()
    {
        return regionNumber;
    }

    public void setRegionNumber(int regionNumber)
    {
        this.regionNumber = regionNumber;
    }
    
    public int getPopulation() 
    {
        return population;
    }

    public void setPopulation(int population) 
    {
        this.population = population;
    }

    public String getAllInformation()//all information is the record
    {
        return allInformation;
    }

    public void setAllInformation(String allInformation) 
    {
        this.allInformation = allInformation;
    }

}