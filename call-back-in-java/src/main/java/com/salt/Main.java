package com.salt;

import com.salt.ds.Pair;
import com.salt.evaluator.AddEvaluator;
import com.salt.evaluator.MultiplyEvaluator;
import com.salt.render.VerboseRunner;
import com.salt.service.EvaluatorService;

public class Main {
    public static void main(String[] args) {
        EvaluatorService service = new EvaluatorService();
        service.takeAction(
                a -> a.getA() * a.getB(),
                a -> System.out.println(a),
                new Pair(5, 7)
        );
    }
}
