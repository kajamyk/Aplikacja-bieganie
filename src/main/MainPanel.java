package main;

import java.awt.*;
import java.util.Random;
public class MainPanel {
     public static String getRandomQuote() {
        String [] quoteList = {"\"Ten jeden krok, wybranie celu i trzymanie się go, zmienia wszystko.\"",
                "\"Bieganie, to ten czas kiedy negatywne emocje znikają, a w ich miejsce pojawia się szczęście.\"",
                "\"Bieganie, to wspaniały Świat, który warto poznać samemu.\"",
                "\"Nie poddawaj się tylko dlatego, że jest trudno.\"",
                "\"Gdy ktoś mówi, że bieganie to nie sport, zabierz go ze sobą na trening.\"",
                "\"Kiedy chcesz się poddać, przypomnij sobie, po co zacząłeś.\"",
                "\"Motywacja pozwala wystartować. Nawyk utrzymuje w ruchu.\"",
                "\"Bieganie to klucz, który otwiera drogę do lepszego życia.\"",
                "\"Przestań myśleć o bieganiu. Zacznij biegać.\"",
                "\"Możesz znacznie więcej, niż ci się wydaje.\"",
                "\"Działaj tak, jakby porażka była niemożliwa, a sukces pewny.\"",
                "\"Może nie jestem jeszcze u celu, ale jestem bliżej niż wczoraj.\"",
                "\"Zadbaj o swoje ciało. To jedyne miejsce, jakie masz do życia.\"",
                "\"Jeśli będziesz czekał na idealne warunki, to do niczego nie dojdziesz.\"",
                "\"Dziś zrób to czego innym się nie chce, a jutro będziesz miał to czego inni pragną.\"",
                "\"Jeżeli nie masz pasji, to znaczy, że marnujesz swój czas.\"",
                "\"Nie musisz być wielki aby zacząć, ale musisz zacząć, aby być wielkim.\""};


        Random rand = new Random();
        int index = rand.nextInt(quoteList.length);
        return quoteList[index];
    }
    public static Color getColor(int sliderValue){
         Color [] colorTable = new Color[10];
         colorTable[0] = new Color(25, 0, 51);
         colorTable[1] = new Color(51, 0, 102);
         colorTable[2] = new Color(76, 0, 153);
         colorTable[3] = new Color(102, 0, 204);
         colorTable[4] = new Color(127, 0, 255);
         colorTable[5] = new Color(153, 51, 255);
         colorTable[6] = new Color(178, 102, 255);
         colorTable[7] = new Color(204, 153, 255);
         colorTable[8] = new Color(229, 204, 255);
         colorTable[9] = new Color(255, 255, 255);
         return colorTable[sliderValue];
    }
}
