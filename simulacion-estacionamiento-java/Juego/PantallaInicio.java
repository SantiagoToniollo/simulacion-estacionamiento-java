import greenfoot.*;  

public class PantallaInicio extends World {

    public PantallaInicio() {    
        super(850, 691, 1);
        configurarPantallaInicio();
    }

    /**
     * Configura la pantalla de inicio:
     * - Escala la imagen al tamaño de la ventana manteniendo proporción.
     * - Pinta el fondo negro y centra la imagen escalada.
     * - Muestra el mensaje para iniciar.
     */
    private void configurarPantallaInicio() {
        GreenfootImage imagenFondo = new GreenfootImage("pantallaInicio.png");

        // Calcular escala proporcional
        double escalaAncho = (double) getWidth() / imagenFondo.getWidth();
        double escalaAlto  = (double) getHeight() / imagenFondo.getHeight();
        double escala = Math.min(escalaAncho, escalaAlto);

        int nuevoAncho = (int) (imagenFondo.getWidth() * escala);
        int nuevoAlto  = (int) (imagenFondo.getHeight() * escala);

        imagenFondo.scale(nuevoAncho, nuevoAlto);

        // Crear fondo negro y centrar la imagen escalada
        GreenfootImage fondo = new GreenfootImage(getWidth(), getHeight());
        fondo.setColor(Color.BLACK);
        fondo.fill();
        fondo.drawImage(imagenFondo, (getWidth() - nuevoAncho) / 2, (getHeight() - nuevoAlto) / 2);

        setBackground(fondo);

        // Texto de inicio
        showText("Presiona ENTER para iniciar", getWidth() / 2, getHeight() - 50);
    }

    /**
     * Detecta si el jugador presiona ENTER para comenzar el juego.
     */
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}



