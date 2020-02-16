import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
/**
 * This class provides methods for
 * reading in the data file and 
 * generating the monthly reports.
 *
 * Project 11
 * Marco Gonzalez - COMP1210 - 010
 * 12/05/2018
 */
public class CardholderProcessor
{
   // Instance variables
   
   /** An array of Cardholder objects. */
   private Cardholder[] cards;
   /** 
    * An array of String elements to hold
    * invalid records from the data file.  
    */
   private String[] invalidRecords;
    
    // Constructor
    
/**
 * Sets default values for the instance variables.
 */
   public CardholderProcessor()
   {
      cards = new Cardholder[0];
      invalidRecords = new String[0];
   }
    
    // Methods
    
 /**
  * Returns an array of type Cardholder
  * representing the Cardholder array
  * field.
  *
  * @return The Cardholder array
  */
   public Cardholder[] getCardholdersArray()
   {
      return cards;
   }
   
 /**
  * Returns an array of type String
  * representing the invalid records
  * array field.
  *
  * @return The invalid records array
  */
   public String[] getInvalidRecordsArray()
   {
      return invalidRecords;
   }
   
 /**
  * Increases the Cardholder array's capacity
  * by one. Adds the parameter  cardsIn in
  * the last position of the String array.
  *
  * @param cardsIn Command line arguments
  */
   public void addCardholder(Cardholder cardsIn)
   {
      cards = Arrays.copyOf(cards, cards.length + 1);
      cards[cards.length - 1] = cardsIn;
   }
   
 /**
  * Increases the Cardholder array's capacity
  * by one. Adds the parameter  cardsIn in
  * the last position of the String array.
  *
  * @param records Command line arguments
  */
   public void addInvalidRecord(String records)
   {
      invalidRecords = Arrays.copyOf(invalidRecords, invalidRecords.length + 1);
      invalidRecords[invalidRecords.length - 1] = records;
   }
   
 /**
  * Reads the data file name as a String
  * and throws FileNotFoundException. A
  * Scanner object on the line should be
  * created to read the values in that line.
  * The Cardholder objects that are read are
  * added to the Cardholder array.
  *
  * @param filename Command line arguments
  * @throws FileNotFoundException for File Scanner
  */
   public void readCardholderFile(String filename) 
      throws FileNotFoundException
   {
      
      Scanner scanFile = new Scanner(new File(filename));
      scanFile.useDelimiter("\n");
      while (scanFile.hasNext())
      {
         
         
         String currentLine = scanFile.next();
         Scanner scan = new Scanner(currentLine);
         
         
         scan.useDelimiter(";");
         
         scan.useDelimiter("\n");
         
         
         String category = scan.useDelimiter(";").next();
         
         try
         {
            
            if (!(category.equals("1")) 
                  && !(category.equals("2")) && !(category.equals("3")))
            {
               throw new InvalidCategoryException();
            }
         
         
            if (category.equals("1"))
            {
               category = "Sapphire Cardholder";
            }
            if (category.equals("2"))
            {
               category = "Diamond Cardholder";
            }
            if (category.equals("3"))
            {
               category = "Blue Diamond Cardholder";
            }
         
         
            try
            {   
               String acctNumber = scan.next();
               String name = scan.next();
               double prevBalance = Double.parseDouble(scan.next());
               double payment = Double.parseDouble(scan.next());
            
               double[] purchases = new double[0]; 
               while (scan.hasNext())
               {
                  String temp = scan.next();
                  double purchase = Double.parseDouble(temp.trim());
                  purchases = Arrays.copyOf(purchases, purchases.length + 1);
                  purchases[purchases.length - 1] = purchase;
               }
            
            
               if (category.equals("Sapphire Cardholder"))
               {
                  SapphireCardholder sc = 
                     new SapphireCardholder(acctNumber, name);
                  sc.addPurchases(purchases);
                  sc.setPrevBalance(prevBalance);
                  sc.setPayment(payment);
                  addCardholder(sc);
               }
               else if (category.equals("Diamond Cardholder"))
               {
                  DiamondCardholder dc = 
                     new DiamondCardholder(acctNumber, name);
                  dc.addPurchases(purchases);
                  dc.setPayment(payment);
                  dc.setPrevBalance(prevBalance);
                  addCardholder(dc);
               }
               else
               {
                  BlueDiamondCardholder bdc = 
                     new BlueDiamondCardholder(acctNumber, name);
                  bdc.addPurchases(purchases);
                  bdc.setPayment(payment);
                  bdc.setPrevBalance(prevBalance);
                  addCardholder(bdc);
               }
            }
            catch (NumberFormatException e)
            {
               String invalidNum = 
                  currentLine.trim() + " *** invalid numeric value ***";
               addInvalidRecord(invalidNum);
            }
         
         }
         catch (InvalidCategoryException e)
         {
            String invalidCat = 
               currentLine.trim() + " *** invalid category ***";
            addInvalidRecord(invalidCat);
         }
         
            
      }
      
      
   }
   
 /**
  * Reads the Cardholder array in the same
  * order as in the file that was read. It
  * prints the objects as a report.
  *
  * @return Monthly Cardholder Report
  */
   public String generateReport()
   {
      String monthlyReport = "----------------------------";
      monthlyReport += "\nMonthly Cardholder Report";
      monthlyReport += "\n----------------------------";
      
      
      for (Cardholder object : cards) {
         monthlyReport += ("\n" + object + "\n");
      }
      
      return monthlyReport + "\n";
   }
   
 /**
  * Reads the Cardholder array, looks at the
  * names in each object, and sorts them by
  * alphabetical order. It prints the objects 
  * as a report.
  *
  * @return Monthly Cardholder Report (by name)
  */
   public String generateReportByName()
   {
      String monthlyReport = "--------------------------------------";
      monthlyReport += "\nMonthly Cardholder Report (by Name)";
      monthlyReport += "\n--------------------------------------";
      Arrays.sort(cards);
      for (Cardholder object : cards) {
         monthlyReport += ("\n" + object + "\n");
      }
      
      return monthlyReport + "\n";
   }
   
 /**
  * Reads the Cardholder array, looks at the current
  * balance in each object, and sorts them numerically.
  * It prints the objects as a report.
  *
  * @return Monthly Cardholder Report (by balance)
  */
   public String generateReportByCurrentBalance()
   {
      String monthlyReport = "---------------------------------------";
      monthlyReport += "\nMonthly Cardholder Report (by Current Balance)";
      monthlyReport += "\n---------------------------------------";
      
      Arrays.sort(cards, new CurrentBalanceComparator());
      for (Cardholder object : cards) {
         monthlyReport += ("\n" + object + "\n");
      }
      
      return monthlyReport + "\n";
   }
   
   
 /**
  * Reads the invalid records array and prints each
  * element as part of a Invalid Records Report at
  * the end of the initial output.
  *
  * @return Invalid Records Report
  */
   public String generateInvalidRecordsReport()
   {
      String invalidReport = "-----------------------";
      invalidReport += "\nInvalid Records Report";
      invalidReport += "\n-----------------------";
      
      for (String line : invalidRecords) 
      {
         invalidReport += ("\n" + line + "\n");
      }
      
      return invalidReport + "\n";
   }
}