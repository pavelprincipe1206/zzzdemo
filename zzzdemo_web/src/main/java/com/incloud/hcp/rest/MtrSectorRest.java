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

import com.incloud.hcp.domain.MtrSector;
import com.incloud.hcp.domain.response.MtrSectorResponse;
import com.incloud.hcp.repository.delta.MtrSectorDeltaRepository;
import com.incloud.hcp.rest._framework.JPACustomRest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URISyntaxException;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public abstract class MtrSectorRest extends JPACustomRest<MtrSectorResponse, MtrSector, Integer> {

    @Autowired
    protected MtrSectorDeltaRepository mtrSectorDeltaRepository;

    protected String setObtenerNombreArchivoExcel() {
        return "MtrSector";
    }

    /************************/
    /* Instancia de Bean    */
    /************************/
    protected final MtrSector createInstance() {
        MtrSector mtrSector = new MtrSector();
        return mtrSector;
    }

    /**
     * Find by por codigoSector
     */
    @ApiOperation(value = "Busca registro de tipo <T> en base a codigoSector", produces = "application/json")
    @GetMapping(value = "/_getByCodigoSector/{codigoSector}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<MtrSector> getByCodigoSector(@PathVariable String codigoSector) throws URISyntaxException {
        log.debug(this.NOMBRE_CLASE + " - Ingresando getByCodigoSector: " + codigoSector);
        try {
            return Optional.ofNullable(this.mtrSectorDeltaRepository.getByCodigoSector(codigoSector)).map(bean -> new ResponseEntity<>(bean, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
    public ResponseEntity<MtrSector> getByDescripcion(@PathVariable String descripcion) throws URISyntaxException {
        log.debug(this.NOMBRE_CLASE + " - Ingresando getByDescripcion: " + descripcion);
        try {
            return Optional.ofNullable(this.mtrSectorDeltaRepository.getByDescripcion(descripcion)).map(bean -> new ResponseEntity<>(bean, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
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

}
