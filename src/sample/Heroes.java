package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Heroes {
    public Elements Base;
    public Elements skills;

    public Heroes(String input) throws IOException {
        Document doc = Jsoup.connect("https://darkestdungeon.gamepedia.com/" + input).get();
        Base = doc.getElementsByClass("wikitable charactertable");
        skills = doc.getElementsByClass("wikitable");
    }
    public static ArrayList<String> statList(Heroes hero, int y) {
        ArrayList<String> Catagories = new ArrayList<>();

        for (int x = 2; x < 12; x++) {
                Catagories.add(hero.Base.select("tr").get(x).select("td:eq(" + y + ")").text());
        }
        for (int x = 12; x < 16; x++) {
            Catagories.add(hero.Base.select("tr").get(x).child(0).text());
            Catagories.add(hero.Base.select("tr").get(x).child(2).text());
        }
        return  Catagories;
    }
    public static ArrayList<String> statList2(Heroes hero, int y) {
        ArrayList<String> Catagories = new ArrayList<>();

        for (int x = 2; x < 12; x++) {
            Catagories.add(hero.Base.select("tr").get(x).select("td:eq(" + y + ")").text());
        }
        for (int x = 12; x < 16; x++) {
            Catagories.add(hero.Base.select("tr").get(x).child(1).text());
            Catagories.add(hero.Base.select("tr").get(x).child(3).text());
        }
        return Catagories;
    }
    public static ArrayList<String> skillsListDamage(Heroes hero, int y, int selector) {
        ArrayList<String> Stuff = new ArrayList<>();
        Stuff.add(hero.skills.get(selector).select("tr").get(1).select("td:eq(" + y + ")").text());
        if (y == 2){
            Stuff.add(RANK(hero, selector));
        }
        else{
            Stuff.add(hero.skills.get(selector).select("tr").get(2).select("td:eq(" + (y + -1) + ")").text());
        }

        return Stuff;
    }
    public static ArrayList<String> SkillListBuff(Heroes hero, int selector) {
        ArrayList<String> Stuff = new ArrayList<>();
        Stuff.add(hero.skills.get(selector).select("tr").get(0).text());
        System.out.println(hero.skills.get(selector).select("tr").get(0).text());
        return Stuff;
    }
    public static ArrayList<String> SkillListHeal(Heroes hero, int selector) {
        ArrayList<String> Stuff = new ArrayList<>();
        Stuff.add(hero.skills.get(1).select("tr").get(0).text());
        System.out.println(hero.skills.get(selector).select("tr").get(0).text());
        return Stuff;
    }
    public static String RANK(Heroes hero, int selector) {
        String places = "";
        for (int x = 1; x < 5; x++) {
            if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                    "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/f/ff/Grey_dot.png?version=076bea2cedf423f5708d70126c4938ab")) {
                places = places + "0";

            }
            if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                    "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/f/fa/Yellow_dot.png?version=eb8a237b9baf3aa5ce018224176a00e9")) {
                places = places + "1";
            }
        }
            return places;
        }


}



