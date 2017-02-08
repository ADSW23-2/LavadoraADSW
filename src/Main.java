public class Main {

    public static void main(String[] args) {
        LavadoraV1 lavadora1 = new LavadoraV1();
        lavadora1.lavar();
        lavadora1.lavar();
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
