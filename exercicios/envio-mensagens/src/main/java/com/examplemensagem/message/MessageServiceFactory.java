package com.examplemensagem.message;

/**
 * Fábrica simples para criar instâncias de {@link MessageService}.
 * Encapsula a lógica de decisão de qual classe concreta instanciar.
 */
public class MessageServiceFactory {
    /**
     * Cria uma instância de um serviço de mensagem com base no tipo fornecido.
     *
     * @param type o tipo de serviço desejado ("email", "sms", "whatsapp")
     * @return uma instância que implementa {@link MessageService}
     * @throws IllegalArgumentException se o tipo for desconhecido
     */
    public static MessageService create(final String type) {
        switch (type.toLowerCase()) {
            case "email":
                return new Email();
            case "sms":
                return new Sms();
            case "whatsapp":
                return new WhatsApp();
            default:
                throw new IllegalArgumentException("Tipo de serviço de mensagem desconhecido: " + type);
        }
    }
}
