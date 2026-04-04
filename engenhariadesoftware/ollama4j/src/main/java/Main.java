import model.RoteiroModel;
import service.RoteiroService;

public class Main {

    static void main() {

        RoteiroService roteiroService = new RoteiroService();

        Long inicio = System.nanoTime();

        RoteiroModel roteiroDrama = roteiroService.gerarRoteiro("Comédia", "Peça de teatro", "Um homem devia dinheiro a um traficante dono de cartel, mas quando é sequestrado, ele vira amigo dos sequestradores e posteriormente se torna chefe do cartel devivo a sua habilidade de fazer piadas e ser extemamente engraçado");
        roteiroService.gerarDocumentoRoteiro(roteiroDrama);

        Long fim = System.nanoTime();
        Long duracao = (fim - inicio) / 1000000000;

        System.out.printf("roteiro gerado em %d segundos", duracao);
    }
}
