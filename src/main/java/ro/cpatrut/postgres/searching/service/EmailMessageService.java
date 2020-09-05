package ro.cpatrut.postgres.searching.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ro.cpatrut.postgres.searching.dto.EmailMessageTO;

public interface EmailMessageService {

    Page<EmailMessageTO> findEmails(final String text, final PageRequest pageRequest);
}
