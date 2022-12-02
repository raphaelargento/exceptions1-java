package model.exceptions;

public class DomainException extends RuntimeException {
    // RuntimeException - O compilador não é obrigado a tratar da exceção    
    // Exception - O compilador é obrigado a tratar a exceção

    //Exception é uma classe serializable e precisa ter um número de versão
    private static final long serialVersionUID = 1L; 

    public DomainException(String msg){
        super(msg);
    }
}
