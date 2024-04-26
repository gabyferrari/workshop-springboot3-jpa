package com.projetospringboot.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() { //para o codigo ficar acessivel 
		return code;
	}
	
	//converter um valor numerico para um tipo enumerado
	public static OrderStatus valueOf(int code) { //static pois esse metodo vai funcionar sem precisar instanciar
	    for (OrderStatus value : OrderStatus.values()) { //percorre todos os valores do tipo enumerado 
	    	if (value.getCode() == code) { //e vai testar se o codigo q estou procurando por igual ao do PAID por ex ele retorna 
	    		return value;
	    	}
	    }
	    throw new IllegalArgumentException("Inavalid OrderStatus code "); //caso o codigo q estou procurando nao for igual a nenhum acima
	}

}
