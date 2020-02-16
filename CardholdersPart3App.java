import java.io.FileNotFoundException;
/**
 * This class serves as the driver
 * and includes the main method.
 *
 * Project 11
 * Marco Gonzalez - COMP1210 - 010
 * 12/05/2018
 */
public class CardholdersPart3App
{
  /**
* This main method checks if the a
* valid file name was given and 
* generates four different reports
* based on the info in the file.
*
* @param args Command line arguments
*/
   public static void main(String[] args)
   { 
      if (args.length == 0)
      {
         System.out.println("File name expected as"
            + " command line argument.\nProgram ending.\n"); 
      }
      else
      {
         try
         {
            CardholderProcessor obj = new CardholderProcessor();
            obj.readCardholderFile(args[0]);
            System.out.print(obj.generateReport());
            System.out.print(obj.generateReportByName());
            System.out.print(obj.generateReportByCurrentBalance());
            System.out.print(obj.generateInvalidRecordsReport());
         }
         catch (FileNotFoundException e)
         {
            System.out.println(" *** Attempted to read file: "
               + args[0] + " (No such file or directory)");
         }
      }
   }
}