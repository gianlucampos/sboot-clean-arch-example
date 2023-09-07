package br.com.gianlucampos.sbootcleanarchexample.application.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class CustomErrorRepresentation {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private String timestamp;
    private String errorMsg;
    private Integer statusCode;
    private String correlationId;

}
