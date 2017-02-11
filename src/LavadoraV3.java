import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LavadoraV3 {


    //Se usa una LinkedList porque son mas eficientes para los metodos que se requieren
    private List<Ropa> miLista;
    private static final int PESOMAX = 1000;
    private static final int PRENDASMAX = 10;

    public LavadoraV3() {
        miLista = new LinkedList<>();
    }

    public boolean mete(List<Ropa> entLista){
        //Comprovamos el numero de elementos que vamos a introducir
        if(checkPeso(entLista) && checkElementos(entLista)){
            miLista.addAll(entLista);
            System.out.println("Se han metido Correctamente");
            return true;
        }else{
            System.out.println("No se han podido meter");
            return false;
        }

    }

    public void vacia(){
        System.out.println("Lavadora Vaciada");
        miLista.clear();
    }

    private boolean checkPeso(List<Ropa> entLista){
        if(getPeso(entLista)+getPeso(miLista)<= PESOMAX){
            return true;
        }else{
            System.out.println("Exceso De Peso");
            return false;
        }

    }

    private int getPeso(List<Ropa> lista) {
        int peso = 0;
        for(Ropa r : lista){
            peso += r.getPeso();
        }
        return peso;
    }

    private boolean checkElementos(List<Ropa> entLista){
        if(entLista.size()+miLista.size()<=PRENDASMAX){
            return true;
        }else{
            System.out.println("Exceso de Elementos");
            return false;
        }
    }

    public List<Ropa> getRopa() {
        return miLista;
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
        LavadoraV3 lavadora3 = new LavadoraV3();
        //Lista Correcto 1
        Ropa[] miColada1 = {camisa,pantalon,blusa,blusa,blusa,blusa,camisa};
        List<Ropa> miListaColada1 = Arrays.asList(miColada1);
        lavadora3.mete(miListaColada1);
        //Array Correcto 2
        Ropa[] miColada2 = {blusa,blusa,blusa};
        List<Ropa> miListaColada2 = Arrays.asList(miColada2);
        lavadora3.mete(miListaColada2);
        lavadora3.vacia();
        //Segundo Llenado
        lavadora3.mete(miListaColada2);
        lavadora3.vacia();
        //Array Exceso de Elementos
        Ropa[] miColadaConDemasiadosElementos = {camisa,pantalon,blusa,blusa,blusa,blusa,camisa,blusa,blusa,blusa,blusa,blusa};
        List<Ropa> miListaColadaConDemasiadosElementos = Arrays.asList(miColadaConDemasiadosElementos);
        lavadora3.mete(miListaColadaConDemasiadosElementos);
        //Array con exceso de peso
        Ropa[] miColadaConExcesoDePeso = {camisa,pantalon,blusa,blusa_azul,blusa_roja,blusa_amarilla};
        List<Ropa> miListaColadaConExcesoDePeso = Arrays.asList(miColadaConExcesoDePeso);
        lavadora3.mete(miListaColadaConExcesoDePeso);
    }
}
