package dev.alfrendosilalahi.project.exeption;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entity, String fieldName, String fieldValue) {
        super(String.format("%s with %s %s not found", entity, fieldName, fieldValue));
    }

}
