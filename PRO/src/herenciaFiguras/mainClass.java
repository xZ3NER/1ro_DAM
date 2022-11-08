package herenciaFiguras;

public class mainClass {
    public static void main(String[] args) {
        figuras circle = new circle(3.5F); //creación de un objeto que hereda de figuras
        imprimir(circle.getName());
        imprimir(String.valueOf(circle.area()));
        imprimir(circle.perimetro()+"\n");

        figuras square = new square(2);
        imprimir(square.getName());
        imprimir(String.valueOf(square.area()));
        imprimir(square.perimetro()+"\n");

        figuras triangulo = new triangle(2,3);
        imprimir(triangulo.getName());
        imprimir(String.valueOf(triangulo.area()));
        imprimir(triangulo.perimetro()+"\n");
    }
    //Para verificar, por ejemplo en una lista, si el objeto es un cuadrado y no un círculo, ponemos if(forma instanceof circle)

    public static void imprimir(String texto) {
        System.out.println(texto);
    }
}
