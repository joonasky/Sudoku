#Aihemäärittely

**Aihe**: Sudoku peli, jolle voi antaa ratkaistavaksi sudokun tai joka voi
      antaa pelaajalle ratkaistavaksi sudokun. Mikäli päättää pelata itse, voi peliltä kysyä neuvoa. 

**Käyttäjät**: Pelin pelaajat

**Toiminnot**:<ul>
  	<li>Uuden tyhjän pelin valitseminen</li>
  	<li>Uuden valmiin pelin valitseminen</li>
  	<li>Seuraavan askeleen ehdotus</li>
  	<li>Sudokun ratkaisu</li>
	<li>Sudokun tarkastus</li>
	</ul>

**Rakennekuvaus**

Board-luokka on pelin ydin. Sillä on kaikki metodit, joita peliin tarvitaan. Pelin luomiseen 
Board-luokka käyttää BoardGenerator-luokkaa. Ja sudokujen ratkaisemiseen Board-luokka käyttää 
BoardSolver-luokkaa.
BoardGenerator generoi sudokut sudokut2.txt-tiedostosta.

Käyttöliittymä Gui koostuu SudokuComponentista ja kuuntelijoista. SudokuComponent piirtää siis pelikentän.
ButtonListener kuuntelee nappuloita ja suorittaa vastaavia Board-olion tehtäviä. MouseEar-kuuntelija 
kuuntelee mihin hiri näppäilee ja aktivoi Board luokasta vaativat solut. Keyboardear-kuuntelija 
kuuntelee näppäimistöä ja asettaa näpätyn numeron aktiiviseen kenttään Board-oliossa.

	   	   
	   
