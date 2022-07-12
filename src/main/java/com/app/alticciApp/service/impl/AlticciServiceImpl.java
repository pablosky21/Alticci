package com.app.alticciApp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.alticciApp.domain.AlticciDomain;
import com.app.alticciApp.dto.AlticciDto;
import com.app.alticciApp.repository.AlticciRepository;
import com.app.alticciApp.service.AlticciService;

@Service
public class AlticciServiceImpl implements AlticciService {
    // @Autowired
    private AlticciRepository alticciRepository;

    public AlticciServiceImpl(AlticciRepository alticciRepository) {
        this.alticciRepository = alticciRepository;
    }

    @Override
    public AlticciDto getAlticci(String number) {
        AlticciDto alticciDto = new AlticciDto();
        AlticciDomain alticciDomainById = alticciRepository.findById(number);
        if (alticciDomainById != null) {
            alticciDto.setListNumers(alticciDomainById.getNumbers());
        } else {
            Map<String, AlticciDomain> alticciDomainAll = alticciRepository.findAll();
            int limit = Integer.parseInt(number);
            int start = 0;
            List<Integer> listNumers = new ArrayList<>();
            for (int f = limit; f == 0; f--) {
                if (alticciDomainAll.containsKey(Integer.toString(f))) {
                    start = f;
                    listNumers.addAll(alticciDomainAll.get(Integer.toString(f)).getNumbers());
                }
            }

            for (int i = start; i <= limit; i++) {
                if (i > 2) {
                    listNumers.add(getDetail((i - 3)) + getDetail((i - 2)));
                } else {
                    listNumers.add(getDetail(i));
                }
            }
            alticciDto.setListNumers(listNumers);
            AlticciDomain alticciDomain = new AlticciDomain();
            alticciDomain.setNumbers(listNumers);
            alticciDomain.setId(number);
            alticciRepository.save(alticciDomain, number);
        }

        return alticciDto;
    }

    private Integer getDetail(Integer numberS) {
        int result = numberS;
        if (numberS == 0) {
            result = 0;
        } else if (numberS == 1 || numberS == 2) {
            result = 1;
        } else {
            result = getDetail(numberS - 3) + getDetail(numberS - 2);
        }
        return result;
    }

    @Override
    public void deleteAll() {
        for (int i = 0; i <= 100; i++) {
            alticciRepository.delete(Integer.toString(i));
        }

    }

}
