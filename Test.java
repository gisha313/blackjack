package blackjack;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("BLACKJACK - by Bogdan & Ognjen");
        System.out.println();

        System.out.println("Unesite svoje ime i kolicinu novca: ");
        Igrac igrac = new Igrac(in.next(), in.nextInt(), 0, 0);

        System.out.print("Da li zelite da zapocnete igru? (da/ne): ");
        boolean igra = in.next().equals("da");

        if(!igra)
            System.out.println("Mozda sutra?");
        else{
            Deck deck = new Deck();
            while(igrac.getBal()!=0 && igra){

                if(!deck.imaDovoljno())
                    deck = new Deck();

                igrac.resetKarte();
                
                System.out.print("Unesite opkladu: ");
                igrac.setBet(in.nextInt());

                while(igrac.getBet() == 0){
                    System.out.println("Nemate toliko novca!" + igrac.toStringNovac());
                    System.out.print("Unesite opkladu ponovo: ");
                    igrac.setBet(in.nextInt());
                }

                Karta k1 = deck.izvuciKartu();
                Karta k2 = deck.izvuciKartu();

                System.out.println("Vase karte su: " + k1.getZnak() + " " + k2.getZnak());
                igrac.hit(k1.getVrednost() + k2.getVrednost());
                System.out.println(igrac.toStringKarte());

                if(igrac.getKarte() == 21){
                    System.out.println("BLACKJACK!!!");
                    igrac.blackjack();

                    System.out.println(igrac.toStringNovac());
                
                    System.out.print("Da li zelite da igrate ponovo (da/ne): ");
                    igra = (in.next().equals("da"));
                    break;
                }

                if(igrac.getKarte() > 21){
                    System.out.println("BUST!");
                    System.out.println(igrac.toStringNovac());
                
                    System.out.print("Da li zelite da igrate ponovo (da/ne): ");
                    igra = (in.next().equals("da"));
                    break;
                }

                if(igrac.getBet() > igrac.getBal())
                    System.out.print("hit/fold: ");
                else
                    System.out.print("hit/double/fold: ");
                String potez = in.next();
                
                boolean zavrseno = false;

                while(!potez.equals("fold")){
                    Karta k = deck.izvuciKartu();
                    System.out.println("Vasa karta je: " + k.getZnak());
                    if(potez.equals("hit"))
                        igrac.hit(k.getVrednost());
                    else
                        igrac.duplo(k.getVrednost());

                    System.out.println(igrac.toStringKarte());
                    if(igrac.getKarte() > 21){
                        System.out.println("BUST!");
                        zavrseno = true;
                        break;
                    }
                    else if(igrac.getKarte() == 21){
                        System.out.println("Pobedili ste! ");
                        igrac.povecajBalance();
                        zavrseno = true;
                        break;
                    }
                    System.out.println("hit/fold ?");
                    potez = in.next();
                }

                if(!zavrseno){
                    int dealerKarte = 0;
                    while(dealerKarte < 17)
                        dealerKarte += deck.izvuciKartu().getVrednost();
                    System.out.println("Dealer: " + dealerKarte);
                    if(dealerKarte == igrac.getKarte()){
                        System.out.println("PUSH!");
                    }
                    if(dealerKarte > 21){
                        System.out.println("Dealer BUST!");
                        igrac.povecajBalance();
                    }
                    else if(dealerKarte > igrac.getKarte()){
                        System.out.println("Izgubili ste! ");
                    }
                    else{
                        System.out.println("Pobedili ste! ");
                        igrac.povecajBalance();
                    }
                
                }
                    
                if(igrac.getBal() <= 0){
                    System.out.println("Ostali ste bez novca! ");
                    break;
                }

                System.out.println(igrac.toStringNovac());
                
                System.out.print("Da li zelite da igrate ponovo (da/ne): ");
                igra = (in.next().equals("da"));
            }

            System.out.println("Hvala na igranju!");
        }
        in.close();
    }
}
