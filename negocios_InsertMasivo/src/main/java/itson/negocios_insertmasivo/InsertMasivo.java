package itson.negocios_insertmasivo;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import bos.EmpleadoBO;
import bos.FuncionBO;
import bos.PeliculaBO;
import bos.SalaBO;
import bos.SucursalBO;
import dto.EmpleadoDTO;
import dto.FiltroDTO;
import dto.FuncionDTO;
import dto.PeliculaDTO;
import dto.SalaDTO;
import dto.SucursalDTO;
import dto.enums.TipoEmpleado;
import exceptions.NegocioException;
import exceptions.PeliculaNoExistenteException;
import exceptions.SalaNoExistenteException;
import exceptions.SucursalNoExistenteException;
import interfaces.IEmpleadoBO;
import interfaces.IFuncionBO;
import interfaces.IPeliculaBO;
import interfaces.ISalaBO;
import interfaces.ISucursalBO;
import java.time.LocalDateTime;
import java.util.List;

public class InsertMasivo implements IInsertMasivo {

    private final ISucursalBO sucursalBO;
    private final ISalaBO salaBO;
    private final IEmpleadoBO empleadoBO;
    private final IPeliculaBO peliculaBO;
    private final IFuncionBO funcionBO;

    public InsertMasivo() {
        this.sucursalBO = SucursalBO.getInstancia();
        this.salaBO = SalaBO.getInstancia();
        this.empleadoBO = EmpleadoBO.getInstancia();
        this.peliculaBO = PeliculaBO.getInstancia();
        this.funcionBO = FuncionBO.getInstancia();
    }

    @Override
    public void insertMasivo() {
        List<PeliculaDTO> peliculas = peliculaBO.obtenerPeliculas(new FiltroDTO(1, 6, ""));
        if (peliculas.isEmpty()) {
            insertarSucursales();
            insertarSalas();
            insertarEmpleados();
            insertarPeliculas();
            insertarFunciones();
        }
    }

    private void insertarSucursales() {
        try {
            sucursalBO.insertarSucursal(new SucursalDTO(null, "Nainari", "Av. México 101"));
            sucursalBO.insertarSucursal(new SucursalDTO(null, "Bella Vista", "Blvd. Camino Real 230"));
        } catch (NegocioException e) {
            System.out.println("Error insertando sucursales: " + e.getMessage());
        }
    }

    private void insertarSalas() {
        try {
            // SalaDTO(id, nombre, filas, columnas, sucursalId)
            salaBO.insertarSala(new SalaDTO(null, "Sala 1", 7, 8));
            salaBO.insertarSala(new SalaDTO(null, "Sala 3", 7, 8));
            salaBO.insertarSala(new SalaDTO(null, "Sala 2", 8, 9));
            salaBO.insertarSala(new SalaDTO(null, "Sala 1", 5, 5));
        } catch (NegocioException e) {
            System.out.println("Error insertando salas: " + e.getMessage());
        }
    }

    private void insertarEmpleados() {
        try {

            empleadoBO.insertarEmpleado(new EmpleadoDTO(
                    null, "Saul", "Apodaca", "Baldenegro",
                    obtenerSucursal("Nainari"),
                    "Gerente",
                    "SaulApodaca.png", "admin", TipoEmpleado.ADMINISTRADOR, "1234"));
            empleadoBO.insertarEmpleado(new EmpleadoDTO(
                    null, "Alejandro", "Rodríguez", "Lugo",
                    obtenerSucursal("Nainari"),
                    "Empleado",
                    "alther.png", "normal", TipoEmpleado.NORMAL, "1234"));
        } catch (NegocioException | SucursalNoExistenteException e) {
            System.out.println("Error insertando empleados: " + e.getMessage());
        }
    }

    private void insertarPeliculas() {
        try {
            peliculaBO.insertarPelicula(new PeliculaDTO(null, "Spider-man 3", "spiderman.png", "182min", "Español"));
            peliculaBO.insertarPelicula(new PeliculaDTO(null, "Black Phone 2", "blackphone.png", "148min", "Inglés"));
            peliculaBO.insertarPelicula(new PeliculaDTO(null, "Crepúsculo", "crepusculo.png", "110min", "Doblado"));
            peliculaBO.insertarPelicula(new PeliculaDTO(null, "Harry Potter Y La Piedra Filosofal", "harryPotter.png", "200min", "Español"));
            peliculaBO.insertarPelicula(new PeliculaDTO(null, "Five Nights at Freddy´s", "fivenightsatfreddy.png", "200min", "Español"));
            peliculaBO.insertarPelicula(new PeliculaDTO(null, "Five Nights at Freddy´s 2", "fivenightsatfreddy2.png", "150min", "Inglés"));
            peliculaBO.insertarPelicula(new PeliculaDTO(null, "Interestellar", "interestellar.png", "250min", "Español"));
        } catch (NegocioException e) {
            System.out.println("Error insertando películas: " + e.getMessage());
        }
    }

    private void insertarFunciones() {
        try {
            funcionBO.insertarFuncion(new FuncionDTO(null,
                    obtenerSala("Sala 1"),
                    obtenerPelicula("Spider-man 3"),
                    " Sala Tradicional",
                    LocalDateTime.of(2025, 12, 10, 16, 0)));

            funcionBO.insertarFuncion(new FuncionDTO(null,
                    obtenerSala("Sala 3"),
                    obtenerPelicula("Spider-man 3"),
                    " Sala VIP",
                    LocalDateTime.of(2025, 12, 10, 19, 0)));

            funcionBO.insertarFuncion(new FuncionDTO(
                    null,
                    obtenerSala("Sala 2"),
                    obtenerPelicula("Spider-man 3"),
                    " Sala Tradicional",
                    LocalDateTime.of(2025, 12, 10, 22, 0)));

            funcionBO.insertarFuncion(new FuncionDTO(null,
                    obtenerSala("Sala 2"),
                    obtenerPelicula("Spider-man 3"),
                    " Sala Tradicional",
                    LocalDateTime.of(2025, 12, 10, 20, 0)));
        } catch (NegocioException | PeliculaNoExistenteException | SalaNoExistenteException e) {
            System.out.println("Error insertando funciones: " + e.getMessage());
        }
    }

    private SucursalDTO obtenerSucursal(String nombre) throws NegocioException {
        return sucursalBO.obtenerPorNombre(nombre);
    }

    private SalaDTO obtenerSala(String nombre) throws NegocioException {
        return salaBO.obtenerPorNombre(nombre);
    }

    private PeliculaDTO obtenerPelicula(String titulo) throws NegocioException {
        return peliculaBO.obtenerPorTitulo(titulo);
    }

}
