package io.swagger.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import io.swagger.annotations.ApiParam;
import io.swagger.customizacao.service.ContaService;
import io.swagger.customizacao.util.RespostasUtil;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-10-27T23:17:19.797Z")

@Controller
public class ContaApiController implements ContaApi {

	@Autowired
	private ContaService contaService;

	@Autowired
	private RespostasUtil respostasUtil;
    
    @org.springframework.beans.factory.annotation.Autowired
    public ContaApiController() {
    }

    public ResponseEntity<Double> consultaSaldo(@ApiParam(value = "",required=true) @PathVariable("agencia") Integer agencia,
    											@ApiParam(value = "",required=true) @PathVariable("numero") Long numero,
    											@ApiParam(value = "",required=true) @PathVariable("digito") Integer digito,
    											@ApiParam(value = "" ,required=true) 
    											@RequestHeader(value="Authorization", required=true) String authorization) {
    	try {
			return contaService.consultaSaldo(authorization, agencia, numero, digito);
		} catch (Exception e) {
			return respostasUtil.getErroInternoDouble(RespostasUtil.MENSAGEM_FALHA_AO_TENTAR_CONSULTAR_SALDO);
		}
    }

}
