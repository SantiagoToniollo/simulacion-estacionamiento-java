import greenfoot.*;  

/**
 * Auto verde que puede estar estático o moverse automáticamente en vertical.
 */
public class CopyOfautoVerde extends Actor {

    private static final int VELOCIDAD = 5;  // velocidad fija de movimiento
    private boolean movimientoAutomatico;    // define si el auto se mueve
    private boolean moviendoAbajo = true;    // controla la dirección vertical

    /**
     * Constructor por defecto (auto estático, nivel 1).
     */
    public CopyOfautoVerde() {
        this(false);
    }

    /**
     * Constructor que permite decidir si el auto se mueve automáticamente.
     * @param movimientoAutomatico true si debe moverse, false si queda estático
     */
    public CopyOfautoVerde(boolean movimientoAutomatico) {
        this.movimientoAutomatico = movimientoAutomatico;

        // Escalar la imagen del auto
        GreenfootImage imagen = getImage();
        imagen.scale(110, 46);
        setImage(imagen);
    }

    /**
     * Método principal: ejecuta acciones del auto en cada ciclo.
     */
    public void act() {
        if (movimientoAutomatico) {
            moverVerticalmente();
        }
    }

    /**
     * Mueve el auto hacia arriba y abajo dentro de los límites del mundo.
     */
    private void moverVerticalmente() {
        if (moviendoAbajo) {
            setLocation(getX(), getY() + VELOCIDAD); 
            if (getY() >= getWorld().getHeight() - 50) {
                moviendoAbajo = false; // cambia dirección hacia arriba
            }
        } else {
            setLocation(getX(), getY() - VELOCIDAD); 
            if (getY() <= 50) {
                moviendoAbajo = true; // cambia dirección hacia abajo
            }
        }
    }
}
