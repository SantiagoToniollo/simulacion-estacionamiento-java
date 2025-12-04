\# 🚗 Simulador de Estacionamiento UTN



Un videojuego de simulación de conducción desarrollado en \*\*Java\*\* utilizando el framework \*\*Greenfoot\*\*. El objetivo es replicar la experiencia de estacionar en el predio de la facultad, respetando normas de tránsito y físicas de movimiento realistas.



\## 📋 Descripción del Juego

El jugador controla un vehículo que debe navegar por el estacionamiento de la universidad. La misión es encontrar la \*\*Zona Verde\*\* y estacionar el auto correctamente antes de que se acabe el tiempo, evitando obstáculos estáticos y dinámicos.



El juego cuenta con un sistema de \*\*física dinámica\*\* que simula la inercia y el giro de un auto real, alejándose del movimiento arcade simple para ofrecer un desafío de precisión.



\## ✨ Características Principales



\* \*\*Sistema de Niveles:\*\* Progresión de dificultad. Al completar el Nivel 1, el jugador avanza automáticamente a un escenario más complejo.

\* \*\*Física Realista:\*\* El auto del jugador tiene aceleración, frenado y radio de giro, lo que obliga a maniobrar con cuidado.

\* \*\*Entorno Vivo (NPCs):\*\*

&nbsp;   \* \*\*Peatones:\*\* Personas con rutas predefinidas que cruzan el estacionamiento.

&nbsp;   \* \*\*Autos:\*\* Vehículos en movimiento y otros estacionados que funcionan como obstáculos.

\* \*\*Ciclo de Juego:\*\* Pantalla de Inicio, Gameplay, Pantalla de "Game Over" y Reinicio Automático.



\## 🎮 Reglas y Mecánicas



\### ✅ Cómo Ganar

El jugador debe llevar el auto hasta la \*\*Zona Verde\*\* designada.

\* \*\*Condición de Victoria:\*\* El auto debe quedar \*\*perfectamente alineado\*\* (no puede estar cruzado) y totalmente dentro de la zona.



\### ❌ Cómo Perder (Game Over)

El juego termina inmediatamente y se reinicia si ocurre cualquiera de estas 3 situaciones:

1\.  \*\*Colisión con Objetos:\*\* Chocar contra otro auto (estacionado o en movimiento).

2\.  \*\*Atropellar Peatones:\*\* Chocar contra una persona.

3\.  \*\*Tiempo Agotado:\*\* El contador llega a cero antes de estacionar.

4\.  \*\*Infracción de Terreno:\*\* Tocar o transitar por el césped/pasto.



\## 🕹️ Controles

\* \*\*Cualquier Tecla:\*\* Iniciar el juego desde la portada.

\* \*\*Flechas del Teclado (o WASD):\*\*

&nbsp;   \* ⬆️ \*\*Arriba:\*\* Acelerar.

&nbsp;   \* ⬇️ \*\*Abajo:\*\* Frenar / Reversa.

&nbsp;   \* ⬅️ ➡️ \*\*Izquierda/Derecha:\*\* Girar el volante.



\## 🛠️ Conceptos Técnicos Aplicados (Java/POO)



Este proyecto demuestra la implementación práctica de:

\* \*\*Herencia y Polimorfismo:\*\* Uso de la clase base `Actor` de Greenfoot para crear subclases específicas (`AutoJugador`, `Obstaculo`, `Persona`) con comportamientos únicos.

\* \*\*Manejo de Colisiones:\*\* Algoritmos para detectar intersecciones entre objetos (`isTouching`, `getOneIntersectingObject`).

\* \*\*Lógica de Estados:\*\* Control del flujo del juego (Portada -> Nivel 1 -> Nivel 2 -> Reset).

\* \*\*Algoritmos de Movimiento:\*\* Lógica predefinida para los NPCs y física de inercia para el jugador.



\## 🚀 Cómo Ejecutar el Proyecto

1\.  Asegúrate de tener instalado \[Greenfoot](https://www.greenfoot.org/download).

2\.  Clona este repositorio o descarga el código.

3\.  Abre el archivo `project.greenfoot`.

4\.  Presiona el botón \*\*Run\*\* en la interfaz.



---

\*\*Autor:\*\* Santiago Toniollo

\*Estudiante de Ingeniería en Sistemas - UTN FRVM\*

