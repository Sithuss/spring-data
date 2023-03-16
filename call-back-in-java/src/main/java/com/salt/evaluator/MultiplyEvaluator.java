package com.salt.evaluator;

import com.salt.ds.Pair;

public class MultiplyEvaluator implements Evaluator{

    @Override
    public int evaluate(Pair pair) {
        return pair.getA() * pair.getB();
    }
}
