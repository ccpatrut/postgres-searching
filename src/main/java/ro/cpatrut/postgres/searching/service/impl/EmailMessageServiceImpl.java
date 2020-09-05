package ro.cpatrut.postgres.searching.service.impl;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ro.cpatrut.postgres.searching.dto.EmailMessageTO;
import ro.cpatrut.postgres.searching.entities.EmailMessageEntity;
import ro.cpatrut.postgres.searching.mapper.EmailMessageMapper;
import ro.cpatrut.postgres.searching.repository.EmailMessageRepository;
import ro.cpatrut.postgres.searching.service.EmailMessageService;

import java.util.List;

@Service
@Slf4j
public class EmailMessageServiceImpl implements EmailMessageService {
    private final EmailMessageRepository emailMessageRepository;
    private final EmailMessageMapper mapper;

    EmailMessageServiceImpl(final EmailMessageRepository emailMessageRepository, final EmailMessageMapper mapper) {
        this.emailMessageRepository = emailMessageRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<EmailMessageTO> findEmails(final String text, final PageRequest pageRequest) {
        final Page<EmailMessageEntity> emailMessageEntities = emailMessageRepository.findEmailMessageEntities(text, pageRequest);

        final List<EmailMessageTO> messages = emailMessageEntities
                .stream()
                .map(mapper::toResource)
                .collect(ImmutableList.toImmutableList());
        log.info("mails found: " + messages);

        return new PageImpl<>(messages, emailMessageEntities.getPageable(), emailMessageEntities.getTotalElements());
    }


}
