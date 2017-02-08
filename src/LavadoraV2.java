import java.lang.reflect.Array;
import java.util.Arrays;

public class LavadoraV2 extends LavadoraV1{

    private static final int PESOMAX = 1000;
    private static final int PRENDASMAX = 10;
    private int slotsVacios;
    private int pesoPrendas;
    private Ropa[] misPrendas;



    public LavadoraV2(){
        super();
        misPrendas = new Ropa[PRENDASMAX];
        slotsVacios = 10;
        pesoPrendas = 0;
        System.out.println("Lavadora Vacia");

    }

    public void vaciarLavadora(){
        //Vaciamos Lavadora
        Arrays.fill(misPrendas,null);
        //Rst variables de control
        slotsVacios = 10;
        pesoPrendas = 0;
        //log
        System.out.println("Hemos vaciado la lavadora");
    }

    public boolean meterPrendas(Ropa[] mPrendas){
        if(mPrendas.length <= slotsVacios){
            if(getPesoEnt(mPrendas) <= PESOMAX-pesoPrendas){
                //Copiamos Array
                System.arraycopy(mPrendas,0,misPrendas,PRENDASMAX-slotsVacios,mPrendas.length);
                //Actualizamos datos de control
                slotsVacios -= mPrendas.length;
                pesoPrendas += getPesoEnt(mPrendas);
                //Imprimimos logs
                System.out.println("Todas las Prendas metidas");
                System.out.printf("El peso de las prendas es: %d \nEl numero de prendas es %d\n",pesoPrendas,PRENDASMAX-slotsVacios);
                return true;
            } else{
                System.out.println("Error, Las prendas que se introducen pesan demasiado");
                return false;
            }

        }else{
            System.out.println("Error, el array contiene demasiadas Prendas");
            return false;
        }
    }

    private int getPesoEnt (Ropa[] mPrendas){
        int mPrendasPeso = 0;
        for(Ropa entP : mPrendas){
            mPrendasPeso += entP.getPeso();
        }
        return mPrendasPeso;
    }

    public static void main(String[] args) {
        Ropa camisa = new Ropa("camisa",150,Color.ROJO);
        Ropa pantalon = new Ropa("pantalón",300,Color.ROJO);
        Ropa blusa = new Ropa("blusa",50,Color.BLANCO);
        Ropa blusa_azul = new Ropa("blusa",200,Color.AZUL);
        Ropa blusa_roja = new Ropa("blusa",450,Color.ROJO);
        Ropa blusa_amarilla = new Ropa("blusa",450,Color.AMARILLO);
        System.out.println(camisa.toString());
        System.out.println(pantalon.toString());
        System.out.println(blusa.toString());
        LavadoraV2 lavadora2 = new LavadoraV2();
        //Array Correcto 1
        Ropa[] miColada1 = {camisa,pantalon,blusa,blusa,blusa,blusa,camisa};
        lavadora2.meterPrendas(miColada1);
        //Array Correcto 2
        Ropa[] miColada2 = {blusa,blusa,blusa};
        lavadora2.meterPrendas(miColada2);
        lavadora2.lavar();
        lavadora2.vaciarLavadora();
        //Segundo Llenado
        lavadora2.meterPrendas(miColada2);
        lavadora2.lavar();
        lavadora2.vaciarLavadora();
        //Array Exceso de Elementos
        Ropa[] miColadaConDemasiadosElementos = {camisa,pantalon,blusa,blusa,blusa,blusa,camisa,blusa,blusa,blusa,blusa,blusa};
        lavadora2.meterPrendas(miColadaConDemasiadosElementos);
        //Array con exceso de peso
        Ropa[] miColadaConExcesoDePeso = {camisa,pantalon,blusa,blusa_azul,blusa_roja,blusa_amarilla};
        lavadora2.meterPrendas(miColadaConExcesoDePeso);


    }


}
