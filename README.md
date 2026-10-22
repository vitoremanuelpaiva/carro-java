# Simulador de Carro em Java

Simulador de carro executado no terminal, feito em Java para praticar orientação a objetos. O programa tem um menu interativo para ligar e desligar o carro, acelerar, frear, virar e trocar de marcha.

## Regras do carro

- O carro só acelera com uma marcha engatada (a marcha 0 é o ponto morto).
- Cada marcha tem uma faixa de velocidade, e o limite do carro é 120 km/h.
- Só é possível trocar de marcha se a velocidade couber na faixa da nova marcha.
- O carro só vira em velocidades de 1 a 40 km/h.
- Só é possível desligar o carro parado e em ponto morto.

| Marcha | Velocidade mínima | Velocidade máxima |
|--------|-------------------|-------------------|
| 0      | 0                 | 0                 |
| 1      | 0                 | 20                |
| 2      | 20                | 40                |
| 3      | 40                | 60                |
| 4      | 60                | 80                |
| 5      | 80                | 100               |
| 6      | 100               | 120               |

## Como rodar

É preciso ter o JDK (Java) instalado. Na pasta do projeto:

```
javac -d out *.java
java -cp out ex010.MenuCarro
```

## Estrutura

- `Carro.java`: classe com o estado do carro (ligado, marcha, velocidade) e todas as regras.
- `MenuCarro.java`: menu no terminal que lê as opções e mostra os resultados.

## O que pratiquei

- Classes, atributos privados e métodos que devolvem `true` ou `false`.
- Vetores para guardar as faixas de velocidade de cada marcha, em vez de vários `if`.
- Mensagens que explicam o motivo real de cada falha (a classe guarda o motivo e o menu o mostra).
- Tratamento de entrada inválida no menu com `try/catch`.
- Testar valores de fronteira (por exemplo, a velocidade em que se troca de marcha).

## Autor

Vitor Emanuel Batista Paiva, [@vitoremanuelpaiva](https://github.com/vitoremanuelpaiva)