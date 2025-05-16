import com.agcarvalho.exportador_factory_method.ExportadorListaProduto;
import com.agcarvalho.exportador_factory_method.ExportadorListaProdutoHtml;
import com.agcarvalho.exportador_factory_method.ExportadorListaProdutoMarkdown;
import com.agcarvalho.exportador_factory_method.Produto;

import java.util.List;

/**
 * Executa a aplicação Exportador utilizando Factory Method.
 * @author Adriano Carvalho (Adaptado de @author original Manoel Campos)
 */
public class Principal {
    public static void main(String[] args) {
        final var listaProdutos = List.of(
                new Produto("TV", "LG", "132-A", 120),
                new Produto("Notebook", "Asus", "New age", 341),
                new Produto("Smartphone", "Samsung", "Galaxy S10", 214)
        );

        ExportadorFactory factoryHtml = new ExportadorListaProdutoHtmlFactory();
        ExportadorListaProduto exportadorHtml = factoryHtml.criarExportador();
        System.out.println("Lista de Produtos em HTML\n");
        System.out.println(exportadorHtml.exportar(listaProdutos));

        ExportadorFactory factoryMd = new ExportadorListaProdutoMarkdownFactory();
        ExportadorListaProduto exportadorMd = factoryMd.criarExportador();
        System.out.println("Lista de Produtos em Markdown\n");
        System.out.println(exportadorMd.exportar(listaProdutos));
    }
}

// Nova interface Factory
interface ExportadorFactory {
    ExportadorListaProduto criarExportador();
}

// Factory concreta para HTML
class ExportadorListaProdutoHtmlFactory implements ExportadorFactory {
    @Override
    public ExportadorListaProduto criarExportador() {
        return new ExportadorListaProdutoHtml();
    }
}

// Factory concreta para Markdown
class ExportadorListaProdutoMarkdownFactory implements ExportadorFactory {
    @Override
    public ExportadorListaProduto criarExportador() {
        return new ExportadorListaProdutoMarkdown();
    }
}
