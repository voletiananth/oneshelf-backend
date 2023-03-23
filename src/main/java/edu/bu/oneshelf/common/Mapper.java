package edu.bu.oneshelf.common;

import java.io.IOException;

public interface Mapper<T>{
    T toMap() throws Exception;
}
