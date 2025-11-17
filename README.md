# **📚 Proyecto Java 2 – Gestor Biblioteca 📚**

## 📋 Descripción

Este proyecto permite gestionar libros, películas y videojuegos y usuarios de una Biblioteca, registrando su préstamo y devolución. Permite realizar operaciones de búsqueda, préstamos y devoluciones, así como importar y exportar datos en formato JSON. La interfaz principal se basa en ventanas emergentes (JOptionPane), ofreciendo una experiencia sencilla e interactiva para el usuario.

---

## 🚦 Estado del Proyecto

| Versión | Estado |
|--------:|:-------|
|     1.0 | ✅      |

---
## ⚙️ Requisitos para compilar y ejecutar

### 📁 Clonar el repositorio

```bash
# Ubícate en la carpeta donde guardarás el proyecto
git clone https://github.com/Arevaliis/GestionBiblioteca.git
cd GestionBiblioteca
```

### 💻 Ejecución desde Consola
```
1. Compilar el programa: javac src/main/java/main.Main.java
2. Ejecutar programa: java -cp src/main/java main.Main
```

### 🧠 Ejecución desde IntelliJ
```
1. Abre el proyecto
2. Ejecuta Run en main.Main.java
```
---

## 🛠️ Instrucciones de uso

Al ejecutar el archivo `main.Main.java`, se iniciará el programa. Lo primero que veremos es el menú principal:

===== MENÚ BIBLIOTECA =====
 1. Listar
   2. Buscar por titulo
   3. Buscar por año
   4. Prestar
   5. Devolver
   6. Alta Usuario
   7. Exportar Usuarios
   8. Importar Usuarios
   9. Exportar Catalogo
   10. Importar Catalogo
   0. Salir

El programa solicitará que selecciones una opción. Si ingresas un valor no numérico o fuera de rango, se mostrará un mensaje de error y deberás intentarlo nuevamente.

### ⚠️ Ejemplo: Prestar un producto ⚠️

1. Primero se mostrará una lista con todos los productos disponibles.
2. Ingresa el **ID del producto** que deseas prestar.
    - Si el ID no existe o se cancela la acción (pulsando “Cancel” o cerrando la ventana), volverás al menú principal.
3. Después, se mostrará una lista de todos los **usuarios registrados**. Ingresa el **ID del usuario** que realizará el préstamo.
    - Si el ID no existe, se ofrecerá la opción de agregar un nuevo usuario.
    - Si confirmas, solo deberás ingresar el **nombre del usuario** y el sistema asignará automáticamente un ID.
4. Una vez seleccionados producto y usuario, se registrará el préstamo y se mostrará un **mensaje de confirmación**.


---
## 👤 Autoría
* [Jose Iglesias Arévalo](https://arevaliis.github.io/Portafolio)

---
## 📄 Licencia
Este proyecto no tiene licencia.

---
## 📫 Contacto

- ✉️ [joseiglesiasarevalo@gmail.com](mailto:joseiglesiasarevalo@gmail.com)
- 💼 [LinkedIn](https://www.linkedin.com/in/jose-iglesias-ar%C3%A9valo-812860206/)
- 🐙 [GitHub](https://github.com/Arevaliis)