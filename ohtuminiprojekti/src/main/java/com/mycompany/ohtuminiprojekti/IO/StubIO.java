
package com.mycompany.ohtuminiprojekti.IO;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author Pavel
 */
public class StubIO implements IO {
    private Deque<String> inputList;
    private List<String> outputList;
    public StubIO()
    {
        inputList = new ArrayDeque<String>();
        outputList = new ArrayList<String>();
    }
    public void addInput(String input)
    {
        inputList.add(input);
    }
    @Override
    public String nextInput() {
        if (inputList.peek() == null)   return "";
        return inputList.poll();
    }

    @Override
    public void output(String out) {
        outputList.add(out);
    }
    
    public String getOutput(int index){
        return outputList.get(index);
    }
    
}
