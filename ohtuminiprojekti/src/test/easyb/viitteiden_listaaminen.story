import com.mycompany.ohtuminiprojekti.*
import com.mycompany.ohtuminiprojekti.IO.*
import com.mycompany.ohtuminiprojekti.search.*

description 'Käyttäjänä voin listata viitteet'

scenario "lisättyä muutama viite listauskomennosta ne listataan lisäysjärjestyksessä", {
    given 'ohjelma on käynnistetty', {
        io = new StubIO() 
        ui = new UI(io)
        sc = new ScannerForTest("tiedosto.bib")
    }

    when '3 liitettä on lisätty', {
        io.addInput("add")
        io.addInput("book")
        io.addInput("etu1")
        io.addInput("suku1")
        io.addInput("")
        io.addInput("kirja1")
        io.addInput("1111")
        io.addInput("Julkaisija1")
        io.addInput("k")
        io.addInput("tiedosto")
        io.addInput("add")
        io.addInput("book")
        io.addInput("etu2")
        io.addInput("suku2")
        io.addInput("")
        io.addInput("kirja2")
        io.addInput("2222")
        io.addInput("Julkaisija2")
        io.addInput("k")
        io.addInput("tiedosto")
        io.addInput("add")
        io.addInput("book")
        io.addInput("etu3")
        io.addInput("suku3")
        io.addInput("")
        io.addInput("kirja3")
        io.addInput("3333")
        io.addInput("Julkaisija3")
        io.addInput("k")
        io.addInput("tiedosto")
        io.addInput("search")
        io.addInput("tiedosto")
        io.addInput("")
        io.addInput("")
        ui.run()
    }

    then 'viitteet tulostetaan lisäämisjärjestyksessä', {
        s = io.getOutput(51).split("author")
        s[0].shouldHave("year: 1111")
        s[0].shouldHave("year: 2222")
        s[0].shouldHave("year: 3333")
    }
}

scenario "käyttäjän annettua oikeat lomaketiedot tiedoston luonti onnistuu", {
    given 'ohjelma on käynnistetty', {
        io = new StubIO() 
        ui = new UI(io)
        sc = new ScannerForTest("tiedosto.bib")
    }

    when 'oikeat tiedot on lisätty lomakkeeseen', {
        io.addInput("add")
        io.addInput("book")
        io.addInput("Etunimi")
        io.addInput("Sukunimi")
        io.addInput("")
        io.addInput("Kirja")
        io.addInput("1987")
        io.addInput("Julkaisija")
        io.addInput("k")
        io.addInput("tiedosto")
        ui.run()
    }

    then 'tieto löytyy tiedostosta', {
        sc.readFile()
        sc.contains("@book").shouldBe(true)
        sc.contains("author = {Sukunimi, Etunimi}").shouldBe(true)
        sc.contains("title = {Kirja}").shouldBe(true)
        sc.contains("year = {1987}").shouldBe(true)
        sc.contains("publisher = {Julkaisija}").shouldBe(true)
        sc.close()
    }
}
