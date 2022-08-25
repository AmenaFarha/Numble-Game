import java.util.*;

public class Game {
	
	Player player = new Player();  //create instance of Player class
	private int abandonGameIndicator = 6;  // Chosen 6 as abandonGameIndicator
	private int attempt = 0; // attempt number (initially 0)
	Scanner console = new Scanner(System.in); //create instance of Scanner
	private int computerAbandon; //Abandon number for computer
	private int computerGuess; //computer's guessed number
	private int computerScore = 0; // Computer's Score (initially 0)
	private int currentGuess;  //current guessed number
	NumberGenerator generatedNumber = new NumberGenerator();  //create instance of NumberGenerator class
	private int hiddenNumber;  //the hidden number
	private int max;  // maximum value of possible range 
	private int min;  // minimum value of possible range
	private String name; //name of the player
	private int partialScore1; //partial score if player is incorrect
	private int partialScore2; //partial score if computer is incorrect
    private String playerGuess; //Player's input
    private int playerGuessNumber; //player's input as guessed number 
    private int playerScore = 0; // Player's Score (initially 0)
    private int round = 1; // Round number (initially 1) 
    private int score; // score for correct guess
    private int turn;  // Player's turn
    
    //Calculate score if both player are incorrect
    
    public void calculateScore()
    {   	
 	 if (partialScore1 == partialScore2)		 
 	 {
 		 System.out.println();
 		 System.out.println("Hidden number for the round was "+hiddenNumber);
 		 System.out.println("No one of you got the point");
 		 showRoundScore();
 		 countRound();
 	 } 	 
 	 else if (partialScore1 < partialScore2)		 
 	  {
 		 System.out.println();
 		 System.out.println("Hidden number for the round was "+hiddenNumber);
 		 System.out.println(""+name+" got 1 point");
 		 playerScore = playerScore + 1;
 		 showRoundScore();
 		 countRound();
 	  } 	 
 	 else if (partialScore1 > partialScore2)		 
 	  {
 		 System.out.println();
 		 System.out.println("Hidden number for the round was "+hiddenNumber);
 		 System.out.println("Player2 got 1 the point");
 		 computerScore = computerScore + 1;
 		 showRoundScore();
 		 countRound();
 	 }
 	}  
    
    //Check computer's guessed number and get score if correct
    
    public void CheckComputerGuess() 
    {
    	
 	   if (computerGuess == hiddenNumber)
 		   
 		  {
 			 System.out.println("Player 2 guessed correctly!");  
 			 countScore();
 			 System.out.println();
 			 System.out.println("Hidden number for the round was "+hiddenNumber);
 			 System.out.println("Player 2 got "+score+" points."); 
 			 computerScore = computerScore + score;
 			 showRoundScore();
 			 countRound();
 		  }
 	   
 		 else if (computerGuess > hiddenNumber)			  
 		  {
 			 System.out.println("Inorrect Guess! 'Hint: Guessed number is higher than the hidden number.'\n");
 			 higerGuess();
 			 partialScore2 = computerGuess - hiddenNumber; 			 
 			 if (attempt == 6)	 
 				   calculateScore();	  
 		  } 			  
 		  else if (computerGuess < hiddenNumber)	  
 		  {
 			  System.out.println("Inorrect Guess! 'Hint: Guessed number is lower than the hidden number.New\n");
 			  lowerGuess();
 			  partialScore2 = hiddenNumber - computerGuess;		  
 			  if (attempt == 6)		  
 				   calculateScore();
 		  }		  
 	}
    
    //Check palyer's guessed number and get score if correct
    
