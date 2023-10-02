package br.upe.acs.model.dto;

import br.upe.acs.model.enums.RequestStatusEnum;

public record RequestDTO(int semester, String note, RequestStatusEnum status, byte[] signedFile) {}