/*
 * Project home: https://github.com/jaxio/celerio-angular-quickstart
 * 
 * Source code generated by Celerio, an Open Source code generator by Jaxio.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Modificado por CARLOS BAZALAR
 * Email: cbazalarlarosa@gmail.com
 * Template pack-angular:src/main/java/dto/EntityDTOService.java.e.vm
 */
package com.incloud.hcp.service.impl;

import com.incloud.hcp.common.enums.AppParametriaLabelEnum;
import com.incloud.hcp.common.enums.AppParametriaModuloEnum;
import com.incloud.hcp.common.excel.ExcelDefault;
import com.incloud.hcp.domain.AppParametria;
import com.incloud.hcp.domain.MtrGrupoArticulo;
import com.incloud.hcp.domain.MtrGrupoArticulo_;
import com.incloud.hcp.domain.response.MtrGrupoArticuloResponse;
import com.incloud.hcp.exception.ServiceException;
import com.incloud.hcp.repository.delta.AppParametriaDeltaRepository;
import com.incloud.hcp.repository.delta.MtrGrupoArticuloDeltaRepository;
import com.incloud.hcp.service.MtrGrupoArticuloService;
import com.incloud.hcp.service._framework.bean.BeanCargaMasivoDTO;
import com.incloud.hcp.service._framework.bean.BeanListaMasivoDTO;
import com.incloud.hcp.service._framework.impl.JPACustomServiceImpl;
import com.incloud.hcp.service.requireNew.MtrGrupoArticuloRequireNewService;
import com.incloud.hcp.service.support.PageRequestByExample;
import com.incloud.hcp.utils.Constants;
import com.incloud.hcp.utils.PredicateUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A simple DTO Facility for MtrGrupoArticulo.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public abstract class MtrGrupoArticuloServiceImpl extends JPACustomServiceImpl<MtrGrupoArticuloResponse, MtrGrupoArticulo, Integer>
        implements MtrGrupoArticuloService {

    protected final String NAME_SHEET = "MtrGrupoArticulo";
    protected final String CONFIG_TITLE = "com/incloud/hcp/excel/MtrGrupoArticuloExcel.xml";
    private final Integer REGISTROS_COLOR = 10;

    @Autowired
    protected AppParametriaDeltaRepository appParametriaDeltaRepository;

    @Autowired
    protected MtrGrupoArticuloDeltaRepository mtrGrupoArticuloDeltaRepository;

    @Autowired
    protected MtrGrupoArticuloRequireNewService mtrGrupoArticuloRequireNewService;

    /*****************************/
    /* Metodos de Busqueda       */
    /*****************************/

    protected final ExampleMatcher setAbstractFind(ExampleMatcher matcher) {
        matcher = ExampleMatcher.matching() //
                .withMatcher(MtrGrupoArticulo_.codigoSap.getName(), match -> match.ignoreCase().startsWith())
                .withMatcher(MtrGrupoArticulo_.descripcion.getName(), match -> match.ignoreCase().startsWith());
        return matcher;
    }

    protected abstract Sort setFindAll(Sort sort);

    protected abstract Sort setFind(MtrGrupoArticulo req, ExampleMatcher matcher, Example<MtrGrupoArticulo> example, Sort sort);

    protected abstract void setFindPaginated(PageRequestByExample<MtrGrupoArticulo> req, ExampleMatcher matcher, Example<MtrGrupoArticulo> example);

    protected final MtrGrupoArticulo setObtenerBeanResponse(MtrGrupoArticuloResponse bean) {
        return bean.getBean();
    }

    protected final Class<MtrGrupoArticulo> setObtenerClassBean() {
        return MtrGrupoArticulo.class;
    }

    protected List<Predicate> setAbstractPredicate(MtrGrupoArticuloResponse bean, CriteriaBuilder cb, Root<MtrGrupoArticulo> root) {
        List<Predicate> predicates = new ArrayList<>();
        MtrGrupoArticulo entity = bean.getBean();
        /* Obtener condiciones */
        PredicateUtils.addPredicates(predicates, bean.getIdCondicion(), "id", entity.getId(), cb, root);
        PredicateUtils.addPredicates(predicates, bean.getCodigoSapCondicion(), "codigoSap", entity.getCodigoSap(), cb, root);
        PredicateUtils.addPredicates(predicates, bean.getDescripcionCondicion(), "descripcion", entity.getDescripcion(), cb, root);
        /* Obtener valores de Lista */
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "id", bean.getIdList(), cb, root);
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "codigoSap", bean.getCodigoSapList(), cb, root);
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "descripcion", bean.getDescripcionList(), cb, root);
        return predicates;
    }

    /****************/
    /* METODOS CRUD */
    /****************/

    protected final String validacionesPrevias(MtrGrupoArticulo bean) throws Exception {
        String mensaje = "";
        if (!Optional.of(bean.getCodigoSap()).isPresent()) {
            String msg = this.messageSource.getMessage("message.mtrGrupoArticulo.codigoSap.requerido", null, LocaleContextHolder.getLocale());
            mensaje += "* " + msg + "<br/>";
        }
        if (!Optional.of(bean.getDescripcion()).isPresent()) {
            String msg = this.messageSource.getMessage("message.mtrGrupoArticulo.descripcion.requerido", null, LocaleContextHolder.getLocale());
            mensaje += "* " + msg + "<br/>";
        }
        String msg = this.setValidacionesPrevias(bean);
        if (StringUtils.isNotBlank(msg)) {
            mensaje += "* " + msg + "<br/>";
        }
        return mensaje;
    }

    protected String setValidacionesPrevias(MtrGrupoArticulo bean) throws Exception {
        String mensaje = "";
        return mensaje;
    }

    protected String validacionesPreviasCreate(MtrGrupoArticulo bean) throws Exception {
        String msg = null;
        MtrGrupoArticulo validar = null;
        validar = this.mtrGrupoArticuloDeltaRepository.getByCodigoSap(bean.getCodigoSap());
        if (Optional.ofNullable(validar).isPresent()) {
            msg = this.messageSource.getMessage("message.mtrGrupoArticulo.codigoSap.duplicado", null, LocaleContextHolder.getLocale());
            return msg;
        }
        validar = this.mtrGrupoArticuloDeltaRepository.getByDescripcion(bean.getDescripcion());
        if (Optional.ofNullable(validar).isPresent()) {
            msg = this.messageSource.getMessage("message.mtrGrupoArticulo.descripcion.duplicado", null, LocaleContextHolder.getLocale());
            return msg;
        }
        return msg;
    }

    protected String validacionesPreviasSave(MtrGrupoArticulo bean) throws Exception {
        String msg = null;
        MtrGrupoArticulo validar = null;
        validar = this.mtrGrupoArticuloDeltaRepository.getByCodigoSap(bean.getCodigoSap());
        if (Optional.ofNullable(validar).isPresent()) {
            if (bean.getId().intValue() != validar.getId().intValue()) {
                msg = this.messageSource.getMessage("message.mtrGrupoArticulo.codigoSap.duplicado", null, LocaleContextHolder.getLocale());
                return msg;
            }
        }
        validar = this.mtrGrupoArticuloDeltaRepository.getByDescripcion(bean.getDescripcion());
        if (Optional.ofNullable(validar).isPresent()) {
            if (bean.getId().intValue() != validar.getId().intValue()) {
                msg = this.messageSource.getMessage("message.mtrGrupoArticulo.descripcion.duplicado", null, LocaleContextHolder.getLocale());
                return msg;
            }
        }
        return msg;
    }

    protected MtrGrupoArticulo completarDatosBean(MtrGrupoArticulo bean) throws Exception {
        BigDecimal data = new BigDecimal(0.00);
        bean = this.setCompletarDatosBean(bean);
        return bean;
    }

    protected MtrGrupoArticulo setCompletarDatosBean(MtrGrupoArticulo bean) throws Exception {
        return bean;
    }

    protected final MtrGrupoArticulo setAbstractCreate(MtrGrupoArticulo dto) throws Exception {
        MtrGrupoArticulo bean = new MtrGrupoArticulo();
        bean = (MtrGrupoArticulo) BeanUtils.cloneBean(dto);
        return bean;
    }

    /************************/
    /* METODOS CRUD Masivos */
    /************************/

    protected MtrGrupoArticulo setUploadExcel(Cell currentCell, MtrGrupoArticulo mtrGrupoArticulo, int contador) throws Exception {
        Double valorDouble = new Double(0);
        BigDecimal valorDecimal = new BigDecimal(0);
        Boolean valorBoolean = new Boolean(true);
        String valorCadena = "";
        switch (contador) {
        case 1:
            try {
                valorCadena = currentCell.getStringCellValue();
                if (valorCadena.length() > 10) {
                    throw new ServiceException("Valor Campo codigoSap contiene mas de 10 caracter(es)");
                }
                mtrGrupoArticulo.setCodigoSap(valorCadena);
            } catch (Exception e) {
                throw new ServiceException("Valor Campo codigoSap está en formato incorrecto");
            }
            break;
        case 2:
            try {
                valorCadena = currentCell.getStringCellValue();
                if (valorCadena.length() > 60) {
                    throw new ServiceException("Valor Campo descripcion contiene mas de 60 caracter(es)");
                }
                mtrGrupoArticulo.setDescripcion(valorCadena);
            } catch (Exception e) {
                throw new ServiceException("Valor Campo descripcion está en formato incorrecto");
            }
            break;
        default:
            break;
        }
        return mtrGrupoArticulo;
    }

    protected AppParametria setObtenerRegistroConfiguracionUploadExcel() {
        AppParametria appParametriaData = this.appParametriaDeltaRepository.getByModuloAndLabelAndStatus(AppParametriaModuloEnum.CARGA_EXCEL.getEstado(),
                AppParametriaLabelEnum.INICIO_REGISTRO_DATA.getEstado(), Constants.ESTADO_ACTIVO);
        return appParametriaData;
    }

    protected MtrGrupoArticulo setInicializarBeanUpdateExcel() {
        MtrGrupoArticulo bean = new MtrGrupoArticulo();
        bean.setId(null);
        return bean;
    }

    protected final Integer setObtenerId(MtrGrupoArticulo bean) {
        return bean.getId();
    }

    /************************/
    /* Instancia de Bean    */
    /************************/

    protected final MtrGrupoArticulo createInstance() {
        MtrGrupoArticulo mtrGrupoArticulo = new MtrGrupoArticulo();
        return mtrGrupoArticulo;
    }

    protected final BeanCargaMasivoDTO<MtrGrupoArticulo> createInstanceMasivoDTO() {
        BeanCargaMasivoDTO<MtrGrupoArticulo> beanCargaMasivoDTO = new BeanCargaMasivoDTO<MtrGrupoArticulo>();
        return beanCargaMasivoDTO;

    }

    protected final BeanListaMasivoDTO<BeanCargaMasivoDTO<MtrGrupoArticulo>> createInstanceListaMasivoDTO() {
        BeanListaMasivoDTO<BeanCargaMasivoDTO<MtrGrupoArticulo>> beanCargaMasivoDTOBeanListaMasivoDTO = new BeanListaMasivoDTO<BeanCargaMasivoDTO<MtrGrupoArticulo>>();
        return beanCargaMasivoDTOBeanListaMasivoDTO;
    }

    /*****************************/
    /* Metodos que generan Excel */
    /*****************************/

    protected String devuelveNombreSheet() {
        return this.NAME_SHEET;
    }

    protected String devuelveListaHeaderExcelXML() {
        return this.CONFIG_TITLE;
    }

    protected int setAbstractDownloadExcel(MtrGrupoArticulo bean, HSSFRow dataRow) {
        int contador = 0;
        ExcelDefault.setValueCell(bean.getId(), dataRow.createCell(contador));
        contador++;
        ExcelDefault.setValueCell(bean.getCodigoSap(), dataRow.createCell(contador));
        contador++;
        ExcelDefault.setValueCell(bean.getDescripcion(), dataRow.createCell(contador));
        contador++;
        return contador;
    }

    protected int setAbstractDownloadExcelSXLSX(MtrGrupoArticulo bean, Row dataRow, List<CellStyle> cellStyleList) {
        int contador = 0;
        ExcelDefault.setValueCell(bean.getId(), dataRow.createCell(contador), "I", cellStyleList);
        contador++;
        ExcelDefault.setValueCell(bean.getCodigoSap(), dataRow.createCell(contador), "S", cellStyleList);
        contador++;
        ExcelDefault.setValueCell(bean.getDescripcion(), dataRow.createCell(contador), "S", cellStyleList);
        contador++;
        return contador;
    }

    protected String setAbstractGenerateInsertExcelSXLSX(MtrGrupoArticulo bean) {
        String fechaS = "";
        String sqlInsert = "INSERT INTO mtr_grupo_articulo(";
        sqlInsert = sqlInsert + "mtr_grupo_articulo_id" + ", ";
        sqlInsert = sqlInsert + "codigo_sap" + ", ";
        sqlInsert = sqlInsert + "descripcion" + ")";
        sqlInsert = sqlInsert + " VALUES (";
        sqlInsert = sqlInsert + bean.getId() + ", ";
        if (StringUtils.isBlank(bean.getCodigoSap())) {
            sqlInsert = sqlInsert + "null" + ", ";
        } else {
            sqlInsert = sqlInsert + "'" + bean.getCodigoSap() + "'" + ", ";
        }
        if (StringUtils.isBlank(bean.getDescripcion())) {
            sqlInsert = sqlInsert + "null";
        } else {
            sqlInsert = sqlInsert + "'" + bean.getDescripcion() + "'";
        }
        sqlInsert = sqlInsert + " );";
        return sqlInsert;
    }

    /*****************/
    /* Otros Metodos */
    /*****************/

}