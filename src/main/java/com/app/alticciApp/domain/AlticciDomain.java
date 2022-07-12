package com.app.alticciApp.domain;

import java.io.Serializable;
import java.util.List;

public class AlticciDomain implements Serializable {
    private List<Integer> numbers;
    private String id;
    public List<Integer> getNumbers() {
        return numbers;
    }
    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
