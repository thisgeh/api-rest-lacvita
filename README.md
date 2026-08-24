# LacVita API

API REST para gestão de doação de leite materno, conectando **nutrizes** (doadoras) a **pontos de coleta** e bancos de leite humano. A solução cobre todo o fluxo: cadastro da doadora, endereço para coleta em casa, envio e aprovação de documentos de saúde (exames), cadastro de pontos de coleta, agendamento de doações (em casa ou entrega presencial), registro da coleta realizada, controle de qualidade do leite recebido, feedback da doadora e lembretes/notificações.

## Stack

- Java 21 + Spring Boot 4.1.1
- Spring Data JPA + Hibernate
- MySQL 8
- ModelMapper (conversão DTO ↔ Entidade)
- Bean Validation (`jakarta.validation`)
- springdoc-openapi / Swagger UI

## Como rodar (ambiente limpo)

1. Iniciar o Docker Desktop.

2. Subir o banco MySQL:
```bash
docker run -d \
    --name mysql \
    --rm \
    -e MYSQL_ROOT_PASSWORD=root_pwd \
    -e MYSQL_USER=new_user \
    -e MYSQL_PASSWORD=my_pwd \
    -e MYSQL_DATABASE=lacvita \
    -p 3306:3306 \
    mysql
```

3.
```bash
./mvnw spring-boot:run
```

4. A API sobe em `http://localhost:8080`, com todas as rotas sob o prefixo `api/v1`.

5. Para parar: `Ctrl+C` na aplicação e `docker stop mysql`


## Endpoints

### Nutrizes — `/api/v1/nutrizes`
| Método | Rota | Descrição |
|---|---|---|
| POST | `/` | Cadastra uma nutriz |
| POST | `/login` | Autentica por e-mail ou CPF + senha |
| GET | `/{id}` | Busca por id |
| GET | `/` | Lista todas |
| PUT | `/{id}` | Atualiza dados |
| DELETE | `/{id}` | Remove |

### Endereços — `/api/v1/enderecos`
| Método | Rota | Descrição |
|---|---|---|
| POST | `/` | Cadastra endereço de uma nutriz (`nutrizeId` obrigatório) |
| GET | `/{id}` | Busca por id |
| GET | `/nutriz/{nutrizeId}` | Lista endereços de uma nutriz |
| PUT | `/{id}` | Atualiza |
| DELETE | `/{id}` | Remove |

### Documentos de saúde — `/api/v1/documentos-saude`
| Método | Rota | Descrição |
|---|---|---|
| POST | `/` | Envia documento (`tipo`: ver enum `TipoExame`). Status inicial é sempre `PENDENTE` |
| GET | `/{id}` | Busca por id |
| GET | `/nutriz/{nutrizeId}` | Lista documentos de uma nutriz |
| PUT | `/{id}` | Atualiza o `status` (análise manual — ver enum `StatusDocumento`) |

### Pontos de coleta — `/api/v1/pontos-coleta`
| Método | Rota | Descrição |
|---|---|---|
| POST | `/` | Cadastra ponto de coleta (independente de nutriz) |
| GET | `/{id}` | Busca por id |
| GET | `/` | Lista todos |
| PUT | `/{id}` | Atualiza |
| DELETE | `/{id}` | Remove |

### Agendamentos — `/api/v1/agendamentos`
| Método | Rota | Descrição |
|---|---|---|
| POST | `/` | Cria agendamento. Se `tipoColeta = EM_CASA`, `enderecoId` é obrigatório; se `PONTO_COLETA`, `pontoColetaId` é obrigatório. `dataAgendada` precisa ser uma data futura |
| GET | `/{id}` | Busca por id |
| GET | `/nutriz/{nutrizeId}` | Lista agendamentos de uma nutriz |
| PUT | `/{id}` | Atualiza `status` (ver enum `StatusAgendamento`) — ao setar `REALIZADO`, uma `Coleta` é criada automaticamente |
| DELETE | `/{id}` | Remove |

