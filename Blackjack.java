
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackJack {

//    private Kaart[] kaarten = new String[52];
    private ArrayList<String> kaarten = new ArrayList<>();
    static ArrayList<String> stapel;

//    private static ArrayList<Kaart> kaarten = new ArrayList<>();
//    static ArrayList<Kaart> stapel;

    boolean doorgaan = true;
    int totaalPunten = 0;
    Scanner sc = new Scanner(System.in);

    public BlackJack() {    // constructor
        kaarten.add(0, "H2");
        kaarten.add(1, "H3");
        kaarten.add(2, "H4");
        kaarten.add(3,"H5");
        kaarten.add(4,"H6");
        kaarten.add(5,"H7");
        kaarten.add(6,"H8");
        kaarten.add(7,"H9");
        kaarten.add(8,"H10"); // etc tot 52 kaarten
    }

    public static void main(String[] args) {
        BlackJack spel = new BlackJack();
        ArrayList<String> stapel = spel.kaarten;
        Collections.shuffle(stapel);
        System.out.println("De kaarten zijn als volgt:" + stapel);
        spel.spelen();

    }


    public void spelen() {
        while(doorgaan) {
            System.out.println("Welkom bij een nieuw BlackJack-spel.");
            ArrayList<String> stapel = kaarten;
            Collections.shuffle(stapel);
            System.out.println("De kaarten wordt geschud. Dit zijn ze: " + stapel);

            System.out.println("Wil je een kaart vragen, passen, of stoppen met het spel?");
            System.out.println("Typ 'k' voor een kaart");
            System.out.println("Typ 'p' voor passen");
            System.out.println("Typ 'q' voor stoppen");
            Scanner sc = new Scanner(System.in);
            String invoer = sc.nextLine();
            if (invoer.trim().equals("k")) {
                kaartVragen();
            } else if (invoer.trim().equals("p")) {
                passen();
            } else {
                stoppen();
                doorgaan = false;
            }
        }
    }

    void kaartVragen() {
        System.out.println("OK, je krijgt een kaart uitgedeeld.");
        String uitgedeeldeKaart = stapel.get(stapel.size() -1);
        stapel.remove(stapel.size() -1);
        // ik wil hier de waarde van de uitgedeelde kaartpunten ophalen en deze optellen bij het totaal aantal punten
        totaalPunten += Integer.parseInt(uitgedeeldeKaart.substring(1));
    }

    void passen() {
        System.out.println("Je wilt passen.");
        System.out.println("Jouw huidige score is/blijft: " + totaalPunten);
    }

    void stoppen() {
        System.out.println("Jammer, je hebt het spel beeindigd. Tot een volgende keer misschien!");
    }
}

// onderstaande class alleen gebruiken als kaart een apart object wordt (ipv String)
//class Kaart {
//
//    private String kleur;
//    private int waarde;
//
//    public Kaart(String kleur, int waarde){        //constructor, mag ook zonder parameters, want kaarten staan al vast?
//        this.kleur = kleur;
//        this.waarde = waarde;
//    }








