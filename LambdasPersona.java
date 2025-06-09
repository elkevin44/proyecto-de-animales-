import java.util.*;
import java.util.stream.*;

public class LambdasPersona {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
            new Persona("Juan", "Martinez", 45, "M", 4500000, "director"),
            new Persona("Ana", "Morales", 29, "F", 350000, "desarrollador"),
            new Persona("Andrés", "Muñoz", 22, "M", 280000, "desarrollador"),
            new Persona("Luisa", "Mendoza", 33, "F", 300000, "desarrollador"),
            new Persona("Jose", "Gomez", 40, "M", 370000, "director"),
            new Persona("Andrea", "Morales", 27, "F", 400000, "analista")
        );

        System.out.println("Sueldo por 8 horas de directores masculinos:");
        personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("director") && p.getGenero().equalsIgnoreCase("M"))
                .peek(p -> System.out.print("Nombre: " + p.getNombre() + " " + p.getApellido() + " "))
                .map(p -> p.getSueldoHora() * 8)
                .forEach(sueldo -> System.out.println("Sueldo por 8 horas: $" + sueldo));

        Optional<Persona> primeraDevFemenina = personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("desarrollador") && p.getGenero().equalsIgnoreCase("F"))
                .findFirst();
        if(primeraDevFemenina.isPresent()) {
            System.out.println("Primera desarrolladora femenina: " + primeraDevFemenina.get());
        } else {
            System.out.println("No hay desarrolladora femenina.");
        }

        Optional<Persona> masGana = personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("desarrollador"))
                .max(Comparator.comparing(Persona::getSueldoHora));
        if(masGana.isPresent()) {
            System.out.println("Desarrollador que más gana por hora: " + masGana.get());
        } else {
            System.out.println("No hay desarrolladores.");
        }

        System.out.println("Mujeres ordenadas por nombre:");
        personas.stream()
                .filter(p -> p.getGenero().equalsIgnoreCase("F"))
                .sorted(Comparator.comparing(Persona::getNombre))
                .forEach(System.out::println);
    }
}
