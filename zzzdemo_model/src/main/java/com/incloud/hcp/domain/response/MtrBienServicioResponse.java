/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/domain/EntityResponse.java.e.vm
 */
package com.incloud.hcp.domain.response;

import com.incloud.hcp.domain.BaseResponseDomain;
import com.incloud.hcp.domain.MtrBienServicio;
import com.incloud.hcp.domain.MtrGrupoArticulo;
import com.incloud.hcp.domain.MtrUnidadMedida;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * Simple Interface for MtrBienServicio.
 */
@Data
@ToString
@EqualsAndHashCode
public class MtrBienServicioResponse extends BaseResponseDomain<MtrBienServicio> {

    /****************************/
    /* Variables de Condiciones */
    /****************************/

    private String idCondicion;
    private String codigoSapCondicion;
    private String descripcionCondicion;
    private String tipoItemCondicion;
    private String descripcionBreveCondicion;
    //private String mtrGrupoArticuloCondicion;
    //private String mtrUnidadMedidaCondicion;

    /****************************/
    /* Variables Listas         */
    /****************************/

    private List<Integer> idList;
    private List<String> codigoSapList;
    private List<String> descripcionList;
    private List<String> tipoItemList;
    private List<String> descripcionBreveList;
    private List<MtrGrupoArticulo> mtrGrupoArticuloList;
    private List<MtrUnidadMedida> mtrUnidadMedidaList;

}
