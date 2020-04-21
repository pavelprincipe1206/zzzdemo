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
import com.incloud.hcp.common.graph.GraphBarChart;
import com.incloud.hcp.common.graph.GraphBean;
import com.incloud.hcp.common.graph.GraphDataset;
import com.incloud.hcp.common.graph.GraphPieChart;
import com.incloud.hcp.domain.*;
import com.incloud.hcp.domain.response.CerNotaPedidoHistorialResponse;
import com.incloud.hcp.exception.ServiceException;
import com.incloud.hcp.repository.delta.AppParametriaDeltaRepository;
import com.incloud.hcp.repository.delta.CerNotaPedidoDeltaRepository;
import com.incloud.hcp.repository.delta.CerNotaPedidoHistorialDeltaRepository;
import com.incloud.hcp.repository.delta.MtrEstadoDeltaRepository;
import com.incloud.hcp.service.CerNotaPedidoHistorialService;
import com.incloud.hcp.service._framework.bean.BeanCargaMasivoDTO;
import com.incloud.hcp.service._framework.bean.BeanListaMasivoDTO;
import com.incloud.hcp.service._framework.impl.JPACustomServiceImpl;
import com.incloud.hcp.service.delta.CerNotaPedidoDeltaService;
import com.incloud.hcp.service.delta.MtrEstadoDeltaService;
import com.incloud.hcp.service.requireNew.CerNotaPedidoHistorialRequireNewService;
import com.incloud.hcp.service.support.PageRequestByExample;
import com.incloud.hcp.utils.Constants;
import com.incloud.hcp.utils.DateUtils;
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
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * A simple DTO Facility for CerNotaPedidoHistorial.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public abstract class CerNotaPedidoHistorialServiceImpl extends JPACustomServiceImpl<CerNotaPedidoHistorialResponse, CerNotaPedidoHistorial, Integer>
        implements CerNotaPedidoHistorialService {

    protected final String NAME_SHEET = "CerNotaPedidoHistorial";
    protected final String CONFIG_TITLE = "com/incloud/hcp/excel/CerNotaPedidoHistorialExcel.xml";
    private final Integer REGISTROS_COLOR = 10;

    @Autowired
    protected AppParametriaDeltaRepository appParametriaDeltaRepository;

    @Autowired
    protected CerNotaPedidoHistorialDeltaRepository cerNotaPedidoHistorialDeltaRepository;

    @Autowired
    protected CerNotaPedidoHistorialRequireNewService cerNotaPedidoHistorialRequireNewService;

    @Autowired
    protected CerNotaPedidoDeltaService cerNotaPedidoDeltaService;

    @Autowired
    protected CerNotaPedidoDeltaRepository cerNotaPedidoDeltaRepository;

    @Autowired
    protected MtrEstadoDeltaService mtrEstadoDeltaService;

    @Autowired
    protected MtrEstadoDeltaRepository mtrEstadoDeltaRepository;

    /*****************************/
    /* Metodos de Busqueda       */
    /*****************************/

    protected final ExampleMatcher setAbstractFind(ExampleMatcher matcher) {
        matcher = ExampleMatcher.matching() //
                .withMatcher(CerNotaPedidoHistorial_.descripcion.getName(), match -> match.ignoreCase().startsWith())
                .withMatcher(CerNotaPedidoHistorial_.usuarioHistoral.getName(), match -> match.ignoreCase().startsWith());
        return matcher;
    }

    protected abstract Sort setFindAll(Sort sort);

    protected abstract Sort setFind(CerNotaPedidoHistorial req, ExampleMatcher matcher, Example<CerNotaPedidoHistorial> example, Sort sort);

    protected abstract void setFindPaginated(PageRequestByExample<CerNotaPedidoHistorial> req, ExampleMatcher matcher, Example<CerNotaPedidoHistorial> example);

    protected final CerNotaPedidoHistorial setObtenerBeanResponse(CerNotaPedidoHistorialResponse bean) {
        return bean.getBean();
    }

    protected final Class<CerNotaPedidoHistorial> setObtenerClassBean() {
        return CerNotaPedidoHistorial.class;
    }

    protected List<Predicate> setAbstractPredicate(CerNotaPedidoHistorialResponse bean, CriteriaBuilder cb, Root<CerNotaPedidoHistorial> root) {
        List<Predicate> predicates = new ArrayList<>();
        CerNotaPedidoHistorial entity = bean.getBean();
        /* Obtener condiciones */
        PredicateUtils.addPredicates(predicates, bean.getIdCondicion(), "id", entity.getId(), cb, root);
        PredicateUtils.addPredicates(predicates, bean.getDescripcionCondicion(), "descripcion", entity.getDescripcion(), cb, root);
        PredicateUtils.addPredicates(predicates, bean.getUsuarioHistoralCondicion(), "usuarioHistoral", entity.getUsuarioHistoral(), cb, root);
        PredicateUtils.addPredicates(predicates, bean.getFechaHistorialCondicion(), "fechaHistorial", entity.getFechaHistorial(), cb, root);
        //PredicateUtils.addPredicates(predicates, bean.getCerNotaPedidoCondicion(), "cerNotaPedido", entity.getCerNotaPedido(), cb, root);
        //PredicateUtils.addPredicates(predicates, bean.getMtrEstadoCondicion(), "mtrEstado", entity.getMtrEstado(), cb, root);
        /* Obtener valores de Lista */
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "id", bean.getIdList(), cb, root);
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "descripcion", bean.getDescripcionList(), cb, root);
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "usuarioHistoral", bean.getUsuarioHistoralList(), cb, root);
        PredicateUtils.addPredicatesListValorPrimitivo(predicates, "fechaHistorial", bean.getFechaHistorialList(), cb, root);
        //PredicateUtils.addPredicatesListValorBean(predicates, "cerNotaPedido", bean.getCerNotaPedidoList(), cb, root);
        //PredicateUtils.addPredicatesListValorBean(predicates, "mtrEstado", bean.getMtrEstadoList(), cb, root);
        return predicates;
    }

    /****************/
    /* METODOS CRUD */
    /****************/

    protected final String validacionesPrevias(CerNotaPedidoHistorial bean) throws Exception {
        String mensaje = "";
        if (!Optional.of(bean.getUsuarioHistoral()).isPresent()) {
            String msg = this.messageSource.getMessage("message.cerNotaPedidoHistorial.usuarioHistoral.requerido", null, LocaleContextHolder.getLocale());
            mensaje += "* " + msg + "<br/>";
        }
        if (!Optional.of(bean.getFechaHistorial()).isPresent()) {
            String msg = this.messageSource.getMessage("message.cerNotaPedidoHistorial.fechaHistorial.requerido", null, LocaleContextHolder.getLocale());
            mensaje += "* " + msg + "<br/>";
        }
        String msg = this.setValidacionesPrevias(bean);
        if (StringUtils.isNotBlank(msg)) {
            mensaje += "* " + msg + "<br/>";
        }
        return mensaje;
    }

    protected String setValidacionesPrevias(CerNotaPedidoHistorial bean) throws Exception {
        String mensaje = "";
        return mensaje;
    }

    protected String validacionesPreviasCreate(CerNotaPedidoHistorial bean) throws Exception {
        String msg = null;
        CerNotaPedidoHistorial validar = null;
        return msg;
    }

    protected String validacionesPreviasSave(CerNotaPedidoHistorial bean) throws Exception {
        String msg = null;
        CerNotaPedidoHistorial validar = null;
        return msg;
    }

    protected CerNotaPedidoHistorial completarDatosBean(CerNotaPedidoHistorial bean) throws Exception {
        BigDecimal data = new BigDecimal(0.00);
        bean = this.setCompletarDatosBean(bean);
        return bean;
    }

    protected CerNotaPedidoHistorial setCompletarDatosBean(CerNotaPedidoHistorial bean) throws Exception {
        return bean;
    }

    protected final CerNotaPedidoHistorial setAbstractCreate(CerNotaPedidoHistorial dto) throws Exception {
        CerNotaPedidoHistorial bean = new CerNotaPedidoHistorial();
        bean = (CerNotaPedidoHistorial) BeanUtils.cloneBean(dto);
        return bean;
    }

    /************************/
    /* METODOS CRUD Masivos */
    /************************/

    protected CerNotaPedidoHistorial setUploadExcel(Cell currentCell, CerNotaPedidoHistorial cerNotaPedidoHistorial, int contador) throws Exception {
        Double valorDouble = new Double(0);
        BigDecimal valorDecimal = new BigDecimal(0);
        Boolean valorBoolean = new Boolean(true);
        String valorCadena = "";
        switch (contador) {
        case 1:
            try {
                valorCadena = currentCell.getStringCellValue();
                if (valorCadena.length() > 200) {
                    throw new ServiceException("Valor Campo descripcion contiene mas de 200 caracter(es)");
                }
                cerNotaPedidoHistorial.setDescripcion(valorCadena);
            } catch (Exception e) {
                throw new ServiceException("Valor Campo descripcion está en formato incorrecto");
            }
            break;
        case 2:
            try {
                valorCadena = currentCell.getStringCellValue();
                if (valorCadena.length() > 20) {
                    throw new ServiceException("Valor Campo usuarioHistoral contiene mas de 20 caracter(es)");
                }
                cerNotaPedidoHistorial.setUsuarioHistoral(valorCadena);
            } catch (Exception e) {
                throw new ServiceException("Valor Campo usuarioHistoral está en formato incorrecto");
            }
            break;
        case 3:
            try {
                valorCadena = currentCell.getStringCellValue();
                Date valorFechaD = DateUtils.convertStringToDate("dd/MM/yyyy", valorCadena);
                cerNotaPedidoHistorial.setFechaHistorial(valorFechaD);
            } catch (Exception ex) {
                throw new ServiceException("Valor Campo fechaHistorial está en formato incorrecto");
            }
            break;
        default:
            break;
        }
        return cerNotaPedidoHistorial;
    }

    protected AppParametria setObtenerRegistroConfiguracionUploadExcel() {
        AppParametria appParametriaData = this.appParametriaDeltaRepository.getByModuloAndLabelAndStatus(AppParametriaModuloEnum.CARGA_EXCEL.getEstado(),
                AppParametriaLabelEnum.INICIO_REGISTRO_DATA.getEstado(), Constants.ESTADO_ACTIVO);
        return appParametriaData;
    }

    protected CerNotaPedidoHistorial setInicializarBeanUpdateExcel() {
        CerNotaPedidoHistorial bean = new CerNotaPedidoHistorial();
        bean.setId(null);
        return bean;
    }

    protected final Integer setObtenerId(CerNotaPedidoHistorial bean) {
        return bean.getId();
    }

    /************************/
    /* Instancia de Bean    */
    /************************/

    protected final CerNotaPedidoHistorial createInstance() {
        CerNotaPedidoHistorial cerNotaPedidoHistorial = new CerNotaPedidoHistorial();
        return cerNotaPedidoHistorial;
    }

    protected final BeanCargaMasivoDTO<CerNotaPedidoHistorial> createInstanceMasivoDTO() {
        BeanCargaMasivoDTO<CerNotaPedidoHistorial> beanCargaMasivoDTO = new BeanCargaMasivoDTO<CerNotaPedidoHistorial>();
        return beanCargaMasivoDTO;

    }

    protected final BeanListaMasivoDTO<BeanCargaMasivoDTO<CerNotaPedidoHistorial>> createInstanceListaMasivoDTO() {
        BeanListaMasivoDTO<BeanCargaMasivoDTO<CerNotaPedidoHistorial>> beanCargaMasivoDTOBeanListaMasivoDTO = new BeanListaMasivoDTO<BeanCargaMasivoDTO<CerNotaPedidoHistorial>>();
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

    protected int setAbstractDownloadExcel(CerNotaPedidoHistorial bean, HSSFRow dataRow) {
        int contador = 0;
        ExcelDefault.setValueCell(bean.getId(), dataRow.createCell(contador));
        contador++;
        ExcelDefault.setValueCell(bean.getDescripcion(), dataRow.createCell(contador));
        contador++;
        ExcelDefault.setValueCell(bean.getUsuarioHistoral(), dataRow.createCell(contador));
        contador++;
        ExcelDefault.setValueCell(bean.getFechaHistorial(), dataRow.createCell(contador));
        contador++;
        return contador;
    }

    protected int setAbstractDownloadExcelSXLSX(CerNotaPedidoHistorial bean, Row dataRow, List<CellStyle> cellStyleList) {
        int contador = 0;
        ExcelDefault.setValueCell(bean.getId(), dataRow.createCell(contador), "I", cellStyleList);
        contador++;
        ExcelDefault.setValueCell(bean.getDescripcion(), dataRow.createCell(contador), "S", cellStyleList);
        contador++;
        ExcelDefault.setValueCell(bean.getUsuarioHistoral(), dataRow.createCell(contador), "S", cellStyleList);
        contador++;
        ExcelDefault.setValueCell(bean.getFechaHistorial(), dataRow.createCell(contador), "DT", cellStyleList);
        contador++;
        return contador;
    }

    protected String setAbstractGenerateInsertExcelSXLSX(CerNotaPedidoHistorial bean) {
        String fechaS = "";
        String sqlInsert = "INSERT INTO cer_nota_pedido_historial(";
        sqlInsert = sqlInsert + "cer_nota_pedido_historial_id" + ", ";
        sqlInsert = sqlInsert + "descripcion" + ", ";
        sqlInsert = sqlInsert + "usuario_historal" + ", ";
        sqlInsert = sqlInsert + "fecha_historial" + ", ";
        sqlInsert = sqlInsert + "cer_nota_pedido_id" + ", ";
        sqlInsert = sqlInsert + "mtr_estado_id" + ")";
        sqlInsert = sqlInsert + " VALUES (";
        sqlInsert = sqlInsert + bean.getId() + ", ";
        if (StringUtils.isBlank(bean.getDescripcion())) {
            sqlInsert = sqlInsert + "null" + ", ";
        } else {
            sqlInsert = sqlInsert + "'" + bean.getDescripcion() + "'" + ", ";
        }
        if (StringUtils.isBlank(bean.getUsuarioHistoral())) {
            sqlInsert = sqlInsert + "null" + ", ";
        } else {
            sqlInsert = sqlInsert + "'" + bean.getUsuarioHistoral() + "'" + ", ";
        }
        if (bean.getFechaHistorial() != null) {
            fechaS = DateUtils.convertDateToString("dd/MM/yyyy HH:mm:ss", bean.getFechaHistorial());
            sqlInsert = sqlInsert + "to_date('" + fechaS + "','dd/MM/yyyy HH:mm:ss')" + ", ";
        } else {
            sqlInsert = sqlInsert + "null" + ", ";
        }
        sqlInsert = sqlInsert + bean.getCerNotaPedido().getId() + ", ";
        sqlInsert = sqlInsert + bean.getMtrEstado().getId();
        sqlInsert = sqlInsert + " );";
        return sqlInsert;
    }

    /*****************/
    /* Otros Metodos */
    /*****************/

    public Long countByCerNotaPedido(CerNotaPedido cerNotaPedido) {
        return this.cerNotaPedidoHistorialDeltaRepository.countByCerNotaPedido(cerNotaPedido);
    }

    public GraphBean graphByCerNotaPedido() {
        List<CerNotaPedido> lista = this.cerNotaPedidoDeltaRepository.findAll();
        if (lista == null || lista.size() <= 0) {
            return null;
        }
        GraphBean graphBean = new GraphBean();

        /* Obteniendo Pie Chart */
        GraphPieChart graphPieChart = new GraphPieChart();
        GraphDataset graphDataset = new GraphDataset();
        GraphDataset[] listaGraphDataset = new GraphDataset[1];
        Long[] data = new Long[lista.size()];
        String[] labels = new String[lista.size()];
        String[] backgroundColor = new String[lista.size()];
        String[] hoverBackgroundColor = new String[lista.size()];
        String[] borderColor = new String[lista.size()];
        String[] hoverBorderColor = new String[lista.size()];
        int contador = 0;
        int contadorColor = 0;
        for (CerNotaPedido bean : lista) {
            Long valor = this.cerNotaPedidoHistorialDeltaRepository.countByCerNotaPedido(bean);
            String descripcion = this.setGraphDescripcionByCerNotaPedido(bean);
            data[contador] = valor;
            labels[contador] = descripcion;
            backgroundColor[contador] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBackgroundColor[contador] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            borderColor[contador] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBorderColor[contador] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            contador++;
            contadorColor++;
            if (contadorColor >= REGISTROS_COLOR) {
                contadorColor = 1;
            }
        }
        String titulo = this.setGraphPieChartTituloByCerNotaPedido();
        graphDataset.setLabel(titulo);
        graphDataset.setData(data);
        graphDataset.setBackgroundColor(backgroundColor);
        graphDataset.setHoverBackgroundColor(hoverBackgroundColor);
        listaGraphDataset[0] = graphDataset;
        graphPieChart.setDatasets(listaGraphDataset);
        graphPieChart.setLabels(labels);
        graphBean.setPiechart(graphPieChart);

        GraphBarChart graphBarChart = new GraphBarChart();
        GraphDataset[] listaGraphDatasetBar = new GraphDataset[lista.size()];
        String[] labelsBar = new String[1];
        labelsBar[0] = this.setGraphBarChartTituloByCerNotaPedido();
        contador = 0;
        contadorColor = 0;
        for (CerNotaPedido bean : lista) {
            Long valor = this.cerNotaPedidoHistorialDeltaRepository.countByCerNotaPedido(bean);
            String descripcion = this.setGraphDescripcionByCerNotaPedido(bean);
            GraphDataset graphDatasetBar = new GraphDataset();
            Long[] dataBar = new Long[1];

            String[] backgroundColorBar = new String[1];
            String[] hoverBackgroundColorBar = new String[1];
            String[] borderColorBar = new String[1];
            String[] hoverBorderColorBar = new String[1];

            dataBar[0] = valor;
            backgroundColorBar[0] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBackgroundColorBar[0] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            borderColorBar[0] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBorderColorBar[0] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];

            graphDatasetBar.setLabel(descripcion);
            graphDatasetBar.setData(dataBar);
            graphDatasetBar.setBackgroundColor(backgroundColorBar);
            graphDatasetBar.setHoverBackgroundColor(hoverBackgroundColorBar);
            graphDatasetBar.setBorderColor(borderColorBar);
            graphDatasetBar.setHoverBorderColor(hoverBorderColorBar);
            listaGraphDatasetBar[contador] = graphDatasetBar;

            contador++;
            contadorColor++;
            if (contadorColor >= REGISTROS_COLOR) {
                contadorColor = 1;
            }

        }
        graphBarChart.setDatasets(listaGraphDatasetBar);
        graphBarChart.setLabels(labelsBar);
        graphBean.setBarchart(graphBarChart);
        return graphBean;
    }

    protected String setGraphDescripcionByCerNotaPedido(CerNotaPedido cerNotaPedido) {
        return cerNotaPedido.getId().toString();
    }

    protected String setGraphPieChartTituloByCerNotaPedido() {
        return "CerNotaPedido";
    }

    protected String setGraphBarChartTituloByCerNotaPedido() {
        return "CerNotaPedido";
    }

    public Long countByMtrEstado(MtrEstado mtrEstado) {
        return this.cerNotaPedidoHistorialDeltaRepository.countByMtrEstado(mtrEstado);
    }

    public GraphBean graphByMtrEstado() {
        List<MtrEstado> lista = this.mtrEstadoDeltaRepository.findAll();
        if (lista == null || lista.size() <= 0) {
            return null;
        }
        GraphBean graphBean = new GraphBean();

        /* Obteniendo Pie Chart */
        GraphPieChart graphPieChart = new GraphPieChart();
        GraphDataset graphDataset = new GraphDataset();
        GraphDataset[] listaGraphDataset = new GraphDataset[1];
        Long[] data = new Long[lista.size()];
        String[] labels = new String[lista.size()];
        String[] backgroundColor = new String[lista.size()];
        String[] hoverBackgroundColor = new String[lista.size()];
        String[] borderColor = new String[lista.size()];
        String[] hoverBorderColor = new String[lista.size()];
        int contador = 0;
        int contadorColor = 0;
        for (MtrEstado bean : lista) {
            Long valor = this.cerNotaPedidoHistorialDeltaRepository.countByMtrEstado(bean);
            String descripcion = this.setGraphDescripcionByMtrEstado(bean);
            data[contador] = valor;
            labels[contador] = descripcion;
            backgroundColor[contador] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBackgroundColor[contador] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            borderColor[contador] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBorderColor[contador] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            contador++;
            contadorColor++;
            if (contadorColor >= REGISTROS_COLOR) {
                contadorColor = 1;
            }
        }
        String titulo = this.setGraphPieChartTituloByMtrEstado();
        graphDataset.setLabel(titulo);
        graphDataset.setData(data);
        graphDataset.setBackgroundColor(backgroundColor);
        graphDataset.setHoverBackgroundColor(hoverBackgroundColor);
        listaGraphDataset[0] = graphDataset;
        graphPieChart.setDatasets(listaGraphDataset);
        graphPieChart.setLabels(labels);
        graphBean.setPiechart(graphPieChart);

        GraphBarChart graphBarChart = new GraphBarChart();
        GraphDataset[] listaGraphDatasetBar = new GraphDataset[lista.size()];
        String[] labelsBar = new String[1];
        labelsBar[0] = this.setGraphBarChartTituloByMtrEstado();
        contador = 0;
        contadorColor = 0;
        for (MtrEstado bean : lista) {
            Long valor = this.cerNotaPedidoHistorialDeltaRepository.countByMtrEstado(bean);
            String descripcion = this.setGraphDescripcionByMtrEstado(bean);
            GraphDataset graphDatasetBar = new GraphDataset();
            Long[] dataBar = new Long[1];

            String[] backgroundColorBar = new String[1];
            String[] hoverBackgroundColorBar = new String[1];
            String[] borderColorBar = new String[1];
            String[] hoverBorderColorBar = new String[1];

            dataBar[0] = valor;
            backgroundColorBar[0] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBackgroundColorBar[0] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];
            borderColorBar[0] = Constants.BACKGROUND_COLOR_GRAPH[contadorColor];
            hoverBorderColorBar[0] = Constants.HOVER_BACKGROUND_COLOR_GRAPH[contadorColor];

            graphDatasetBar.setLabel(descripcion);
            graphDatasetBar.setData(dataBar);
            graphDatasetBar.setBackgroundColor(backgroundColorBar);
            graphDatasetBar.setHoverBackgroundColor(hoverBackgroundColorBar);
            graphDatasetBar.setBorderColor(borderColorBar);
            graphDatasetBar.setHoverBorderColor(hoverBorderColorBar);
            listaGraphDatasetBar[contador] = graphDatasetBar;

            contador++;
            contadorColor++;
            if (contadorColor >= REGISTROS_COLOR) {
                contadorColor = 1;
            }

        }
        graphBarChart.setDatasets(listaGraphDatasetBar);
        graphBarChart.setLabels(labelsBar);
        graphBean.setBarchart(graphBarChart);
        return graphBean;
    }

    protected String setGraphDescripcionByMtrEstado(MtrEstado mtrEstado) {
        return mtrEstado.getId().toString();
    }

    protected String setGraphPieChartTituloByMtrEstado() {
        return "MtrEstado";
    }

    protected String setGraphBarChartTituloByMtrEstado() {
        return "MtrEstado";
    }

}
