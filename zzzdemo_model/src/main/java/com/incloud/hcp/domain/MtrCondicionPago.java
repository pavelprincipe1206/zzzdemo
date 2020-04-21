/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/domain/Entity.java.e.vm
 */
package com.incloud.hcp.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.logging.Logger;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "mtr_condicion_pago")
//@Audited
//@AuditTable("_audi_mtr_condicion_pago")
public class MtrCondicionPago extends BaseDomain implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(MtrCondicionPago.class.getName());

    /***************************/
    /* Atributos de la Entidad */
    /***************************/

    // Raw attributes
    private Integer id;
    private String codigoCondicionPagoSap;
    private String descripcion;
    private String estado;

    @Override
    public String entityClassName() {
        return MtrCondicionPago.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "mtr_condicion_pago_id", precision = 10)
    @GeneratedValue(strategy = SEQUENCE, generator = "seq_mtr_condicion_pago")
    @Id
    @SequenceGenerator(name = "seq_mtr_condicion_pago", sequenceName = "seq_mtr_condicion_pago", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public MtrCondicionPago id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [codigoCondicionPagoSap] ------------------------

    @NotEmpty(message = "{message.mtrCondicionPago.codigoCondicionPagoSap.requerido}")
    @Size(max = 20, message = "{message.mtrCondicionPago.codigoCondicionPagoSap.sizeMax} {max} {message.caracter}")
    @Column(name = "codigo_condicion_pago_sap", nullable = false, unique = true, length = 20)
    public String getCodigoCondicionPagoSap() {
        return codigoCondicionPagoSap;
    }

    public void setCodigoCondicionPagoSap(String codigoCondicionPagoSap) {
        this.codigoCondicionPagoSap = codigoCondicionPagoSap;
    }

    public MtrCondicionPago codigoCondicionPagoSap(String codigoCondicionPagoSap) {
        setCodigoCondicionPagoSap(codigoCondicionPagoSap);
        return this;
    }
    // -- [descripcion] ------------------------

    //@NotEmpty(message = "{message.mtrCondicionPago.descripcion.requerido}")
    @Size(max = 255, message = "{message.mtrCondicionPago.descripcion.sizeMax} {max} {message.caracter}")
    @Column(name = "descripcion", nullable = true, unique = false)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public MtrCondicionPago descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }
    // -- [estado] ------------------------

    @NotEmpty(message = "{message.mtrCondicionPago.estado.requerido}")
    @Size(max = 1, message = "{message.mtrCondicionPago.estado.sizeMax} {max} {message.caracter}")
    @Column(name = "estado", nullable = false, length = 1)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public MtrCondicionPago estado(String estado) {
        setEstado(estado);
        return this;
    }

    /**
     * Apply the default values.
     */
    public MtrCondicionPago withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof MtrCondicionPago && hashCode() == other.hashCode());
    }

    private volatile int previousHashCode = 0;

    @Override
    public int hashCode() {
        int hashCode = Objects.hashCode(getDescripcion());

        if (previousHashCode != 0 && previousHashCode != hashCode) {
            log.warning("DEVELOPER: hashCode has changed!." //
                    + "If you encounter this message you should take the time to carefuly review equals/hashCode for: " //
                    + getClass().getCanonicalName());
        }

        previousHashCode = hashCode;
        return hashCode;
    }

    /**
     * Construct a readable string representation for this MtrCondicionPago instance.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("codigoCondicionPagoSap", getCodigoCondicionPagoSap()) //
                .add("descripcion", getDescripcion()) //
                .add("estado", getEstado()) //
                .toString();
    }
}
