package io.swagger.customizacao.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.swagger.customizacao.entity.ClienteEntity;
import io.swagger.customizacao.entity.ContaEntity;
import io.swagger.customizacao.entity.TransacaoEntity;
import io.swagger.customizacao.repository.Contas;
import io.swagger.customizacao.repository.Transacoes;
import io.swagger.customizacao.util.RespostasUtil;
import io.swagger.model.Transacao;
import io.swagger.model.Transacao.TipoEnum;

@Service
public class TransacaoService {

	private static final String MENSAGEM_DADOS_DE_CONTA_INVALIDOS = "Dados de Conta inválidos!";

	private static final String MENSAGEM_CONTA_NAO_INFORMADA = "Conta não informada!";

	private static final String MENSAGEM_VALOR_DA_TRANSACAO_NAO_INFORMADO = "Valor da transação não informado!";

	private static final String MENSAGEM_TIPO_DE_TRANSACAO_INVALIDO = "Tipo de transação inválido!";

	private static final String MENSAGEM_TRANSACAO_EXCLUÍDA_COM_SUCESSO = "Transação excluída com sucesso!";

	private static final String MENSAGEM_NAO_FOI_POSSÍVEL_EXCLUIR_A_TRANSACAO = "Não foi possível excluir a transação.";

	private static final String MENSAGEM_NAO_FOI_POSSÍVEL_ENCONTRAR_O_TIPO_DA_TRANSACAO = "Não foi possível encontrar o tipo da transação";

	private static final String MENSAGEM_NAO_FOI_POSSÍVEL_RECUPERAR_CONTA_ASSOCIADA_A_TRANSACAO = "Não foi possível recuperar conta associada a transação.";
	
    private static final String MENSAGEM_FALHA_AO_SALVAR_TRANSACAO = "Falha ao salvar transação.";

	private static final String MENSAGEM_CONTA_NAO_ENCONTRADA = "Conta não encontrada.";

	private static final String MENSAGEM_TRANSACAO_NAO_ENCONTRADA = "Transação não encontrada.";

	private static final String MENSAGEM_NAO_AUTORIZADO = "Cliente não autorizado.";

	private static final String DEBITO = TipoEnum.DEBITO.toString();

	private static final String DEPOSITO = TipoEnum.DEPOSITO.toString();

	private static final String MENSAGEM_TRANSACAO_ATUALIZADA_COM_SUCESSO = "Transação atualizada com sucesso!";

	private static final String MENSAGEM_TIPO_DE_TRANSAÇÃO_INVALIDO = "Tipo de transação inválido.";

	private static final String MENSAGEM_VALOR_INVÁLIDO = "Valor inválido.";

	
	@Autowired
    private Transacoes transacoes;
	
	@Autowired
    private Contas contas;
	
	@Autowired
    private RespostasUtil respostasUtil;
	
	@Autowired
	private ClienteService clienteService;
	
	public ResponseEntity<Transacao> salva(String authorization, Transacao transacao, String tipo) {

		ClienteEntity clienteEntity = clienteService.getClienteByAuthorization(authorization);

		if (clienteEntity == null) {
			return respostasUtil.getRequisicaoInvalidaTransacao(MENSAGEM_NAO_AUTORIZADO);
		}

		TransacaoEntity transacaoEntity = new TransacaoEntity();

		if (tipo.equalsIgnoreCase(DEPOSITO)) {

			transacaoEntity.setTipo(DEPOSITO);

		} else if (tipo.equalsIgnoreCase(DEBITO)) {

			transacaoEntity.setTipo(DEBITO);

		} else {
			return respostasUtil.getRequisicaoInvalidaTransacao(MENSAGEM_TIPO_DE_TRANSACAO_INVALIDO);
		}

		if (transacao.getValor() == null || transacao.getValor() <= 0) {
			return respostasUtil.getRequisicaoInvalidaTransacao(MENSAGEM_VALOR_DA_TRANSACAO_NAO_INFORMADO);
		}

		if (transacao.getConta() == null) {
			return respostasUtil.getRequisicaoInvalidaTransacao(MENSAGEM_CONTA_NAO_INFORMADA);
		}

		Integer agencia = transacao.getConta().getAgencia();
		Long numero = transacao.getConta().getNumero();
		Integer digito = transacao.getConta().getDigito();

		if (agencia == null || numero == null || digito == null) {
			return respostasUtil.getRequisicaoInvalidaTransacao(MENSAGEM_DADOS_DE_CONTA_INVALIDOS);
		}

		ContaEntity contaEntity = contas.findByAgenciaAndNumeroAndDigitoAndCliente(agencia, numero, digito,
				clienteEntity);

		if (contaEntity == null) {
			return respostasUtil.getRequisicaoInvalidaTransacao(MENSAGEM_CONTA_NAO_ENCONTRADA);
		} else {
			if (DEPOSITO.equalsIgnoreCase(transacaoEntity.getTipo())) {
				contaEntity.setSaldo(contaEntity.getSaldo() + transacao.getValor());
			} else {
				contaEntity.setSaldo(contaEntity.getSaldo() - transacao.getValor());
			}
		}

		transacaoEntity.setConta(contaEntity);
		transacaoEntity.setData(new Date());
		transacaoEntity.setValor(transacao.getValor());

		transacaoEntity = transacoes.save(transacaoEntity);

		if (transacaoEntity == null) {
			return respostasUtil.getRequisicaoInvalidaTransacao(MENSAGEM_FALHA_AO_SALVAR_TRANSACAO);
		}

		transacao.setValor(transacaoEntity.getValor());
		transacao.setId(transacaoEntity.getId());

		return new ResponseEntity<Transacao>(transacao, HttpStatus.CREATED);
	}
	
