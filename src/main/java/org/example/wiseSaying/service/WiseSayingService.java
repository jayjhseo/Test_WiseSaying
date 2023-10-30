package org.example.wiseSaying.service;

import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.repository.WiseSayingRepository;


public class WiseSayingService {
    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    public long create(String author, String content) {
        return wiseSayingRepository.create(author, content);
    }

    public void getAllList() {
        wiseSayingRepository.getAllList();
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingRepository.remove(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String author, String content) {
        wiseSayingRepository.modify(wiseSaying, author, content);
    }

    public WiseSaying getWiseSayingsById(long id) {
        return wiseSayingRepository.getWiseSayingsById(id);
    }
}
