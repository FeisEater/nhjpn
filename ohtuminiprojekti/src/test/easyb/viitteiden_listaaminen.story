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
        io.addInput("")
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
        io.addInput("")
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
        io.addInput("")
        io.addInput("k")
        io.addInput("tiedosto")
        io.addInput("search")
        io.addInput("tiedosto")
        io.addInput("")
        io.addInput("")
        ui.run()
    }

    then 'viitteet tulostetaan lisäämisjärjestyksessä', {
        s = io.getOutput(49).split("author")
        s[1].shouldHave("year: 1111")
        s[2].shouldHave("year: 2222")
        s[3].shouldHave("year: 3333")
        sc.close()
    }
}
