public class PesoExcedidoException extends Exception {
    public PesoExcedidoException(int peso,int pesoMax){
        System.out.printf("El peso es: %d cuando el peso max es: %d",peso,pesoMax);
    }
}
