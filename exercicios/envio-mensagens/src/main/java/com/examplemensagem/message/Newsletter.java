package com.examplemensagem.message;

import com.examplemensagem.people.Customer;

import java.util.List;
import java.util.function.Function;

/**
 * Envia mensagens em massa para uma lista de clientes,
 * utilizando algum {@link MessageService}.
 *
 * @author Manoel Campos da Silva Filho
 */
public class Newsletter {
    private final List<Customer> customers;

    // 1. Depende da interface (Strategy), não da implementação concreta.
    private MessageService messageService;

    /**
     * Instancia uma newsletter para envio de mensagens para uma determinada lista de clientes
     * @param customers lista de clientes para enviar mensagens
     * @param messageService A estratégia de envio de mensagens a ser utilizada.
     */

    public Newsletter(final List<Customer> customers, final MessageService messageService) {
        this.customers = customers;
        // 2. A estratégia é injetada via construtor.
        this.messageService = messageService;
    }

    /**
     * Envia uma mensagem personalizada para uma lista de clientes.
     * Não é obrigatória a inclusão de marcadores no template.
     * Um exemplo de template seria:
     *      Olá #name, seu telefone foi atualizado para #phone.
     * @param msgTemplate Um template de mensagem com marcações (placeholders)
     *        que serão substituídos por atributos do cliente de destino.
     * @param destinationExtractor Uma função que extrai o destino correto (email ou telefone) do cliente.
     */
    public void send(final String msgTemplate, final Function<Customer, String> destinationExtractor) {
        for (final Customer customer : customers) {
            // 3. O destino é obtido de forma flexível.
            final String Destination = destinationExtractor.apply(customer);
            final String formattedMsg = formatMsg(customer, msgTemplate);

            // 4. Usa o serviço (Padrão Strategy) injetado, sem saber qual é.
            this.messageService.send(Destination, formattedMsg);
        }
    }

    /**
     * Substitui marcações (placeholders) na mensagem por valores
     * de atributos de um cliente.
     *
     * @param customer cliente de destino
     * @param msgTemplate Um template de mensagem com marcações (placeholders)
     *        que serão substituídos por atributos do cliente de destino.
     * @return a mensagem com as marcações substituídas pelos atributos do cliente.
     */
    private String formatMsg(final Customer customer, final String msgTemplate) {
        return msgTemplate
            .replaceAll("#name", customer.getName())
            .replaceAll("#email", customer.getEmail())
            .replaceAll("#phone", customer.getPhone());
    }
}
