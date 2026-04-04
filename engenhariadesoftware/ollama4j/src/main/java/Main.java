import model.RoteiroModel;
import service.RoteiroService;

public class Main {

    static void main() {

        RoteiroService roteiroService = new RoteiroService();

        RoteiroModel roteiroDrama = roteiroService.gerarRoteiro("Drama", "Filme cult", "Um homem perdeu a esperança de um mundo feliz, pois se sente muito triste com a evolução da Inteligẽncia Artificial");

        Long inicio = System.nanoTime();
        roteiroService.gerarDocumentoRoteiro(roteiroDrama);
        Long fim = System.nanoTime();
        Long duracao = (fim - inicio) / 1000000000;

        System.out.printf("roteiro gerado em %.2f segundos", duracao);
    }
}
