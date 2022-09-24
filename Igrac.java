package blackjack;

public class Igrac {
    private int balance, bet, karte;
    public String ime;
    public Igrac(String ime, int balance, int bet, int karte)
    {
        this.balance = balance;
        this.bet = bet;
        this.karte = karte;
        this.ime = ime;
    }
    public int getBal()
    {
        return this.balance;
    }
    public int getBet()
    {
        return this.bet;
    }
    public int getKarte()
    {
        return this.karte;
    }
    public String getIme()
    {
        return this.ime;
    }
    public String toStringNovac()
    {
        return "Vasa kolicina novca je: " + this.balance;
    }
    public String toStringKarte()
    {
        return "Vas zbir karata je: " + this.karte;
    }
    public void setBet(int x)
    {
        if(x <= this.balance){
            this.bet = x;
            this.balance -= x;
        }
    }
    public void povecajBalance()
    {
        this.balance += this.bet * 2;
    }
    public void hit(int x)
    {
        this.karte += x;
    }
    public void duplo(int x)
    {
        this.karte += x;
        this.balance -= this.bet;
        this.bet += this.bet;
    }
    public void blackjack(){
        this.balance += this.bet + this.bet * 1.5;
    }
    
    public void resetKarte(){
        this.karte = 0;
    }
}