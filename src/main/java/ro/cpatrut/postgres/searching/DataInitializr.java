package ro.cpatrut.postgres.searching;

import com.google.common.collect.Lists;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.cpatrut.postgres.searching.entities.EmailMessageEntity;
import ro.cpatrut.postgres.searching.repository.EmailMessageRepository;

import java.util.List;
import java.util.UUID;

@Component
public class DataInitializr implements CommandLineRunner {
    private final EmailMessageRepository emailMessageRepository;

    public DataInitializr(final EmailMessageRepository emailMessageRepository) {
        this.emailMessageRepository = emailMessageRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        while (emailMessageRepository.count() < 100_000) {
            saveChunks();
            System.out.println(emailMessageRepository.count() + " count");
        }
    }


    private void saveChunks() {
        final List<EmailMessageEntity> messages = Lists.newArrayListWithCapacity(100_000);
        for (int i = 0; i < 1_000; i++) {
            messages.add(createRandomMessageEntity(LoremIpsum.getInstance()));
        }
        emailMessageRepository.saveAll(messages);
        emailMessageRepository.flush();
    }

    private EmailMessageEntity createRandomMessageEntity(final Lorem lorem) {
        final EmailMessageEntity emailMessageEntity = new EmailMessageEntity();
        emailMessageEntity.setId(UUID.randomUUID());
        emailMessageEntity.setTitle(lorem.getTitle(5, 10));
        emailMessageEntity.setSubtitle(lorem.getTitle(10, 20));
        emailMessageEntity.setEmail(lorem.getEmail());
        emailMessageEntity.setFirstName(lorem.getFirstName());
        emailMessageEntity.setLastName(lorem.getLastName());
        emailMessageEntity.setContent(lorem.getWords(100, 900));
        return emailMessageEntity;
    }
}
