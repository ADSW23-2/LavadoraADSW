import org.junit.*;


import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;


public class LavadoraTest {

    private static int MAX_PRENDAS = 10;
    private static int MAX_PESO = 1000;

    LavadoraV4 lavadora = new LavadoraV4();

    Ropa ropa1 = new Ropa("Vestido",1, Color.AMARILLO);
    Ropa ropa2 = new Ropa("Pantalones",1, Color.BLANCO);
    Ropa ropa3 = new Ropa("Abrigo",1 , Color.AZUL);
    Ropa ropa4 = new Ropa("Vestido",1, Color.AMARILLO);
    Ropa ropa5 = new Ropa("Vestido",50, Color.AMARILLO);
    Ropa ropa6 = new Ropa("Pantalones",50, Color.BLANCO);
    Ropa ropa7 = new Ropa("Abrigo",50, Color.AZUL);
    Ropa ropa8 = new Ropa("Vestido",50, Color.AMARILLO);
    Ropa ropa9 = new Ropa("Pantalones",100, Color.BLANCO);
    Ropa ropa10 = new Ropa("Abrigo",100, Color.AZUL);
    Ropa ropa11 = new Ropa("Vestido",100, Color.AMARILLO);
    Ropa ropa12 = new Ropa("Abrigo",999, Color.AZUL);
    Ropa ropa13 = new Ropa("Abrigo",1000, Color.AZUL);
    Ropa ropa14 = new Ropa("Abrigo",1001, Color.AZUL);

    LinkedList<Ropa> colada1 = new LinkedList<Ropa>(); // No excede prendas ni peso
    LinkedList<Ropa> colada2 = new LinkedList<Ropa>(); // Limite prendas y no peso
    LinkedList<Ropa> colada3 = new LinkedList<Ropa>(); // Excede prendas y no peso

    LinkedList<Ropa> colada4 = new LinkedList<Ropa>(); // No excede prendas ni peso
    LinkedList<Ropa> colada5 = new LinkedList<Ropa>(); // No excede prendas y limite
    // peso
    LinkedList<Ropa> colada6 = new LinkedList<Ropa>(); // No excede prendas y excede
    // peso

    @Before
    public void setUp(){
        colada1.add(ropa1);
        colada1.add(ropa2);
        colada1.add(ropa3);
        colada1.add(ropa4);
        colada1.add(ropa5);
        colada1.add(ropa6);
        colada1.add(ropa7);
        colada1.add(ropa8);
        colada1.add(ropa9);

        colada2.add(ropa1);
        colada2.add(ropa2);
        colada2.add(ropa3);
        colada2.add(ropa4);
        colada2.add(ropa5);
        colada2.add(ropa6);
        colada2.add(ropa7);
        colada2.add(ropa8);
        colada2.add(ropa9);
        colada2.add(ropa10);

        colada3.add(ropa1);
        colada3.add(ropa2);
        colada3.add(ropa3);
        colada3.add(ropa4);
        colada3.add(ropa5);
        colada3.add(ropa6);
        colada3.add(ropa7);
        colada3.add(ropa8);
        colada3.add(ropa9);
        colada3.add(ropa10);
        colada3.add(ropa11);

        colada4.add(ropa12);

        colada5.add(ropa13);

        colada6.add(ropa14);
    }
    @Test

    public void testMete1() throws Exception {
        lavadora.metePeso(colada1);
        assertEquals(MAX_PRENDAS-1, lavadora.getRopa().size());
    }

    @Test
    public void testMete2() throws Exception {
        lavadora.metePeso(colada2);
        assertEquals(MAX_PRENDAS, lavadora.getRopa().size());
    }

    @Test (expected=Exception.class)
    public void testMete3() throws Exception {
        lavadora.metePeso(colada3);
    }

    @Test
    public void testMete4() throws Exception {
        lavadora.metePeso(colada4);
		assertEquals(1, lavadora.getRopa().size());
		assertEquals(MAX_PESO-1,lavadora.getPesoAct());
    }

    @Test
    public void testMetePeso5() throws Exception {
        lavadora.metePeso(colada5);
        assertEquals(MAX_PESO, lavadora.getPesoAct());
    }

    @Test(expected=PesoExcedidoException.class)
    public void testMetePeso6() throws Exception {
        lavadora.metePeso(colada6);
    }

    @Test
    public void vacia() throws Exception{
        lavadora.metePeso(colada1);
        lavadora.vacia();
        assertEquals(0, lavadora.getRopa().size());
    }
}
