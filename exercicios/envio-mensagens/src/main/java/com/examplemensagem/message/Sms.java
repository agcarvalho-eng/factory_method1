package com.examplemensagem.message;

/**
 * Envia mensagens pelo Short Message Service (SMS)
 * @author Manoel Campos da Silva Filho
 */
public class Sms implements MessageService {
    @Override
    public void send(final String destination, final String msg) throws MessageSendException {
        System.out.printf("Enviando msg SMS para %s: %s%n", destination, msg);
    }
}
