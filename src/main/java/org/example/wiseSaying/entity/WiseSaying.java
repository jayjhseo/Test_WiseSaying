package org.example.wiseSaying.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class WiseSaying {
    long id;
    String author;
    String content;

    public WiseSaying (Map<String, Object> row) {
        this.id = 1; // 테스트 값
        this.author = (String) row.get("author");
        this.content = (String) row.get("content");
        // 테스트 값
    }
}
