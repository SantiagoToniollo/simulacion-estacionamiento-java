import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class persona1 extends Actor
{
    private int velocidad = 4;
    private int direccion = -1; // -1 = izquierda, 1 = derecha

    // Límites de movimiento (ajustar según la "calle")
    private int limiteIzquierdo = 200;
    private int limiteDerecho = 780;

    public persona1()
    {
        GreenfootImage img = getImage();
        img.scale(40, 40);
        setImage(img);
    }

    public void act()
    {
        // Cambiar dirección si llega a los límites
        if (getX() <= limiteIzquierdo) direccion = 1;
        if (getX() >= limiteDerecho) direccion = -1;

        // Mover según la dirección
        setLocation(getX() + velocidad * direccion, getY());
    }
}


