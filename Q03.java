//3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, 
//faça um programa, na linguagem que desejar, que calcule e retorne:
//• O menor valor de faturamento ocorrido em um dia do mês;
//• O maior valor de faturamento ocorrido em um dia do mês;
//• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
//IMPORTANTE:
//a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
//b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class Q03 {
    public static void main(String[] args) {
        try {
            // Caminho para o arquivo XML
            File inputFile = new File("C:\\Users\\Gusta\\OneDrive\\Área de Trabalho\\Teste\\Q01.TXT");

            // Carrega o XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Obtém todos os elementos "valor" do XML
            NodeList nList = doc.getElementsByTagName("valor");

            double soma = 0.0;
            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            int diasComFaturamento = 0;

            // Processa os valores de faturamento
            for (int i = 0; i < nList.getLength(); i++) {
                Element element = (Element) nList.item(i);
                double valor = Double.parseDouble(element.getTextContent());

                if (valor > 0) {
                    soma += valor;
                    diasComFaturamento++;

                    if (valor < menorValor) {
                        menorValor = valor;
                    }

                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }
                }
            }

            // Calcula a média mensal
            double mediaMensal = soma / diasComFaturamento;

            // Conta os dias com faturamento acima da média mensal
            int diasAcimaDaMedia = 0;
            for (int i = 0; i < nList.getLength(); i++) {
                Element element = (Element) nList.item(i);
                double valor = Double.parseDouble(element.getTextContent());

                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            // Exibe os resultados
            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
