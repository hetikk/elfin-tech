package interview.elfintech.repository.elastic.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;

@Document(indexName="domains")
@Getter
@Setter
public class DomainEntity {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

}
