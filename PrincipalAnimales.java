import java.util.*;

public class PrincipalAnimales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Animal> animales = new ArrayList<>();
        Map<String, List<Animal>> clasificacion = new TreeMap<>();
        clasificacion.put("Terrestres", new ArrayList<>());
        clasificacion.put("Acuáticos", new ArrayList<>());
        clasificacion.put("Aéreos", new ArrayList<>());

        String opcion;
        do {
            System.out.println("Ingrese nombre del animal:");
            String nombre = sc.nextLine();
            System.out.println("Ingrese tipo (Terrestres/Acuáticos/Aéreos):");
            String tipo = sc.nextLine();
            System.out.println("Ingrese género (masculino/femenino):");
            String genero = sc.nextLine();

            Animal animal = new Animal(nombre, tipo, genero);
            animales.add(animal);

            switch(tipo.toLowerCase()) {
                case "terrestres":
                    clasificacion.get("Terrestres").add(animal); break;
                case "acuáticos":
                case "acuatico":
                    clasificacion.get("Acuáticos").add(animal); break;
                case "aéreos":
                case "aereos":
                case "aereo":
                case "aéreo":
                    clasificacion.get("Aéreos").add(animal); break;
                default:
                    System.out.println("Tipo no reconocido. No se clasificó el animal.");
            }

            System.out.println("¿Desea ingresar otro animal? (s/n)");
            opcion = sc.nextLine();
        } while(opcion.equalsIgnoreCase("s"));

        for (Map.Entry<String, List<Animal>> entry : clasificacion.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Animal a : entry.getValue()) {
                System.out.println("    " + a.getNombre());
            }
        }
    }
}
