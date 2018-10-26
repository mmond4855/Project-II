package ProjectII;

import dao.LineSequential;

public class ProjectII
{

    public static void main(String[] args)
    {
        //For connecting to database.
       String dbDirectory = "F:/CIS2206 - Business Programming I/";
       String dbName = "PopulationDB";
       String userName = "Admin";
       String password = "MuCis";
       
       //For bringing in Transaction dat file
       String inFile = "F:/CIS2206 - Business Programming I/Project II/PopulationTransaction.dat";
       String inFileStreamName = "populationTransaction";
       String ioMode1 = "input";
       
       //For put in records
       String inputLine = "";
       
       //Our ruler with the transaction record included
       final int [] townRecordMarksIn = {3, 23, 25, 27, 33, 34};
       
         
  
       TransactionRecords town;//Declare new town object.
       
       //Opens the transaction dat file.
       initialization(inFile, inFileStreamName, ioMode1);
       
       PopulationDatabaseOperations.setConnection(dbDirectory, dbName, userName, password);
       //Connects to database.
       
       //loops through the records.
       while((inputLine = LineSequential.read(inFileStreamName)) != null)
       {
           town = new TransactionRecords(); //Declare new transaction record.
           
           //Updates the database.
            databaseUpdate(town, inputLine, townRecordMarksIn);
       }
       
       //Closes the dat file.
       termination(inFileStreamName, ioMode1);

        
    }
    
    //For opening the dat file.
    private static void initialization(String inFile, String inFileStreamName, String ioMode1)
    {
        LineSequential.open(inFile, inFileStreamName, ioMode1);
        
    }
    
    //Initializes transaction records.
    private static void initializeTransactionRecords(TransactionRecords town, String inputLine, int [] townRecordMarksIn)
    {
        town.setTownNumber(Integer.valueOf(inputLine.substring(0, townRecordMarksIn[0])));
        town.setTownName(inputLine.substring(townRecordMarksIn[0], townRecordMarksIn[1]));
        town.setCountyNumber(Integer.valueOf(inputLine.substring(townRecordMarksIn[1], townRecordMarksIn[2])));
        town.setRegionNumber(Integer.valueOf(inputLine.substring(townRecordMarksIn[2], townRecordMarksIn[3])));
        town.setPopulation(Integer.valueOf(inputLine.substring(townRecordMarksIn[3], townRecordMarksIn[4])));
        town.setTranCode(Integer.valueOf(inputLine.substring(townRecordMarksIn[4], townRecordMarksIn[5])));
    
    }
    
    //Updates the database.
    private static void databaseUpdate(TransactionRecords town, String inputLine, int [] townRecordMarksIn)
    {
        //I know this isn't really needed but I used it to not be so redundant when finding town numbers.
            
            
            initializeTransactionRecords(town, inputLine, townRecordMarksIn);
            int townNumberIn = town.getTownNumber();
            //For the transaction codes.
            switch(town.getTranCode())
                {
                    case 1: //For deleting.
                    {
                        PopulationDatabaseOperations.deleteTown(townNumberIn);
                        System.out.println("Record #: " + townNumberIn + " has been deleted.");
                        break;
                    }

                    case 2://For adding.
                    {
                        PopulationDatabaseOperations.insertTown(town);
                        System.out.println(town.getTownName() + " has been inserted.");
                        break;
                    }
                    
                    case 3://For modifying town name.
                    {
                        PopulationDatabaseOperations.modifyTownName(townNumberIn, town.getTownName());
                        System.out.println("Record #: " + townNumberIn + "'s name is modified.");
                        break;
                    }
                    
                    case 4://For modifying county number.
                    {
                        PopulationDatabaseOperations.modifyCountyNumber(townNumberIn, town.getCountyNumber());
                        System.out.println("Record #: " + townNumberIn + "'s county number is modified. ");
                        break;
                    }
                    
                    case 5://For modifying region number.
                    {
                        PopulationDatabaseOperations.modifyRegionNumber(townNumberIn, town.getRegionNumber());
                        System.out.println("Record #: " + townNumberIn + "'s region number is modified. ");
                        break;
                    }
                    case 6://For modifying population.
                    {
                        PopulationDatabaseOperations.modifyPopulation(townNumberIn, town.getPopulation());
                        System.out.println("Record #: " + townNumberIn + "'s population is modified. ");
                        break;
                    }
                    default: //Gives error message.
                    {
                        System.out.println("Invalid Code Tranasction.");
                        break;
                    }
                }
            
    
        
        
    }
    
    //Closes the database.
    private static void termination(String inFileStreamName, String ioMode1)
            {
                LineSequential.close(inFileStreamName, ioMode1);
                System.out.println("Database is complete. ");

            }
}
