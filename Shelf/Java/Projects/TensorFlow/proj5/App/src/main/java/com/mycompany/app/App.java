package com.mycompany.app;

import org.tensorflow.ConcreteFunction;
import org.tensorflow.Signature;
import tensorflow.Tensor;
import tensorflow.TensorFlow;
import org.tensorflow.op.Ops;
import org.tensorflow.op.math.Add;
import org.tensorflow.types.TInt32;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Tensorflow " + TensorFlow.version());
    }
}
