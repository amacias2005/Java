import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class OrdenarGrupos {

    public static Map<Character, Map<Integer, String>> ordenarGrupos(Map<Integer, String> m) {
        // Usamos TreeMap para ordenar alfabéticamente por la clave Character
        // andy
        Map<Character, Map<Integer, String>> gruposOrdenados = new TreeMap<>();

        for (Map.Entry<Integer, String> entry : m.entrySet()) {
            char primerCaracter = entry.getValue().charAt(0);

            if (!gruposOrdenados.containsKey(primerCaracter)) {
                // Usamos LinkedHashMap para mantener el orden de inserción de los valores
                // internos
                gruposOrdenados.put(primerCaracter, new LinkedHashMap<>());
            }

            gruposOrdenados.get(primerCaracter).put(entry.getKey(), entry.getValue());
        }

        return gruposOrdenados;
    }

    public static void main(String[] args) {
        Map<Integer, String> m = new LinkedHashMap<>();
        m.put(1, "Manzana");
        m.put(2, "Banana");
        m.put(3, "Cereza");
        m.put(4, "Aguacate");
        m.put(5, "Dátil");
        m.put(6, "Arándano");

        Map<Character, Map<Integer, String>> gruposOrdenados = ordenarGrupos(m);

        // Imprimir el resultado ordenado
        for (Map.Entry<Character, Map<Integer, String>> grupoEntry : gruposOrdenados.entrySet()) {
            System.out.println("Grupo " + grupoEntry.getKey() + ":");
            for (Map.Entry<Integer, String> valorEntry : grupoEntry.getValue().entrySet()) {
                System.out.println("  " + valorEntry.getKey() + ": " + valorEntry.getValue());
            }
        }
    }
}