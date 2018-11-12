package training;

public class Product {

  private String code;
  private String quantity;
  private String dateFrom;
  private String dateTo;
  private String path;
  private String manufacter;
  private String keyword;
  private String shortDescription;
  private String longDescription;
  private String head;
  private String meta;
  private String price;
  private String currency;
  private String priceCurrency;

  public String getName() {
    return name;
  }

  public Product setName(String name) {
    this.name = name;
    return this;
  }

  public String getCode() {
    return code;
  }

  public Product setCode(String code) {
    this.code = code;
    return this;
  }

  public String getQuantity() {
    return quantity;
  }

  public Product setQuantity(String quantity) {
    this.quantity = quantity;
    return this;
  }

  public String getDateFrom() {
    return dateFrom;
  }

  public Product setDateFrom(String dateFrom) {
    this.dateFrom = dateFrom;
    return this;
  }

  public String getDateTo() {
    return dateTo;
  }

  public Product setDateTo(String dateTo) {
    this.dateTo = dateTo;
    return this;
  }

  public String getPath() {
    return path;
  }

  public Product setPath(String path) {
    this.path = path;
    return this;
  }

  public String getManufacter() {
    return manufacter;
  }

  public Product setManufacter(String manufacter) {
    this.manufacter = manufacter;
    return this;
  }

  public String getKeyword() {
    return keyword;
  }

  public Product setKeyword(String keyword) {
    this.keyword = keyword;
    return this;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public Product setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
    return this;
  }

  public String getLongDescription() {
    return longDescription;
  }

  public Product setLongDescription(String longDescription) {
    this.longDescription = longDescription;
    return this;
  }

  public String getHead() {
    return head;
  }

  public Product setHead(String head) {
    this.head = head;
    return this;
  }

  public String getMeta() {
    return meta;
  }

  public Product setMeta(String meta) {
    this.meta = meta;
    return this;
  }

  public String getPrice() {
    return price;
  }

  public Product setPrice(String price) {
    this.price = price;
    return this;
  }

  public String getCurrency() {
    return currency;
  }

  public Product setCurrency(String currency) {
    this.currency = currency;
    return this;
  }

  public String getPriceCurrency() {
    return priceCurrency;
  }

  public Product setPriceCurrency(String priceCurrency) {
    this.priceCurrency = priceCurrency;
    return this;
  }

  private String name;

  public enum Currency {
    EURO("Euros"),
    USD("US Dollars");

    private String typeOfCurrency;

    Currency(String typeOfCurrency) {
      this.typeOfCurrency = typeOfCurrency;
    }

    public boolean equalsName(String otherName) {
      // (otherName == null) check is not needed because name.equals(null) returns false
      return typeOfCurrency.equals(otherName);
    }

    public String toString() {
      return this.typeOfCurrency;
    }
  }
}
