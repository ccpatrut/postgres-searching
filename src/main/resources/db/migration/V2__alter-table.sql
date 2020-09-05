ALTER TABLE mails.email_message
    ADD tsv tsvector;

CREATE INDEX textsearch_idx ON mails.email_message USING GIN (tsv);

CREATE FUNCTION tsvector_update_mails() returns trigger as
$$
begin
    new.tsv :=
                    setweight(to_tsvector('pg_catalog.english', new.title), 'A') ||
                    setweight(to_tsvector('pg_catalog.english', new.subtitle), 'B') ||
                    setweight(to_tsvector('pg_catalog.english', new.content), 'D');
    return new;
end
$$ LANGUAGE plpgsql;

CREATE TRIGGER tsvectorupdate2
    BEFORE INSERT OR UPDATE
    ON mails.email_message
    FOR EACH ROW
EXECUTE PROCEDURE
    tsvector_update_mails();


