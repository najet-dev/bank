package fr.najet.bank.dto;

public class MessageDto {
  private String message;

  public MessageDto() {
  }

  public MessageDto(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
