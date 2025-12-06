/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import dto.enums.TipoMembresia;
import java.util.regex.Pattern;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

/**
 * DTO (Data Transfer Object) que representa un Objeto de Beneficio en el sistema.
 * <p>
 * Esta clase es utilizada para transportar datos entre las diferentes capas de la aplicación
 * siguiendo la arquitectura: GestorSubsistemaX → InterfazOtroSubsistema → BO → Mapper → DAO → Dominio.
 * </p>
 * 
 * <p><strong>Características principales:</strong></p>
 * <ul>
 *   <li><strong>Inmutable:</strong> Una vez construido, sus datos no pueden modificarse</li>
 *   <li><strong>Thread-safe:</strong> Seguro para uso en entornos concurrentes</li>
 *   <li><strong>Validado:</strong> Incluye validaciones de integridad de datos</li>
 *   <li><strong>Flexible:</strong> Permite creación con diferentes combinaciones de campos</li>
 * </ul>
 * 
 * <p><strong>Uso típico:</strong></p>
 * <pre>{@code
 * // Creación completa
 * ObjetoBeneficioDTO dto = ObjetoBeneficioDTO.builder()
 *     .id("507f1f77bcf86cd799439011")
 *     .nombre("Laptop Gaming")
 *     .costo(1500)
 *     .stock(10)
 *     .tipoMembresia(TipoMembresia.PREMIUM)
 *     .build();
 * 
 * // Creación disponible para múltiples membresías
 * ObjetoBeneficioDTO dtoMultiples = ObjetoBeneficioDTO.builder()
 *     .nombre("Descuento Especial")
 *     .costo(100)
 *     .tipoMembresia(TipoMembresia.BASICA)
 *     .tipoMembresia(TipoMembresia.PREMIUM)
 *     .build();
 * }</pre>
 * 
 * @author [Nombre del desarrollador]
 * @version 2.0
 * @see ObjetoBeneficioBO
 * @see ObjetoBeneficioMapper
 * @see ObjetoBeneficioDAO
 * @see TipoMembresia
 */
public class ObjetoBeneficioDTO {
    
    /**
     * Identificador único del objeto.
     * <p>
     * Sigue el formato de ObjectId de MongoDB (24 caracteres hexadecimales).
     * Puede ser {@code null} para objetos nuevos que aún no han sido persistidos.
     * </p>
     */
    private final String id;
    
    /**
     * Nombre del objeto de beneficio.
     * <p>
     * Campo obligatorio. No puede ser {@code null}, vacío o solo espacios.
     * </p>
     */
    private final String nombre;
    
    /**
     * Costo del objeto en unidades monetarias.
     * <p>
     * Campo obligatorio. Debe ser un valor positivo o cero.
     * </p>
     */
    private final int costo;
    
    /**
     * Cantidad disponible en inventario.
     * <p>
     * Campo opcional. Puede ser {@code null} para objetos que no requieren inventario.
     * Si se proporciona, debe ser un valor positivo o cero.
     * </p>
     */
    private final Integer stock;
    
    /**
     * Conjunto de tipos de membresía que pueden adquirir este beneficio.
     * <p>
     * Campo opcional. Si no se especifica, se considera que el beneficio está disponible
     * para todos los tipos de membresía. Nunca es {@code null} pero puede estar vacío.
     * </p>
     */
    private final Set<TipoMembresia> tiposMembresia;
    
    /**
     * Constructor privado que solo puede ser invocado por el Builder.
     * <p>
     * Garantiza que todas las instancias de ObjetoBeneficioDTO sean creadas
     * mediante el patrón Builder y cumplan con las validaciones requeridas.
     * </p>
     * 
     * @param builder Instancia del Builder con los datos validados
     */
    private ObjetoBeneficioDTO(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.costo = builder.costo;
        this.stock = builder.stock;
        this.tiposMembresia = Collections.unmodifiableSet(
            builder.tiposMembresia != null ? 
            new HashSet<>(builder.tiposMembresia) : 
            new HashSet<>()
        );
    }
    
