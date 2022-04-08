package Prisma;

/**
 * Clase de los objetos
 */
public class Prisma {
    private int baseTriangulo;
    private int alturaPrisma;
    private float areaTotal;

    /**
     * Constructor que define los valores iniciales de los atributos.
     * @param baseTriangulo Base del triángulo.
     * @param alturaPrisma Altura del prisma de base triangular.
     */
    public Prisma(int baseTriangulo, int alturaPrisma) {
        this.baseTriangulo=baseTriangulo;
        this.alturaPrisma=alturaPrisma;
    }

    /**
     * Getter del atributo.
     * @return Devuelve el valor del atributo.
     */
    public int getBaseTriangulo() {
        return this.baseTriangulo;
    }

    /**
     * Setter del atributo.
     * @param baseTriangulo Nuevo valor del atributo.
     */
    public void setBaseTriangulo(int baseTriangulo) {
        this.baseTriangulo = baseTriangulo;
    }

    /**
     * Getter del atributo.
     * @return Devuelve el valor del atributo.
     */
    public int getAlturaPrisma() {
        return this.alturaPrisma;
    }

    /**
     * Setter del atributo.
     * @param alturaPrisma Nuevo valor del atributo.
     */
    public void setAlturaPrisma(int alturaPrisma) {
        this.alturaPrisma = alturaPrisma;
    }

    /**
     * Getter del atributo.
     * @return Devuelve el valor del atributo.
     */
    public float getAreaTotal() {
        return this.areaTotal;
    }

    /**
     * Calcula la altura de un triángulo.
     * @return Devuelve dicha altura.
     */
    public float alturaTriangulo() {
        return (float) (Math.sqrt(3)/2*this.baseTriangulo);
    }

    /**
     * Calcula el área de la base triangular del prisma
     * @param alturaTriangulo Altura que tiene el triángulo.
     * @return Devuelve el área calculado.
     */
    public float areaBase(float alturaTriangulo) {
        return (this.baseTriangulo*alturaTriangulo)/2;
    }

    /**
     * Calcula el perímetro de la base del prisma triangular
     * @return Devuelve dicho perímetro
     */
    public float perimetro() {
        return 3*this.baseTriangulo;
    }

    /**
     * Calcula el área lateral del prisma
     * @param perimetro Perimetro del prisma
     * @return Devuelve dicha área
     */
    public float areaLateral(float perimetro) {
        return perimetro*this.alturaPrisma;
    }

    /**
     * Calcula el área total del prisma triangular y lo almacena en el atributo correspondiente
     * @return Devuelve dicha área total
     */
    public float areaTotal() {
        float areaBase = areaBase(alturaTriangulo());
        float areaLateral = areaLateral(perimetro());
        this.areaTotal = 2*areaBase+areaLateral;

        return this.areaTotal;
    }
}

