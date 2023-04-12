package com.test.alticci.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/alticci")
public class AlticciController {

    private final Map<Integer, Long> sequence;

    public AlticciController() {
        sequence = new HashMap();
        sequence.put(0,0l);
        sequence.put(1,1l);
        sequence.put(2,1l);
    }

    @CrossOrigin
    @GetMapping("/{n}")
    public Long get(@PathVariable(value = "n") @Min(0) Integer n) {
        if(sequence.containsKey(n))
            return sequence.get(n);

        sequence.put(n, get(n-3) + get(n-2));
        return sequence.get(n);
    }
}
