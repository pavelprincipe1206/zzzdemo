/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/domain/EntityMeta_.java.e.vm
 */
package com.incloud.hcp.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(MtrTipoImputacion.class)
public abstract class MtrTipoImputacion_ {

    // Raw attributes
    public static volatile SingularAttribute<MtrTipoImputacion, Integer> id;
    public static volatile SingularAttribute<MtrTipoImputacion, String> codigoTipoImputacion;
    public static volatile SingularAttribute<MtrTipoImputacion, String> descripcion;
}
