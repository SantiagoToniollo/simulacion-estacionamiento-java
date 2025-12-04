import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Nivel 2 - Dificultad mayor al nivel 1.
 * Contiene autos en movimiento y peatones.
 */
public class Nivel2 extends World {

    private int tiempo = 20 * 60; // ~20 segundos

    public Nivel2() {
        super(850, 691, 1);
        prepare();
    }

    public void act() {
        tiempo--;
        showText("Tiempo: " + tiempo / 60, 70, 20);

        if (tiempo <= 0) {
            Greenfoot.playSound("derrota.mp3");
            showCenteredMessage("¡Se acabó el tiempo!");
            Greenfoot.stop();
        }
    }

    /**
     * Muestra un mensaje centrado en pantalla.
     */
    private void showCenteredMessage(String message) {
        showText(message, getWidth() / 2, getHeight() / 2);
    }

    /**
     * Prepara los objetos iniciales del nivel.
     */
    private void prepare() {
        addJugador();
        addMeta();
        addAutos();
        addPeatones();
    }

    /**
     * Crea y coloca al jugador.
     */
    private void addJugador() {
        autoJugador jugador = new autoJugador();
        addObject(jugador, 100, 667);
        jugador.setRotation(270);
    }

    /**
     * Crea la zona verde de victoria.
     */
    private void addMeta() {
        zonaVerde meta = new zonaVerde();
        addObject(meta, 327, 40);
        meta.setRotation(90);
    }

    /**
     * Crea los autos del nivel.
     */
    private void addAutos() {
        // Auto amarillo fijo
        autoAmarillo autoAmarillo = new autoAmarillo();
        addObject(autoAmarillo, 330, 384);

        // Otro auto amarillo
        autoAmarillo autoAmarillo2 = new autoAmarillo();
        addObject(autoAmarillo2, 740, 556);

        // Auto rojo
        autoRojo autoRojo = new autoRojo();
        addObject(autoRojo, 380, 230);
        autoRojo.setRotation(270);

        // Copia de auto rojo
        CopyOfautoRojo autoRojo2 = new CopyOfautoRojo();
        addObject(autoRojo2, 789, 199);

        // Auto verde que se mueve automáticamente
        autoVerde autoVerde = new autoVerde(true);
        addObject(autoVerde, 30, 142);
        autoVerde.setRotation(90);

        // Otro auto verde
        CopyOfautoVerde autoVerde2 = new CopyOfautoVerde();
        addObject(autoVerde2, 538, 391);
        autoVerde2.setRotation(270);
    }

    /**
     * Crea los peatones.
     */
    private void addPeatones() {
        persona1 p1 = new persona1();
        addObject(p1, 762, 126);
        p1.setRotation(270);

        persona2 p2 = new persona2();
        addObject(p2, 240, 543);
    }
}
