# 🚗 Simulador de Estacionamiento UTN

Un videojuego de simulación de conducción desarrollado en **Java** utilizando el framework **Greenfoot**. El objetivo es replicar la experiencia de estacionar en el predio de la facultad, respetando normas de tránsito y físicas de movimiento realistas.

[![Video Demo](https://img.youtube.com/vi/LoZLyLm-hOM/0.jpg)](https://youtu.be/LoZLyLm-hOM)
**▶️ [Ver video demostrativo completo](https://youtu.be/LoZLyLm-hOM)**

---

## 📋 Descripción del Juego

El jugador controla un vehículo que debe navegar por el estacionamiento de la universidad. La misión es encontrar la **Zona Verde** y estacionar el auto correctamente antes de que se acabe el tiempo, evitando obstáculos estáticos y dinámicos.

El juego cuenta con un sistema de **física dinámica** que simula la inercia y el giro de un auto real, alejándose del movimiento arcade simple para ofrecer un desafío de precisión.

---
---

## ✨ Características Principales

### 🎮 Sistema de Juego
* **Sistema de Niveles:** Progresión de dificultad. Al completar el Nivel 1, el jugador avanza automáticamente a un escenario más complejo.
* **Física Realista:** El auto del jugador tiene aceleración, frenado y radio de giro, lo que obliga a maniobrar con cuidado.
* **Contador de Tiempo:** Límite de tiempo para completar el objetivo, visible en pantalla.
* **Ciclo de Juego:** Pantalla de Inicio → Gameplay → Game Over → Reinicio Automático.

### 🚶 Entorno Vivo (NPCs)
* **Peatones:** Personas con rutas predefinidas que cruzan el estacionamiento.
* **Autos:** Vehículos en movimiento y otros estacionados que funcionan como obstáculos.
* **Comportamiento Dinámico:** Los NPCs se mueven de forma autónoma, creando desafíos impredecibles.

### 🎯 Zona de Estacionamiento
* **Zona Verde Visual:** Área claramente marcada donde el jugador debe estacionar.
* **Validación de Alineación:** El juego verifica que el auto esté correctamente posicionado.

---

## 🎮 Reglas y Mecánicas

### ✅ Cómo Ganar

El jugador debe llevar el auto hasta la **Zona Verde** designada.

**Condición de Victoria:**
- El auto debe quedar **perfectamente alineado** (no puede estar cruzado)
- El vehículo debe estar **totalmente dentro de la zona verde**
- Se debe completar antes de que el tiempo llegue a cero

### ❌ Cómo Perder (Game Over)

El juego termina inmediatamente y se reinicia si ocurre **cualquiera** de estas situaciones:

1. ⚠️ **Colisión con Objetos:** Chocar contra otro auto (estacionado o en movimiento)
2. 🚶 **Atropellar Peatones:** Chocar contra una persona
3. ⏱️ **Tiempo Agotado:** El contador llega a cero antes de estacionar
4. 🌱 **Infracción de Terreno:** Tocar o transitar por el césped/pasto

---

## 🕹️ Controles

### Iniciar Juego
* **Cualquier Tecla:** Iniciar el juego desde la portada

### Movimiento del Vehículo
* ⬆️ **Flecha Arriba (o W):** Acelerar hacia adelante
* ⬇️ **Flecha Abajo (o S):** Frenar / Reversa
* ⬅️ **Flecha Izquierda (o A):** Girar el volante a la izquierda
* ➡️ **Flecha Derecha (o D):** Girar el volante a la derecha

**Nota:** El sistema de física simula inercia, por lo que el auto no frena instantáneamente.

---

## 🛠️ Tecnologías y Conceptos Aplicados

### Stack Técnico
* **Lenguaje:** Java
* **Framework:** Greenfoot
* **Paradigma:** Programación Orientada a Objetos (POO)

### Conceptos de POO Implementados

#### 1️⃣ **Herencia y Polimorfismo**
```java
// Uso de la clase base Actor de Greenfoot
public class AutoJugador extends Actor {
    // Implementación específica para el auto del jugador
}

public class Obstaculo extends Actor {
    // Comportamiento común para obstáculos
}

public class Persona extends Actor {
    // Lógica de movimiento para peatones
}
```

#### 2️⃣ **Manejo de Colisiones**
```java
// Detección de intersecciones entre objetos
if (isTouching(Obstaculo.class)) {
    // Lógica de Game Over por colisión
}

Actor peatonColisionado = getOneIntersectingObject(Persona.class);
if (peatonColisionado != null) {
    // Game Over por atropello
}
```

#### 3️⃣ **Lógica de Estados**
- Control del flujo del juego: Portada → Nivel 1 → Nivel 2 → Reset
- Gestión de estados del auto (acelerando, frenando, girando)
- Validación de condiciones de victoria/derrota

#### 4️⃣ **Algoritmos de Movimiento**
- **NPCs:** Rutas predefinidas con patrones de movimiento
- **Física del jugador:** Sistema de inercia y fricción
- **Radio de giro realista:** Cálculos trigonométricos para simular dirección

---

## 🚀 Cómo Ejecutar el Proyecto

### Requisitos Previos
1. **Greenfoot** instalado → [Descargar aquí](https://www.greenfoot.org/download)
2. **Java JDK 11+** (usualmente incluido con Greenfoot)

### Pasos de Instalación

#### Opción 1: Clonar desde GitHub
```bash
# 1. Clonar el repositorio
git clone https://github.com/SantiagoToniollo/simulacion-estacionamiento-java.git

# 2. Navegar a la carpeta
cd simulacion-estacionamiento-java

# 3. Abrir con Greenfoot
# Hacer doble clic en el archivo project.greenfoot
```

#### Opción 2: Descargar ZIP
1. Click en el botón verde **"Code"** → **"Download ZIP"**
2. Extraer el archivo ZIP
3. Abrir la carpeta extraída
4. Hacer doble clic en `project.greenfoot`

### Ejecutar el Juego
1. Una vez abierto en Greenfoot, presionar el botón **"Run"** (parte superior)
2. Presionar **cualquier tecla** para comenzar desde la pantalla de inicio
3. Usar las flechas del teclado para controlar el vehículo

---

## 📊 Arquitectura del Proyecto

### Estructura de Clases

```
Actor (Greenfoot base)
├── AutoJugador
│   ├── Física de movimiento
│   ├── Detección de colisiones
│   └── Control de entrada (teclado)
├── Obstaculo
│   ├── AutoEstacionado
│   └── AutoMovimiento (NPC)
├── Persona (Peatones NPC)
│   └── Algoritmo de rutas predefinidas
├── ZonaVerde
│   └── Validación de estacionamiento correcto
└── Mundo
    ├── EstacionamientoNivel1
    ├── EstacionamientoNivel2
    ├── PantallaInicio
    └── PantallaGameOver
```

### Flujo de Ejecución

```
1. PantallaInicio
   ↓ (Presionar cualquier tecla)
2. EstacionamientoNivel1
   ↓ (Completar objetivo)
3. EstacionamientoNivel2
   ↓ (Completar objetivo o Game Over)
4. PantallaGameOver
   ↓ (Reinicio automático después de 3 segundos)
5. Vuelve a PantallaInicio
```

---

## 🎓 Aprendizajes y Desafíos

### Desafíos Técnicos Resueltos

1. **Física Realista de Conducción:**
   - Implementación de inercia y fricción
   - Cálculo de vectores de dirección basados en rotación
   - Balance entre realismo y jugabilidad

2. **Sistema de Colisiones Preciso:**
   - Detección en tiempo real sin afectar el framerate
   - Diferenciación entre tipos de colisión (obstáculo vs peatón)

3. **Lógica de NPCs:**
   - Algoritmos de pathfinding básico para peatones
   - Movimiento fluido de autos NPC sin trabarse

4. **Validación de Estacionamiento:**
   - Cálculo de alineación del vehículo
   - Verificación de posición dentro de zona verde

---

## 🔮 Posibles Mejoras Futuras

- [ ] Sistema de puntuación basado en precisión y tiempo
- [ ] Más niveles con diferentes layouts de estacionamiento
- [ ] Power-ups (ej: tiempo extra, radar de obstáculos)
- [ ] Modo multijugador (dos jugadores compitiendo)
- [ ] Efectos de sonido y música de fondo
- [ ] Tabla de récords (highscores)
- [ ] Tutorial interactivo para nuevos jugadores

---

## 👨‍💻 Autor

**Santiago Toniollo**  
*Estudiante de Ingeniería en Sistemas - UTN FRVM*

📧 toniollosantiago@gmail.com  
🐙 [GitHub](https://github.com/SantiagoToniollo)

---

## 📝 Notas Académicas

Proyecto desarrollado como parte de la materia **Paradigmas de Programación** en la Universidad Tecnológica Nacional, Facultad Regional Villa María.

### Conceptos Evaluados
- ✅ Programación Orientada a Objetos (Herencia, Polimorfismo)
- ✅ Manejo de eventos y detección de colisiones
- ✅ Algoritmos de movimiento y física básica
- ✅ Lógica de estados y flujo de juego
- ✅ Uso de framework Greenfoot

---

## 📹 Video Demostrativo

**▶️ [Ver gameplay completo en YouTube](https://youtu.be/LoZLyLm-hOM)**

El video muestra:
- Pantalla de inicio
- Jugabilidad del Nivel 1
- Sistema de física y controles
- Interacción con NPCs (peatones y autos)
- Condiciones de Game Over
- Progresión al Nivel 2

---

⭐ Si te gustó el proyecto, no olvides darle una estrella en GitHub!

