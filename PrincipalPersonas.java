import java.util.*;
import java.util.stream.*;

public class PrincipalPersonas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        String opcion;
        do {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Apellido: ");
            String apellido = sc.nextLine();
            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());
            System.out.print("Género (M/F): ");
            String genero = sc.nextLine();
            System.out.print("Sueldo por hora: ");
            double sueldoHora = Double.parseDouble(sc.nextLine());
            System.out.print("Cargo: ");
            String cargo = sc.nextLine();

            personas.add(new Persona(nombre, apellido, edad, genero, sueldoHora, cargo));

            System.out.print("¿Desea ingresar otra persona? (s/n): ");
            opcion = sc.nextLine();
        } while(opcion.equalsIgnoreCase("s"));

        long cantidad = personas.stream().count();
        System.out.println("Cantidad de personas: " + cantidad);

        double promedioEdad = personas.stream()
                .mapToInt(Persona::getEdad)
                .average().orElse(0);
        System.out.println("Promedio de edades: " + promedioEdad);

        long mayoresEdad = personas.stream().filter(p -> p.getEdad() >= 18).count();
        System.out.println("Cantidad de personas mayores de edad: " + mayoresEdad);

        System.out.println("Personas cuyos nombres empiezan con 'A':");
        personas.stream()
                .filter(p -> p.getNombre().startsWith("A"))
                .forEach(System.out::println);

        System.out.println("Personas cuyos apellidos contienen 'M':");
        personas.stream()
                .filter(p -> p.getApellido().toUpperCase().contains("M"))
                .forEach(System.out::println);
    }
}
