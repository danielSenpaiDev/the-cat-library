package org.api.catlibrary.util.logging;

public class LogInfo {
	private String transactionRef;
	private String nodeRef;
	private String consumerRef;
	private String message;
	
	public String getTransactionRef() {
		return transactionRef;
	}
	public void setTransactionRef(String transactionRef) {
		this.transactionRef = transactionRef;
	}
	public String getNodeRef() {
		return nodeRef;
	}
	public void setNodeRef(String nodeRef) {
		this.nodeRef = nodeRef;
	}
	public String getConsumerRef() {
		return consumerRef;
	}
	public void setConsumerRef(String consumerRef) {
		this.consumerRef = consumerRef;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
