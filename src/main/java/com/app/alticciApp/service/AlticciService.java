package com.app.alticciApp.service;

import com.app.alticciApp.dto.AlticciDto;

public interface AlticciService {
    
    public AlticciDto    getAlticci(String number);
    
    public void    deleteAll();

}
