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


}
