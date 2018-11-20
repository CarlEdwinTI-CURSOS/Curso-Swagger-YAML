package io.swagger.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;
import io.swagger.customizacao.service.ClienteService;
import io.swagger.customizacao.util.RespostasUtil;
import io.swagger.model.Cliente;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-10-27T23:17:19.797Z")

@Controller
public class ClienteApiController implements ClienteApi {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private RespostasUtil respostasUtil;
	
    public ResponseEntity<Cliente> cadastraCliente(@ApiParam(value = ""  )  @Valid @RequestBody Cliente cliente_) {
        
    	try {
            return clienteService.salva(cliente_);
         } catch (Exception e) {
          return respostasUtil.getErroInternoCliente(ClienteService.FALHA_AO_TENTAR_CADASTRAR_UM_CLIENTE);
         }
    }

}
