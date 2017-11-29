package com.algos.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by cdeshpande on 3/30/17.
 */
public class Experiment {

    public static void main(String[] args) throws IllegalAccessException {
        try {
            exceptionThrower();
        } catch (IllegalAccessException e) {
            System.out.println("in illegalaccessexception, rethrowing");
            throw e;
        } catch (Exception ex) {
            System.out.println("in exception");
        }
        finally {
            System.out.println("in finally");
        }

    }


    private static void exceptionThrower() throws IllegalAccessException {
        throw new IllegalAccessException("bad state");
    }



}
