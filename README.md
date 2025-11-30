**_Inicializar la aplicación_**
1. Para ejecutar correctamente la aplicación, es recomendable utilizar Java 21 o superior para evitar posibles errores. También se debe crear una base de datos igual a la presentada en el punto anterior, con el nombre “colegio”. En caso contrario, puedes usar el script incluido en el proyecto, dentro del paquete “database”, y ejecutarlo mediante MySQL Workbench. 

2. La tabla “administradores” requiere al menos un registro para poder iniciar sesión. Por motivos académicos, el script ya incluye la inserción de un usuario “ADMIN”, por lo que no necesitarás agregarlo manualmente. 

3. Es recomendable utilizar la aplicación “XAMPP” para crear un servidor local o algún otro servicio que permita iniciar un servidor, local o remoto. De lo contrario, no se podrá realizar lo siguiente. 

4. Después de eso, se deben configurar los parámetros URL, USER y PASS en la clase ConexionMySQL del paquete dao. El driver de conexión ya está incluido en el proyecto, así que no es necesario descargar nada adicional. Con esto listo, puedes generar el archivo .jar usando la opción Clean and Build del IDE. Por defecto, el .jar se encontrará en la carpeta del proyecto, dentro del directorio “target”. Dentro de ese directorio se generarán dos .jar: uno sin dependencias y otro con todas las dependencias. Para que la aplicación funcione correctamente, debes ejecutar el que incluye las dependencias. 

5. Antes de ejecutar el .jar es necesario iniciar el servidor local, para poder acceder a la base de datos. 
