public class NumberGenerator {
	
	  private int randomNumber;
	
	  //Generate random number
	  //param minLimit the minimum value and maxLimit the maximum value (inclusive), for random number generation
	  //random integer from minLimit to maxLimit, inclusive 
	 
	  public int getNumberGenerator(int minLimit, int maxLimit)
	  {
	      randomNumber = (int)(Math.random()*(maxLimit - minLimit + 1) + minLimit);
	      return randomNumber;
	  }
	  
	  //Default Constructor for class NumberGenerator
	  
	  public NumberGenerator()
	  {
	      
	  }
	    
	  //Parameterized Constructor for setting minimum value and maximum value
	  //param minLimit, maxLimit are the integer values entered
	
	  public NumberGenerator(int minLimit, int maxLimit)
	  {
	      getNumberGenerator(minLimit, maxLimit);
	  }
 }
