 ### Engenharia de Software
1. Comentar com suas palavras o primeiro trecho do livro Software Engineering at Google, Oreilly. (primeiro post)
   
O trecho levanta uma questão que raramente é discutida com clareza: a diferença real entre "programar" e "fazer engenharia de software". No mercado, os dois termos são usados como sinônimos, mas há uma distinção importante por trás deles.
A comparação com outras engenharias ajuda a entender o ponto. Um engenheiro civil não só sabe construir, ele segue normas, calcula carga, garante que a estrutura vai se sustentar. Na área de software, historicamente, não existe esse mesmo nível de exigência. E o argumento é que, conforme o software vai se tornando parte essencial da infraestrutura do mundo, essa falta de rigor começa a cobrar um preço alto.

2. Comentar com suas palavras o segundo trecho do livro Software Engineering at Google, Oreilly.(segundo post)

A definição de engenharia de software como "programação integrada ao longo do tempo" é simples, mas muda bastante a perspectiva. O foco não é só escrever código que funciona agora, é pensar no que acontece com esse código meses ou anos depois, quando o time muda, a tecnologia evolui e os requisitos se tornam outros.
Os três pilares apresentados reforçam essa ideia. Tempo e mudança, escala e crescimento, trade-offs e custos. Esse último chama atenção porque toda decisão técnica tem um preço, e engenharia de verdade envolve saber avaliar esse preço de forma consciente, o que nem sempre é ensinado na teoria.
O argumento de que o Google tem algo único a contribuir faz sentido nesse contexto. Não é só teoria, é experiência acumulada lidando com uma das bases de código mais complexas do mundo por mais de duas décadas.<br>

3. Listar e explicar 3 exemplos de tradeoffs

Tradeoff é a necessidade de abrir mão de um benefício em troca de outro.
- Qualidade x Custo: produtos de maior qualidade tendem a custar mais.
- Risco x Retorno: O quanto um risco vale a pena é baseado no retorno.
- Saúde x prazer: Viver em pról da saúde pode significar abdicar de prazeres.

---
  
3 - Requisitos não funcionais
 
**Desempenho**
Define o tempo que o sistema leva para responder. Um sistema correto mas lento pode ser tão problemático quanto um sistema que não funciona corretamente. <br>
**Segurança**
Define como o sistema protege dados e funcionalidades contra acessos indevidos. Costuma ser negligenciado no início e é difícil de corrigir depois.<br>
**Escalabilidade**
É a capacidade do sistema de continuar funcionando bem conforme a demanda cresce. Impacta diretamente as decisões de arquitetura desde o início do projeto.<br>
**Manutenibilidade**
Refere-se à facilidade de modificar e evoluir o sistema ao longo do tempo. Um sistema difícil de manter acumula dívida técnica e se torna caro de sustentar.<br>
**Disponibilidade**
Define o quanto o sistema precisa estar acessível e no ar. <br>
 
4 - Trade-offs (negociação entre requisitos não funcionais)
 
Citar e descrever 3 cenários de trade-offs (ver slide 12, mas usar outros exemplos):
- **Segurança x Usabilidade:** Uma aplicação pode exigir diversas formas de autentiação, o que aumenta a segurança, mas torna a usabilidade ruim.<br>
-  **Tempo de desenvolvimento x Qualidade:** Um time, a fim de cumprir alguma data limite, pode precisar entregar um resultado com qualidade menor que a esperada.  <br>
- **Viés x Variância:** Um modelo muito simples erra por não capturar os padrões dos dados, enquanto um modelo muito complexo erra por memorizar o conjunto de treino e generalizar mal para dados novos. <br>
