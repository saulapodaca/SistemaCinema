package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.util.ArrayList;
import java.util.List;


public class ComboDTO {
    
    private String id;
    private String nombre;
    private String rutaImagen;
    private String descripcion;
    private TamanoPalomitasDTO tamanoPalomitasDTO;
    private SaborPalomitasDTO saborPalomitasDTO;
    private List<SaborBebidaDTO> bebidas = new ArrayList<>();
    private int indiceBebidaActual = 0;
    private DulceDTO dulceDTO;
    private double precio;

    public ComboDTO() {
    }

    public ComboDTO(String id, String nombre, String rutaImagen, String descripcion, TamanoPalomitasDTO tamanoPalomitasDTO, SaborPalomitasDTO saborPalomitasDTO, DulceDTO dulceDTO, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
        this.descripcion = descripcion;
        this.tamanoPalomitasDTO = tamanoPalomitasDTO;
        this.saborPalomitasDTO = saborPalomitasDTO;
        this.dulceDTO = dulceDTO;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TamanoPalomitasDTO getTamanoPalomitasDTO() {
        return tamanoPalomitasDTO;
    }

    public void setTamanoPalomitasDTO(TamanoPalomitasDTO tamanoPalomitasDTO) {
        this.tamanoPalomitasDTO = tamanoPalomitasDTO;
    }

    public SaborPalomitasDTO getSaborPalomitasDTO() {
        return saborPalomitasDTO;
    }

    public void setSaborPalomitasDTO(SaborPalomitasDTO saborPalomitasDTO) {
        this.saborPalomitasDTO = saborPalomitasDTO;
    }

    public List<SaborBebidaDTO> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<SaborBebidaDTO> bebidas) {
        this.bebidas = bebidas;
    }

    public DulceDTO getDulceDTO() {
        return dulceDTO;
    }

    public void setDulceDTO(DulceDTO dulceDTO) {
        this.dulceDTO = dulceDTO;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
     public void agregarBebida(SaborBebidaDTO bebida) {
        bebidas.add(bebida);
    }

    public SaborBebidaDTO getBebidaActual() {
        if (indiceBebidaActual < bebidas.size()) {
            return bebidas.get(indiceBebidaActual);
        }
        return null;
    }
    
     public boolean hayMasBebidas() {
        return indiceBebidaActual < bebidas.size() - 1;
    }

    public void avanzarBebida() {
        indiceBebidaActual++;
    }

    public int getTotalBebidas() {
        return bebidas.size();
    }

    public void reiniciarBebidas() {
        indiceBebidaActual = 0;
    }

}
