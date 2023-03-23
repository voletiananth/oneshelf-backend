package edu.bu.oneshelf.pantry.utils;

import edu.bu.oneshelf.common.Pair;
import edu.bu.oneshelf.pantry.exceptions.ZipCodeException;

public class Zipcode {

    public static boolean isValidZipcode(Integer zipcode){
        if (zipcode == null){
            throw new ZipCodeException("Zipcode cannot be null");
        }
        return zipcode >= 10000 && zipcode <= 99999;
    }

    public static Pair<Integer, Integer> getZipcodeRange(Integer zipcode){
        if(!isValidZipcode(zipcode)){
            throw new ZipCodeException("Invalid Zipcode");
        }
        int from = zipcode - zipcode % 1000;
        int to = from + 999;
        return new Pair<>(from,to);
    }
}
