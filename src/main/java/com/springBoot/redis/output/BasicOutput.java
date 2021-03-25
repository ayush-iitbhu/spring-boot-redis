package com.springBoot.redis.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicOutput {

    private String message = "SUCCESS";

    private String errorDesc = "";

    private List<String> errorList = new ArrayList<String>() ;
}
