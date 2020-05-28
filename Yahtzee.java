import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Demo {
    Scanner sc = new Scanner(System.in);
    boolean spelen = true;
    int aantalWorpen = 0;
    final ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();
    int[] blokkeerArray = {0, 0, 0, 0, 0};
    Worp worp = new Worp();


    public Demo() {
        for (int a = 0; a < 5; a++) {
            dobbelstenen.add(a, new Dobbelsteen());
        }
    }

    public static void main(String[] args) {
        System.out.println("Welkom bij Yahtzee");
        new Demo().spelen();
        System.out.println("Bedankt voor het spelen");
    }

    public void spelen() {
        while (spelen) {
//        for (int a = 0; a < 10000; a++) {
            System.out.println("Wil je spelen?");
            System.out.println("Druk 'Enter' om te spelen, of 'q' om te stoppen");
            String invoer = sc.nextLine();
            if (invoer.equals("q")) {
                spelen = false;
                System.out.println("Jammer. Je hebt het spel beeindigd.");
                break;
            } else if (invoer.equals("")){
                spelen = true;
//                System.out.println("OK, nog een rondje");     /*dit hoeft alleen geprint te worden als er al minimaal 1x geworpen is*/
                System.out.println("De dobbelstenen worden gegooid");
                System.out.println("WORP " + (aantalWorpen+1));
                System.out.println("1 2 3 4 5");
                /* in onderstaande loop moet nog ingebouwd worden dat alleen bij blokkeerwaarde = 0 er geworpen kan worden */
                for (int i = 0; i < dobbelstenen.size(); i++) {
                    Dobbelsteen ds = dobbelstenen.get(i);
                    if (blokkeerArray[i] == 0){
                        ds.steenwaarde = ds.werpen();
                    }
                }
                worp.uitslag(dobbelstenen);
                aantalWorpen++;
                System.out.println("");
                System.out.println("Welke posities wil je vasthouden?");
                vasthouden();
            }
        }
    }

    public void vasthouden() {
        Scanner sc = new Scanner(System.in);
        int index;
        String posities = sc.next();
        System.out.println("Posities " + posities + " worden vastgehouden");

        // met onderstaande loop wordt van de opgegeven posities de bijhorende waarde in de blokkeerarray op '1' gezet
        for (int i = 0; i < posities.length(); i++) {
            String positie = posities.substring(i, i + 1);
            index = Integer.parseInt(positie) - 1;
            this.blokkeerArray[index] = 1;
        }
    }

    public class Dobbelsteen {
        int steenwaarde;

        int werpen() {
            Random r = new Random();
            steenwaarde = r.nextInt(6) +1;
            return steenwaarde;
        }
    }

    public class Worp {
        int[] worpResultaat = new int[5];

        public void uitslag(ArrayList<Dobbelsteen> dobbelstenen) {
            for (int i = 0; i < worpResultaat.length; i++) {
                worpResultaat[i] = dobbelstenen.get(i).steenwaarde;
            }
            System.out.println(Arrays.toString(worpResultaat));

        }
    }
}