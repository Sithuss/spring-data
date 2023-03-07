package com.salt.render;

public class VerboseRunner implements RenderExpression{
    @Override
    public void display(int num) {
        System.out.println(
                String.format("num = [%s] ", num)
        );
    }
}
