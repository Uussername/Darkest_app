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
        if (y == 3) {
            Stuff.add(RANKtarget(hero, selector));
        }
        else{
            Stuff.add(hero.skills.get(selector).select("tr").get(2).select("td:eq(" + (y + -1) + ")").text());
        }

        return Stuff;
    }
    public static ArrayList<String> SkillListBuff(Heroes hero,int y, int selector) {
        ArrayList<String> Stuff = new ArrayList<>();
        Stuff.add(hero.skills.get(selector).select("tr").get(1).select("td:eq(" + y + ")").text());
        if (y == 1){
            Stuff.add(RANK(hero, selector));
        }
        if (y == 2) {
                Stuff.add(RANKtargetBUFF(hero, selector));
        }
        else{
            Stuff.add(hero.skills.get(selector).select("tr").get(2).select("td:eq(" + (y + -1) + ")").text());
        }
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
    public static String RANKtarget(Heroes hero, int selector) {
        String places = "";
        if (hero.skills.get(selector).select("span").text().equals("Self")) {
        places = "SELF";
        return places;
        }
        for (int x = 5; x < 9; x++) {
            if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                    "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/f/ff/Grey_dot.png?version=076bea2cedf423f5708d70126c4938ab")) {
                places = places + "0";
            }
            else if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                    "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/7/78/Red_dot.png?version=3e045feb532a7fda9d2f824a00f470ac")) {
                places = places + "1";
            }
            else if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                        "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/1/1b/Red_dotr.png?version=7b7fcb669574a1356b7863cd6b691df3")) {
                places = places + "2";
            }
            else if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                    "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/0/0f/Red_dotl.png?version=f2ca7d56c985fb15a7e6da033b46fdf6")) {
                places = places + "2";
            }
            else if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                    "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/6/62/Red_dotlr.png?version=1fdff0f7564b1d712845a5791109fdd2")) {
                places = places + "2";
            }
        }
        return places;
    }

    public static String RANKtargetBUFF(Heroes hero, int selector) {
        String places = "";
        if (hero.skills.get(selector).select("span").first().text().equals("Self")) {
            places = "SELF";
            return places;
        }
        else {
            for (int x = 5; x < 9; x++) {
                if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                        "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/f/ff/Grey_dot.png?version=076bea2cedf423f5708d70126c4938ab")) {
                    places = places + "0";
                } else if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                        "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/f/fa/Yellow_dot.png?version=eb8a237b9baf3aa5ce018224176a00e9")) {
                    places = places + "1";
                } else if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                        "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/d/de/Yellow_dotr.png?version=da420266801c7e86b972cfba8d8e24b1")) {
                    places = places + "2";
                } else if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                        "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/1/15/Yellow_dotlr.png?version=35a93268b46e1f32d5fdbc7403b59ffb")) {
                    places = places + "2";
                } else if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                        "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/d/df/Yellow_dotl.png?version=8ae1d92860aac694d0f6845484d3a021")) {
                    places = places + "2";
                }
            }
            return places;
        }
    }
    public static Integer RANKnum(Heroes hero, int selector, int x) {
        int places = 0;
            if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                    "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/f/ff/Grey_dot.png?version=076bea2cedf423f5708d70126c4938ab")) {
                places = places + 0;
            }
            if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                    "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/f/fa/Yellow_dot.png?version=eb8a237b9baf3aa5ce018224176a00e9")) {
                places = places + 1;
            }
        return places;
    }
}



