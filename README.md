# tabuleiro-padroes

* Singleton para o tabuleiro – Apenas um tabuleiro deve existir. Isso pode ser feito garantindo que a classe Tabuleiro tenha um construtor privado e um método estático para retornar a única instância.

* Factory para criação de jogadores e casas – A classe Jogo pode ter fábricas que criam instâncias de Jogador (Normal, Sortudo, Azarado) e das casas (CasaSimples, CasaSorte, CasaPrisao, etc.).

* Strategy para as casas – Cada tipo de casa deve ter sua própria implementação do método aplicarRegra(), seguindo o princípio da herança e do polimorfismo.

* Injeção de dependência para casas – As casas recebem o jogador para aplicar os efeitos corretamente (exemplo: verificar se ele tem bônus).

* Facade para a classe Jogo – A classe Jogo gerencia a criação e execução do jogo, facilitando o uso na Main.
