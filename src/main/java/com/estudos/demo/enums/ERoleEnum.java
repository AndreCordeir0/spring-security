package com.estudos.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum ERoleEnum {
    ROLE_USER("ROLE_USER"),
    ROLE_MODERATOR("ROLE_MODERATOR"),
    ROLE_ADMIN("ROLE_ADMIN");

    private String valor;

    public String getValor(){
        return this.valor;
    }
    public static ERoleEnum of(String role){
        for (ERoleEnum e : values()) {
            if (e.getValor().equals(role)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Valor inválido para enum ERoleEnum: " + role);
    }
}
