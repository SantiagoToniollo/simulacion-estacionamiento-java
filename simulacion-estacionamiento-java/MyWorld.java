import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mundo principal (Nivel 1).
 * Controla el inicio del juego, el temporizador y los objetos del nivel.
 */
public class MyWorld extends World {

    // Estado del juego
    private static boolean reinicio = false;
    private boolean juegoIniciado = false;

    // Fondos
    private GreenfootImage fondoInicio;
    private GreenfootImage fondoJuego;

    // Tiempo (30 segundos aprox.)
    private int tiempo = 30 * 60;

    // Fuente para los textos
    private final Font fuenteNegrita = new Font("Arial", true, false, 24);

    public MyWorld() {    
        super(850, 691, 1); 

        if (!reinicio) {
            mostrarPantallaInicio();
        } else {
            iniciarJuego();
            reinicio = false;
        }
        prepare();
    }

    public void act() {
        if (!juegoIniciado) {
            mostrarMensajeInicio();
            if (Greenfoot.isKeyDown("enter")) {
                iniciarJuego();
            }
        } else {
            actualizarJuego();
        }
    }

    /**
     * Configura la pantalla de inicio con la imagen de presentación.
     */
    private void mostrarPantallaInicio() {
        fondoInicio = new GreenfootImage("pantallaInicio.png");
        setBackground(fondoInicio);
    }

    /**
     * Inicia el juego mostrando el fondo y agregando los objetos.
     */
    private void iniciarJuego() {
        juegoIniciado = true;
        fondoJuego = new GreenfootImage("fondoJuego.jpg");
        setBackground(fondoJuego);
        prepararNivel1();
    }

    /**
     * Lógica que se ejecuta cada ciclo de juego.
     */
    private void actualizarJuego() {
        // Restaurar fondo para limpiar el contador
        setBackground(fondoJuego);

        // Actualizar tiempo
        tiempo--;
        showText("Tiempo: " + tiempo / 60, 70, 20);

        // Si se acaba el tiempo
        if (tiempo <= 0) {
            Greenfoot.playSound("derrota.mp3");
            showText("¡Se acabó el tiempo!", getWidth() / 2, getHeight() / 2);
            reiniciarNivel1();
        }
    }

    /**
     * Prepara todos los objetos del nivel 1 (autos, personas, zona de victoria).
     */
    private void prepararNivel1() {
        setBackground("fondoJuego.jpg");

        // --- Autos y personas ---
        autoRojo autoRojo = new autoRojo();
        autoVerde autoVerde = new autoVerde();
        autoAmarillo autoAmarillo = new autoAmarillo();
        autoAmarillo autoAmarillo2 = new autoAmarillo();
        persona1 persona1 = new persona1();
        CopyOfautoVerde copyOfautoVerde = new CopyOfautoVerde();
        CopyOfautoRojo copyOfautoRojo = new CopyOfautoRojo();

        // --- Zona verde (meta) ---
        zonaVerde zona = new zonaVerde();
        addObject(zona, 585, 40);
        zona.setRotation(90);

        // --- Auto jugador ---
        autoJugador autoJugador = new autoJugador();
        addObject(autoJugador, 102, 656);
        autoJugador.setRotation(270);

        // --- Añadir los demás objetos ---
        addObject(autoRojo, 380, 227);
        addObject(autoVerde, 534, 372);
        addObject(autoAmarillo, 432, 565);
        addObject(persona1, 792, 127);
        addObject(copyOfautoVerde, 328, 568);
        addObject(copyOfautoRojo, 816, 97);
        addObject(autoAmarillo2, 484, 232);

        // Rotaciones iniciales
        autoVerde.setRotation(90);
        autoRojo.setRotation(270);
        copyOfautoVerde.setRotation(90);
        copyOfautoRojo.setRotation(90);
        autoAmarillo2.setRotation(180);
        persona1.setRotation(270);
    }

    /**
     * Reinicia el nivel 1.
     */
    private void reiniciarNivel1() {
        reinicio = true;
        Greenfoot.setWorld(new MyWorld());
    }

    /**
     * Dibuja un mensaje centrado en pantalla (para la pantalla de inicio).
     */
    private void mostrarMensajeInicio() {
        dibujarTextoCentrado("Presiona ENTER para comenzar", getWidth() / 2, getHeight() - 50, fuenteNegrita);
    }

    /**
     * Método auxiliar para dibujar texto en el fondo.
     */
    private void dibujarTextoCentrado(String mensaje, int x, int y, Font fuente) {
        GreenfootImage img = new GreenfootImage(mensaje, 24, Color.WHITE, new Color(0, 0, 0, 0));
        img.setFont(fuente);
        getBackground().drawImage(img, x - img.getWidth() / 2, y - img.getHeight() / 2);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
