package sample;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by Marcin on 2015-10-10.
 */
public class CountingModule {
    private double promile;
    private double time;
    private int numberOfMen;
    private int numberOfWomen;
    private String typeOfAlcochol;
    private String typeOfParty;
    private double liters;
    private double price;
    private double prefferedPrice;

    public void setNumberOfMen(int numberOfMen) {
        this.numberOfMen = numberOfMen;
    }
    public void setNumberOfWomen(int numberOfWomen) {
        this.numberOfWomen = numberOfWomen;
    }
    public void setTypeOfAlcochol(String typeOfAlcochol) {
        this.typeOfAlcochol = typeOfAlcochol;
    }
    public void setTypeOfParty(String typeOfParty) {
        this.typeOfParty = typeOfParty;
    }
    public void setPrefferedPrice(double prefferedPrice) {
        this.prefferedPrice = prefferedPrice;
    }
    public void setTime(double time) {
        this.time = time;
    }
    public double getLiters() {
        return liters;
    }
    public double getPrice() {
        return price();
    }


    private double countGrams(){
        chooseTypeOfParty(typeOfParty);
        double promilFactor = -(double)time * (-0.12) + promile + 0.12;
        double cleanAlcolInMl = promilFactor * 70;
        return cleanAlcolInMl * (numberOfMen + 0.5 * numberOfWomen);
    }

    private void chooseTypeOfParty(String typeOfParty){
        switch(typeOfParty){
            case "Kulturalna prywatka":
                promile = 0.5;
                break;
            case "Klasyczna domówka":
                promile = 1.35;
                break;
            case "Mordownia":
                promile = 2.5;
                break;
        }
    }

    private double chooseAlco(String typeOfAlcochol) {
        switch (typeOfAlcochol){
            case "Piwo":
                price = 6;
                return 0.05;
            case "Wino":
                price = 30;
                return 0.12;
            case "Drinki":
                price = 60;
                return 0.5;
            case "Wódka":
                price = 45;
                return 0.38;
            default:
                return 0;
        }
    }

    public void countLiters(){
        liters =  (countGrams() / 1000)/chooseAlco(typeOfAlcochol);
    }

    public double price(){
        if(price == 0){
            chooseAlco(typeOfAlcochol);
        }
        return liters * price;
    }

    public String comparePrices(){
        if(price()>10*prefferedPrice)
            return "Brakuje Ci kupe kasy";
        else if(price()>5*prefferedPrice)
            return "Nie bądź żyd dorzuć trochę";
        else if(price()>2*prefferedPrice)
            return "Mało kapusty!";
        else if(price()>prefferedPrice)
            return "Brakło trochę :/";
        else if(10*price()<prefferedPrice)
            return "Szykuje się gruba impreza, wziąłbym 10 razy tyle :P";
        else if(5*price()<prefferedPrice)
            return "Weź więcej, nie zmarnuje się :D";
        else if(2*price()<prefferedPrice)
            return "Można szaleć ;)";
        else if(price()==prefferedPrice)
            return "W sam raz :D";
        else
            return "Jeszcze pare można wziąć";
    }



    public static void main(String[] args) {
        CountingModule cm = new CountingModule();
        cm.setTime(5);
        cm.setPrefferedPrice(20);
        cm.setNumberOfWomen(1);
        cm.setNumberOfMen(1);
        cm.setTypeOfParty("Mordownia");
        cm.setTypeOfAlcochol("Piwo");
        cm.countLiters();
        cm.price();
        cm.comparePrices();
        System.out.println(cm.promile);
        System.out.println(cm.liters);
        System.out.println(cm.price());
        System.out.println(cm.comparePrices());
    }
}