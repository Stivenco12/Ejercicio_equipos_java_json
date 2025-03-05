package equipos_json.Moduls;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import equipos_json.Moduls.Equipo.Jugador;

public class EquipoService {

    private static final String FILE_PATH = "persons.json";
    private Map<Integer, Equipo> Equipos;
    private ObjectMapper objectMapper ;

    public EquipoService(){
        objectMapper  = new ObjectMapper();
        Equipos = cargarEquipo();
    }

    private Map<Integer, Equipo> cargarEquipo() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return new HashMap<>();
            return objectMapper.readValue(file, new TypeReference<Map<Integer, Equipo>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
  
    private void guardarEquipo() {
        try {
            objectMapper.writeValue(new File(FILE_PATH), Equipos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearEquipo(String Equipo, String Ciudad, String Fecha_fundacion,  String Presidente,List<Jugador> Jugadores) {
        int id = (Equipo.isEmpty()) ? 1 : Equipos.keySet().stream().max(Integer::compare).orElse(0) + 1;
        Equipo nuevaEquipo = new Equipo(Equipo, Ciudad, Fecha_fundacion,Presidente,Jugadores);
        Equipos.put(id, nuevaEquipo);
        guardarEquipo();
        System.out.println("✅ Persona agregada con ID: " + id);
    }

    public void listarEquipo() {
        if (Equipos.isEmpty()) {
            System.out.println("📂 No hay personas disponibles.");
            return;
        }
        Equipos.forEach((id, Equipo) -> System.out.println("ID: " + id + " | " + Equipo));
    }

    public Equipo buscarEquipo(int id) {
        return Equipos.get(id);
    }

    public void actualizarEquipo(int id, String Equipo, String Ciudad, String Fecha_fundacion,String Presidente,List<Jugador> Jugadores) {
        if (Equipos.containsKey(id)) {
            Equipo Equipe = Equipos.get(id);
            Equipe.setEquipo(Equipo);
            Equipe.setCiudad(Ciudad);
            Equipe.setFecha_fundacion(Fecha_fundacion);
            Equipe.setPresidente(Presidente);
            Equipe.setJugadores(Jugadores);
            guardarEquipo();
            System.out.println("✅ Persona actualizada.");
        } else {
            System.out.println("⚠️ Persona no encontrada.");
        }
    }

    public void eliminarEquipo(int id) {
        if (Equipos.remove(id) != null) {
            guardarEquipo();
            System.out.println("🗑 Persona eliminada.");
        } else {
            System.out.println("⚠️ Persona no encontrada.");
        }
    }
}
