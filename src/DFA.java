//package csen1002.main.task1;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Write your info here
 *
 * @name John Smith
 * @id 43-0234
 * @labNumber 07
 */
public class DFA {
    /**
     * DFA constructor
     *
     * @param description is the string describing a DFA
     */
    String states[];
    ArrayList<String> acceptedStates;
    String currentState;
    String initialState;
    String transitions[];
    Hashtable<String,String> transitionfn;

    public DFA(String description) {
        String[] pands= description.split("#");
        String[] p = pands[0].split(";");
        this.states = new String[p.length];
        this.transitions = new String[p.length];
        this.transitionfn = new Hashtable<String, String>();
        this.initialState = "0";
        this.currentState = this.initialState;
        this.acceptedStates = new ArrayList<String>();
        String s [] = pands[1].split(",");
        for (int i=0; i < s.length; i++)
        {
            this.acceptedStates.add(s[i]);
        }
        System.out.println();

    for (int i=0; i< p.length; i++)
    {
        this.states[i] = Character.toString(p[i].charAt(0));
    }
    for (int i=0; i< p.length; i++)
    {
        this.transitions[i] = Character.toString(p[i].charAt(2)) + Character.toString(p[i].charAt(4));
    }
    for (int i =0; i< this.states.length; i++)
    {
        this.transitionfn.put(this.states[i],this.transitions[i]);
    }

    System.out.println(this.transitionfn);


    }

    /**
     * Returns true if the string is accepted by the DFA and false otherwise.
     *
     * @param input is the string to check by the DFA.
     * @return if the string is accepted or not.
     */
    public boolean run(String input) {
        // TODO Write Your Code Here

        for (int i = 0; i<input.length();i++)
        {
            String posTransitions = this.transitionfn.get(this.currentState);
            String currentInput = Character.toString(input.charAt(i));
            if (currentInput.equals("0"))
            {
                this.currentState = Character.toString(posTransitions.charAt(0));
            }
            if (currentInput.equals("1"))
            {
                this.currentState = Character.toString(posTransitions.charAt(1));
            }
        }
        if (acceptedStates.contains(this.currentState)) return true;

        return false;
    }

    public static void main(String[] args) {
        DFA dfa = new DFA("0,0,1;1,2,1;2,0,3;3,3,3#1,3");
        System.out.println(dfa.run("00111"));
    }
}
