package br.upe.acs.model.dto;

import br.upe.acs.model.enums.RequestStatusEnum;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDTO {
	
	private int semester;
	
	private String note;

	private RequestStatusEnum status;

	private byte[] signedFile;

}
