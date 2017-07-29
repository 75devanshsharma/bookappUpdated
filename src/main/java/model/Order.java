package model;

public class Order {
private Integer id;
private Integer customerId;
private String bookName;
private Integer quantity;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getCustomerId() {
	return customerId;
}
public void setCustomerId(Integer customerId) {
	this.customerId = customerId;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "Order [id=" + id + ", customerId=" + customerId + ", bookName=" + bookName + ", quantity=" + quantity + "]";
}

}