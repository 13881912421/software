package org.openapitools.api;

import org.openapitools.model.Book;
import org.openapitools.model.BookInput;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-18T17:08:17.792697300+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.bookstore.base-path:/api}")
public class BooksApiController implements BooksApi {

    private final ConcurrentHashMap<Long, Book> bookStorage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    private final NativeWebRequest request;

    public BooksApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    // 获取所有图书
    @Override
    public ResponseEntity<List<Book>> booksGet() {
        return ResponseEntity.ok(new ArrayList<>(bookStorage.values()));
    }

    // 根据ID获取图书
    @Override
    public ResponseEntity<Book> booksBookIdGet(Integer bookId) {
        Book book = bookStorage.get(bookId.longValue());
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    // 添加新图书
    @Override
    public ResponseEntity<Book> booksPost(BookInput bookInput) {
        long newId = idGenerator.getAndIncrement();
        Book newBook = new Book();
        newBook.setId(newId);
        newBook.setTitle(bookInput.getTitle());
        newBook.setAuthor(bookInput.getAuthor());
        newBook.setIsbn(bookInput.getIsbn());
        newBook.setPublishedDate(bookInput.getPublishedDate());
        newBook.setPrice(bookInput.getPrice());
        newBook.setStock(bookInput.getStock());

        bookStorage.put(newId, newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    // 更新图书信息
    @Override
    public ResponseEntity<Book> booksBookIdPut(Integer bookId, BookInput bookInput) {
        Book existing = bookStorage.get(bookId.longValue());
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        // 更新字段（保留原ID）
        existing.setTitle(bookInput.getTitle());
        existing.setAuthor(bookInput.getAuthor());
        existing.setIsbn(bookInput.getIsbn());
        existing.setPublishedDate(bookInput.getPublishedDate());
        existing.setPrice(bookInput.getPrice());
        existing.setStock(bookInput.getStock());

        return ResponseEntity.ok(existing);
    }

    // 删除图书
    @Override
    public ResponseEntity<Void> booksBookIdDelete(Integer bookId) {
        Book removed = bookStorage.remove(bookId.longValue());
        if (removed == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
