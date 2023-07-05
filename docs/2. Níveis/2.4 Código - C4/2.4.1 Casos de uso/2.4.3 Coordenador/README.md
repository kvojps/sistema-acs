# 2.4.3 Coordenador

`/2. Níveis/2.4 Código - C4/2.4.1 Casos de uso/2.4.3 Coordenador`

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

![diagram](https://www.plantuml.com/plantuml/svg/0/fLJ1Jjj04BrRyZzCwGKECRWSIgCe2W95wg4K5SGrcknEo8grD-ok2-tlS40SEFOB_6CThws08wSgvc1ftynxCxEpBvauZzONcOOVKqYJT3zDFl5t64VkHkKhj9W12c_iXV-b2V2EdCaeZeOdnbX9EKfZXu0En0k6Zvxk_N2k2oP-y4lA2DmA1McSnv4buJ6_vc8xLS-3zFF-GNh4tvUTEDgTAkqjMh1qMoYdoiVo3xczgi6YpioQZ33ac7_XqHSrmOKZnyvuGf06K1Uv2QcS8xC0EVqDlIsVHQ4nv3A6gaASEZcVXfXOBHXzXTE0b6HmQMue3z1NfpZYs9Lo1MhrktFUd-jaUsJMVG-RwXBLEzoyv2bw1CbBBEQPSgvyg6ybEJnhOcYQklnSUe7pyiahWUkQsIn4gGeoyPnu0qRMPLPa5P_3PCU2k5RNP5XdDkyIHwyVVg1fuGU3yTRBjyZItEKLkVDbMqohhfUXRkT-MbGcTOxQqGH6ITAu1bvv5eOm6Z6WN8x7suNiaHwg5oVs4A-jsaEhP0zHi7eFNTkPRzStbln7vmuZl4-P_E_Cspfl_iosLuYZ2P_uF_Sl)

![diagram](https://www.plantuml.com/plantuml/svg/0/dLHDImCn4Bqlx7yOzQA7hgs2ubAAfTYR8XQybcbsgi5iiYPPl_wE1q_-Ylun9wcrjNOLX0raalTUNjw4FNKUhQzB1LT3w6H7-vticCT9chWxgIkqM08AR-p8Foi2V2HdIagJBNzB9O6hK932IPfO4Xxr3MEsMQbzqDvl7tHu76wdIJumnXQaiJ0s1tGWbZNiU7ho-KJLh9gFfFDKOWIv-VmR84rshwMhKSaNjC3h5hs1Wk3MMAOKFFg34HI6vz89qfxSNX1x-6AD8tICmh7OK2gM-4MfOeSBfIWqdJC-LHPRB3Mu74Q0gAPSNN1AiTGnhjrpz7RsBcg5SRNaKeOAUA-lo78Nliu1PoQMiuO9oYU4-ngrbmMoD_w2AT8F4jbXbC8vUzNAMTZdIvKe5OGUWlb-YIXWnn6mIkmhJo4EOShAE3bxcxt-pEJpr8WSBytD4qsJrTwsMhs6vDTHJR4k7a5BqTG7O8FrzHGWongmA-y9SkXsfHQgBgZN0-x5PXlGpRBGrtKg5wIB7bD_POOdq4Jzuz3bEsdWfyccV2DtSul-9RIMRQD4cfpoZFyc7m00)

![diagram](https://www.plantuml.com/plantuml/svg/0/bPDDRi8m44Rtbdo7ATt0Wl2ZggeY525LxG7W0D7WZC2j4rEFGzlpiEW9UW8kLXEW18g2khEbDq_VpDXZzkXycHkOFCCWUkWDea5V2dxLnH8Tve3AMpVrduO0tubjJbBS-0Nb1Bn4HGPdKZXI7ejvO5f1qn_UzVh3-vOKyQErBgC2C-jYG0PrlCEjfmyVpqmPZF5KiwSSAuXtvnEW_LIiD3fmz5PgrfklpJSnR2C21ckkcJThszcMKqMcUr9PudG7e3rwWb-RnlgAg5TEw8Lqc1RW2et6465j8QDQfBt0xS5q1ogqls4gqTGQhIgJenCN_dNnWKqFxBbEYlfGkzsaUG3dy9MmXrrqdPulV2XeNnnFP_i66aGGHSdLNceBXnX68rqeKsQK901ID3HLoI_6QZHU3_n_fnHZAhBmdNu0)

![diagram](https://www.plantuml.com/plantuml/svg/0/VP9BJiCm48RtaNA7eMnWqKUw0KLLL8JW0Eq1ggazRItyAFP4m7bOS91U32UXqBG9YXGbck__RF_9F31wBes6nJDaeomRnziqJSABidlqQ005Ex_a3qs0RnISeJIvuXqPWh17GHhNQU99CDfjP0RHCvdUZIVJ-q6Qv8_EUKaMfVCvO03nzmxNJE-ShtKPZVbI1IQ3DHIQvnQG9ZSBPBLH0ZruUYrLK8UlmwUxhHB-E5hzZ0Iwc7W8GTd8IxLLZDgGvNYAopWsN3lyP0KQPNTdwq5LIvHG44wZLn8brHBwvSysePbybCIckGmWkzPla5M3jEBLTLhQS5XqRlVOMJtlrrr6OJGgElixgHzocCsK5RgKL1JnStVXbQUpWruHG9fq9ofNxod-zSt9olWxVmC0)