    public void CheckPlayerGuess() 
    {	   
 	  if (playerGuessNumber == hiddenNumber) 		  
 	   { 
 		  System.out.println(""+name+" guessed correctly!");  
 		  countScore();
 		  System.out.println();
 		  System.out.println("Hidden number for the round was "+hiddenNumber);
 		  System.out.println(""+name+" got "+score+" points."); 
 		  playerScore = playerScore + score;
 		  showRoundScore();
 		  countRound();
 	   }	  
 	  else if (playerGuessNumber > hiddenNumber )		  
 	   {
 		  System.out.println("Inorrect Guess! 'Hint: Guessed number is higher than the hidden number.'\n");
 		  higerGuess();
 		  partialScore1 =  playerGuessNumber - hiddenNumber;	  
 		  if (attempt == 6)
 			  calculateScore();
 	   }		  
 	  else if (playerGuessNumber < hiddenNumber)	  
 	  {
 		  System.out.println("Inorrect Guess! 'Hint: Guessed number is lower than the hidden number.'\n");
 		  lowerGuess();
 		  partialScore1 = hiddenNumber - playerGuessNumber;	  
 		  if (attempt == 6)		  
 			   calculateScore();  
 	  }	  
    }
    
    //Check player name's length
    
    public void checkPlayerName()
    {
        if ((name.trim().length() == 0) || (name == null))     	
        {
            System.out.println("Name cannot be blank.");
            setPlayerName();
        }       
        else if (name.trim().length() > 8)       	
        {
            System.out.println("Name cannot contain more than 8 characters.");
            setPlayerName();
        }     
        else      	
        {
     	  System.out.println("Hi "+name+ "! Lets start the game.");
     	  System.out.println("");
     	  countRound();     	  
        }
    }
    
    //Generate random number from the possible range as computer guess
    //Check computerAbandon and abandonGameIndicator (I have chosen 6 for abandonGameIndicator)
    
    public void computerNumberGuess()
    {   	
      if (computerAbandon == abandonGameIndicator)    	  
      {
       attempt++;	 
       System.out.println ("The abandoned value is "+computerAbandon);	 
 	   System.out.println("Palyer2 has abandoned the round.\n");
 	   countScore();
 	   System.out.println(""+name+" got "+score+" points."); 
 	   playerScore = playerScore + score;
 	   showRoundScore();
 	   countRound();
      }     
      else     	  
      {  
 	   computerGuess = generatedNumber.getNumberGenerator(min, max);
 	   System.out.println("Player2's guessed number is "+computerGuess);
 	   currentGuess = computerGuess;
 	   attempt++;
      }     
    }
    
    //Start round and check the round number
    //check the attempt number for each round
    //Generate turn of players randomly
    
    public void countRound()
    {
 	   generateComputerAbandon();   //Generate abandon value for computer 
 	   hiddenNumber = generatedNumber.getNumberGenerator(1,100);  //Generate random number for hidden number
 	   turn = generatedNumber.getNumberGenerator(1,2);  //Generate random number for turn
 	   min = 1;
	   max = 100;	     
 	   if (round <= 4)       
 	   {
 		   System.out.println("************* Round "+round+ " ******************");
 		   System.out.println("");		   
 		   if (turn == 1)	   
 			   System.out.println("For this round 1st turn will be "+name+"'s.\n");		   
 		   else
 			   System.out.println("For this round 1st turn will be Player2's.\n");		   
 		   round++;
 		   attempt = 0;
 		   int i = 0;
 		  
 		   while (i <= 6) 
 		   {			   
 		   if (turn == 1) 			   
 		   {  
 			  System.out.println(""+name+", its your turn. Please enter a number: "); 
 		      playerGuess2();
 		 	  computerNumberGuess();
 		 	  CheckComputerGuess();
 	       }		   
 		   else		   
 		   {  
 			   computerNumberGuess();
 			   CheckComputerGuess();
 			   System.out.println(""+name+", its your turn. Please enter a number: ");  
 			   playerGuess2();
 		   }
 		   
 		  i=+2;
 		  
 	      }
 	   }	   
 	   else
 		   exitGame();
    }
    
    //Count score if both players are incorrect
  
    public void countScore()
    {
 	   switch (attempt)
        {
            case 1:
         	   score = 18; break;
            case 2:
         	   score = 12; break;
            case 3:
         	   score = 8; break;
            case 4:
         	   score = 5; break;
            case 5:
         	   score = 3; break;
            case 6:   
         	   score = 2; break;
            default:
            	
        }
 	 }
    
    //Display welcome massage and ask player to enter the name
    
    public void display()
    {
        System.out.println("***********************************************");
        System.out.println("******** Hello! Welcome to Numble Game ********");
        System.out.println("***********************************************");
        System.out.println();
        setPlayerName();
    }
    
