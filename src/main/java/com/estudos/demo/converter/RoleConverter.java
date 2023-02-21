package com.estudos.demo.converter;

import com.estudos.demo.enums.ERoleEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<ERoleEnum, String> {
    @Override
    public String convertToDatabaseColumn(ERoleEnum eRoleEnum) {
        return "ADMIN";
    }

    @Override
    public ERoleEnum convertToEntityAttribute(String role) {

        return ERoleEnum.of(role);
    }
}
