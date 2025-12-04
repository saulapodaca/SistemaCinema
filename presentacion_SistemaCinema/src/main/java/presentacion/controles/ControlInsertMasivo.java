package presentacion.controles;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import itson.negocios_insertmasivo.IInsertMasivo;
import itson.negocios_insertmasivo.InsertMasivo;


public class ControlInsertMasivo {

    /**
     * Instancia única del control
     */
    private static ControlInsertMasivo instance;

    private final IInsertMasivo insertMasivo;

    /**
     * Constructor privado que inicializa el frame principal
     */
    private ControlInsertMasivo() {
        this.insertMasivo = new InsertMasivo();
    }

    /**
     * Método que obtiene la instancia única del controlador de pantallas, si no
     * existe, crea una nueva
     *
     * @return
     */
    public static synchronized ControlInsertMasivo getInstance() {
        if (instance == null) {
            instance = new ControlInsertMasivo();
        }
        return instance;
    }
    
    public void insertMasivo(){
        insertMasivo.insertMasivo();
    }
    
}
