class CheckInValues extends Blackjack {
public static int CardsPlayed = 0;
public CheckInValues(int val) {
super();
if(val == 0) {
   CheckScore(val);

} else {
if(CheckScore(val)) {
   addCard(val);
}
}
}

public void addCard(int val) {
deck[getCardsPlayed()] = val;
addCardsPlayed();
}



//CardsPlayed g,s
public static int getCardsPlayed() {
return CardsPlayed;
}
public void addCardsPlayed() {
CardsPlayed += 1;
}
public void addCardsPlayed(int x) {
CardsPlayed += x;
}


}