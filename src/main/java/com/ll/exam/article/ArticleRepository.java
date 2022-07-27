package com.ll.exam.article;

import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private static List<ArticleDto> datum;
    private static long lastId;

    static {
        datum = new ArrayList<>();
        lastId = 0;
    }

    public static long write(String title, String body) {
        long id = ++lastId;
        ArticleDto newArticleDto = new ArticleDto(id, title, body);

        datum.add(newArticleDto);

        return id;
    }

    public static List<ArticleDto> findAll() {
        return datum;
    }

    public static ArticleDto findById(long id) {
        for (ArticleDto articleDto : datum) {
            if (articleDto.getId() == id)
                return articleDto;
        }
        return null;
    }

    public static void doDelete(long id) {
        for (ArticleDto articleDto : datum) {
            if (articleDto.getId() == id) {
                datum.remove(articleDto);
                return;
            }
        }
    }

    public static void doModify(long id, String title, String body) {
        for (ArticleDto articleDto : datum) {
            if (articleDto.getId() == id) {
                articleDto.setTitle(title);
                articleDto.setBody(body);
                return;
            }
        }
    }
}