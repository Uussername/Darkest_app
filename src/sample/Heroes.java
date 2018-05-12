package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Main class of data that is used throughout the program
 * Contains methods that format the data to be used in tables or to set labels
 */
public class Heroes {
    /**
     * Base is the first table of the webpage and contains base stats of the character
     * skills is every other table of the page, typically used with .get()
     * skills go by 1, 3, 5, 7, 9, 11, 13 in the .get() command
     */
    public Elements Base;
    public Elements skills;

    /**
     * Constructor for the class needs the ending of the URL to scrape the Elements
     *
     * @param input ending of the URL of the page being scraped ex: Abomination, Plague_Doctor
     * @throws IOException exception for Jsoup
     *
     * connects to site using the input and grabs the Elements
     */
    public Heroes(String input) throws IOException {
        Document doc = Jsoup.connect("https://darkestdungeon.gamepedia.com/" + input).get();
        Base = doc.getElementsByClass("wikitable charactertable");
        skills = doc.getElementsByClass("wikitable");
    }

    /**
     * method for table creation
     * formats columns of data into ArrayList
     *
     * @param hero elements being worked with
     * @param y the column of the table being sorted
     * @param z used to differentiate from row headings and row data
     *
     * creates new ArrayList
     * For loop, 10 iterations
     *          selects the individual data element of the column being processed
     * the same data must be collected as values do not change
     * For loop, 4
     *          grabs stat categories or the values depending on z
     * @return the ArrayList of the Column of data
     */
    public static ArrayList<String> statList(Heroes hero, int y, int z) {
        ArrayList<String> Catagories = new ArrayList<>();

        for (int x = 2; x < 12; x++) {
                Catagories.add(hero.Base.select("tr").get(x).select("td:eq(" + y + ")").text());
        }
        for (int x = 12; x < 16; x++) {
            Catagories.add(hero.Base.select("tr").get(x).child(z).text());
            Catagories.add(hero.Base.select("tr").get(x).child(z+2).text());
        }
        return  Catagories;
    }

    /**
     * similar to starList
     * method for table creation
     * formats columns of data into ArrayList
     *
     * @param hero elements of webpage
     * @param y the column being processed
     * @param selector the table of the column
     *
     *  creates an ArrayList
     * Runs RANK and RANK target to obtain data for coulmns that only contain images
     * grabs the rest of the columns
     *
     * @return column of skill data, 2 items
     */
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

    /**
     * similar to starListDamage, but gets the ranks sooner
     * method for table creation
     * formats columns of data into ArrayList
     *
     * @param hero elements of webpage
     * @param y the column being processed
     * @param selector the table of the column
     *
     * creates an ArrayList
     * Runs RANK and RANK target to obtain data for coulmns that only contain images
     * grabs the rest of the columns
     *
     * @return column of skill data, 2 items
     */
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

    /**
     * Changes 2 specific images into 1 or 0 and puts a whole string together
     * @param hero elements of webpage
     * @param selector Skill being selected
     *
     * if the image in the cell of the table is gray, add a 0 to the string
     * if the image in the cell of the table is yellow, add a 1 to the string
     * repeat for all 4 images
     *
     * @return the created string
     */
    private static String RANK(Heroes hero, int selector) {
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

    /**
     * Changes 5 specific images into 1, 2 or 0 and puts a whole string together
     * @param hero elements of webpage
     * @param selector Skill being selected
     *
     * if the image in the cell of the table is gray, add a 0 to the string
     * if the image in the cell of the table is red, add a 1 to the string
     * if the image in the cell of the table is some other red dot, add a 2 to the string
     *
     * repeat for all 4 images
     *
     * @return the created string
     */
    private static String RANKtarget(Heroes hero, int selector) {
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

    /**
     * Changes 5 specific images into 1, 2 or 0 and puts a whole string together
     * @param hero elements of webpage
     * @param selector Skill being selected
     *
     * if the image in the cell of the table is gray, add a 0 to the string
     * if the image in the cell of the table is yellow, add a 1 to the string
     * if the image in the cell of the table is some other yellow dot, add a 2 to the string
     *
     * repeat for all 4 images
     *
     * @return the created string
     */
    private static String RANKtargetBUFF(Heroes hero, int selector) {
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

    /**
     * Changes 2 specific images into 1 or 0 and puts a whole string together
     *
     * @param hero elements of webpage
     * @param selector Skill being selected
     * @param x image in cell being inspected
     *
     * if the image in the cell of the table is gray, return a 0
     * if the image in the cell of the table is red, return a 1
     *
     * @return the integer
     */
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

    /**
     * Changes 5 specific images into 1 or n0 and puts a whole string together
     *
     * @param hero elements of webpage
     * @param selector Skill being selected
     * @param x image in cell being inspected
     *
     * if the image in the cell of the table is gray, return a 0
     * if the image in the cell of the table is red, return a 1
     *
     * @return the integer
     */
    public static Integer RANKtargetNUM(Heroes hero, int selector, int x) {
        int places = 0;
        if (hero.skills.get(selector).select("span").first().text().equals("Self")) {
            return places;
        }
        if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/f/ff/Grey_dot.png?version=076bea2cedf423f5708d70126c4938ab")) {
            places = places + 0;
        }
        if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/7/78/Red_dot.png?version=3e045feb532a7fda9d2f824a00f470ac")) {
            places = places + 1;
        }
        if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/1/1b/Red_dotr.png?version=7b7fcb669574a1356b7863cd6b691df3")) {
            places = places + 1;
        }
        if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/0/0f/Red_dotl.png?version=f2ca7d56c985fb15a7e6da033b46fdf6")) {
            places = places + 1;
        }
        if (hero.skills.get(selector).select("img").get(x).attr("src").equals(
                "https://d1u5p3l4wpay3k.cloudfront.net/darkestdungeon_gamepedia/6/62/Red_dotlr.png?version=1fdff0f7564b1d712845a5791109fdd2")) {
            places = places + 1;
        }
        return places;
    }
}



