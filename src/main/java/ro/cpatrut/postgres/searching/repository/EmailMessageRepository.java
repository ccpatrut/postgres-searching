package ro.cpatrut.postgres.searching.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.cpatrut.postgres.searching.entities.EmailMessageEntity;

import java.util.UUID;

public interface EmailMessageRepository extends JpaRepository<EmailMessageEntity, UUID> {

    @Query(value = "SELECT id, email,first_name, last_name, title, content, subtitle, creation_time, update_time," +
            " ts_rank_cd(tsv, query, 1) AS rank\n" +
            "FROM mails.email_message, to_tsquery(?1) query\n" +
            "WHERE query @@ tsv\n" +
            "ORDER BY rank DESC",
            countQuery = "SELECT count(*)\n" +
                    "FROM mails.email_message, to_tsquery(?1) query\n" +
                    "WHERE query @@ tsv",
            nativeQuery = true)
    Page<EmailMessageEntity> findEmailMessageEntities(final String text, final Pageable pageable);

}
