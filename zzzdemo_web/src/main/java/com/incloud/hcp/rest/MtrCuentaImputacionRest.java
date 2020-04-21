/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/rest/EntityResource.java.e.vm
 */
package com.incloud.hcp.rest;

import com.incloud.hcp.common.BindingErrorsResponse;
import com.incloud.hcp.common.graph.GraphBean;
import com.incloud.hcp.domain.MtrCuentaImputacion;
import com.incloud.hcp.domain.MtrTipoImputacion;
import com.incloud.hcp.domain.response.MtrCuentaImputacionResponse;
import com.incloud.hcp.repository.delta.MtrCuentaImputacionDeltaRepository;
import com.incloud.hcp.rest._framework.JPACustomRest;
import com.incloud.hcp.service.delta.MtrCuentaImputacionDeltaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public abstract class MtrCuentaImputacionRest extends JPACustomRest<MtrCuentaImputacionResponse, MtrCuentaImputacion, Integer> {

    @Autowired
    protected MtrCuentaImputacionDeltaService mtrCuentaImputacionDeltaService;

    @Autowired
    protected MtrCuentaImputacionDeltaRepository mtrCuentaImputacionDeltaRepository;

    protected String setObtenerNombreArchivoExcel() {
        return "MtrCuentaImputacion";
    }

    /************************/
    /* Instancia de Bean    */
    /************************/
    protected final MtrCuentaImputacion createInstance() {
        MtrCuentaImputacion mtrCuentaImputacion = new MtrCuentaImputacion();
        return mtrCuentaImputacion;
    }

    /**
     * Find by por codigoCuentaImputacion
     */
    @ApiOperation(value = "Busca registro de tipo <T> en base a codigoCuentaImputacion", produces = "application/json")
    @GetMapping(value = "/_getByCodigoCuentaImputacion/{codigoCuentaImputacion}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<MtrCuentaImputacion> getByCodigoCuentaImputacion(@PathVariable String codigoCuentaImputacion) throws URISyntaxException {
        log.debug(this.NOMBRE_CLASE + " - Ingresando getByCodigoCuentaImputacion: " + codigoCuentaImputacion);
        try {
            return Optional.ofNullable(this.mtrCuentaImputacionDeltaRepository.getByCodigoCuentaImputacion(codigoCuentaImputacion))
                    .map(bean -> new ResponseEntity<>(bean, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            if (this.devuelveRuntimeException) {
                throw new RuntimeException(e);
            }
            HttpHeaders headers = this.devuelveErrorHeaders(e);
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Find by por descripcion
     */
    @ApiOperation(value = "Busca registro de tipo <T> en base a descripcion", produces = "application/json")
    @GetMapping(value = "/_getByDescripcion/{descripcion}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<MtrCuentaImputacion> getByDescripcion(@PathVariable String descripcion) throws URISyntaxException {
        log.debug(this.NOMBRE_CLASE + " - Ingresando getByDescripcion: " + descripcion);
        try {
            return Optional.ofNullable(this.mtrCuentaImputacionDeltaRepository.getByDescripcion(descripcion))
                    .map(bean -> new ResponseEntity<>(bean, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            if (this.devuelveRuntimeException) {
                throw new RuntimeException(e);
            }
            HttpHeaders headers = this.devuelveErrorHeaders(e);
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    /*****************/
    /* Otros Metodos */
    /*****************/

    /**
    * Contador de registros para el atributo mtrTipoImputacion.
    */
    @ApiOperation(value = "Contador de registros para el atributo mtrTipoImputacion", produces = "application/json")
    @PostMapping(value = "/countByMtrTipoImputacion", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> countByMtrTipoImputacion(@RequestBody @Valid MtrTipoImputacion mtrTipoImputacion, BindingResult bindingResult)
            throws URISyntaxException {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors()) {
            errors.addAllErrors(bindingResult);
            if (this.devuelveRuntimeException) {
                throw new RuntimeException(errors.toJSON());
            }
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
        log.debug("Ingresando countByMtrTipoImputacion");
        try {
            return Optional.ofNullable(this.mtrCuentaImputacionDeltaService.countByMtrTipoImputacion(mtrTipoImputacion))
                    .map(l -> new ResponseEntity<>(l, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            if (this.devuelveRuntimeException) {
                throw new RuntimeException(e);
            }
            headers = this.devuelveErrorHeaders(e);
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    /**
    * Genera Grafico de registros para el atributo mtrTipoImputacion.
    */
    @ApiOperation(value = "Genera Grafico de registros para el atributo mtrTipoImputacion", produces = "application/json")
    @GetMapping(value = "/graphByMtrTipoImputacion", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<GraphBean> graphByMtrTipoImputacion() throws URISyntaxException {
        log.debug("Ingresando graphByMtrTipoImputacion");
        try {
            return Optional.ofNullable(this.mtrCuentaImputacionDeltaService.graphByMtrTipoImputacion()).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            if (this.devuelveRuntimeException) {
                throw new RuntimeException(e);
            }
            HttpHeaders headers = this.devuelveErrorHeaders(e);
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

}