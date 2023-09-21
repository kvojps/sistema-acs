package br.upe.acs.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaginationUtils {

    public static <T> Map<String, Object> generateRequestsPagination(List<T> list, int page, int amount) {
        Map<String, Object> response = new HashMap<>();
        response.put("requisicoes", generatePagination(list, page, amount));
        response.put("paginaAtual", page);
        response.put("totalItens", list.size());
        response.put("totalPaginas", Math.floorDiv(list.size(), amount) + (list.size() % amount == 0 ? 0 : 1));

        return response;
    }

    private static <T> List<T> generatePagination(List<T> list, int page, int amount) {
        int starts = page * amount;
        int end = Math.min(starts + amount, list.size());

        if (starts >= end) {
            return Collections.emptyList();
        }

        return list.subList(starts, end);
    }

}
