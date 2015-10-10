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
    private double price = 0;
    private double prifferedPrice;

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

    private double countGrams(){
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
                price = 5;
                return 0.05;
            case "Wino":
                price = 30;
                return 0.12;
            case "Drinki":
                price = 40;
                return 0.5;
            case "Wódka":
                price = 30;
                return 0.38;
            default:
                return 0;
        }
    }

    private void countLiters(String typeOfAlcochol){
        liters =  (countGrams() / 1000)/chooseAlco(typeOfAlcochol);
    }

    private double price(){
        if(price == 0){
            chooseAlco(typeOfAlcochol);
        }
        return liters * price;
    }

    private String comparePrices(){
        if(price()>10*prifferedPrice)
            return "Brakuje Ci kupe kasy";
        else if(price()>5*prifferedPrice)
            return "Nie bądź żyd dorzuć trochę";
        else if(price()>2*prifferedPrice)
            return "Mało kapusty!";
        else if(price()>prifferedPrice)
            return "Brakło trochę :/";
        else if(10*price()<prifferedPrice)
            return "Szykuje się gruba impreza, wziąłbym 10 razy tyle :P";
        else if(5*price()<prifferedPrice)
            return "Weź więcej, nie zmarnuje się :D";
        else if(2*price()<prifferedPrice)
            return "Można szaleć ;)";
        else if(price()==prifferedPrice)
            return "W sam raz :D";
        else
            return "Jeszcze pare można wziąć";
    }



    public static void main(String[] args) {
        CountingModule countingModule = new CountingModule();
        countingModule.numberOfMen = 2;
        countingModule.numberOfWomen = 2;
        countingModule.time = 3;
        countingModule.chooseTypeOfParty("Mordownia");
        countingModule.countLiters("Piwo");
        System.out.println(countingModule.liters);
        System.out.println(countingModule.price());
        System.out.println();

        countingModule.prifferedPrice = 200;
        System.out.println(countingModule.comparePrices());


    }
}