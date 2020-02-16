import java.util.Arrays;
import java.text.DecimalFormat;
/**
 * This class outputs information
 * about a user's account. The 
 * information deals with their
 * balance, category, account number,
 * purchases, and purchase points.
 *
 * Project 11
 * Marco Gonzalez - COMP1210 - 010
 * 12/05/2018
 */
public abstract class Cardholder implements Comparable<Cardholder>
{
   // Instance Variables
   
   /** The category. */
   protected String category;
/** The account number. */
   protected String acctNumber;
/** The name. */
   protected String name;
/** The previous balance. */
   protected double prevBalance;
/** The payment amount. */
   protected double payment;
/** An array that represents new purchases. */
   protected double[] purchases;
/** The interest rate. */
   public static final double INTEREST_RATE = 0.01;

// Constructor

/**
 * Sets default values for the instance variables.
 *
 * @param acctNumberIn Command line arguments
 * @param nameIn Command line arguments
 */
   public Cardholder(String acctNumberIn, String nameIn) 
   {
      name = nameIn;
      acctNumber = acctNumberIn;
      purchases = new double[0];
   }
 
 //Methods
   
 /**
  * Returns the account number.
  *
  * @return The account number
  */
   public String getAcctNumber()
   {
      return acctNumber;
   }
   
 /**
  * Sets a value to the account number.
  *
  * @param acctNumberIn Command line arguments
  */
   public void setAcctNumber(String acctNumberIn)
   {
      acctNumber = acctNumberIn;
   }
  
 /**
  * Returns a name.
  *
  * @return name
  */
   public String getName()
   {
      return name;
   }
   
 /**
  * Sets a value to name.
  *
  * @param nameIn Command line arguments
  */
   public void setName(String nameIn)
   {
      name = nameIn;
   }
  
 /**
  * Returns the previous balance.
  *
  * @return The previous balane
  */
   public double getPrevBalance()
   {
      return prevBalance;
   }
   
 /**
  * Sets a value to previous balance.
  *
  * @param prevBalanceIn Command line arguments
  */
   public void setPrevBalance(double prevBalanceIn)
   {
      prevBalance = prevBalanceIn;
   }
  
 /**
  * Returns the payment amount.
  *
  * @return The payment amount
  */
   public double getPayment()
   {
      return payment;
   }
   
 /**
  * Sets a value to the payment amount.
  *
  * @param paymentIn Command line arguments
  */
   public void setPayment(double paymentIn)
   {
      payment = paymentIn;
   }
  
 /**
  * Returns the array of purchases.
  *
  * @return The array of purchases
  */
   public double[] getPurchases()
   {
      return purchases;
   }
   
 /**
  * Sets a value to the list of purchases.
  *
  * @param purchasesIn Command line arguments
  */
   public void setPurchases(double[] purchasesIn)
   {
      purchases = purchasesIn;
   }
  
 /**
  * Accepts a variable length parameter and adds
  * double values to the purchases array.
  *
  * @param list Command line arguments
  */
   public void addPurchases(double... list)
   { 
                
      for (double x : list)
      {
         addPurchases2(x);
      }
   }
   
   /**
  * This method adds a purchase to the
  * purchase list.
  *
  * @param element Command line arguments
  */
   private void addPurchases2(double element)
   {
      boolean check = false;
      if (purchases.length == 0)
      {
         check = true;
      }
      purchases = Arrays.copyOf(purchases, purchases.length + 1); 
      for (int j = 0; j <= purchases.length; j++)
      {
         if (check)
         {
            purchases[0] = element;
         }
         else
         {
            purchases[purchases.length - 1] = element;
         } 
      }
      
   }
     
   /**
    * This method finds the variables that matches the parameter
    * and deletes them from the list.
    *
    * @param list Command line arguments
    */
   public void deletePurchases(double... list)
   {
      for (double x : list)
      {
         deletePurchases2(x);
      }
   }
   
   /**
    * This method removes the specified element.
    *
    * @param element Command line arguments
    */
   private void deletePurchases2(double element)
   {
      int count = 0;
      int check = 0;
      for (int i = 0; i < purchases.length; i++)
      {
         if (purchases[i] == element)
         {
            count = 1 + count;
            for (int j = i; j < purchases.length - 1; j++)
            {
               purchases[j] = purchases[j + 1];
            }
         }
         else
         {
            check++;
         }
      }
     
      if (check != purchases.length)
      {
         for (int z = 0; z < count; z++) 
         {
            purchases = Arrays.copyOf(purchases, purchases.length - 1);
         }
      } 
   }
   
 /**
  * Returns calculated interest.
  *
  * @return Interest owed
  */
   public double interest()
   {
      return (prevBalance - payment) * INTEREST_RATE;
   }
  
 /**
  * Returns total items in purchase array.
  *
  * @return array number size
  */
   public double totalPurchases()
   {
      double total = 0;
      for (double x : purchases)
      {
         total += x;
      }
      return total;
   }
  
 /**
  * Returns balance.
  *
  * @return balance
  */
   public double balance()
   {
      return prevBalance + interest() + totalPurchases();
   }
  
 /**
  * Returns current balance.
  *
  * @return current balance
  */
   public double currentBalance()
   {
      return prevBalance - payment + interest() + totalPurchases();
   }
  
  /**
  * Returns minimial payment.
  *
  * @return minimal payment
  */
   public double minPayment()
   {
      return currentBalance() * .03;
   }
  
 /**
  * Returns output.
  *
  * @return output
  */
   public String toString()
   {
      String strBalance = Double.toString(prevBalance);
      DecimalFormat newFormat1 = new DecimalFormat("$#,##0.00");
      DecimalFormat newFormat2 = new DecimalFormat("#,##0");
      String output = category;
      output += "\nAcctNo/Name: " + acctNumber + " " + name;
      output += "\nPrevious Balance: " + newFormat1.format(prevBalance);
      output += "\nPayment: (" + newFormat1.format(payment) + ")";
      output += "\nInterest: " + newFormat1.format(interest());
      output += "\nNew Purchases: " + newFormat1.format(totalPurchases());
      output += "\nCurrent Balance: " + newFormat1.format(currentBalance());
      output += "\nMinimum Payment: " + newFormat1.format(minPayment());
      output += "\nPurchase Points: " + newFormat2.format(totalPurchases());
      return output;
   }
  
 /**
  * Returns number of purchase points gained.
  *
  * @return purchase points
  */
   public abstract int purchasePoints();

 /**
  * The compareTo method compares the name
  * strings in the objects.
  *
  * @param obj Command line arguments
  * @return purchase points
  */
   public int compareTo(Cardholder obj)
   {
      return name.compareToIgnoreCase(obj.getName());
   }
   
  /**
   * Checks if an object is of the
   * Cardholder type.
   *
   * @param obj Command line arguments
   * @return true or false
   */
   public boolean equals(Object obj) 
   { 
      if (!(obj instanceof Cardholder)) {
         return false;
      }
      else {
         Cardholder c = (Cardholder) obj;
         return (name.equalsIgnoreCase(c.getName()));
      } 
   }
      
  /**
   * Allows for comparison of two Cardholder
   * arrays.
   *
   * @return zero
   */
   public int hashCode() 
   { 
      return 0;
   }  


}


