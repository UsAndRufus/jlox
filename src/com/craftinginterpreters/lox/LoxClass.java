package com.craftinginterpreters.lox;

import java.util.List;
import java.util.Map;

class LoxClass implements LoxCallable {
    final Token name;
    private final Map<String, LoxFunction> methods;
    private final Map<String, LoxGetter> getters;
    private final Map<String, LoxFunction> classMethods;

    LoxClass(Token name, Map<String, LoxFunction> methods, Map<String, LoxGetter> getters,
             Map<String, LoxFunction> classMethods) {
        this.name = name;
        this.methods = methods;
        this.getters = getters;
        this.classMethods = classMethods;

        System.out.println("class methods for " + name.lexeme);

        for (String classMethod : this.classMethods.keySet()) {
            System.out.println(classMethod);
        }
    }

    LoxFunction findMethod(String name) {
        if (methods.containsKey(name)) {
            return methods.get(name);
        }

        return null;
    }

    LoxGetter findGetter(String name) {
        if (getters.containsKey(name)) {
            return getters.get(name);
        }

        return null;
    }

    LoxFunction findClassMethod(String name) {
        if (classMethods.containsKey(name)) {
            return classMethods.get(name);
        }

        return null;
    }

    @Override
    public String toString() {
        return name.lexeme;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        LoxInstance instance = new LoxInstance(this);
        LoxFunction initializer = findMethod("init");
        if (initializer != null) {
            initializer.bind(instance).call(interpreter, arguments);
        }

        return instance;
    }

    @Override
    public int arity() {
        LoxFunction initializer = findMethod("init");
        if (initializer == null) return 0;
        return initializer.arity();
    }
}