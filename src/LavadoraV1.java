
public class LavadoraV1 {

    private int numeroLavados;

    public LavadoraV1(){
        numeroLavados = 0;
    }
    public void lavar(){
        System.out.printf("Lavando...\n");
        System.out.printf("El numero de lavados es %d \n",++numeroLavados);
    }

    public int getNumeroLavados() {
        return numeroLavados;
    }

    public static void main(String[] args) {
        LavadoraV1 lavadora1 = new LavadoraV1();
        lavadora1.lavar();
        lavadora1.lavar();
    }
}
