import greenfoot.*;  

/**
 * Representa una zona verde que el jugador debe alcanzar para completar el nivel.
 */
public class zonaVerde extends Actor {

    private static final int ANCHO = 70;
    private static final int ALTO = 10;
    private static final int MARGEN_POS = 20; // tolerancia para considerar que el auto está dentro

    public zonaVerde() {
        // Crear un rectángulo verde semi-transparente
        GreenfootImage imagen = new GreenfootImage(ANCHO, ALTO);
        imagen.setColor(new Color(0, 255, 0, 100)); // verde con transparencia
        imagen.fillRect(0, 0, ANCHO, ALTO);
        setImage(imagen);
    }

    public void act() {
        Actor auto = getOneIntersectingObject(autoJugador.class);
        if (auto != null && dentroDeZona(auto)) {
            // Auto dentro de la zona: mostrar victoria y pasar al siguiente nivel
            World mundo = getWorld();
            Greenfoot.playSound("victoria.mp3");
            mundo.showText("¡Nivel completado!", mundo.getWidth()/2, mundo.getHeight()/2);
            Greenfoot.delay(280);
            Greenfoot.setWorld(new Nivel2());
        }
    }

    /**
     * Comprueba si el centro del auto está dentro de la zona considerando un margen.
     */
    private boolean dentroDeZona(Actor auto) {
        int zx = getX();
        int zy = getY();
        int ax = auto.getX();
        int ay = auto.getY();

        return Math.abs(ax - zx) <= MARGEN_POS && Math.abs(ay - zy) <= MARGEN_POS;
    }
}





