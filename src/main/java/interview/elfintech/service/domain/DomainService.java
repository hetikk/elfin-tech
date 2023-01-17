package interview.elfintech.service.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainService {

    private final DomainRepository repository;

    public List<String> getAvailableEmailDomains() {
        return repository.getAvailableEmailDomains();
    }

}
