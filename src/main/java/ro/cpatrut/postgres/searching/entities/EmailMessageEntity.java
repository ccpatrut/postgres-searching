package ro.cpatrut.postgres.searching.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Table(schema = "mails", name = "email_message")
@Entity
@Data
public class EmailMessageEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private UUID id;

    @Column(name = "email", nullable = false, updatable = false)
    private String email;


    @Column(name = "first_name", nullable = false, updatable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false, updatable = false)
    private String lastName;

    @Column(name = "title", nullable = false, updatable = false)
    private String title;

    @Column(name = "subtitle", nullable = false)
    private String subtitle;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "creation_time", nullable = false)
    @CreationTimestamp
    private ZonedDateTime creationTime;

    @Column(name = "update_time", nullable = false)
    @UpdateTimestamp
    private ZonedDateTime updateTime;
}
