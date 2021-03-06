/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/dto/EntityDTO.java.e.vm
 */
package com.incloud.hcp.service;

import com.incloud.hcp.common.graph.GraphBean;
import com.incloud.hcp.domain.Boleta;
import com.incloud.hcp.domain.Item;
import com.incloud.hcp.domain.response.ItemResponse;
import com.incloud.hcp.service._framework.JPACustomService;

/**
 * Simple Interface for Item.
 */
public interface ItemService extends JPACustomService<ItemResponse, Item, Integer> {

    Long countByBoleta(Boleta idBoleta);

    GraphBean graphByBoleta();

}
