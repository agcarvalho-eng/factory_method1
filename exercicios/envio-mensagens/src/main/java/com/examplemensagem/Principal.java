package com.examplemensagem;

import com.examplemensagem.message.MessageService;
import com.examplemensagem.message.MessageServiceFactory;
import com.examplemensagem.people.Customer;
import com.examplemensagem.message.Newsletter;

import java.util.List;
import java.util.function.Function;

/**
 * Executa a aplicação
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        final List<Customer> customers = List.of(
            new Customer("Manoel", "(63) 1111-2222", "manoel@teste.com"),
            new Customer("Breno",  "(63) 3333-4444", "breno@teste.com"),
            new Customer("Raysa",  "(63) 5555-6666", "raysa@teste.com")
        );

        // Definir a estratégia de envio a ser utilizada.
        final String serviceType = "whatsapp"; //Aqui pode ser alterado para sms ou whatsapp para teste.

        // Usar a fábbrica para criar a instância dos serviço (Padrão Strategy)
        final MessageService messageService = MessageServiceFactory.create(serviceType);

        // Criar a instância do NewsLetter (Context) injetando a estratégia escolhida
        final Newsletter newsletter = new Newsletter(customers, messageService);
        final String msgTemplate = "Aproveite que estamos com toda a loja em promoção.";

        // Determinar qual dado do cliente a ser usado como destino, considerando o serviço escolhido.
        final Function<Customer, String> destinationExtractor;
        if ("email".equals(serviceType)) {
            destinationExtractor = (Customer customer) -> customer.getEmail();
        } else {
            destinationExtractor = (Customer customer) -> customer.getPhone();
        }

        // Executar o envio
        newsletter.send(msgTemplate, destinationExtractor);
    }
}
