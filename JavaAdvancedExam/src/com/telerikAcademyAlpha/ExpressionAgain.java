package com.telerikAcademyAlpha;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ExpressionAgain {
    public static void main(String[] args) throws ScriptException {
        String str = "3*3*3";
        int[] arr = new int[3];

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        System.out.println(engine.eval(str));
    }
}
