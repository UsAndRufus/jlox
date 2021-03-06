# jlox

Java implementation of the Lox language, following the [Crafting Interpreters](http://craftinginterpreters.com/) book.
See my [clox repo](https://github.com/UsAndRufus/clox/tree/main) for the second half of the book.

## Progress
    4. Scanning               ✅
    5. Representing Code      ✅
    6. Parsing Expressions    ✅
    7. Evaluating Expressions ✅
    8. Statements and State   ✅
    9. Control Flow           ✅
    10. Functions             ✅
    11. Resolving and Binding ✅
    12. Classes               ✅
    13. Inheritance           ✅

## Extras

- Multiline non-nested comments (ie `/*...*/`)
- Ternary if (see `ternary-if` branch - can parse but not interpret)
- Getters syntax (see `class-extensions` branch)
- Class methods (see `class-extensions` branch)
  - These are not implemented using metaclasses as recommended so are potentially a bit broke