    //Show final score of the game and ask player to exit game or restart the game
    
    public void exitGame()
    {
 	   player.setName(name);
 	   player.setScore(playerScore, computerScore);
 	   player.showResult();
 	   System.out.println();
 	   System.out.println("Do you want to paly again? If yes enter Y/y or otherwise enter any key.\n");
 	   String c = console.next();  
 	   if (c.equalsIgnoreCase("y"))
 		   {
 		   playerScore = 0;
 		   computerScore = 0;
 		   round = 1;
 		   setPlayerName();
 		   }	   
 	   else
 	      {
 		   System.out.println();
 		   System.out.println("Thanks for palying!");
 		   System.out.println("Hope to see you soon.");
 		   System.out.println();
 		   System.exit(0);
 	     }
    }
    
   //Constructor for objects of class Game
    
   public Game()
 	   {    
     	
 	   } 
    
   //Generate abandon value for computer
   
   public void generateComputerAbandon()
   {
	   computerAbandon = generatedNumber.getNumberGenerator(1,20); 
   }
   
   // Update maximum value as per the guessed number
   
   public void higerGuess()
   {
	   max = currentGuess - 1;	   
	   if (attempt < 6)
	   {
	   System.out.println("New possible range is in between "+min+" to "+max);
	   System.out.println();
	   }
   }
   
  // check the palyer's entered input is number or not
   
   private static boolean isNumeric(String str)
   {
		 if (str.matches("[0-9]+"))
		  return true;
		 else
		  return false;
   }
   
   // Update minimum value as per the guessed number
   
   public void lowerGuess()
   {
	   min = currentGuess + 1;
	   if (attempt < 6)
	   {
	   System.out.println("New possible range is in between "+min+" to "+max);
	   System.out.println();
	   }
   }
   
   //main method
   
   public static void main(String[] args)
   {
	   Game game = new Game();
       game.display();
		
   }
   
   //Take input from player as a guessed number 
   
   public void playerGuess2()
   { 
	   playerGuess = console.nextLine();
	   isNumeric(playerGuess);
	   if (isNumeric(playerGuess))
	   {
		   playerNumberGuess();
	   }
	   else 
	   {
		   System.out.println("Invalid!! Please enter a number in between the range.");
		   playerGuess2();
	   }
	   
   }
   
    //Check player's guessed number is in between the range or not
    //Check player's abandon value
      
   public void playerNumberGuess()
   {	   
	   playerGuessNumber = Integer.parseInt(playerGuess);
	   if (playerGuessNumber > 100)
	   {
		   if (playerGuessNumber == 999)
		   {
			   System.out.println(""+name+ " has abandoned the round.");
			   countScore();
			   attempt++;
			   countScore();
			   System.out.println("Player2 got "+score+" points."); 
			   computerScore = computerScore + score;
			   showRoundScore();
			   countRound();
		   }		   
		   else 
		   {   
		   System.out.println("Number cannot be Greater than 100. Enter again:\n");
		   playerGuess2();
		   }	   
	   }
       else if (playerGuessNumber < 1)
	   {
		   System.out.println("Number cannot be Less than 1. Enter again:\n");
		   playerGuess2();
	   }	   
	   else
	   {
	       if (playerGuessNumber < min || playerGuessNumber > max)
		   {	   
		   System.out.println(""+name+"'s guessed number is "+playerGuess);
		   System.out.println("Your guessed number is not in between the possible range.\n");
		   attempt++;
	       }		   
		   else
		   {
		   System.out.println(""+name+"'s guessed number is "+playerGuess);	 
		   currentGuess = playerGuessNumber;
		   attempt++;
		   CheckPlayerGuess();   
		   }
	   }   
   } 
   
   //To set player name ask player to enter the name
   
   public void setPlayerName()
   {
       console = new Scanner(System.in);
       System.out.println("Please enter your name: ");
       name = console.nextLine();
       checkPlayerName();
   }
   
   //Show round total score at the end of the round
   
   public void  showRoundScore()
   {
	     System.out.println();
		 System.out.println("Total score of "+name+ " is "+playerScore);
		 System.out.println("Total score of Player2 is "+computerScore);
		 System.out.println();
   }
}
