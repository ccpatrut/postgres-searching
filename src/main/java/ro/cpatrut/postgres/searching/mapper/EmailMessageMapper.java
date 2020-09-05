package ro.cpatrut.postgres.searching.mapper;

import org.mapstruct.Mapper;
import ro.cpatrut.postgres.searching.dto.EmailMessageTO;
import ro.cpatrut.postgres.searching.entities.EmailMessageEntity;

@Mapper(componentModel = "spring")
public interface EmailMessageMapper {

    EmailMessageTO toResource(final EmailMessageEntity emailMessageEntity);
}
