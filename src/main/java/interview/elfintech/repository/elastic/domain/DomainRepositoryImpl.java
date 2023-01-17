package interview.elfintech.repository.elastic.domain;

import interview.elfintech.service.domain.DomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DomainRepositoryImpl implements DomainRepository {

    private final DomainDao domainDao;

    @Override
    public List<String> getAvailableEmailDomains() {
        Iterable<DomainEntity> allDomains = domainDao.findAll();
        ArrayList<String> res = new ArrayList<>();
        for (DomainEntity item : allDomains) {
            res.add(item.getName());
        }
        return res;
    }

    @Override
    public String create(String name) {
        DomainEntity entity = new DomainEntity();
        entity.setName(name);
        domainDao.save(entity);
        return name;
    }

}
