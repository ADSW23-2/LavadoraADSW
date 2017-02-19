import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LavadoraV4 {
    //Se usa una LinkedList porque son mas eficientes para los metodos que se requieren
    private List<Ropa> miLista;
    private static final int PESOMAX = 1000;
    private static final int PRENDASMAX = 10;

    public LavadoraV4() {
        miLista = new LinkedList<>();
    }

    public boolean metePeso(List<Ropa> entLista) throws Exception{
        if(checkPeso(entLista) && checkElementos(entLista)){
            miLista.addAll(entLista);
            System.out.println("Se han metido Correctamente");
            return true;
        }
        System.out.println("No se han podido metePesor");
        return false;
    }

    public void vacia(){
        System.out.println("Lavadora Vaciada");
        miLista.clear();
    }

    private boolean checkPeso(List<Ropa> entLista) throws Exception{
        int pesoTotal = getPeso(entLista) + getPeso(miLista);
        if(pesoTotal >= PESOMAX){
            throw new PesoExcedidoException(pesoTotal,PESOMAX);
        }
        return true;
    }

    private int getPeso(List<Ropa> lista) {
        int peso = 0;
        for(Ropa r : lista){
            peso += r.getPeso();
        }
        return peso;
    }

    private boolean checkElementos(List<Ropa> entLista) throws Exception {
        if(entLista.size()+miLista.size()>=PRENDASMAX){
            throw new Exception("Exceso de Elementos");
        }
            return true;
    }

    public List<Ropa> getRopa() {
        return miLista;
    }

    public int getPesoAct(){
        return getPeso(miLista);
    }

    public static void main(String[] args){
        Ropa camisa = new Ropa("camisa",150,Color.ROJO);
        Ropa pantalon = new Ropa("pantalón",300,Color.ROJO);
        Ropa blusa = new Ropa("blusa",50,Color.BLANCO);
        Ropa blusa_azul = new Ropa("blusa",200,Color.AZUL);
        Ropa blusa_roja = new Ropa("blusa",450,Color.ROJO);
        Ropa blusa_amarilla = new Ropa("blusa",450,Color.AMARILLO);
        System.out.println(camisa.toString());
        System.out.println(pantalon.toString());
        System.out.println(blusa.toString());
        LavadoraV4 lavadora4 = new LavadoraV4();
        //Lista Correcto 1
        Ropa[] miColada1 = {camisa,pantalon,blusa,blusa,blusa,blusa,camisa};
        List<Ropa> miListaColada1 = Arrays.asList(miColada1);
        try {
            lavadora4.metePeso(miListaColada1);
        }catch (
                PesoExcedidoException e){e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
        //Array Correcto 2
        Ropa[] miColada2 = {blusa,blusa,blusa};
        List<Ropa> miListaColada2 = Arrays.asList(miColada2);
        try {
            lavadora4.metePeso(miListaColada2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        lavadora4.vacia();
        //Segundo Llenado
        try {
            lavadora4.metePeso(miListaColada2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        lavadora4.vacia();
        //Array Exceso de Elementos
        Ropa[] miColadaConDemasiadosElementos = {camisa,pantalon,blusa,blusa,blusa,blusa,camisa,blusa,blusa,blusa,blusa,blusa};
        List<Ropa> miListaColadaConDemasiadosElementos = Arrays.asList(miColadaConDemasiadosElementos);
        try {
            lavadora4.metePeso(miListaColadaConDemasiadosElementos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Array con exceso de peso
        Ropa[] miColadaConExcesoDePeso = {camisa,pantalon,blusa,blusa_azul,blusa_roja,blusa_amarilla};
        List<Ropa> miListaColadaConExcesoDePeso = Arrays.asList(miColadaConExcesoDePeso);
        try {
            lavadora4.metePeso(miListaColadaConExcesoDePeso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