    /**
     * Builder para crear instancias inmutables de {@link ObjetoBeneficioDTO}.
     * <p>
     * Implementa el patrón Builder para permitir la creación flexible de DTOs
     * con validaciones integradas. Todos los métodos devuelven la misma instancia
     * del Builder permitiendo encadenamiento de llamadas (fluent interface).
     * </p>
     * 
     * <p><strong>Validaciones implementadas:</strong></p>
     * <ul>
     *   <li>ID: Si se proporciona, debe ser un ObjectId válido de MongoDB</li>
     *   <li>Nombre: Campo obligatorio, no nulo y no vacío</li>
     *   <li>Costo: Campo obligatorio, no negativo</li>
     *   <li>Stock: Campo opcional, si se proporciona no puede ser negativo</li>
     *   <li>TiposMembresia: Campo opcional, no valida duplicados (Set los elimina)</li>
     * </ul>
     * 
     * @see #builder()
     * @see #build()
     */
    public static class Builder {
        private static final Pattern MONGO_ID_PATTERN = 
            Pattern.compile("^[0-9a-fA-F]{24}$");
        
        private String id;
        private String nombre;
        private int costo;
        private Integer stock;
        private Set<TipoMembresia> tiposMembresia;
        
        /**
         * Establece el identificador único del objeto.
         * <p>
         * Si se proporciona un valor, debe cumplir con el formato de ObjectId de MongoDB
         * (24 caracteres hexadecimales). Si es {@code null}, se asume que es un objeto nuevo.
         * </p>
         * 
         * @param id Identificador en formato MongoDB ObjectId, o {@code null} para objetos nuevos
         * @return Esta instancia del Builder para encadenamiento
         * @throws IllegalArgumentException Si el ID no es null y no cumple el formato esperado
         */
        public Builder id(String id) {
            if (id != null && !MONGO_ID_PATTERN.matcher(id).matches()) {
                throw new IllegalArgumentException(
                    "El ID debe ser un ObjectId válido de MongoDB (24 caracteres hexadecimales). " +
                    "Valor recibido: '" + id + "'"
                );
            }
            this.id = id;
            return this; 
        }
        
        /**
         * Establece el nombre del objeto de beneficio.
         * <p>
         * Campo obligatorio que no puede ser nulo, vacío o consistir solo en espacios.
         * </p>
         * 
         * @param nombre Nombre del objeto, no puede ser {@code null} o vacío
         * @return Esta instancia del Builder para encadenamiento
         * @throws IllegalArgumentException Si el nombre es nulo, vacío o solo espacios
         */
        public Builder nombre(String nombre) {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException(
                    "El nombre es obligatorio y no puede estar vacío o ser solo espacios."
                );
            }
            this.nombre = nombre.trim();
            return this;
        }
        
        /**
         * Establece el costo del objeto.
         * <p>
         * Campo obligatorio que representa el precio en unidades monetarias.
         * No puede ser un valor negativo.
         * </p>
         * 
         * @param costo Costo del objeto, debe ser mayor o igual a cero
         * @return Esta instancia del Builder para encadenamiento
         * @throws IllegalArgumentException Si el costo es negativo
         */
        public Builder costo(int costo) {
            if (costo < 0) {
                throw new IllegalArgumentException(
                    "El costo no puede ser negativo. Valor recibido: " + costo
                );
            }
            this.costo = costo;
            return this;
        }
        
        /**
         * Establece la cantidad disponible en inventario.
         * <p>
         * Campo opcional. Si se proporciona un valor, no puede ser negativo.
         * Si es {@code null}, indica que el objeto no requiere control de inventario
         * (por ejemplo, servicios digitales).
         * </p>
         * 
         * @param stock Cantidad en inventario, o {@code null} si no aplica
         * @return Esta instancia del Builder para encadenamiento
         * @throws IllegalArgumentException Si el stock es negativo
         */
        public Builder stock(Integer stock) {
            if (stock != null && stock < 0) {
                throw new IllegalArgumentException(
                    "El stock no puede ser negativo. Valor recibido: " + stock
                );
            }
            this.stock = stock;
            return this;
        }
        
        /**
         * Establece un tipo de membresía que puede adquirir este beneficio.
         * <p>
         * Campo opcional. Puede llamarse múltiples veces para agregar varios tipos.
         * Los duplicados se eliminan automáticamente ya que se usa un {@link Set}.
         * Si no se llama a este método, el beneficio estará disponible para todos los tipos.
         * </p>
         * 
         * @param tipo El tipo de membresía que puede adquirir este beneficio
         * @return Esta instancia del Builder para encadenamiento
         * @throws IllegalArgumentException Si el tipo es {@code null}
         */
        public Builder tipoMembresia(TipoMembresia tipo) {
            if (tipo == null) {
                throw new IllegalArgumentException("El tipo de membresía no puede ser null");
            }
            
            if (this.tiposMembresia == null) {
                this.tiposMembresia = new HashSet<>();
            }
            
            this.tiposMembresia.add(tipo);
            return this;
        }
        
