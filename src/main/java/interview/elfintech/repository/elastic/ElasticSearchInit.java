package interview.elfintech.repository.elastic;

import interview.elfintech.service.domain.DomainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ElasticSearchInit {

    private final DomainRepository domainRepository;
    private static final List<String> DEFAULT_DOMAINS = List.of(".com", ".ru");

    @PostConstruct
    public void init() {
        if (domainRepository.getAvailableEmailDomains().isEmpty()) {
            for (String domain : DEFAULT_DOMAINS) {
                domainRepository.create(domain);
                log.info("Created default domain: {}", domain);
            }
        }
    }

}