package com.agcarvalho.exportador_factory_method;

/**
 * Exporta dados de uma lista de {@link Produto} para HTML.
 *
 * <p>Observe que, como estamos usando agora o padrão Factory Method para instanciar
 * objetos {@link ExportadorListaProduto}, as classes concretas como esta são definidas com visibilidade "package",
 * não podendo ser acessadas fora do pacote.
 * Assim, não teremos como instanciar diretamente tais classes.
 * A Factory Method faz isso pra nós.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
public class ExportadorListaProdutoHtml extends AbstractExportadorListaProduto {
    @Override
    public String abrirTabela() {
        return "<table>\n";
    }

    @Override
    public String fecharTabela() {
        return "</table>\n";
    }

    @Override
    public String abrirLinha() {
        return "  <tr>";
    }

    @Override
    public String fecharLinha() {
        return "</tr>\n";
    }

    @Override
    public String abrirLinhaTitulos() {
        return "    <thead>\n";
    }

    @Override
    public String fecharLinhaTitulos() {
        return "    </thead>\n";
    }

    @Override
    public String abrirColuna(String valor) {
        return "<td>" + valor;
    }

    @Override
    public String fecharColuna() {
        return "</td>";
    }
}
