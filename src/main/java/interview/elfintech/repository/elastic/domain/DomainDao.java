package interview.elfintech.repository.elastic.domain;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DomainDao extends ElasticsearchRepository<DomainEntity, String> {


}