### Coletas — `/api/v1/coletas`
> Sem `POST` — é criada automaticamente quando um agendamento vira `REALIZADO`.

| Método | Rota | Descrição |
|---|---|---|
| GET | `/{id}` | Busca por id |
| GET | `/agendamento/{agendamentoId}` | Busca a coleta gerada por um agendamento |
| PUT | `/{id}` | Atualiza `status` (ver enum `StatusColeta`), `volumeColetadoMl`, `dataRealizacao` |

### Qualidade do leite — `/api/v1/qualidade-leite`
> Relação 1:1 com `Coleta` — só é possível registrar uma vez por coleta.

| Método | Rota | Descrição |
|---|---|---|
| POST | `/` | Registra análise (`coletaId` obrigatório). `resultado` começa sempre como `EM_ANALISE` (ver enum `ResultadoAnalise`) |
| GET | `/{id}` | Busca por id |
| GET | `/coleta/{coletaId}` | Busca pela coleta |

### Feedbacks — `/api/v1/feedbacks`
| Método | Rota | Descrição |
|---|---|---|
| POST | `/` | Registra feedback (`nutrizeId` obrigatório, `coletaId` opcional, `nota` de 1 a 5) |
| GET | `/{id}` | Busca por id |
| GET | `/nutriz/{nutrizeId}` | Lista feedbacks de uma nutriz |

### Lembretes — `/api/v1/lembretes`
| Método | Rota | Descrição |
|---|---|---|
| POST | `/` | Cria lembrete manualmente (`nutrizeId`, `tipo` — ver enum `TipoLembrete` —, `titulo`, `mensagem`) |
| GET | `/nutriz/{nutrizeId}` | Lista lembretes de uma nutriz |
| PATCH | `/{id}/lido` | Marca como lido |

## Enums — valores exatos aceitos pela API

Enviar qualquer valor fora dessa lista (inclusive minúsculo ou com acento) retorna `400 Bad Request`.

| Enum | Valores | Onde é usado |
|---|---|---|
| `StatusAgendamento` | `AGENDADO`, `CONFIRMADO`, `CANCELADO`, `REALIZADO` | `PUT /agendamentos/{id}` → campo `status` |
| `StatusColeta` | `PENDENTE`, `REALIZADA`, `CANCELADA` | `PUT /coletas/{id}` → campo `status` |
| `StatusDocumento` | `PENDENTE`, `APROVADO`, `REPROVADO` | `PUT /documentos-saude/{id}` → campo `status` |
| `ResultadoAnalise` | `EM_ANALISE`, `APROVADO`, `REPROVADO` | Definido em `QualidadeLeite.resultado` (sem endpoint de escrita ainda) |
| `TipoColeta` | `EM_CASA`, `PONTO_COLETA` | `POST /agendamentos` → campo `tipoColeta` |
| `TipoExame` | `HIV`, `HEPATITE_B`, `HEPATITE_C`, `OUTRO` | `POST /documentos-saude` → campo `tipo` |
| `TipoPontoColeta` | `BANCO_LEITE_HUMANO`, `PONTO_PARCEIRO` | `POST /pontos-coleta` → campo `tipo` |
| `TipoLembrete` | `COLETA`, `DICA_SAUDE`, `CONQUISTA`, `NOVIDADE`, `ACESSIBILIDADE` | `POST /lembretes` → campo `tipo` |

## Formato de erro

Todos os erros seguem o mesmo formato de resposta:

```json
{
  "status": 404,
  "erro": "Recurso não encontrado",
  "detalhes": ["Nutriz não encontrada com id: 99"],
  "timestamp": "2026-08-23T10:00:00"
}
```

| Status | Quando acontece |
|---|---|
| `400` | Corpo da requisição inválido (campo obrigatório faltando, formato errado, enum inválido) |
| `404` | Recurso buscado por id não existe |
| `422` | Regra de negócio violada (ex: e-mail/CPF já cadastrado, coleta duplicada para o mesmo agendamento) |
| `500` | Erro interno não tratado |