package ro.cpatrut.postgres.searching.dto;

import lombok.*;

@Data
@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailMessageTO {
    String email;
    String firstName;
    String lastName;
    String title;
    String subtitle;
    String content;
    String updateTime;
    String creationTime;

    @Builder
    private static EmailMessageTO createEmailMessage(final String email,
                                                     final String firstName,
                                                     final String lastName,
                                                     final String title,
                                                     final String subtitle,
                                                     final String content,
                                                     final String updateTime,
                                                     final String creationTime) {
        return new EmailMessageTO(email, firstName, lastName, title, subtitle, content, updateTime, creationTime);
    }
}
