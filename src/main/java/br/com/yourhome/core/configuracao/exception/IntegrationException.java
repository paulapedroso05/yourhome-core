package br.com.yourhome.core.configuracao.exception;

import br.com.yourhome.core.configuracao.exception.model.MessageType;
import org.springframework.http.HttpStatus;

import java.util.List;

public class IntegrationException extends AppRuntimeException {

	public IntegrationException(List<String> notifications) {
		super(MessageType.Internal_Architecture_Error, notifications, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	public IntegrationException(List<String> notifications, Throwable cause) {
		super(MessageType.Internal_Architecture_Error, notifications, cause, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

}
