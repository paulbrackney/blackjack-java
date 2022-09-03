import java.util.Scanner;

public class Blackjack{

public class Cards {

//declaring variables for cards
public int value;
  public String name;
  public String suit;
  public double number;
  public String symbol;
  public String character;

//creating constructor for cards
public Cards(int value, String name, String suit, double number, String symbol, String character){
  this.value = value;
  this.name = name;
  this.suit = suit;
  this.number = number;
  this.symbol = symbol;
  this.character = character;
  }
}

//creating a deck of standard playing cards
 Cards[] deck = {
   new Cards(11, "ace", "spades", 1, "♠", "A"),
   new Cards(2, "two", "spades", 2, "♠", "2"),
   new Cards(3, "three", "spades", 3, "♠", "3"),
   new Cards(4, "four", "spades", 4, "♠", "4"),
   new Cards(5, "five", "spades", 5, "♠", "5"),
   new Cards(6, "six", "spades", 6, "♠", "6"),
   new Cards(7, "seven", "spades", 7, "♠", "7"),
   new Cards(8, "eight", "spades", 8, "♠", "8"),
   new Cards(9, "nine", "spades", 9, "♠", "9"),
   new Cards(10, "ten", "spades", 10, "♠", "10"),
   new Cards(10, "jack", "spades", 11, "♠", "J"),
   new Cards(10, "queen", "spades", 12, "♠", "Q"),
   new Cards(10, "king", "spades", 13, "♠", "K"),
   new Cards(11, "ace", "hearts", 14, "♥", "A"),
   new Cards(2, "two", "hearts", 15, "♥", "2"),
   new Cards(3, "three", "hearts", 16, "♥", "3"),
   new Cards(4, "four", "hearts", 17, "♥", "4"),
   new Cards(5, "five", "hearts", 18, "♥", "5"),
   new Cards(6, "six", "hearts", 19, "♥", "6"),
   new Cards(7, "seven", "hearts", 20, "♥", "7"),
   new Cards(8, "eight", "hearts", 21, "♥", "8"),
   new Cards(9, "nine", "hearts", 22, "♥", "9"),
   new Cards(10, "ten", "hearts", 23, "♥", "10"),
   new Cards(10, "jack", "hearts", 24, "♥", "J"),
   new Cards(10, "queen", "hearts", 25, "♥", "Q"),
   new Cards(10, "king", "hearts", 26, "♥", "K"),
   new Cards(11, "ace", "clubs", 27, "♣", "A"),
   new Cards(2, "two", "clubs", 28, "♣", "2"),
   new Cards(3, "three", "clubs", 29, "♣", "3"),
   new Cards(4, "four", "clubs", 30, "♣", "4"),
   new Cards(5, "five", "clubs", 31, "♣", "5"),
   new Cards(6, "six", "clubs", 32, "♣", "6"),
   new Cards(7, "seven", "clubs", 33, "♣", "7"),
   new Cards(8, "eight", "clubs", 34, "♣", "8"),
   new Cards(9, "nine", "clubs", 35, "♣", "9"),
   new Cards(10, "ten", "clubs", 36, "♣", "10"),
   new Cards(10, "jack", "clubs", 37, "♣", "J"),
   new Cards(10, "queen", "clubs", 38, "♣", "Q"),
   new Cards(10, "king", "clubs", 39, "♣", "K"),
   new Cards(11, "ace", "diamonds", 40, "♦", "A"),
   new Cards(2, "two", "diamonds", 41, "♦", "2"),
   new Cards(3, "three", "diamonds", 42, "♦", "3"),
   new Cards(4, "four", "diamonds", 43, "♦", "4"),
   new Cards(5, "five", "diamonds", 44, "♦", "5"),
   new Cards(6, "six", "diamonds", 45, "♦", "6"),
   new Cards(7, "seven", "diamonds", 46, "♦", "7"),
   new Cards(8, "eight", "diamonds", 47, "♦", "8"),
   new Cards(9, "nine", "diamonds", 48, "♦", "9"),
   new Cards(10, "ten", "diamonds", 49, "♦", "10"),
   new Cards(10, "jack", "diamonds", 50, "♦", "J"),
   new Cards(10, "queen", "diamonds", 51, "♦", "Q"),
   new Cards(10, "king", "diamonds", 52, "♦", "K"),
};

//method to start a new game 
public void startGame(Blackjack game){
	game.placeBet();
	mySize = 2;
	myScore = 0;
	dealSize = 2;
	dealerScore = 0;
    game.dealCards();
	game.printBoard(game);
}

public int bet = 0;
// method that prompts the user to place a bet
public void placeBet(){
	Scanner scnr = new Scanner(System.in);
	boolean invalid = true;
			do {
			System.out.println("Please place your bet for this hand. For example, if you want to bet $5 this hand, just click 5.");
	bet = scnr.nextInt();
			if (bet >= 5 && bet <= myChips){
				invalid = false;
			} else if (bet < 5) {
				System.out.println("Minimum bet is $5. Please enter a number greater than or equal to 5.");
			} else {
				System.out.println("Your bank only has $" + myChips + ". Please enter a number less than or equal to your bank."); 
			}
		} while (invalid);
	System.out.println("The game is about to begin! You bet $" + bet + ". Good luck!");
	System.out.println();
}


//method that awards chips for blackjack wins (pays 3:2)
public void awardBlackjack(int bet){
	myChips = myChips + ((3*bet)/2);
	System.out.println("Now you have $" + myChips + ".");
}

//method that awards chips for non-blackjack wins
public void awardChips(int bet){
	myChips += bet;
	System.out.println("Now you have $" + myChips + ".");
}

//method that subtracts chips for losses 
public void takeChips(int bet){
	myChips -= bet;
	System.out.println("Now you have $" + myChips + ".");
}

//method that checks if player has enough chips to play again
public void checkChips(Blackjack game){
	Scanner scnr = new Scanner(System.in);
	if (myChips < 5){
		System.out.println("Unfortunately, your bank has fell below the minimum bet for this game. Better luck next time!");
	} else {
		boolean invalid = true;
			do {
			System.out.println("Would you like to play another hand? Please enter 'yes' or 'no'.");
			String decision = scnr.nextLine();
			if (decision.equals("yes")){
				invalid = false;
				game.startGame(game);
			} 
			if (decision.equals("no")){
				invalid = false;
			}
		} while (invalid);
	}
}


public int myChips = 20;
//main method
public static void main(String[] args){
	Scanner scnr = new Scanner(System.in);
	System.out.println("Welcome to Blackjack! At this table, Blackjack pays 3:2. ");
	System.out.println("You will start the game with $20, and your goal is to end the game with as many chips as possible.");
	System.out.println("The minimum bet is $5, so falling below that will automatically end the game.");
	System.out.println("You can choose to end the game at any time, and your remaining chips will be your final score. ");
	
	boolean invalid = true;
			do {
			System.out.println("Are you ready to play? Please enter 'yes' or 'no'.");
			String decision = scnr.nextLine();
			if (decision.equals("yes")){
				invalid = false;
				Blackjack game = new Blackjack();
				game.startGame(game);
			} 
			if (decision.equals("no")){
				invalid = false;
			}
		} while (invalid);
  }
  
