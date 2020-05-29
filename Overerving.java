public class Overerving {

    public static void main(String[] args) {
//        Gebouw gebouw1 = new Gebouw("geel");
//        Gebouw[] gebouwen = new Gebouw[4];
//        gebouwen[0] = new Gebouw("rood");
////        gebouw1.schoonmaken();
//        Huis huis = new Huis();
//        huis.kleur = "geel";
//        huis.schoonmaken();
//        Gebouw gebouw2 = new Huis();
//        gebouw2.schoonmaken();
//        huis.wonen();
//        gebouw2.wonen();  /* dit kan niet */
//        Gebouw gebouw = new Gebouw();
        VrijeTijd vt = new Cat();
        vt.luieren();
    }
}

abstract class Gebouw {
    String kleur;

    void schoonmaken() {
        System.out.println("Gebouw: Ik word schoongemaakt.");
    }

    Gebouw(){

    }

    Gebouw(String kleur) {
        this.kleur = kleur;
    }
}

class Huis extends Gebouw implements VrijeTijd{
    String adres;
    int aantalBewoners;
    void wonen(){
        System.out.println("Huis: Wonen");
    }

    Huis(){
        super("blauw");
    }

    Huis(int aantalBewoners){
        super("wit");
        this.aantalBewoners = aantalBewoners;
    }

    @Override
    public void luieren() {
        System.out.println("Er wordt in huis geluierd");
    }
}

class Kantoor extends Gebouw {
    String directeur;
    void werken(){
        System.out.println("Kantoor: hier wordt gewerkt");
    }
    public void schoonmaken() {
        System.out.println("Kantoor: Ik word schoongemaakt");
    }

}

class Bouwbedrijf{
    String directeur;
    Huis eigenhuis;
//    Huis bouwen(){
//
//    }
}

class Cat implements VrijeTijd{
    String naam = "Poes";
    public void luieren(){
        System.out.println("De kat is aan het luieren");
    }
}

interface VrijeTijd {
    boolean isPrettig = true;
    void luieren();
}