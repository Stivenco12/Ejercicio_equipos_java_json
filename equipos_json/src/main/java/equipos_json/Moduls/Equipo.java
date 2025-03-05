package equipos_json.Moduls;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Equipo implements Serializable{
    
    @JsonProperty("Equipo")
    private String Equipo;

    @JsonProperty("Ciudad")
    private String Ciudad;

    @JsonProperty("Fecha_fundacion")
    private String Fecha_fundacion;

    @JsonProperty("Presidente")
    private String Presidente;

    @JsonProperty("Jugadores")
    private List<Jugador> jugadores;

    public static class Jugador {
        @JsonProperty("nombre")
        private String nombre;
        
        @JsonProperty("edad")
        private int edad;

        public Jugador() {} 

        public Jugador(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }

        public int getEdad() { return edad; }
        public void setEdad(int edad) { this.edad = edad; }

        @Override
        public String toString() {
            return nombre + " (" + edad + " años)";
        }
    }
 
    public Equipo(String Equipo, String Ciudad, String Fecha_fundacion, String Presidente,List<Jugador> Jugadores){
            this.Equipo = Equipo;
            this.Ciudad = Ciudad;
            this.Fecha_fundacion = Fecha_fundacion;
            this.Presidente = Presidente;
            this.jugadores = Jugadores;
    }

    public String getEquipo() { return Equipo; }
    public void setEquipo(String Equipo) { this.Equipo = Equipo; }

    public String getCiudad() { return Ciudad; }
    public void setCiudad(String Ciudad) { this.Ciudad = Ciudad; }

    public String getFecha_fundacion() { return Fecha_fundacion; }
    public void setFecha_fundacion(String Fecha_fundacion) { this.Fecha_fundacion = Fecha_fundacion; }

    public String getPresidente() { return Presidente; }
    public void setPresidente(String Presidente) { this.Presidente = Presidente; }

    public List<Jugador> getJugadores() { return jugadores; }
    public void setJugadores(List<Jugador> jugadores) { this.jugadores = jugadores; }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Nombre del equipo: ");
        stringBuilder.append(Equipo);
        stringBuilder.append(" | Ciudad del equipo: ");
        stringBuilder.append(Ciudad);
        stringBuilder.append(" | Fecha de Fundacion: ");
        stringBuilder.append(Fecha_fundacion);
        stringBuilder.append(" | nombre del presidente: ");
        stringBuilder.append(Presidente);
        stringBuilder.append(" | nombre del jugador: ");
        stringBuilder.append(jugadores);
        return stringBuilder.toString();
    }
    
    



}
