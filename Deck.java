package blackjack;

import java.util.Random;

public class Deck {
    private Karta karte[] = new Karta[13];
    private Random r = new Random();
    public Deck(){

        for (int i = 0; i < 9; i++) {
            karte[i] = new Karta(Character.toString((char)((i+1) + '0')), i+1, 4);
        }

        karte[9] = new Karta("10", 10, 4);
        karte[10] = new Karta("J", 12, 4);
        karte[11] = new Karta("Q", 13, 4);
        karte[12] = new Karta("K", 14, 4);
    }

    public Karta izvuciKartu(){
        int index = r.nextInt(13);
        while(karte[index].getKvantitet()==0)
            index = r.nextInt(13);

        karte[index].smanji();
        return karte[index];
    }

    public int izbrojKarte(){
        int brojKarata = 0;
        for (Karta k : karte)
            brojKarata += k.getKvantitet();
        return brojKarata;
    }

    public boolean imaDovoljno(){
        return(this.izbrojKarte()>10);
    }

}
