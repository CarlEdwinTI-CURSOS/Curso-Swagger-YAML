package io.swagger.customizacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.swagger.customizacao.entity.ClienteEntity;
import io.swagger.customizacao.entity.ContaEntity;
import io.swagger.customizacao.entity.TransacaoEntity;
import io.swagger.customizacao.repository.Contas;
import io.swagger.customizacao.util.RespostasUtil;
import io.swagger.model.Extrato;
import io.swagger.model.Transacao;
import io.swagger.model.Transacao.TipoEnum;

@Service
public class ContaService {
	
	private static final String NAO_EXISTEM_TRANSACOES_CONTA = "Não existem transações para esta conta.";
	
	private static final String DEBITO = TipoEnum.DEBITO.toString();
	
	private static final String DEPOSITO = TipoEnum.DEPOSITO.toString();

	private static final String MENSAGEM_CONTA_NAO_ENCONTRADA = "Conta não encontrada.";

	private static final String MENSAGEM_NAO_AUTORIZADO = "Cliente não autorizado.";

	@Autowired
    private Contas contas;
	
	@Autowired
    private RespostasUtil respostasUtil;
	
	@Autowired
	private ClienteService clienteService;

	public ResponseEntity<Extrato> consultaExtrato(String authorization, Integer agencia, Long conta, Integer digito) {
		ClienteEntity clienteEntity = clienteService.getClienteByAuthorization(authorization);
		
		if(clienteEntity == null) {
			return respostasUtil.getExtratoNaoAutorizado(MENSAGEM_NAO_AUTORIZADO);
		}
		
		ContaEntity contaEntity = contas.findByAgenciaAndNumeroAndDigitoAndCliente(agencia, conta, digito, clienteEntity);
		
		if(contaEntity == null) {
			return respostasUtil.getRequisicaoInvalidaExtrato(MENSAGEM_CONTA_NAO_ENCONTRADA);
		}
		
		if(contaEntity.getTransacoes() == null || contaEntity.getTransacoes().isEmpty()) {
			return respostasUtil.getNaoEncontradoExtrato(NAO_EXISTEM_TRANSACOES_CONTA);
		}
		
		Extrato extrato = new Extrato();
		
		for(TransacaoEntity transacaoEntity : contaEntity.getTransacoes()) {
			
			Transacao transacao = new Transacao();
			transacao.setId(transacaoEntity.getId());
			transacao.setValor(transacaoEntity.getValor());
			
			if(DEBITO.equalsIgnoreCase(transacaoEntity.getTipo())) {
				transacao.setTipo(TipoEnum.DEBITO);
			}else if(DEPOSITO.equalsIgnoreCase(transacaoEntity.getTipo())){
				transacao.setTipo(TipoEnum.DEPOSITO);
			}
			
			extrato.addTransacoesItem(transacao );
		}
		
		return new ResponseEntity<Extrato>(extrato, HttpStatus.OK);
	}
	
	public ResponseEntity<Double> consultaSaldo(String authorization, Integer agencia, Long conta, Integer digito) {
		
		ClienteEntity clienteEntity = clienteService.getClienteByAuthorization(authorization);

		if (clienteEntity == null) {
			return respostasUtil.getNaoAutorizadoDouble(MENSAGEM_NAO_AUTORIZADO);
		}
		
		ContaEntity contaEntity = contas.findByAgenciaAndNumeroAndDigitoAndCliente(agencia, conta, digito, clienteEntity);

		if (contaEntity == null) {
		    return respostasUtil.getRequisicaoInvalidaDouble(MENSAGEM_CONTA_NAO_ENCONTRADA);
		}
		
		return new ResponseEntity<Double>(contaEntity.getSaldo(), HttpStatus.OK);
	}
}
