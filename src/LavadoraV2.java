import java.lang.reflect.Array;
import java.util.Arrays;

public class LavadoraV2 extends LavadoraV1{

    private static final int PESOMAX = 1000;
    private int slotsVacios;
    private int pesoPrendas;
    private Ropa[] misPrendas;



    public LavadoraV2(){
        super();
        misPrendas = new Ropa[10];
        slotsVacios = 10;
        pesoPrendas = 0;
        System.out.println("Lavadora Vacia");

    }

    @Override
    public void lavar() {
        super.lavar();
        Arrays.fill(misPrendas,null);
        slotsVacios = 10;
        pesoPrendas = 0;
    }

    public boolean meterPrendas(Ropa[] mPrendas){
        if(mPrendas.length <= slotsVacios()){
            if(getPesoEnt(mPrendas) <= PESOMAX-pesoPrendas){
                System.arraycopy(mPrendas,0,misPrendas,10-slotsVacios,mPrendas.length);
                System.out.println("Todas las Prendas metidas");
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

    private int getPesoPrendas(){
        int peso = 0;
        for(Ropa p: misPrendas){
            peso += p.getPeso();
        }
        return peso;
    }

    private int slotsVacios(){
        int slots = 0;
        for(Ropa p : misPrendas){
            if(p == null){
                slots++;
            }
        }
        return slots;
    }
}
