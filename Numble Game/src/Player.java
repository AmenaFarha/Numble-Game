public class Player {
	
	private int lastGuess;  //palyer's last guess	
	private String playerName; //name of the player
	private int playerScore; //Player's Score 
    private int playerScore2; //Computer's score
   
    //get method which return the computer's score
    
    public int getComputerScore()
    {
    	return playerScore2;
    }
    
    //get method which return player's last guess of a round
    
    public int getLastGuess()
    {
    	return lastGuess;
    }
    
   //get method which return player's name
    
    public String getPlayerName()
    {
    	return playerName;
    }   

   //get method which return player's score
     
    public int getPlayerScore()
    {
    	return playerScore;
    }
     
    //Default Constructor for objects of class Player
    
    public Player()
    {
    	
    } 
    
    //set method to set the last guess and has a integer type parameter 
    
    public void setLastGuess(int guess)
    {
    	lastGuess = guess;
    }
     
    //set method to set player's name and has a string type parameter
    
    public void setName(String name)
    {
    	playerName = name;
    }
    
    //set method to set the scores of both players and has two integer type parameter
    
    public void setScore(int score1, int score2)
    {
    	playerScore = score1;
    	playerScore2 = score2;
    }
    
    //show the final score of both players at end of the game 
    
    public void showResult() 
       {
       System.out.println("=============================================================");
 	   System.out.println("                         Final Score                         ");
 	   System.out.println("=============================================================");
 	   System.out.println("");
 	   System.out.println("Final Score of "+getPlayerName()+ " is "+getPlayerScore());
 	   System.out.println();
 	   System.out.println("Final Score of Player2 is "+getComputerScore());
 	   System.out.println();
 	   
 	   if (playerScore > playerScore2 )
 	      System.out.println("congratulations! "+getPlayerName()+ " you have won the game. Well palyed!");
 	   else if (playerScore < playerScore2 )
 		   System.out.println("congratulations! Player 2 you have won the game. Well palyed!");   
 	   else 
 		   System.out.println("Its a draw. Well palyed both of you!");
 	   }
}
