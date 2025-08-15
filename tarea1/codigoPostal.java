package tarea1;

/* 

Martínez Ruiz Josué Ignacio

Registro de tiempo:
Investigación de recursos para resolver el problema: 90 min
Codificación: 150 min
Documentación: 25 min
Pruebas: 20 min
Total: 285 min = 4.75 hrs

Reflexión:

Sin duda que fue un reto, primero me surgió la duda de cómo leer un archivo CSV y poder separar los datos,
ya que personalmente desconocía de la estructura de datos HashMap y su funcionamiento, lo que me obligó a 
investigar y entender esta estructura, una vez comprendida, el siguiente paso era implementarla y manipularla.
Al momento de codificar, tuve que buscar muchas sintaxis y métodos que me permitieran lo que buscaba hacer, 
pero de poco a poco fui entendiendo cosas nuevas. 
  
  
*/

//Importamos las librerías necesarias para la lectura del archivo y la creación del HashMap
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class codigoPostal {
    public static void main(String[] args) {

        //Ruta del archivo que queremos leer
        String ruta = "codigos_postales_hmo.csv"; 

        //Usaremos un HashMap para almacenar los datos que nos interesan
        //El HashMap se compone de una Key y un Value, en este caso ambos son String 
        HashMap<String, Integer> codigosRepeticiones = new HashMap<>();

        //Usamos BufferedReader para acceder y leer el archivo deseado
        try (BufferedReader lectura = new BufferedReader(new FileReader(ruta))) {

            //Guardar el registro completo (renglón), para posteriormente separarlo y guardarlo en el HashMap
            String registro;

            //Este while recorre todo el archivo csv, mientras el registro sea diferente de null (vacío)
            while ((registro = lectura.readLine()) != null) {

                //El arreglo guarda en columnas distintas los datos separados de cada registro, los datos están separados por una coma ","
                String[] datos = registro.split(",", 2);

                //Obtiene el código postal de cada registro, ya que el datos[0] contiene el código postal, el .trim() es para eliminar espacios en blanco
                String codigos = datos[0].trim();


                // Verifica si el código postal ya existe en el HashMap
                if (codigosRepeticiones.containsKey(codigos)) {
                    // Si existe, incrementa el valor de repeticiones
                    codigosRepeticiones.put(codigos, codigosRepeticiones.get(codigos) + 1);
                } else {
                    // Si no existe, lo agrega con valor 1
                    codigosRepeticiones.put(codigos, 1);
                }

                

            }

            // Imprime todos los códigos postales y su número de colonias (repeticiones)
                codigosRepeticiones.forEach((key, value) -> {
                    System.out.println("Código Postal: " + key + " -> Número de colonias: " + value);
                });

        } catch (Exception e) {
            // Si ocurre un error al leer el archivo, se imprime un mensaje de error
            System.out.println("Error al leer los datos.");
        }

    }
}
