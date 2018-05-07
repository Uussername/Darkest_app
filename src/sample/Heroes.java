package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Heroes {
    public Elements table;
    public Element skill1;
    public Element skill2;
    public Element skill3;
    public Element skill4;
    public Element skill5;
    public Element skill6;
    public Element skill7;

    public Heroes(String input) throws IOException {
        Document doc = Jsoup.connect("https://darkestdungeon.gamepedia.com/"+input).get();
        table = doc.getElementsByClass("wikitable charactertable");
        skill1 = doc.getElementsByClass("wikitable").get(1);
        skill2 = doc.getElementsByClass("wikitable").get(3);
        skill3 = doc.getElementsByClass("wikitable").get(5);
        skill4 = doc.getElementsByClass("wikitable").get(7);
        skill5 = doc.getElementsByClass("wikitable").get(9);
        skill6 = doc.getElementsByClass("wikitable").get(11);
        skill7 = doc.getElementsByClass("wikitable").get(13);
    }
}



