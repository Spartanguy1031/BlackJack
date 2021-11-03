import java.lang.Math;
import java.util.Scanner;
class Blackjack {
/*
Class Blackjack -
.Depends on CheckInValues
.Creates a storage for cards played, running count, and any hard variables
.Takes user input to win the hand 
*/
/*
Comment key:
g = get
s = set
p = print
add = add
sub = subtract
*/
/*
Codes
1-14 == card numbers
111 == End the count
112 == print cards entered
113 == Checks if there are extra cards in the decks
114 == check probabilities
115 == change deck size
*/

 

public static int getValue() {
System.out.println("Size of deck Please");
Scanner myObj = new Scanner(System.in); //Take user input
int y = myObj.nextInt();
return y;
}

public static final int sod = getValue(); //size of deck

public static int deck[] = new int[sod*52]; //current cards played .Dont go over the limit (default 312 or 6 decks)

public static int count = 0; //running count


public static int ace = 0;
public static int two = 0;
public static int three = 0;
public static int four = 0;
public static int five = 0;
public static int six = 0;
public static int seven = 0;
public static int eight = 0;
public static int nine = 0;
public static int ten = 0;
public static int jack = 0;
public static int queen = 0;
public static int king = 0;

public int aceKeep = 0; //used to find percent chances
public int twoKeep = 0;
public int threeKeep = 0;
public int fourKeep = 0;
public int fiveKeep = 0;
public int sixKeep = 0;
public int sevenKeep = 0;
public int eightKeep = 0;
public int nineKeep = 0;
public int tenKeep = 0;
public int jackKeep = 0;
public int queenKeep = 0;
public int kingKeep = 0;

public Blackjack() {
System.out.println("Deck count: " + sod);
}


/*
Codes
1-14 == card numbers
111 == End the count
112 == print cards entered
113 == Checks if there are extra cards in the decks
114 == check probabilities
115 == change deck size
*/
public static void main(String[] args) {
System.out.println("For help type 101");
//int x = (int)(Math.random() * 10)+3;
Scanner myObj = new Scanner(System.in); //Take user input
int y = myObj.nextInt(); 
Blackjack five;
if(y == 112) { //prints cards entered
printCards(CheckInValues.getCardsPlayed());
} else if(y == 111) { //Ends the current count
System.out.println("Ending Count");
} else if(y == 113) { //Check impossible count
System.out.println("Can't check without cards first");
} else if(y == 114) { 
y = myObj.nextInt();
CheckPercent(y,CheckInValues.getCardsPlayed());
System.out.println((double)2/(double)5);
} else if (y == 101) {
System.out.println("how to read the percent it is that many cards chance overall\nwith a .25 percent change you draw the same card\nCodes\n1-14 == card numbers\n101 = help\n112 == print cards entered\n111 == End the count\n113 == Checks if there are extra cards in the decks\n114 == check probabilities\n115 == change size of deck");
} else {
five = new CheckInValues(y);
}
/*
how to read the percent it is that many cards chance overall
 with a .25 percent change you draw the same card
Codes
1-14 == card numbers
101 = help
112 == print cards entered
111 == End the count
113 == Checks if there are extra cards in the decks
114 == check probabilities
115 == change size of deck
*/
while(y != 111) {
y = myObj.nextInt();
if(y == 112) {
printCards(CheckInValues.getCardsPlayed());
} else if(y == 111) {
System.out.println("Ending Count");
} else if(y == 113) {
addCardsToMem(CheckInValues.getCardsPlayed());
CheckImpossible(CheckInValues.getCardsPlayed());
resetMem();
} else if(y == 114) {
y = myObj.nextInt();
CheckPercent(y,CheckInValues.getCardsPlayed());
} else if(y == 115) {
y = getValue();;
five = new Blackjack();
} else if (y == 101) {
System.out.println("how to read the percent it is that many cards chance overall\nwith a .25 percent change you draw the same card\nCodes\n1-14 == card numbers\n101 = help\n112 == print cards entered\n111 == End the count\n113 == Checks if there are extra cards in the decks\n114 == check probabilities\n115 == change size of deck");
} else {
five = new CheckInValues(y);
}
}
}
/*
Codes
1-14 == card numbers
112 == print cards entered
111 == End the count
113 == Checks if there are extra cards in the decks
114 == check probabilities
*/
public static void CheckPercent(int cardL, int valLength) {
int use = valLength;
double percent = (double)use/(double)deck.length;
addCardsToMem(valLength);

//System.out.println(use + " " + deck.length + " " + use/deck.length + " " + percent + sod);

if(cardL == 1)
System.out.println("Chance for anycard: " + percent * (1-(double)ace/(double)sod) + " Aces left: " + (ace-sod)*-1);
if(cardL == 2)
System.out.println("Chance for anycard: " + percent * (1-(double)two/(double)sod) + " Twos left: " + (two-sod)*-1);
if(cardL == 3)
System.out.println("Chance for anycard: " + percent * (1-(double)three/(double)sod) + " Threes left: " + (three-sod)*-1);
if(cardL == 4)
System.out.println("Chance for anycard: " + percent * (1-(double)four/(double)sod) + " Fours left: " + (four-sod)*-1);
if(cardL == 5)
System.out.println("Chance for anycard: " + percent * (1-(double)five/(double)sod) + " Fives left: " + (five-sod)*-1);
if(cardL == 6)
System.out.println("Chance for anycard: " + percent * (1-(double)six/(double)sod) + " Sixes left: " + (six-sod)*-1);
if(cardL == 7)
System.out.println("Chance for anycard: " + percent * (1-(double)seven/(double)sod) + " Sevens left: " + (seven-sod)*-1);
if(cardL == 8)
System.out.println("Chance for anycard: " + percent * (1-(double)eight/(double)sod) + " Eights left: " + (eight-sod)*-1);
if(cardL == 9)
System.out.println("Chance for anycard: " + percent * (1-(double)nine/(double)sod) +  "Nines left: " + (nine-sod)*-1);
if(cardL == 10)
System.out.println("Chance for anycard: " + percent * (1-(double)ten/(double)sod) + " Tens left: " + (ten-sod)*-1);
if(cardL == 11)
System.out.println("Chance for anycard: " + percent * (1-(double)jack/(double)sod) + " Jacks left: " + (jack-sod)*-1);
if(cardL == 12)
System.out.println("Chance for anycard: " + percent * (1-(double)queen/(double)sod) + " Queens left: " + (queen-sod)*-1);
if(cardL == 13)
System.out.println("Chance for anycard: " + percent * (1-(double)king/(double)sod) + " Kings left: " + (king-sod)*-1);
if(cardL == 14)
System.out.println("Chance for anycard: " + percent * (1-(double)ace/(double)sod) + " Aces left: " + (ace-sod)*-1);
resetMem();
}

public static void resetMem() {
ace = 0;
two = 0;
three = 0;
four = 0;
five = 0;
six = 0;
seven = 0;
eight = 0;
nine = 0;
ten = 0;
jack = 0;
queen = 0;
king = 0;

}

public static void addCardsToMem(int valLength) {
for(int x = 0 ;x < valLength; x++) {
if(deck[x] == 1 || deck[x] == 14)
ace++;
if(deck[x] == 2)
two++;
if(deck[x] == 3)
three++;
if(deck[x] == 4)
four++;
if(deck[x] == 5)
five++;
if(deck[x] == 6)
six++;
if(deck[x] == 7)
seven++;
if(deck[x] == 8)
eight++;
if(deck[x] == 9)
nine++;
if(deck[x] == 10)
ten++;
if(deck[x] == 11)
jack++;
if(deck[x] == 12)
queen++;
if(deck[x] == 13)
king++;
}
}

public static void CheckImpossible(int valLength) { 
//Check each card for having equal or greater than how many decks there are
if(ace > 0)
System.out.println("Ace: " + ace);
if(ace > sod)
System.out.println("Ace Impossible: " + ace);
if(two > 0)
System.out.println("Two: " + two);
if(two > sod)
System.out.println("Two Impossible: " + two);
if(three > 0)
System.out.println("Three: " + three);
if(three > sod)
System.out.println("Three Impossible: " + three);
if(four > 0)
System.out.println("Four: " + four);
if(four > sod)
System.out.println("Four Impossible: " + four);
if(five > 0)
System.out.println("Five: " + five);
if(five > sod)
System.out.println("Five Impossible: " + five);
if(six > 0)
System.out.println("Six: " + six);
if(six > sod)
System.out.println("Six Impossible: " + six);
if(seven > 0)
System.out.println("Seven: " + seven);
if(seven > sod)
System.out.println("Seven Impossible: " + seven);
if(eight > 0)
System.out.println("Eight: " + eight);
if(eight > sod)
System.out.println("Eight Impossible: " + eight);
if(nine > 0)
System.out.println("Nine: " + nine);
if(nine > sod)
System.out.println("Nine Impossible: " + nine);
if(ten > 0)
System.out.println("Ten: " + ten);
if(ten > sod)
System.out.println("Ten Impossible: " + ten);
if(jack > 0)
System.out.println("Jack: " + jack);
if(jack > sod)
System.out.println("Jack Impossible: " + jack);
if(queen > 0)
System.out.println("Queen: " + queen);
if(queen > sod)
System.out.println("Queen Impossible: " + queen);
if(king > 0)
System.out.println("King: " + king);
if(king > sod)
System.out.println("King Impossible: " + king);
}

//deck[] p
public static void printCards(int valLength) {
for(int x = 0 ;x < valLength; x++) {
System.out.println("Cards " + deck[x]);
}
}

//count g,s,p,add
public void addCount() {
count = count + 1;
System.out.println("RUNNNG COUNT: " + count);
}
public void subCount() {
count = count - 1;
System.out.println("RUNNING COUNT: " + count);
}
public void prtCount() {
System.out.println("RUNNING COUNT: " + count);
}
public int getCount() {
return count;
}
//Decides to add or sub from count
public boolean CheckScore(int val) {
int two = 2;
int neutral = 7;
int endneutral = 9;
int high = 13;
int ace = 14;

int lowvalue = -1;
int midvalue = 0;
int highvalue = 1;
int x = val;
System.out.println("USER INPUT: " + x);
if(x == 0) {
System.out.println("I couldn't find 0 in my deck! Try Again");
return false;
}else if(x == ace || x == 1) {
this.subCount();
return true;
}else if(x >= two && x < neutral) {
this.addCount();
return true;
}else if(x >= neutral && x <= endneutral) {
this.prtCount();
return true;
}else if(x >= endneutral + 1 && x <= high) {
this.subCount();
return true;
}else if(x > ace) {
System.out.println("Cards must be between 1-14"); 
return false;
} else {
return false;
}

}

} 