	public ResponseEntity<Void> exclui(String authorization, Long codigo) {
		ClienteEntity clienteEntity = clienteService.getClienteByAuthorization(authorization);
		
		if(clienteEntity == null) {
			return respostasUtil.getNaoAutorizado(MENSAGEM_NAO_AUTORIZADO);
		}
		
		TransacaoEntity transacaoEntity = transacoes.findOne(codigo);
		
		if(transacaoEntity == null) {
			return respostasUtil.getRegistroNaoEncontrado(MENSAGEM_TRANSACAO_NAO_ENCONTRADA);
		}

		ContaEntity contaEntity = transacaoEntity.getConta();
		
		if(contaEntity == null) {
			return respostasUtil.getRequisicaoInvalida(MENSAGEM_NAO_FOI_POSSÍVEL_RECUPERAR_CONTA_ASSOCIADA_A_TRANSACAO);
		}
		
		Double novoSaldo = 0d;
		
		if(DEPOSITO.equalsIgnoreCase(transacaoEntity.getTipo())){
			novoSaldo = contaEntity.getSaldo() - transacaoEntity.getValor();
		}else if(DEBITO.equalsIgnoreCase(transacaoEntity.getTipo())) {
			novoSaldo = contaEntity.getSaldo() + transacaoEntity.getValor();
		}else {
			return respostasUtil.getRequisicaoInvalida(MENSAGEM_NAO_FOI_POSSÍVEL_ENCONTRAR_O_TIPO_DA_TRANSACAO);
		}
		
		transacoes.delete(codigo);
		
		if(transacoes.exists(codigo)) {
			return respostasUtil.getRequisicaoInvalida(MENSAGEM_NAO_FOI_POSSÍVEL_EXCLUIR_A_TRANSACAO);
		}
		
		contaEntity.setSaldo(novoSaldo);
		contas.save(contaEntity);
		
		return respostasUtil.getSucessoSemConteudo(MENSAGEM_TRANSACAO_EXCLUÍDA_COM_SUCESSO);
	}

	public ResponseEntity<Void> atualiza(String authorization, Long codigo, Double valor) {
		ClienteEntity clienteEntity = clienteService.getClienteByAuthorization(authorization);
		
		if(clienteEntity == null){
			return respostasUtil.getRequisicaoInvalida(MENSAGEM_NAO_AUTORIZADO);
		}
		
		if(valor == null || (valor <= 0)) {
			return respostasUtil.getRequisicaoInvalida(MENSAGEM_VALOR_INVÁLIDO);
		}
		
		TransacaoEntity transacaoEntity = transacoes.findOne(codigo);
		
		if(transacaoEntity == null) {
			return respostasUtil.getRegistroNaoEncontrado(MENSAGEM_TRANSACAO_NAO_ENCONTRADA);
		}
		
		ContaEntity contaEntity = transacaoEntity.getConta();
		
		if(DEPOSITO.equalsIgnoreCase(transacaoEntity.getTipo())) {
			contaEntity.setSaldo(contaEntity.getSaldo() - transacaoEntity.getValor());
			contaEntity.setSaldo(contaEntity.getSaldo() + valor);
		}else if(DEBITO.equalsIgnoreCase(transacaoEntity.getTipo())) {
			contaEntity.setSaldo(contaEntity.getSaldo() + transacaoEntity.getValor());
			contaEntity.setSaldo(contaEntity.getSaldo() - valor);
		}else {
			return respostasUtil.getRequisicaoInvalida(MENSAGEM_TIPO_DE_TRANSAÇÃO_INVALIDO);
		}
		
		transacaoEntity.setValor(valor);
		transacoes.save(transacaoEntity);
		
		return respostasUtil.getSucessoSemConteudo(MENSAGEM_TRANSACAO_ATUALIZADA_COM_SUCESSO);
	}
	
}
