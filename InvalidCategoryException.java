/**
 * This class defines a new subclass
 * for the Exception class.
 *
 * Project 11
 * Marco Gonzalez - COMP1210 - 010
 * 12/05/2018
 */
public class InvalidCategoryException extends Exception
{
  /**
   * Super constructor is invoked with the error message.
   */
   public InvalidCategoryException()
   {
      super("*** invalid category ***");
   }
}