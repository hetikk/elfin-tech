package interview.elfintech.service.domain;

import java.util.List;

public interface DomainRepository {

    List<String> getAvailableEmailDomains();

    String create(String name);

}
