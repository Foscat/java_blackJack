package techTalentSouth;


import java.util.Random;
import java.util.Scanner;

/* 
 * Objective: 
 * Get number close or equal to 21 over that loses game
 * 
 * Flow:
 * You get 2 cards and so does the computer
 * get prompt to get a new card and a prompt to stay with hand
 * 
 * Extras:
 * Have computer get more than 2 cards.
 * */

public class Blackjack_Game {

	//global refrence for user score
	static int myScore = 0;

	/////////////////////////////////////////////////////////////////////////////////////////
//	My user prompt
//	Scanner always returns a string so function needs to be String
	public static String hitOrStay(){
		String response = "response";
		
//		Declare scanner
		Scanner HorS = new Scanner(System.in);
		
		System.out.println("Hit or stay? Type Hit for hit all other inputs stay");
		String hitStay = HorS.next();
		
		if(hitStay.equals("hit")){
			int value = valueGiver();
			int newVal =valueAdder(value);
			if(newVal > 21){
				System.out.println("you busted");
				response = "you busted";
			}
			else{
			hitOrStay();
			response = "On like donkey kong";
			}
		}
		else{
			getWinner();
			response = "We respect your decision";	
		}
		return response;
		}
	//////////////////////////////////////////////////////////////////////////////////////
	public static boolean over21(){
		if(myScore <= 20){
			return false;
		}
		 if(myScore == 21){
			System.out.print("Winner Winner chiken dinner!");
			getWinner();
			return false;
		}
		if(myScore > 21){
			return true;
		}
		else{
			return true;
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////
	
	public static void getWinner(){
		int thierScore = computer();
		if(myScore > 21){
			if(myScore < thierScore){
				System.out.println("User busted but score was lower than computer so there is that");
			}
			else{
				System.out.println("Your pretty good a losing");
			}
		}
		if(myScore < 21){
			if(myScore > thierScore){
				System.out.println("You beat thier score!");
			}
			else if(thierScore > 21){
				System.out.println("They busted so you win!!");
			}
			else{
				System.out.println("They beat your score! But hey you didnt bust..");
			}
		}

	}
	
////////////////////////////////////////////////////////////////////////////
	// grabs a random card from deck and returns card as string
	public static String randomCard(){
		Random rand = new Random();
		String deck[] = {
				"ace", "two", "three", "four", "five",
				"six", "seven", "eight", "nine", "ten",
				"jack", "queen", "king"
				}; 
		int compChoice = rand.nextInt(13);
		String newCard = deck[compChoice];
		
		String suites[] = {"hearts", "clubs", "spades", "diamonds"};
		int randSuite = rand.nextInt(3);
		String newSuite = suites[randSuite];
		System.out.println("Random card drawn: " + newCard + " of " + newSuite);
		return newCard;
	}
	/////////////////////////////////////////////////////////////////////////////////
//	Gives values to each card string possibility that comes in
	public static int valueGiver(){
		
		//Test random card
		String card = randomCard();
		int output =0 ;
//		System.out.println(card);
		
		//ace if
		if(card.equals("ace")){
			
			System.out.println("you got a ace");
			
			Random rand = new Random();
			int aceVal = rand.nextInt(2) + 1;
			
			//ace value changer
			if(aceVal == 1){
				output = 1;
			}else{
				output = 11;
			}
		}
		if(card.equals("two")){
			output = 2;
		}
		if(card.equals("three")){
			output = 3;
		}
		if(card.equals("four")){
			output = 4;
		}
		if(card.equals("five")){
			output = 5;
		}
		if(card.equals("six")){
			output = 6;
		}
		if(card.equals("seven")){
			output = 7;
		}
		if(card.equals("eight")){
			output = 8;
		}
		if(card.equals("nine")){
			output = 9;
		}
		if(card.equals("ten")){
			output = 10;
		}
		if(card.equals("jack")){
			output = 10;
		}
		if(card.equals("queen")){
			output = 10;
		}
		if(card.equals("king")){
			output = 10;
		}
		
		return output;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	// Adds values of incoming score to current score
	public static int valueAdder(int inComing){
		int addValue = inComing += myScore;
		System.out.println("adding a value New Value: " + addValue);
		return addValue;
		
	}
	////////////////////////////////////////////////////////////////////////////////////
	
//	Get 2 cards at start of game
	public static int twoCardSpecial(){
		int card1 = valueGiver();
		int card2 = valueGiver();
		//Add cards together and give end value
		return card1 + card2;
	}
	/////////////////////////////////////////////////////////////////////////////////////
	
//	Start game function
	public static void startGame(){
		Scanner start = new Scanner(System.in);
		
		System.out.println("Play a game? yes for yes anything else for no");
		String starter = start.nextLine();
		if(starter.equals("yes")){
			int starterDeck = twoCardSpecial();
			myScore += starterDeck; 
			System.out.println("Your Score: " + myScore);
			hitOrStay();
		}
		else{
			System.out.println("Fine then. Be that way");
		}
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	public static int computer(){

		Random rand = new Random();  
		int compChoice = twoCardSpecial();
		System.out.println("Computer score " + compChoice);
		return compChoice; 
	}
//	Main content  
	public static void main(String[] args){
		//Test my input string
//		String hs = hitOrStay();
//		System.out.println(hs);
		
		//Test random card
//		int card = randomCard();
//		System.out.println(card);
		
		// Test value giver
//		int myVal = valueGiver();
//		System.out.println(myVal);
		//Test value adder
//		valueAdder(myVal);
//		int add = valueAdder(myVal);
//		System.out.println(add);
		
//		int twoCard = twoCardSpecial();
//		myScore = twoCard;
//		System.out.println(twoCard);
//		System.out.println("Yor score: " + myScore);
		
		startGame();
//		computer();

	}

}