        /**
         * Establece múltiples tipos de membresía que pueden adquirir este beneficio.
         * <p>
         * Campo opcional. Proporciona una forma conveniente de agregar varios tipos a la vez.
         * Si se proporciona {@code null} o una colección vacía, no tiene efecto.
         * Los valores nulos dentro de la colección se ignoran.
         * </p>
         * 
         * @param tipos Colección de tipos de membresía, puede ser {@code null}
         * @return Esta instancia del Builder para encadenamiento
         */
        public Builder tiposMembresia(Set<TipoMembresia> tipos) {
            if (tipos != null && !tipos.isEmpty()) {
                if (this.tiposMembresia == null) {
                    this.tiposMembresia = new HashSet<>();
                }
                
                // Agrega solo los tipos no nulos
                for (TipoMembresia tipo : tipos) {
                    if (tipo != null) {
                        this.tiposMembresia.add(tipo);
                    }
                }
            }
            return this;
        }
        
        /**
         * Construye una instancia inmutable de {@link ObjetoBeneficioDTO}.
         * <p>
         * Realiza validaciones finales y crea el DTO con los datos proporcionados.
         * Una vez construido, el DTO no puede modificarse.
         * </p>
         * 
         * <p><strong>Validaciones finales en build():</strong></p>
         * <ul>
         *   <li>Verifica que el nombre haya sido establecido (obligatorio)</li>
         *   <li>Garantiza que el costo sea válido (no negativo)</li>
         *   <li>Asegura que el conjunto de tipos de membresía sea inmutable</li>
         * </ul>
         * 
         * @return Una nueva instancia inmutable de ObjetoBeneficioDTO
         * @throws IllegalStateException Si no se ha establecido el nombre (campo obligatorio)
         */
        public ObjetoBeneficioDTO build() {
            // Validación final del nombre (ya validado en el setter, pero por redundancia)
            if (this.nombre == null) {
                throw new IllegalStateException(
                    "El nombre es un campo obligatorio. Use el método nombre() para establecerlo."
                );
            }
            
            // El costo ya fue validado en el setter, pero verificamos que no sea negativo
            if (this.costo < 0) {
                throw new IllegalStateException(
                    "El costo no puede ser negativo. Valor actual: " + this.costo
                );
            }
            
            return new ObjetoBeneficioDTO(this);
        }
    }
    
    /**
     * Crea y retorna una nueva instancia del {@link Builder}.
     * <p>
     * Este es el punto de entrada principal para construir instancias de
     * {@link ObjetoBeneficioDTO} usando el patrón Builder.
     * </p>
     * 
     * <p><strong>Ejemplo de uso:</strong></p>
     * <pre>{@code
     * ObjetoBeneficioDTO dto = ObjetoBeneficioDTO.builder()
     *     .nombre("Producto Ejemplo")
     *     .costo(100)
     *     .stock(10)
     *     .tipoMembresia(TipoMembresia.PREMIUM)
     *     .build();
     * }</pre>
     * 
     * @return Una nueva instancia del Builder para configurar el DTO
     */
    public static Builder builder() {
        return new Builder();
    }
    
    // =============================================
    // GETTERS - No hay setters porque el DTO es inmutable
    // =============================================
    
    /**
     * Retorna el identificador único del objeto.
     * 
     * @return El ID en formato MongoDB ObjectId, o {@code null} si es un objeto nuevo
     */
    public String getId() {
        return id;
    }

    /**
     * Retorna el nombre del objeto de beneficio.
     * 
     * @return El nombre del objeto, nunca {@code null} o vacío
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el costo del objeto en unidades monetarias.
     * 
     * @return El costo, siempre mayor o igual a cero
     */
    public int getCosto() {
        return costo;
    }

    /**
     * Retorna la cantidad disponible en inventario.
     * 
     * @return El stock, o {@code null} si el objeto no requiere inventario
     */
    public Integer getStock() {
        return stock;
    }
    
    /**
     * Retorna los tipos de membresía que pueden adquirir este beneficio.
     * <p>
     * El conjunto retornado es inmutable. Si no se especificaron tipos de membresía,
     * retorna un conjunto vacío (lo que significa "disponible para todos").
     * </p>
     * 
     * @return Conjunto inmutable de tipos de membresía, nunca {@code null}
     */
    public Set<TipoMembresia> getTiposMembresia() {
        return tiposMembresia;
    }
    
    
    
}
