package br.com.virtual.store.ws.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ClientSpendings")
public class ClientSpendings {

	@Id
	private String id;

	private String clientId;

	private String clientName;

	private String description;

	private Date todaysDateSpendings;

	private List<String> tags;

	private BigDecimal clientSpendings;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTodaysDateSpendings() {
		return todaysDateSpendings;
	}

	public void setTodaysDateSpendings(Date todaysDateSpendings) {
		this.todaysDateSpendings = todaysDateSpendings;
	}

	public BigDecimal getClientSpendings() {
		return clientSpendings;
	}

	public void setClientSpendings(BigDecimal clientSpendings) {
		this.clientSpendings = clientSpendings;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
}
