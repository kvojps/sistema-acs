# 2.4.3 Coordenador

`\2. Níveis\2.4 Código - C4\2.4.1 Casos de uso\2.4.3 Coordenador`

* [Sistema ACS | Docs](../../../../README.md)
  * [1. Requisitos](../../../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
      * [1.1.1 Usuário geral](../../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.1.2 Aluno](../../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.2%20Aluno/README.md)
      * [1.1.3 Coordenação](../../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.3%20Coordena%C3%A7%C3%A3o/README.md)
      * [1.1.4 Comissão](../../../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/1.1.4%20Comiss%C3%A3o/README.md)
    * [1.2 Requisitos Arquiteturais](../../../../1.%20Requisitos/1.2%20Requisitos%20Arquiteturais/README.md)
  * [2. Níveis](../../../../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../../../../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../../../../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1 Back](../../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1%20Back/README.md)
      * [2.3.2 Front](../../../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.2%20Front/README.md)
    * [2.4 Código - C4](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1 Casos de uso](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/README.md)
        * [2.4.1 Usuário geral](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.1%20Usu%C3%A1rio%20geral/README.md)
        * [2.4.2 Aluno](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.2%20Aluno/README.md)
        * [**2.4.3 Coordenador**](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.3%20Coordenador/README.md)
        * [2.4.4 Comissão](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.4%20Comiss%C3%A3o/README.md)
      * [2.4.2 Atividades](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2%20Atividades/README.md)
      * [2.4.3 Classes](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3%20Classes/README.md)
      * [2.4.4 Máquina de estados](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
      * [2.4.5 Sequência](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.5%20Sequ%C3%AAncia/README.md)
  * [3. Manutenção da arquitetura](../../../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)
  * [4. Apêndices](../../../../4.%20Ap%C3%AAndices/README.md)
    * [4.1 Reuniões](../../../../4.%20Ap%C3%AAndices/4.1%20Reuni%C3%B5es/README.md)

---

![diagram](https://www.plantuml.com/plantuml/svg/0/hLJDJjj04BvRyZjCuK8FCRWSshfHX4GKYKCBAeXhDF5EaXNhtNHt3ONNuO1wwB5Fu1VhU6s5cZeIbNjOQRwPRx_vsR5Fd4VhoqB1rncaINgO9k_u7CUHkv5wWnOBmDmRU-dl5G7UaJC5nL5sQemLf54Ocm4wo9ynx7lwxhE5Afdung-f870Rp4dX8euivHxrYiNswfn7wVl3e_G3duzxSNGmayfRj63fMocTh9wgN-JUrWcMJMJUHd93ZlcN7dtP45mmsVU5AmHX05MfJGXfzim3vF1dzBRwcPSAGwnWA6l4eTEBMV3bcoMZCvW690M3AtD3Ea1VMt74lclfIbJoeRVUsssmMpBVEm-JwhlKpF1barFq28A7M2uAwLprs7Gbs3rlVMXQNNukjSH5zSFB7BUQnJnugNOoyO9u0aOqCXkoakrGsPGygdMdj3OPFnzd-QkNEFhpuKUAbduqcknilaCMvaxNvDwNxJ2jNAs3RkzyEbGczPRQamJ6IT9k3S2-afgobSNxJzljXGp6OmQanMIoMuAtPT3zv-qS9BDTv44gKWow7ZwEGGhThHwYr2xsgwhfMQp_fP7yUqUxgddvARz6AuvEsE8__6y0)

![diagram](https://www.plantuml.com/plantuml/svg/0/fPJFQjj04CRl0ht3DBca1ojs2YbLZ8anzQsbr91Jm8ntnycIrQwwkqgJlauFFVKf_6APNV-DiU92GGiQxJS_VVfcqRKFw49JQVW-XbvnUTuhFlBwb6V-GPaQ7LQ08bWt2S-Q07-IjnNbsRjmJnM1hr6GnbcUEH81pHrhJfZKlUYUTozwl3wSv5avijP9CYYjAm4zY6qDfu6UGZdJ3LFBYVA1AamYlxn_9SYpinlb6zJg5phWvmw31KbmRntwMoEvRpYQWBGUfFA2J23_Fj8UDstJf9sYy4mRAysCjr0rUroZ4cc-R5bXrblC6dqR9u6evrnzvPnIQL9WPrymkCLVqMXCJoikLQo0zuQQ7CzXynxmTkOuxLipG_M4yAD14vH4TiTNT4NcKI5RJ2nSjkzw-Hpt-RCgL1hY6C6-_ee4SDCas6qSwa0n466hsdgr-BFulKq5Lg6itfgKqwsvPQPvjZlUJcVGals-gYtNzJdeQ9g7A6onlfy254MB5awrCbJUENo-sXmkAA7VLqReHj9W03oMmuQWNnHnnEqGBiZ80KFUPCHpSHnonCZs61qbvTcXEIJAuL7-9t9l6ly0oxDhlkEVqGi0)

![diagram](https://www.plantuml.com/plantuml/svg/0/fPDBRi8m48Rtbdo7AMnWGNYeGbMA8gIgFG0S81gS4RXrR6exj9o7HK_G4t2ncl2cA5JgpfQ--VpFs1uwZzONkOBH2tIZXtOtwdOuSszIpz5Y3YYyiME_L0JuGSxanDcTdr5EuEOeIE64Cql2evu6fXOqdTvzkzFhrpYBduon6MdCZ8q17OZZ7kgUFdqyKKKmncFfFELOGcwxFWCQpteXqOAbzq8wkVvQVvE3JKJ0OCsbS-kLQMxAgIJJ7IaCkNGBe3bwWb-golgIEAqSqIl9C2t01Ig98SBAG4OdaNO2kmFJBIZG7CAKeh5HKfGcIsSk_EroUpRTivSwpaw7scebrGEuX6-4tTz5oyhfp8U2njNnD3Tle484KPJSx0NgIcgAfnQNZuUhXnW60wc5AZ9A4W3EAjehZxaQy8_ksqtynyxPa7GMFjiF)

![diagram](https://www.plantuml.com/plantuml/svg/0/ZPFBJiCm44Ntbl8FGxk1HPyRKAYY8WHB5kqMgPhQGslXHx4TGR-71H_I7yD9IEaZhRgnOi-zrvCpoTW7T27N2YRFCEWE1hsu31FctwLPeKCDo8Drqx1M1FX9tcfAs5LOaYRmA-IaS9umHpoWMKHDA-RqXxUz_l2kbR3qqLedoA2mBWNqmF_tq0xq5TAvocDYEfK-aCPIvAldFK72hYSOv9lawC3HHowztFnilkrDuN1rQVPNucYZuy5xQQ9Uo8KCg3IPGAy6Z_rO2VVTJuQZbcPvSE5h2GOGo7Ehq4c1WieKsXeEsb21N4o9h4FkGJGrK4bcbMJV_cBhzyOu2lAmYl2eer6gqclg-gog5x0IjakwqybE86ew1UXsimOa06qb3QKBX-lxxMWWXT586gvoGLbs8h48RAHpGIH0mfgzPPkdm5sIV2xuaEf5dSR4-kCjc9-PwgxiU81ZCYB-bBy0)

