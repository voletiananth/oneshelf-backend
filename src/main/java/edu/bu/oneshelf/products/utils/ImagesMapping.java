package edu.bu.oneshelf.products.utils;

import java.util.StringJoiner;

public class ImagesMapping {


    public static String getCategoryUrl(String thumbnail) {
        StringJoiner joiner = new StringJoiner("/");
        joiner.add("category").add("images").add(thumbnail);

        return joiner.toString();

    }


    public static String getProductUrl(String thumbnail) {
        StringJoiner joiner = new StringJoiner("/");
        joiner.add("product").add("images").add(thumbnail);

        return joiner.toString();

    }
}