  int mySize = 2;
  Cards[] myCards = new Cards[10];
  int dealSize = 2;
  Cards[] dealerCards = new Cards[10];

/*method that deals 2 random cards to the player and 2 random cards to the dealer, but one of the dealer's cards is unknown*/
public void dealCards(){

  double randomNumber = Math.random()* 51;

  int a = (int)randomNumber;

  Cards myFirstCard = new Cards(deck[a].value, deck[a].name, deck[a].suit, deck[a].number, deck[a].symbol, deck[a].character);
  
  myCards[0] = myFirstCard;
  
  double randomNumber2 = Math.random()* 51;

  int b = (int)randomNumber2;

  Cards mySecondCard = new Cards(deck[b].value, deck[b].name, deck[b].suit, deck[b].number, deck[b].symbol, deck[b].character);
  
  myCards[1] = mySecondCard;

  double randomNumber3 = Math.random()* 51;

  int c = (int)randomNumber3;

  Cards dealerUpcard = new Cards(deck[c].value, deck[c].name, deck[c].suit, deck[c].number, deck[c].symbol, deck[c].character);
  
  dealerCards[0] = dealerUpcard;

  double randomNumber4 = Math.random()* 51;

  int d = (int)randomNumber4;

  Cards dealerHoleCard = new Cards(deck[d].value, deck[d].name, deck[d].suit, deck[d].number, deck[d].symbol, deck[d].character);
  
  dealerCards[1] = dealerHoleCard;

}

//method to print the board
public void printBoard(Blackjack game){
  System.out.println("My cards:");

	for (int i = 0; i < mySize - 1 ; i++) {
		System.out.print(myCards[i].name + " of " + myCards[i].suit + ", ");
	}
	System.out.println(myCards[mySize - 1].name + " of " + myCards[mySize - 1].suit);

	for (int i = 0; i < mySize -1; i++) {
		System.out.print(myCards[i].character + myCards[i].symbol + ", ");
	}
	System.out.println(myCards[mySize - 1].character + myCards[mySize - 1].symbol);

  System.out.println("");

  if (dealSize == 2) {
  System.out.println("Dealer's upcard:");

  System.out.println(dealerCards[0].name + " of " + dealerCards[0].suit);
  
  System.out.println(dealerCards[0].character + dealerCards[0].symbol);
  }
  
  if (dealSize > 2) {
	System.out.println("Dealer has: ");
	for (int i = 0; i < dealSize - 1; i++) {
		System.out.print(dealerCards[i].name + " of " + dealerCards[i].suit + ", ");
	}
	System.out.println(dealerCards[dealSize - 1].name + " of " + dealerCards[dealSize - 1].suit);
	for (int i = 0; i < dealSize -1; i++) {
		System.out.print(dealerCards[i].character + dealerCards[i].symbol + ", ");
	}
	System.out.println(dealerCards[dealSize - 1].character + dealerCards[dealSize - 1].symbol);
  }
	game.checkForAces(game);
	game.checkWinOrBust(game);
}

//this method checks the player's hand. if 21, blackjack! if greater than 21, bust! if less than 21, it will prompt the player to hit or stand. 
int myScore = 0;
public void checkWinOrBust(Blackjack game){
	myScore = 0;
	for (int i = 0; i < mySize; i++) {
		myScore += myCards[i].value;
	}
	if (myScore > 21) {
		System.out.println("Bust! Dealer wins the hand.");
		game.takeChips(bet);
		game.checkChips(game);
	} else if (myScore == 21) {
		if (mySize == 2){
		System.out.println("Congrats! You have a blackjack! Let's see if the dealer will push.");
		} else {
		System.out.println("Congrats! You got 21! Let's see if the dealer will push.");
		}
		game.dealersTurn(game);
	} else {
		game.giveChoice(game);
	}
}


//method called when the user selects to double down
public void doubleDown(Blackjack game){
	bet = bet * 2;
	game.dealAnother();
	System.out.println("My cards:");

	for (int i = 0; i < mySize - 1 ; i++) {
		System.out.print(myCards[i].name + " of " + myCards[i].suit + ", ");
	}
	System.out.println(myCards[mySize - 1].name + " of " + myCards[mySize - 1].suit);

	for (int i = 0; i < mySize -1; i++) {
		System.out.print(myCards[i].character + myCards[i].symbol + ", ");
	}
	System.out.println(myCards[mySize - 1].character + myCards[mySize - 1].symbol);

  System.out.println("");

  if (dealSize == 2) {
  System.out.println("Dealer's upcard:");

  System.out.println(dealerCards[0].name + " of " + dealerCards[0].suit);
  
  System.out.println(dealerCards[0].character + dealerCards[0].symbol);
  }
  
  if (dealSize > 2) {
	System.out.println("Dealer has: ");
	for (int i = 0; i < dealSize - 1; i++) {
		System.out.print(dealerCards[i].name + " of " + dealerCards[i].suit + ", ");
	}
	System.out.println(dealerCards[dealSize - 1].name + " of " + dealerCards[dealSize - 1].suit);
	for (int i = 0; i < dealSize -1; i++) {
		System.out.print(dealerCards[i].character + dealerCards[i].symbol + ", ");
	}
	System.out.println(dealerCards[dealSize - 1].character + dealerCards[dealSize - 1].symbol);
  }
	game.checkForAces(game);
	myScore = 0;
	for (int i = 0; i < mySize; i++) {
		myScore += myCards[i].value;
	}
	if (myScore > 21) {
		System.out.println("Bust! Dealer wins the hand.");
		game.takeChips(bet);
		game.checkChips(game);
	} else if (myScore == 21) {
		if (mySize == 2){
		System.out.println("Congrats! You have a blackjack! Let's see if the dealer will push.");
		} else {
		System.out.println("Congrats! You got 21! Let's see if the dealer will push.");
		}
		game.dealersTurn(game);
	} else {
		System.out.println("You have a score of " + myScore + ". Now it is the dealer's turn.");
		game.dealersTurn(game);
	}
}

//this method checks a players hand for aces and allows the player to assign each ace a value of 1 or 11
public void checkForAces(Blackjack game){
	Scanner scnr = new Scanner(System.in);
	for (int i = 0; i < mySize; i++) {
		if (myCards[i].name.equals("ace")) {
			boolean invalid = true;
			do {
			int aceIndex = i + 1;
			System.out.println("Would you like your ace (card #" + aceIndex + ") to be 1 point or 11 points? (Please enter '1' or '11'.)");
			myCards[i].value = scnr.nextInt();
			if (myCards[i].value == 1 || myCards[i].value == 11){
				invalid = false;
			}
		} while (invalid);
		}
	}
}


public static String choice;

//this method gives the player a choice to either hit or stand; it is called if the player's hand is below 21
public void giveChoice(Blackjack game){
	Scanner scnr = new Scanner(System.in);
	
	System.out.println("Now, would you like to hit, stand, or double down? (Your hand is at " + myScore +" and dealer has " + dealerCards[0].value + " showing.)");
	
	choice = scnr.nextLine();
	
	System.out.println("You have chosen to " + choice + " with a score of " + myScore + ".");
	
	game.checkInput(choice, game);
}

//this method checks player input for 'stand' or 'hit' and returns other inputs as invalid
public void checkInput(String decision, Blackjack game){
	if (decision.equals("hit")) {
		game.hitWithCard(game);
	} else if (decision.equals("stand")){
		System.out.println("Now it is the dealer's turn.");
		game.dealersTurn(game);
	} else if (decision.equals("double down")){
		if (myChips >= 2 * bet){
		game.doubleDown(game);
		} else {
		System.out.println("You do not have enough chips to double down. Please choose to 'hit' or 'stand'.");
		game.giveChoice(game);
		}
	}else {
		System.out.println("Invalid input. Please enter 'hit', 'stand', or 'double down'.");
		game.giveChoice(game);
	}
}

//method used within hitWithCard() method to deal another card to the player's hand 
public void dealAnother(){
	double randomNumber = Math.random()* 51;

	int a = (int)randomNumber;

	Cards myNextCard = new Cards(deck[a].value, deck[a].name, deck[a].suit, deck[a].number, deck[a].symbol, deck[a].character);
  
	myCards[mySize] = myNextCard;
	
	mySize = mySize + 1;
}

//method used when a player chooses to 'hit'; this method deals a card then prints the board
public static void hitWithCard(Blackjack game){
	game.dealAnother();
	game.printBoard(game);
}

public int dealerScore = 0;
//once the player is finished with their turn, if the player did not bust then the dealer begins their turn with this method. This method flips over the hole card and evaluates the dealer's score at this point. 
public void dealersTurn(Blackjack game){
	System.out.println("Flipping over the dealer's hole card... " + dealerCards[1].name + " of " + dealerCards[1].suit + "!");
	for (int i = 0; i < dealSize; i++){
		dealerScore += dealerCards[i].value;
	}
	System.out.print("Dealer has " + dealerScore + ". ");
	game.checkDealerScore(game);
}

//this method compares the dealer's score to the player's score and then makes an appropriate move for the dealer
public void checkDealerScore(Blackjack game){
	if (dealerScore > 21){
		if (mySize == 2 && myScore == 21){
		System.out.println("Dealer busts! You win. Blackjack pays 3:2.");
		game.awardBlackjack(bet);
		} else {
		System.out.println("Dealer busts! You win.");
		game.awardChips(bet);
		}
	}
	if (dealerScore > 16) {
		if (dealerScore > myScore){
		System.out.println("Dealer wins.");	
		game.takeChips(bet);
		}
	if (dealerScore == myScore){
		System.out.println("Player and dealer push.");
		System.out.println("You still have $" + myChips + ".");
		}
	if (dealerScore < myScore){
		if (mySize == 2 && myScore == 21) {
		System.out.println("You win! Blackjack pays 3:2." );
		game.awardBlackjack(bet);
		} else {
		System.out.println("You win!");
		game.awardChips(bet);	
		}
		}
}
	if (dealerScore < 17) {
		System.out.println("Dealer will hit.");
		do {
			game.dealToDealer();
			System.out.println("Dealer got " + dealerCards[dealSize-1].name + " of " + dealerCards[dealSize-1].suit + ". Dealer now has " + dealerScore + "."); 
		} while (dealerScore < 17);
		
	if (dealerScore > 21){
		if (mySize == 2 && myScore == 21){
		System.out.println("Dealer busts! You win. Blackjack pays 3:2.");
		game.awardBlackjack(bet);
		} else {
		System.out.println("Dealer busts! You win.");
		game.awardChips(bet);
		}
	} else if (dealerScore > myScore){
		System.out.println("Dealer wins the hand.");
		game.takeChips(bet);
	} else if (dealerScore < myScore){
		if (mySize == 2 && myScore == 21){
		System.out.println("Dealer stands on " + dealerScore + ". You win the hand! Blackjack pays 3:2.");
		game.awardBlackjack(bet);
		} else {
		System.out.println("Dealer stands on " + dealerScore + ". You win the hand!");
		game.awardChips(bet);
		}
	} else {
		System.out.println("Player and dealer push.");
		System.out.println("You still have $" + myChips + ".");
	}
}	game.checkChips(game);	
}

//this method gives the dealer another card whenever it is appropriate
public void dealToDealer(){
	double randomNumber = Math.random()* 51;

	int a = (int)randomNumber;

	Cards dealerNextCard = new Cards(deck[a].value, deck[a].name, deck[a].suit, deck[a].number, deck[a].symbol, deck[a].character);
  
	dealerCards[dealSize] = dealerNextCard;
	
	dealSize = dealSize + 1;
	
	dealerScore += dealerNextCard.value;
}

}