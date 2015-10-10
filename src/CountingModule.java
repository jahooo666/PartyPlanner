import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marcin on 2015-10-10.
 */
public class CountingModule {
    private double promile;
    private double time;
    private int numberOfMen;
    private int numberOfWomen;
    private String PartyType;
    private double grams;
    private double liters;
    private double price = 0;



    private void countGrams(){
        double promilFactor = -(double)time * (-0.12) + promile + 0.12;
        double cleanAlcolInMl = promilFactor * 70;
        grams =  cleanAlcolInMl * (numberOfMen + 0.5 * numberOfWomen);
    }

    private int chooseAlco(String PartyType) {
        switch (PartyType){
            case "banquet":
                price = 30;
                return 12;
            case "meeting":
                price = 5;
                return 5;
            case "home":
                price = 30;
                return 38;
            case "outdoors":
                price = 5;
                return 20;
            default:
                return 0;
        }
    }

    private void countLiters(){
        liters =  grams/chooseAlco(PartyType);
    }

    private double price(){
        if(price == 0){
            chooseAlco(PartyType);
        }
        return liters * price;
    }

    public static void main(String[] args) {
        CountingModule countingModule = new CountingModule();
        countingModule.numberOfMen = 1;
        countingModule.numberOfWomen = 1;
        countingModule.time = 3;
        countingModule.promile = 1;
        countingModule.PartyType = "meeting";
        countingModule.countGrams();
        countingModule.countLiters();
        System.out.println(countingModule.liters);
        System.out.println(countingModule.price());
        System.out.println();



    }
}