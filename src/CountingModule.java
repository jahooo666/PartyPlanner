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


    private void countGrams(){
        double gramsPerPerson = 0;
        /*Miejsce na obliczenia*/

        grams =  gramsPerPerson * (numberOfMen + 0.5 * numberOfWomen);
    }

    private int chooseAlco(String PartyType){
        switch (PartyType){
            case "banquet":
                return 12;
            case "meeting":
                return 5;
            case "home":
                return 38;
            case "outdoors":
                return 20;
            default:
                return 5;
        }
    }

    private double countLiters(){
        return grams/chooseAlco(PartyType);
    }
}