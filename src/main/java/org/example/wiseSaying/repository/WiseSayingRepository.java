package org.example.wiseSaying.repository;

import org.example.Container;
import org.example.db.DBConnection;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WiseSayingRepository {
    private List<WiseSaying> wiseSayings;
    long lastId = 0;
    private DBConnection dbConnection;

    public WiseSayingRepository () {
        dbConnection = Container.getDBconnection();
        wiseSayings = new ArrayList<>();
    }
    public long create(String author, String content) {
        lastId++;
        WiseSaying wiseSaying = new WiseSaying(lastId, author, content);
        wiseSayings.add(wiseSaying);
        return lastId;
    }
    public void getAllList() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * FROM wiseSaying"));

        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for (Map<String, Object> row : rows) {
            wiseSayings.add(new WiseSaying(row));
        }
    }
    public void remove(WiseSaying wiseSaying) {
        wiseSayings.remove(wiseSaying);
    }
    public void modify(WiseSaying wiseSaying, String author, String content) {
        wiseSaying.setAuthor(author);
        wiseSaying.setContent(content);
    }
    public WiseSaying getWiseSayingsById(long id) {
        for (int i = 0; i < wiseSayings.size(); i++) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }
}
