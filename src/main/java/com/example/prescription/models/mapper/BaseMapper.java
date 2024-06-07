package com.example.prescription.models.mapper;

public interface BaseMapper<M,D> {
    D convertToDto(M model);
    M convertToModel(D dto);
}
