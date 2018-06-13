package com.enseitankado;

import java.util.*;

import com.enseitankado.ParseMolecule;import java.util.*;
import java.util.*;
import org.junit.Test;
import org.junit.runners.JUnit4;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList( new Object[][] { {Arrays.asList("Na", "Cl"),
                Arrays.asList( 1,   1 ),
                "NaCl",
                "salt"},

                {Arrays.asList("Mg", "H", "O"),
                        Arrays.asList(  1,   2,   2 ),
                        "Mg(OH)2",
                        "magnesium hydroxide"},

                {Arrays.asList("K", "O", "N", "S"),
                        Arrays.asList( 4,   14,  2,   4 ),
                        "K4[ON(SO3)2]2",
                        "Fremy's salt"},
        });
    }

    private Map<String,Integer> expected;
    private String formula, name;

    public SolutionTest(List<String> atoms, List<Integer> nums, String formula, String name) {
        Map<String,Integer> exp = new HashMap<String,Integer>();
        for (int i = 0 ; i < atoms.size() ; i++) exp.put(atoms.get(i), nums.get(i));

        this.expected = exp;
        this.formula = formula;
        this.name = name;
    }

    @Test
    public void testMolecule() {
        System.out.println(expected);
        assertEquals(String.format("Should parse %s: %s", name, formula), expected, ParseMolecule.getAtoms(formula));
    }
}
