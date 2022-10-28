package fr.najet.bank.request;

public class ReponseJSON {
  boolean success = false;
  Object datas;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public Object getDatas() {
    return datas;
  }

  public void setDatas(Object datas) {
    this.datas = datas;
  }

  public ReponseJSON(boolean success, Object datas) {

    this.success = success;
    this.datas = datas;

  }
}
