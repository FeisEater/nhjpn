package com.mycompany.ohtuminiprojekti;

import java.util.ArrayList;

/**
 *
 * @author niko Luokka, joka huolehtii syötteiden käsittelystä bibtexin
 * edellyttämään muotoon.
 */
public class Formatter {

    ArrayList<String> tags;

    public Formatter(ArrayList<String> tags) {
        this.tags = tags;
    }

    /**
     * Luo julkaisulle uniikin tagin kirjailijan/kirjailijoiden nimen ja
     * julkaisuvuoden perusteella.
     *
     * @param nameList Kirjailijoiden nimet.
     * @param year Julkaisuvuosi.
     * @return Palauttaa luodun tagin.
     */
    public String formatTag(String[] nameList, String year) {
        year = year.substring(2);
        String tag = "";

        if (nameList.length == 2) {
            tag += nameList[1];
        } else {
            for (int i = 1; i < nameList.length; i += 2) {
                tag += nameList[i].substring(0, 1);
            }
        }

        tag += year;

        while (tagIsUsed(tag)) {
            tag += "I";
        }

        return tag;
    }

    /**
     * Tarkistaa onko luotu tagi jo käytetty
     *
     * @param tag Tarkistettava luotu tagi
     * @return Palauttaa true jos käytetty, false jos vapaana.
     */
    private boolean tagIsUsed(String tag) {
        if (tags.contains(tag)) {
            return true;
        }

        return false;
    }

    /**
     * Julkaisijat vaativat hiukat enemmän käsittelyä, sillä heitä voi
     * olla useampi kappale, joten tämä metodi huolehtii sen kohdan
     * käsittelystä.
     * 
     * @param nameList
     * @return 
     */
    public String formatAuthors(String[] nameList) {
        String authors = "author = {";

        for (int i = 1; i < nameList.length; i += 2) {
            authors += nameList[i];
            authors += ", ";
            authors += nameList[i - 1];

            if (i != nameList.length - 1) {
                authors += " and ";
            }
        }

        authors += "}," + System.getProperty("line.separator");

        return authors;
    }

    /**
     * Metodi huolehtii kaikkien muiden paitsi julkaisijoiden
     * muotoilusta, sillä ne tulevat bibtexiin aivan samassa muodossa.
     *
     * @param type Tiedon tyyppi (esim. author, title).
     * @param info Tallennettava tieto (esim. vuosiluku, kirjan nimi).
     * @return Palauttaa muotoillun merkkijonon.
     */
    public String format(String type, String info) {
        return type + " = {" + info + "}," + System.getProperty("line.separator");
    }


}
