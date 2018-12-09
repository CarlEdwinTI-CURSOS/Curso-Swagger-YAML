package io.swagger.customizacao.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import io.swagger.model.Cliente;
import io.swagger.model.Extrato;
import io.swagger.model.Transacao;

@Component
public class RespostasUtil {
	
	public static final String MENSAGEM_FALHA_AO_SALVAR_TRANSACAO = "Falha ao salvar transação.";

	public static final String MENSAGEM_FALHA_AO_TENTAR_ATUALIZAR_TRANSACAO = "Falha ao tentar atualizar transação.";
	
	public static final String MENSAGEM_FALHA_AO_TENTAR_EXCLUIR_TRANSACAO = "Falha ao tentar excluir transação.";

	public static final String MENSAGEM_FALHA_AO_TENTAR_CONSULTAR_EXTRATO = "Falha ao tentar consultar extrato.";

	public static final String MENSAGEM_FALHA_AO_TENTAR_CONSULTAR_SALDO = "Falha ao tentar consultar saldo.";

	public static final String HEADER_MENSAGEM = "Mensagem: ";
	
	public static final String HEADER_ERRO = "Erro: ";
	
	private MultiValueMap<String, String> getNovoHeaderComMensagem(String mensagem) {
		MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
		header.add(HEADER_MENSAGEM, mensagem);
		return header;
	}
	
	public ResponseEntity<Void> getErroInterno(String mensagem) {
		return new ResponseEntity<Void>(getNovoHeaderComMensagem(mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Void> getSucessoSemConteudo(String mensagem) {
		return new ResponseEntity<Void>(getNovoHeaderComMensagem(mensagem), HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Void> getRegistroNaoEncontrado(String mensagem) {
		getNovoHeaderComMensagem(mensagem);
		return new ResponseEntity<Void>(getNovoHeaderComMensagem(mensagem), HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Void> getRequisicaoInvalida(String mensagem) {
		return new ResponseEntity<Void>(getNovoHeaderComMensagem(mensagem), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<Void> getNaoAutorizado(String mensagem) {
		return new ResponseEntity<Void>(getNovoHeaderComMensagem(mensagem), HttpStatus.UNAUTHORIZED);
	}	

	public ResponseEntity<Transacao> getErroInternoTransacao(String mensagem) {
		return new ResponseEntity<Transacao>(getNovoHeaderComMensagem(mensagem),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Transacao> getRequisicaoInvalidaTransacao(String mensagem) {
		getNovoHeaderComMensagem(mensagem);
		return new ResponseEntity<Transacao>(getNovoHeaderComMensagem(mensagem), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<Extrato> getErroInternoExtrato(String mensagem) {
		return new ResponseEntity<Extrato>(getNovoHeaderComMensagem(mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Extrato> getNaoEncontradoExtrato(String mensagem) {
		return new ResponseEntity<Extrato>(getNovoHeaderComMensagem(mensagem), HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Extrato> getRequisicaoInvalidaExtrato(String mensagem) {
		return new ResponseEntity<Extrato>(getNovoHeaderComMensagem(mensagem),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Extrato> getExtratoNaoAutorizado(String mensagem) {
		return new ResponseEntity<Extrato>(getNovoHeaderComMensagem(mensagem), HttpStatus.UNAUTHORIZED);
	}

	public ResponseEntity<Double> getErroInternoDouble(String mensagem) {
		return new ResponseEntity<Double>(getNovoHeaderComMensagem(mensagem),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<Double> getRequisicaoInvalidaDouble(String mensagem) {
		return new ResponseEntity<Double>(getNovoHeaderComMensagem(mensagem), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Double> getNaoAutorizadoDouble(String mensagem) {
		return new ResponseEntity<Double>(getNovoHeaderComMensagem(mensagem), HttpStatus.UNAUTHORIZED);
	}

	public ResponseEntity<Cliente> getRequisicaoInvalidaCliente(String mensagem) {
		return new ResponseEntity<Cliente>(getNovoHeaderComMensagem(mensagem), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<Cliente> getErroInternoCliente(String mensagem) {
		return new ResponseEntity<Cliente>(getNovoHeaderComMensagem(mensagem), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
