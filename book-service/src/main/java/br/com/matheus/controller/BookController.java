package br.com.matheus.controller;

import br.com.matheus.dto.ExchangeDto;
import br.com.matheus.environment.InstanceInformationService;
import br.com.matheus.model.Book;
import br.com.matheus.proxy.ExchangeProxy;
import br.com.matheus.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

@Tag(name = "Book Endpoint")
@RestController
@RequestMapping("/book-service")
public class BookController {

    @Autowired
    InstanceInformationService instanceInformationService;

    @Autowired
    private BookRepository repository;

    @Autowired
    private ExchangeProxy proxy;

    @Operation(summary = "Find a specific book by it's ID")
    @GetMapping(value = "/{id}/{currency}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {
        String port = instanceInformationService.retrieveServerPort();

        var book = repository.findById(id).orElseThrow();

        ExchangeDto exchangeDto = proxy.getExchange(book.getPrice(), "USD", currency);

        book.setPrice(exchangeDto.getConvertedValue());
        book.setEnvironment("BOOK PORT: " + port +
                " EXCHANGE PORT: " + exchangeDto.getEnvironment());
        book.setCurrency(currency);
        return book;
    }
}
