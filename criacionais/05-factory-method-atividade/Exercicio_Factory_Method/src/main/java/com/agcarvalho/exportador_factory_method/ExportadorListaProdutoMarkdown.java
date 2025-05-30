package com.agcarvalho.exportador_factory_method;

import java.util.ArrayList;
import java.util.List;

/**
 * Exporta dados de uma lista de {@link Produto} para Markdown (arquivos md).
 *
 * <p>Observe que, como estamos usando o padrão Factory Method para instanciar
 * objetos {@link ExportadorListaProduto}, as classes concretas como esta são definidas com visibilidade "package",
 * não podendo ser acessadas fora do pacote.
 * Assim, não teremos como instanciar diretamente tais classes.
 * A Factory Method faz isso pra nós.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
public class ExportadorListaProdutoMarkdown extends AbstractExportadorListaProduto {
    private static final String SEPARADOR_LN = "-";
    private static final String SEPARADOR_COL = "|";

    @Override
    public String abrirTabela() {
        return "";
    }

    @Override
    public String fecharTabela() {
        return "\n";
    }

    @Override
    public String abrirLinha() {
        return "";
    }

    @Override
    public String fecharLinha() {
        return "\n";
    }

    @Override
    public String abrirLinhaTitulos() { return ""; }

    @Override
    public String fecharLinhaTitulos() {
        final var listaValores = new ArrayList<String>();
        for (int i = 0; i < TITULOS_COLUNAS.size(); i++) {
            listaValores.add("-----");
        }

        return gerarColunasLinha(listaValores);
    }

    @Override
    public String abrirColuna(String valor) {
        return valor;
    }

    @Override
    public String fecharColuna() {
        return " " + SEPARADOR_COL;
    }
}

