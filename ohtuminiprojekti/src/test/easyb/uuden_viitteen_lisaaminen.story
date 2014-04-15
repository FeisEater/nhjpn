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

scenario "käyttäjän annettua oikeat lomaketiedot tiedoston luonti onnistuu", {
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
        io.addInput("k")
        io.addInput("tiedosto")
        ui.run()
    }

    then 'tieto löytyy tiedostosta', {
        sc = new ScannerForTest("tiedosto.bib")        
        sc.readFile()
        sc.contains("@book").shouldBe(true)
        sc.contains("author = {Sukunimi, Etunimi}").shouldBe(true)
        sc.contains("title = {Kirja}").shouldBe(true)
        sc.contains("year = {1987}").shouldBe(true)
        sc.contains("publisher = {Julkaisija}").shouldBe(true)
        sc.close()
    }
}

scenario "käyttäjä antaa tiedot artikkelista ja ne tulostetaan oikein ennen hyväksymistä", {
	given 'ohjelma on käynnistynyt', {
		io = new StubIO() 
        	ui = new UI(io)
        }
        
        when 'oikeat tiedot on lisätty lomakkeeseen', {
        	io.addInput("add")
        	io.addInput("article")
        	io.addInput("Mina")
        	io.addInput("Sina")
        	io.addInput("")
        	io.addInput("artikkeli")
        	io.addInput("1234")
        	io.addInput("Julkaisija")
        	io.addInput("k")
        	io.addInput("tiedosto")
        	ui.run()
        }
        
        then 'samat tiedot tulostetaan ennen hyväksymistä' {
        	io.getOutput(8).shouldHave("Mina Sina")
        	io.getOutput(9).shouldHave("artikkeli")
        	io.getOutput(10).shouldHave("1234")
        	io.getOutput(11).shouldHave("Julkaisija")
        }
}

scenario "käyttäjän annettua oikeat artikkelin lomaketiedot tiedoston luonti onnistuu", {
    given 'ohjelma on käynnistetty', {
        io = new StubIO() 
        ui = new UI(io)
    }

    when 'oikeat tiedot on lisätty lomakkeeseen', {
        io.addInput("add")
        io.addInput("article")
        io.addInput("Mina")
        io.addInput("Sina")
        io.addInput("")
        io.addInput("artikkeli")
        io.addInput("1234")
        io.addInput("Julkaisija")
        io.addInput("k")
        io.addInput("tiedosto")
        ui.run()
    }

    then 'tieto löytyy tiedostosta', {
        sc = new ScannerForTest("tiedosto.bib")        
        sc.readFile()
        sc.contains("@article").shouldBe(true)
        sc.contains("author = {Sina, Mina}").shouldBe(true)
        sc.contains("title = {artikkeli}").shouldBe(true)
        sc.contains("year = {1234}").shouldBe(true)
        sc.contains("publisher = {Julkaisija}").shouldBe(true)
        sc.close()
    }
}
