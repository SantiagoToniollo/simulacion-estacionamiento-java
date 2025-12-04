import greenfoot.*;

/**
 * Representa al auto controlado por el jugador.
 * Puede moverse con rotación y debe permanecer en la calle o zonas válidas.
 */
public class autoJugador extends Actor {

    private static final int VELOCIDAD = 3;

    // Zonas rectangulares válidas (xMin, yMin, xMax, yMax)
    private static final int[][] ALLOWED_ZONES = {
        {0,   480, 170, 691},
        {150, 420, 810, 691},
        {150, 230, 810, 420},
        {120,  40, 810, 230},
        {760,  40, 850, 640}
    };

    private double direccion = 270; // grados iniciales (arriba)

    public autoJugador() {
        GreenfootImage img = getImage();
        img.scale(110, 46);
        setImage(img);
    }

    public void act() {
        controlarMovimiento();
        verificarChoque();
    }

    /** Controla teclas y aplica movimiento/rotación */
    private void controlarMovimiento() {
        if (Greenfoot.isKeyDown("left"))  direccion -= 3;
        if (Greenfoot.isKeyDown("right")) direccion += 3;

        double rad = Math.toRadians(direccion);
        int nx = getX();
        int ny = getY();

        if (Greenfoot.isKeyDown("w")) { // adelante
            nx += (int)Math.round(VELOCIDAD * Math.cos(rad));
            ny += (int)Math.round(VELOCIDAD * Math.sin(rad));
        }
        if (Greenfoot.isKeyDown("s")) { // atrás
            nx -= (int)Math.round(VELOCIDAD * Math.cos(rad));
            ny -= (int)Math.round(VELOCIDAD * Math.sin(rad));
        }
        if (Greenfoot.isKeyDown(".")) { // derecha lateral
            nx += (int)Math.round(VELOCIDAD * Math.cos(rad + Math.PI/2));
            ny += (int)Math.round(VELOCIDAD * Math.sin(rad + Math.PI/2));
        }
        if (Greenfoot.isKeyDown(",")) { // izquierda lateral
            nx += (int)Math.round(VELOCIDAD * Math.cos(rad - Math.PI/2));
            ny += (int)Math.round(VELOCIDAD * Math.sin(rad - Math.PI/2));
        }

        // Movimiento solo si la posición es válida
        if (poseValida(nx, ny)) {
            setLocation(nx, ny);
        }

        setRotation((int)Math.round(direccion));
    }

    /** Verifica si la posición está dentro de zonas permitidas y no es verde */
    private boolean poseValida(int x, int y) {
        World mundo = getWorld();
        if (mundo == null) return false;

        GreenfootImage fondo = mundo.getBackground();
        if (fondo == null) return false;

        // Mantener dentro de pantalla
        if (x < 0 || x >= mundo.getWidth() || y < 0 || y >= mundo.getHeight()) return false;

        // Debe estar en zona permitida
        if (!inAllowedZone(x, y)) return false;

        // No puede pasar por verde
        Color c = fondo.getColorAt(x, y);
        if (c.getGreen() > c.getRed() + 20 && c.getGreen() > c.getBlue() + 20) return false;

        return true;
    }

    /** Devuelve true si (x,y) está dentro de una zona permitida */
    private boolean inAllowedZone(int x, int y) {
        for (int[] z : ALLOWED_ZONES) {
            if (x >= z[0] && x <= z[2] && y >= z[1] && y <= z[3]) return true;
        }
        return false;
    }

    /** Verifica colisiones y reinicia el nivel si ocurre */
    private void verificarChoque() {
        if (chocoCon(autoRojo.class, "¡Perdiste! Chocaste un auto estacionado.") ||
            chocoCon(autoVerde.class, "¡Perdiste! Chocaste un auto estacionado.") ||
            chocoCon(autoAmarillo.class, "¡Perdiste! Chocaste un auto estacionado.") ||
            chocoCon(CopyOfautoRojo.class, "¡Perdiste! Chocaste un auto estacionado.") ||
            chocoCon(CopyOfautoVerde.class, "¡Perdiste! Chocaste un auto estacionado.") ||
            chocoCon(persona1.class, "¡Perdiste! Chocaste a un estudiante.") ||
            chocoCon(persona2.class, "¡Perdiste! Chocaste a un profesor.")) {
            Greenfoot.playSound("derrota.mp3");
            Greenfoot.delay(280);
            Greenfoot.setWorld(new MyWorld());
        }
    }

    /** Método auxiliar para simplificar detección de colisiones con mensaje */
    private boolean chocoCon(Class<?> clase, String mensaje) {
        if (isTouching(clase)) {
            getWorld().showText(mensaje, getWorld().getWidth()/2, getWorld().getHeight()/2);
            return true;
        }
        return false;
    }
}




