import com.mycompany.ohtuminiprojekti.*
import com.mycompany.ohtuminiprojekti.IO.*
import com.mycompany.ohtuminiprojekti.search.*

description 'Käyttäjänä voin lisätä uuden viitteen'

scenario "käyttäjän annettua oikeat lomaketiedot ne tulostetaan takaisin ennen hyväksymistä", {
    given 'ohjelma on käynnistetty', {
        io = new StubIO() 
        ui = new UI(io)
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
        ui.run()
    }

    then 'samat tiedot tulostetaan ennen hyväksymistä', {
        io.getOutput(8).shouldHave("Etunimi Sukunimi")
        io.getOutput(9).shouldHave("Kirja")
        io.getOutput(10).shouldHave("1987")
        io.getOutput(11).shouldHave("Julkaisija")
    }
}