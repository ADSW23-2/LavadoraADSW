public class Ropa implements Lavable{

    private String nombre;
    private int peso;
    private Color color;



    public Ropa(String nombre, int peso, Color color){
        this.nombre = nombre;
        this.peso = peso;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ropa{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                "gr, color=" + color +
                " esColor "+ isColor()+
                '}';
    }

    @Override
    public boolean isColor() {
      return !color.equals(Color.BLANCO);
    }

    @Override
    public int getPeso() {
        return peso;
    }

    public String getNombre() {
        return nombre;
    }

    public Color getColor() {
        return color;
    }
    public static void main(String[] args) {

        Ropa camisa = new Ropa("camisa",150,Color.ROJO);
        Ropa pantalon = new Ropa("pantalón",300,Color.ROJO);
        Ropa blusa = new Ropa("blusa",50,Color.BLANCO);
        System.out.println(camisa.toString());
        System.out.println(pantalon.toString());
        System.out.println(blusa.toString());

    }
}
