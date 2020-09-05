package ro.cpatrut.postgres.searching.api;

import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.cpatrut.postgres.searching.dto.EmailMessageTO;
import ro.cpatrut.postgres.searching.service.EmailMessageService;

@RestController
@RequestMapping(EmailMessageController.PATH)
@Slf4j
public class EmailMessageController {
    static final String PATH = "/emails";

    private final EmailMessageService emailMessageService;

    public EmailMessageController(final EmailMessageService emailMessageService) {
        this.emailMessageService = emailMessageService;
    }

    @GetMapping
    public ResponseEntity<Page<EmailMessageTO>> findEmails(@NotNull @RequestParam("text") final String text,
                                                           @NotNull @RequestParam("page") final int page,
                                                           @NotNull @RequestParam("size") final int size) {
        log.info("Starting text search for " + text);
        return new ResponseEntity<>(emailMessageService.findEmails(text, PageRequest.of(page, size)),
                HttpStatus.OK);
    }
}
