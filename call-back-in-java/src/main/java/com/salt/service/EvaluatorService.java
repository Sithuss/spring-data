package com.salt.service;

import com.salt.ds.Pair;
import com.salt.evaluator.Evaluator;
import com.salt.render.RenderExpression;

public class EvaluatorService {

    public void takeAction(Evaluator evaluator, RenderExpression render, Pair pair){
        render.display(evaluator.evaluate(pair));
    }
}
