import com.mycompany.ohtuminiprojekti.*
import com.mycompany.ohtuminiprojekti.IO.*
import com.mycompany.ohtuminiprojekti.search.*

description 'Käyttäjänä voin lisätä uuden viitteen'

scenario "käyttäjän annettua oikeat lomaketiedot kirjasta ne tulostetaan takaisin ennen hyväksymistä", {
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
        io.addInput("")
        ui.run()
    }

    then 'samat tiedot tulostetaan ennen hyväksymistä', {
        io.getOutput(9).shouldHave("Etunimi Sukunimi")
        io.getOutput(10).shouldHave("Kirja")
        io.getOutput(11).shouldHave("1987")
        io.getOutput(12).shouldHave("Julkaisija")
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
        io.addInput("")
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
                io.addInput("")
        	io.addInput("k")
        	io.addInput("tiedosto")
        	ui.run()
        }
        
        then 'samat tiedot tulostetaan ennen hyväksymistä', {

        	io.getOutput(9).shouldHave("Mina Sina")
        	io.getOutput(10).shouldHave("artikkeli")
        	io.getOutput(11).shouldHave("1234")
        	io.getOutput(12).shouldHave("Julkaisija")

        }
}

scenario "käyttäjän annettua oikeat artikkelin lomaketiedot tiedoston luonti onnistuu", {
    given 'ohjelma on käynnistetty', {
        io = new StubIO() 
        ui = new UI(io)
        sc = new ScannerForTest("tiedosto.bib")        
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
        io.addInput("")
        io.addInput("k")
        io.addInput("tiedosto")
        ui.run()
    }

    then 'tieto löytyy tiedostosta', {
        sc.readFile()
        sc.contains("@article").shouldBe(true)
        sc.contains("author = {Sina, Mina}").shouldBe(true)
        sc.contains("title = {artikkeli}").shouldBe(true)
        sc.contains("year = {1234}").shouldBe(true)
        sc.contains("journal = {Julkaisija}").shouldBe(true)
        sc.close()
    }
}

scenario "käyttäjä antaa tiedot inproceeding ja ne tulostetaan oikein ennen hyväksymistä", {
	given 'ohjelma on käynnistetty', {
		io = new StubIO() 
        	ui = new UI(io)
        }
        
        when 'oikeat tiedot lisätty lomakkeeseen', {
        	io.addInput("add")
        	io.addInput("inproceedings")
        	io.addInput("Kalle")
        	io.addInput("Makinen")
        	io.addInput("")
        	io.addInput("ilmastonmuutos")
        	io.addInput("2000")
        	io.addInput("Maailma")
        	io.addInput("1-3")
        	io.addInput("lehti")
                io.addInput("")
        	ui.run()
        }
        
        then 'samat tiedot tulostetaan ennen hyväksymistä', {
        	io.getOutput(11).shouldHave("Kalle Makinen")
        	io.getOutput(12).shouldHave("ilmastonmuutos")
        	io.getOutput(13).shouldHave("2000")
        	io.getOutput(14).shouldHave("Maailma")
        	io.getOutput(15).shouldHave("1-3")
        	io.getOutput(16).shouldHave("lehti")
        }
}

scenario "käyttäjän annettua oikeat inproceeding lomaketiedot tiedoston luonti onnistuu", {
    given 'ohjelma on käynnistetty', {
        io = new StubIO() 
        ui = new UI(io)        
        sc = new ScannerForTest("tiedosto.bib")
    }

    when 'oikeat tiedot on lisätty lomakkeeseen', {
        io.addInput("add")
        io.addInput("inproceedings")
        io.addInput("Kalle")
        io.addInput("Makinen")
        io.addInput("")
        io.addInput("ilmastonmuutos")
        io.addInput("2000")
        io.addInput("Maailma")
        io.addInput("1-3")
        io.addInput("lehti")
        io.addInput("")
        io.addInput("k")
        io.addInput("tiedosto")
        ui.run()
    }

    then 'tieto löytyy tiedostosta', {
                
        sc.readFile()
        sc.contains("@inproceedings").shouldBe(true)
        sc.contains("author = {Makinen, Kalle}").shouldBe(true)
        sc.contains("title = {ilmastonmuutos}").shouldBe(true)
        sc.contains("year = {2000}").shouldBe(true)
        sc.contains("booktitle = {Maailma}").shouldBe(true)
        sc.contains("pages = {1-3}").shouldBe(true)
        sc.contains("publisher = {lehti}").shouldBe(true)
        sc.close()
    }
}
