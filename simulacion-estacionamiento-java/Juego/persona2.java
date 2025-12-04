import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class persona2 extends Actor
{
    private int velocidad = 4;
    private int direccion = -1; // -1 = arriba, 1 = abajo

    // Límites verticales (ajustar según el área permitida)
    private int limiteSuperior = 90;
    private int limiteInferior = 570;

    public persona2()
    {
        GreenfootImage img = getImage();
        img.scale(40, 40);
        setImage(img);
    }

    public void act()
    {
        // Cambiar dirección si llega a los límites
        if (getY() <= limiteSuperior) direccion = 1;
        if (getY() >= limiteInferior) direccion = -1;

        // Mover según la dirección
        setLocation(getX(), getY() + velocidad * direccion);
    }
}

