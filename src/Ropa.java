/**
 * Created by jcala on 08/02/2017.
 */
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
}
