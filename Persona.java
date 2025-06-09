import java.util.ArrayList;
import java.util.Scanner;

public class Persona {
    // a) Propiedades privadas
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;

    // Método constructor
    public Persona(String nombre, String apellido, String genero, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getGenero() { return genero; }
    public int getEdad() { return edad; }

    // b) Método para capturar y retornar nombre y género de 5 personas
    public static ArrayList<Persona> capturarPersonasPorTeclado() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Persona> personas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese nombre:");
            String nombre = sc.nextLine();
            System.out.println("Ingrese apellido:");
            String apellido = sc.nextLine();
            System.out.println("Ingrese género (Masculino/Femenino):");
            String genero = sc.nextLine();
            System.out.println("Ingrese edad:");
            int edad = Integer.parseInt(sc.nextLine());
            personas.add(new Persona(nombre, apellido, genero, edad));
        }
        return personas;
    }

    public static void mostrarNombresYGeneros(ArrayList<Persona> personas) {
        System.out.println("Nombre\tGénero");
        for (Persona p : personas) {
            System.out.println(p.getNombre() + "\t" + p.getGenero());
        }
    }

    // c) Método para retornar el promedio de edades
    public static double promedioEdades(ArrayList<Persona> personas) {
        int suma = 0;
        for (Persona p : personas) {
            suma += p.getEdad();
        }
        return (double) suma / personas.size();
    }

    // d) Método para retornar cantidad de personas con género Masculino
    public static int contarMasculinos(ArrayList<Persona> personas) {
        int contador = 0;
        for (Persona p : personas) {
            if (p.getGenero().equalsIgnoreCase("Masculino")) {
                contador++;
            }
        }
        return contador;
    }

    // e) Método para retornar cantidad de personas con género Femenino
    public static int contarFemeninos(ArrayList<Persona> personas) {
        int contador = 0;
        for (Persona p : personas) {
            if (p.getGenero().equalsIgnoreCase("Femenino")) {
                contador++;
            }
        }
        return contador;
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        ArrayList<Persona> personas = capturarPersonasPorTeclado();
        mostrarNombresYGeneros(personas);
        System.out.println("Promedio de edades: " + promedioEdades(personas));
        System.out.println("Cantidad de Masculinos: " + contarMasculinos(personas));
        System.out.println("Cantidad de Femeninos: " + contarFemeninos(personas));
    }
}