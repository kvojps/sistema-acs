# 2.4.2 Aluno

`\2. Níveis\2.4 Código - C4\2.4.1 Casos de uso\2.4.2 Aluno`

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
        * [**2.4.2 Aluno**](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.2%20Aluno/README.md)
        * [2.4.3 Coordenador](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.3%20Coordenador/README.md)
        * [2.4.4 Comissão](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1%20Casos%20de%20uso/2.4.4%20Comiss%C3%A3o/README.md)
      * [2.4.2 Atividades](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2%20Atividades/README.md)
      * [2.4.3 Classes](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3%20Classes/README.md)
      * [2.4.4 Máquina de estados](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.4%20M%C3%A1quina%20de%20estados/README.md)
      * [2.4.5 Sequência](../../../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.5%20Sequ%C3%AAncia/README.md)
  * [3. Manutenção da arquitetura](../../../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)
  * [4. Apêndices](../../../../4.%20Ap%C3%AAndices/README.md)
    * [4.1 Reuniões](../../../../4.%20Ap%C3%AAndices/4.1%20Reuni%C3%B5es/README.md)

---

![diagram](https://www.plantuml.com/plantuml/svg/0/fPJ1Ri8m38RlbVeE6LpO0JIk7Qf0av1sG-m1a4bSY9OcB75WFCyEUn1UR6axM3TQ2QsdsFBdFvR_A5D7OCddYYtdguVnE8xkQ8ivChS3ZWhMSUHUfTw1XPm19sDVwAYGmG6ToJ6EuYXPeCsaOZFbjKaOEBQOiJxXEoLhvGDYaHFeJUYo-EQbasHMcTTS6Wsgu7lBEGjtzmgrmHC8S6J1dkdJv-d3t1VSSbuCE7ZM3gsqp8Kv0uciB5wo6i7Haima1s5S2ScgiAeLQZX9yggwgWfRE86EszfSLSwXbGU22Wn12xCr5gePowY50f9xAK1WILwoDjg61Uwh6R_ZtsGS1Qk6mxJSR5XSUOo4EUXH-hFGlf8Qaus5u-F5LPQmoKHghhp0D3rtXgw63TyaqDGtKfXHqBmsu_-IGQxHhcwAVtpj97RbVoUrnZVIJV7w9Tsa5qTJr29yDN7q1G00)

![diagram](https://www.plantuml.com/plantuml/svg/0/ZP7FJW8n4CRlJVeE8rpmm0eIBYiXOCnwyK1s4wzaM0PexBROTXLy7Gy-WK_0YpbRWdyI3npQTFBzlczcqeaFw49TQSYpUQz_BSL5s515uBTOaiQ55Fv9cIqwh03BO5qHzfe0NydRYgIG8fsHMoaDKrqRcm9wc4sX7MWNqeMkwGSeb0zKuH4f_Y2Eoe1cpS6EdclbLR3pLMrAPGtgXc_b6V1uLxt-WC-mrJJkF2fVerPlwE21in6M1FdHV_WuV9A_RAnvrgpLAKXJp7E_c7TxGWQCt9DZ5HshBnPcTraKjyiLQxUeTl-8x1msi_3AtUuuzWAkYbX59r-G954QGbihG-dQuVxcUtj8OJJYWipIZyTIn8nHaiIfpdKCsE7KUXEIynj9CU4d_xqKNm00)

![diagram](https://www.plantuml.com/plantuml/svg/0/ZP8zJiD044PxIxx349fGn80KKPZ8YWjIMxP4QqtiILYntWtx0uJhKEG4d20NOxnMa04XKRZmp7kZ-KQxj0wDyvs4SbLVNS_vkucZC_T07O7TOKCIrt5a7uNQeS4Ei77QL6ul2V25hEueZjA2p4P8oALNEWMqKEHShOHrrE5GgEB8KEDGRTaqzEI55KxN6wyQeHNA7fgKA-0TBdc7IHp5qRH4wmoXEGd7m_63x4NFcj0IcgbxOJrAySQSKAreiDM6B5YzDXJGNtAvwbDESqc6uqFdMrJ70qBBcHqw_qND0-N8C3LqeCNHm7STI1oGUa3OkLFFWXLEpsVf3mUQ8RvEm8cxkWxDFcQHmsoMZH8LLIZyd7e2O94aOJaubq9HkZMultNqwjArz0GfB1RyGwgrMJQoaYGBmV-sX6gaRwctHYkUnFb_lEyx1tKywZyZucZ9k_EJZADF)

![diagram](https://www.plantuml.com/plantuml/svg/0/bL9BJW914DrFCdSeSOCBS482Yv5CM11MQ0X6jwIOAR1YJ_VOdmZUnhZm19w0Yzaz7-FAoAAxg-gzL_KgwPcngAqh1QmNcsIyIKRXJEBemZvHIM0gp4dWDexCCyiADPQ0kLNwtXu50RwIKIN5KReYlMC1SpOvIKife87LF8uqvHRbtdCrlJWsRDLcvsJEIg88fDvw0SdusW_sPzABepZgtwh2Wqkqf55S1TPwCHfxu96DGy5lUFeyVIWe29gv7SSRxo_vGAonBeac3bMrLywsl2JqkbEMTvo7LbzaQaGgIyP3xJA5WWVZJk-QLGrNxWThyZeCZbTp60oorcMuwxJ3cxTZJ5h6S9Xr_k1IiAHqh_5uO-bWqwrm12bCfonpuGhAib-YuFyyHRtNUPBA_Ol_QxM_53uXMPYWYAEP3_sF-mO0)

![diagram](https://www.plantuml.com/plantuml/svg/0/bLBDJW8n4BvlikzGyO87a91mO2KR3XjEQWX4hsRe3ZYnss8xZU3R60y-WK_0YzdkJ-8H3frqvlk-cM-QpXs3PLyfiLgyZCQJSAPfSiMlMA5mUv2eO9Ccxetq7YnK0YGRk-QZGW4Vw4o5QP8jqMv9YOASHCsO2N1YMQI9HScWTu5hyTsJ8pOlMwyb6GqgadghXGXJRyFKNfgaIV_1b05Hm6X1tKJAQZ6U1E2Pd0T5ds35sYYIn73wEVsY4mKgP2Z1TVImGF-U3aWMwf9gxh5gTiPponl5je-6QKiozlesDQ0Desiwc4vkGjxkM1hnvFpforA3xkjozBuin62GjtvZhDD67ME7JbjqECmxQ-9QaSPiP-5untZWRACyYapCPgIbyYNc-JzHj7wPeZ5vcQP-XtCbq_Es2GdgqaLHcip3DNoyFm00)

