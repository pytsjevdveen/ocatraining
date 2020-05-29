class Exceptie {

    public static void main(String[] args) throws DroogteException {
        System.out.println("Begin");
//        Tuin tuin = new Tuin();
//        try {
//            tuin.groeienBloeien();
//        } catch (DroogteException e) {
//            System.out.println("Opgevangen in main");
//        }
//        System.out.println("Einde");
        Keukenhof kh = new Keukenhof();
        kh.opengaan();
        TuinAchterstandswijk t = new TuinAchterstandswijk();
        t.barbequeen();
    }
}

class Tuin {
    int regenPeil = 4; // hier mag ik wijzigen om tussen scenario's te springen
    void groeienBloeien() throws DroogteException {
        if (regenPeil > 5) {
            System.out.println("Het groeit en bloeit");
        } else {
            throw new DroogteException();
        }
    }
}

class DroogteException extends Exception {
}

class Keukenhof {
    Tuin tuin = new Tuin();
    void opengaan(){
        System.out.println("Welkom publiek, komt u binnen");
        try {
            tuin.groeienBloeien();
        } catch (Exception e) {
            System.out.println("Waarschuwing: onze tuin is ivm de droogte niet op zijn mooist");
        }
    }
}


class TuinAchterstandswijk {
    Tuin tuin = new Tuin();
    void barbequeen(){
        try{
            tuin.groeienBloeien();
        } catch (Exception e){
            System.out.println("We gaan toch niet barbequen: ivm de droogte is er te veel brandgevaar");
        }
    }
}

class Indiaan {
    Tuin tuin = new Tuin();
}


