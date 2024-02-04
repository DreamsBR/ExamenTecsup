package com.examenspring.configuration.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@Data
@AllArgsConstructor
public class ResponseBase {
    private int codigo;

    private String mensaje;

    private boolean data;

    private Optional succes;


}
