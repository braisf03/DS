package e1;

import e1.equipos.Artistico.Doblador;
import e1.equipos.Artistico.Especialista;
import e1.equipos.Artistico.Interprete;
import e1.equipos.EquipoHumano;
import e1.equipos.Tecnico.Director;
import e1.equipos.Tecnico.Guionista;
import e1.equipos.Tecnico.Musico;
import e1.equipos.Tecnico.Productor;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PeliculaTest {


    @Test
    void declareMovies(){

        assertThrows(IllegalArgumentException.class, () -> new Pelicula(null,1000));
        assertThrows(IllegalArgumentException.class, () -> new Pelicula("Shreck3",-1000));

    }

    @Test
    void declareTeams(){

        Pelicula p1 = new Pelicula("Shreck",1000);

        //--------------------------------- TEST 1 ---------------------------------

        p1.equipo = new LinkedList<>();

        assertThrows(IllegalArgumentException.class,()-> p1.addMember(null));

        //--------------------------------- TEST 2 ---------------------------------

        p1.addMember(new Doblador("Jose","Maria","31340776A","Peruano"));

        assertThrows(IllegalArgumentException.class,()-> p1.addMember(new Director("Roberto","Pedrosa","31340776A","Madrileño",0)));





    }
    @Test
    void printSalaries() {

        Pelicula p1 = new Pelicula("Shreck",1000);

        //--------------------------------- TEST 1 ---------------------------------

        p1.equipo = new LinkedList<>();

        p1.addMember(new Doblador("Jose","Maria","31340776A","Peruano"));
        p1.addMember(new Interprete("Carmen","Josue","35240776C","Puerto Riquense",true));
        p1.addMember(new Musico("Mario","Prado","39834676D","Peruano"));
        p1.addMember(new Especialista("Brais","Maria","39810346S","Español",true));
        p1.addMember(new Director("Brais","Jr","39810566H","Andorrana",10));
        p1.addMember(new Guionista("Hugo","Estevez","39878776J","Islandiense",true));
        p1.addMember(new Productor("Rodrigo","Arteñon","39833776Q","Murciano"));


        for (EquipoHumano p : p1.equipo) {

            p.addHours(10);

        }

        assertEquals(
                """
                        Jose Maria ( Doblador ): 200,00 euro
                        Carmen Josue ( Interprete protagonista ): 6000,00 euro
                        Mario Prado ( Musico ): 600,00 euro
                        Brais Maria ( Especialista con escenas peligrosas ): 1400,00 euro
                        Brais Jr ( Director con 10 años de experiencia ): 11000,00 euro
                        Hugo Estevez ( Guionista con guion orignal ): 4700,00 euro
                        Rodrigo Arteñon ( Productor ): 900,00 euro
                        """, p1.printSalaries());



        //--------------------------------- TEST 2 ---------------------------------


        p1.equipo = new LinkedList<>();

        p1.addMember(new Doblador("Jose","Maria","31340776A","Peruano"));
        p1.addMember(new Interprete("Carmen","Josue","35240776C","Puerto Riquense",false));
        p1.addMember(new Musico("Mario","Prado","39834676D","Peruano"));
        p1.addMember(new Especialista("Brais","Maria","39810346S","Español",false));
        p1.addMember(new Director("Brais","Jr","39810566H","Andorrana",0));
        p1.addMember(new Guionista("Hugo","Estevez","39878776J","Islandiense",false));
        p1.addMember(new Productor("Rodrigo","Arteñon","39833776Q","Murciano"));




        for (EquipoHumano p : p1.equipo) {

            p.addHours(10);

        }

        assertEquals(
                """
                        Jose Maria ( Doblador ): 200,00 euro
                        Carmen Josue ( Interprete ): 2000,00 euro
                        Mario Prado ( Musico ): 600,00 euro
                        Brais Maria ( Especialista ): 400,00 euro
                        Brais Jr ( Director ): 1000,00 euro
                        Hugo Estevez ( Guionista ): 700,00 euro
                        Rodrigo Arteñon ( Productor ): 900,00 euro
                        """, p1.printSalaries());




        //--------------------------------- TEST 3 ---------------------------------

        p1.equipo = new LinkedList<>();

        assertThrows(IllegalArgumentException.class, p1::printSalaries);

        //--------------------------------- TEST 4 ---------------------------------

        p1.equipo = null;

        assertThrows(IllegalArgumentException.class, p1::printSalaries);
    }

    @Test
    void printRoyalties() {


        Pelicula p1 = new Pelicula("Shreck",1000);
        //--------------------------------- TEST 1 ---------------------------------

        p1.equipo = new LinkedList<>();

        p1.addMember(new Doblador("Jose","Maria","31340776A","Peruano"));
        p1.addMember(new Interprete("Carmen","Josue","35240776C","Puerto Riquense",true));
        p1.addMember(new Musico("Mario","Prado","39834676D","Peruano"));
        p1.addMember(new Especialista("Brais","Maria","39810346S","Español",true));
        p1.addMember(new Director("Brais","Jr","39810566H","Andorrana",10));
        p1.addMember(new Guionista("Hugo","Estevez","39878776J","Islandiense",true));
        p1.addMember(new Productor("Rodrigo","Arteñon","39833776Q","Murciano"));


        assertEquals(
                """
                        Mario Prado ( Musico ): 40,00 euro
                        Brais Jr ( Director ): 50,00 euro
                        Hugo Estevez ( Guionista ): 50,00 euro
                        Rodrigo Arteñon ( Productor ): 20,00 euro
                        """, p1.printRoyalties());


        //--------------------------------- TEST 2 ---------------------------------

        p1.equipo = new LinkedList<>();

        assertThrows(IllegalArgumentException.class, p1::printRoyalties);

        //--------------------------------- TEST 3 ---------------------------------

        p1.equipo = null;

        assertThrows(IllegalArgumentException.class, p1::printRoyalties);
    }
}