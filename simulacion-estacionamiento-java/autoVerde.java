import greenfoot.*;  

/**
 * Auto verde que puede estar estático o moverse automáticamente en vertical dentro de límites.
 */
public class autoVerde extends Actor {

    private static final int VELOCIDAD = 5;  // velocidad fija de movimiento
    private boolean movimientoAutomatico;    // define si el auto se mueve
    private boolean moviendoAbajo = true;    // controla la dirección vertical

    // Límites verticales del movimiento
    private int limiteSuperior = 140;
    private int limiteInferior = 620;

    /**
     * Constructor por defecto (auto estático, nivel 1).
     */
    public autoVerde() {
        this(false);
    }

    /**
     * Constructor que permite decidir si el auto se mueve automáticamente.
     * @param movimientoAutomatico true si debe moverse, false si queda estático
     */
    public autoVerde(boolean movimientoAutomatico) {
        this.movimientoAutomatico = movimientoAutomatico;

        // Escalar la imagen del auto
        GreenfootImage imagen = getImage();
        imagen.scale(110, 46);
        setImage(imagen);
    }

    public void act() {
        if (movimientoAutomatico) {
            moverVerticalmente();
        }
    }

    /**
     * Mueve el auto hacia arriba o abajo dentro de los límites definidos.
     */
    private void moverVerticalmente() {
        // Cambiar dirección si toca límites
        if (getY() <= limiteSuperior) moviendoAbajo = true;
        if (getY() >= limiteInferior) moviendoAbajo = false;

        // Mover según la dirección
        setLocation(getX(), getY() + (moviendoAbajo ? VELOCIDAD : -VELOCIDAD));
    }

    /** Permite ajustar los límites en tiempo de ejecución si se desea */
    public void setLimites(int superior, int inferior) {
        this.limiteSuperior = superior;
        this.limiteInferior = inferior;
    }
}
