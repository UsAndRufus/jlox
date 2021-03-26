package com.craftinginterpreters.lox;

public class LoxGetter extends LoxFunction {
    LoxGetter(Stmt.Function declaration, Environment closure) {
        super(declaration, closure, false);
    }

    public LoxGetter bind(LoxInstance instance) {
        Environment environment = new Environment(closure);
        environment.define("this", instance);
        return new LoxGetter(declaration, environment);
    }

    @Override
    public int arity() {
        return 0;
    }

    @Override
    public String toString() {
        return "gt <" + declaration.name.lexeme + ">";
    }
}
