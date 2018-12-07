package io.swagger.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import io.swagger.customizacao.service.TransacaoService;
import io.swagger.customizacao.util.RespostasUtil;
import io.swagger.model.Transacao;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-10-27T23:17:19.797Z")

@Controller
public class TransacaoApiController implements TransacaoApi {

    private final HttpServletRequest request;
    
	@Autowired
	private TransacaoService transacaoService;

	@Autowired
	private RespostasUtil respostasUtil;

    @org.springframework.beans.factory.annotation.Autowired
    public TransacaoApiController(HttpServletRequest request) {
        this.request = request;
    }

    public ResponseEntity<Void> alteraValorTransacao(@ApiParam(value = "",required=true) @PathVariable("codigo") Long codigo,
    												@NotNull @ApiParam(value = "", required = true) 
    												@Valid @RequestParam(value = "valor", required = true) Double valor,
    												@ApiParam(value = "" ,required=true) 
    												@RequestHeader(value="Authorization", required=true) String authorization) {
    	try {
			return transacaoService.atualiza(authorization, codigo, valor);
		} catch (Exception e) {
			return respostasUtil.getErroInterno(RespostasUtil.MENSAGEM_FALHA_AO_TENTAR_ATUALIZAR_TRANSACAO);
		}
    }

    public ResponseEntity<Transacao> cadastraTransacao(@ApiParam(value = "" ,required=true) 
    													@RequestHeader(value="Authorization", required=true) String authorization,
    													@ApiParam(value = "" ,required=true )  @Valid @RequestBody Transacao transacao,
    													@NotNull @ApiParam(value = "", required = true, allowableValues = "debito, deposito") 
    													@Valid @RequestParam(value = "tipo", required = true) String tipo) {
    	try {
			return transacaoService.salva(authorization, transacao, tipo);
		} catch (Exception e) {
			return respostasUtil.getErroInternoTransacao(RespostasUtil.MENSAGEM_FALHA_AO_SALVAR_TRANSACAO);
		}
        
    }

    public ResponseEntity<Void> excluiTransacao(@ApiParam(value = "",required=true) @PathVariable("codigo") Long codigo,@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
