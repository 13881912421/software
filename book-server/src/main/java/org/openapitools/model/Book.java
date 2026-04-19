package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Book
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-19T16:17:55.861450500+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class Book {

  private Long id;

  private String title;

  private String author;

  private String isbn;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate publishedDate;

  private Float price;

  private Integer stock;

  public Book() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Book(Long id, String title, String author) {
    this.id = id;
    this.title = title;
    this.author = author;
  }

  public Book id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * 图书唯一标识符
   * minimum: 1
   * @return id
   */
  @NotNull @Min(1L) 
  @Schema(name = "id", description = "图书唯一标识符", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Book title(String title) {
    this.title = title;
    return this;
  }

  /**
   * 图书标题
   * @return title
   */
  @NotNull @Size(min = 1, max = 200) 
  @Schema(name = "title", description = "图书标题", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Book author(String author) {
    this.author = author;
    return this;
  }

  /**
   * 作者姓名
   * @return author
   */
  @NotNull @Size(min = 1, max = 100) 
  @Schema(name = "author", description = "作者姓名", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("author")
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Book isbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  /**
   * ISBN编号（13位数字）
   * @return isbn
   */
  @Pattern(regexp = "^[0-9]{13}$") 
  @Schema(name = "isbn", description = "ISBN编号（13位数字）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isbn")
  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Book publishedDate(LocalDate publishedDate) {
    this.publishedDate = publishedDate;
    return this;
  }

  /**
   * 出版日期
   * @return publishedDate
   */
  @Valid 
  @Schema(name = "publishedDate", description = "出版日期", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("publishedDate")
  public LocalDate getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(LocalDate publishedDate) {
    this.publishedDate = publishedDate;
  }

  public Book price(Float price) {
    this.price = price;
    return this;
  }

  /**
   * 图书价格
   * minimum: 0
   * @return price
   */
  @DecimalMin("0") 
  @Schema(name = "price", description = "图书价格", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("price")
  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Book stock(Integer stock) {
    this.stock = stock;
    return this;
  }

  /**
   * 库存数量
   * minimum: 0
   * @return stock
   */
  @Min(0) 
  @Schema(name = "stock", description = "库存数量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("stock")
  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(this.id, book.id) &&
        Objects.equals(this.title, book.title) &&
        Objects.equals(this.author, book.author) &&
        Objects.equals(this.isbn, book.isbn) &&
        Objects.equals(this.publishedDate, book.publishedDate) &&
        Objects.equals(this.price, book.price) &&
        Objects.equals(this.stock, book.stock);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, isbn, publishedDate, price, stock);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Book {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    isbn: ").append(toIndentedString(isbn)).append("\n");
    sb.append("    publishedDate: ").append(toIndentedString(publishedDate)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    stock: ").append(toIndentedString(stock)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

