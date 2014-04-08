
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
    public StubIO()
    {
        inputList = new ArrayDeque<String>();
    }
    public void addInput(String input)
    {
        inputList.add(input);
    }
    @Override
    public String nextInput() {
        return inputList.poll();
    }
    
}
