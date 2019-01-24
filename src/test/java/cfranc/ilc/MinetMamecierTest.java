/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cfranc.ilc;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author am766350
 */
public class MinetMamecierTest {
    	@Test
	public void getSimilarity_SameWord_100() {
		MarkovWord m = new MarkovWord();
		double expected = 1.0;
		//double actual = m.getSimilarity(when2SimpleWords[0],when2SimpleWords[0], 4);
		//assertEquals(expected, actual,0.000000001);		
	}
        
        @Test
        public void common_0(){
            MarkovWord m = new MarkovWord();
            ArrayList<MarkovData> data1 = new ArrayList<MarkovData>();
            ArrayList<MarkovData> data2 = new ArrayList<MarkovData>();
            data1.add(new MarkovData("patate", 6));
            data1.add(new MarkovData("tomate", 6));
            data2.add(new MarkovData("salade", 6));
            data2.add(new MarkovData("courgette", 9));
            int expected = 0;
            int actual = m.common(data1, data2);
            assertEquals(expected, actual, 0.01);
        }
        
        @Test
        public void common_1(){
            MarkovWord m = new MarkovWord();
            ArrayList<MarkovData> data1 = new ArrayList<MarkovData>();
            ArrayList<MarkovData> data2 = new ArrayList<MarkovData>();
            data1.add(new MarkovData("patate", 6));
            data1.add(new MarkovData("tomate", 6));
            data2.add(new MarkovData("patate", 6));
            data2.add(new MarkovData("courgette", 9));
            int expected = 1;
            int actual = m.common(data1, data2);
            assertEquals(expected, actual, 0.01);
        }
        
        @Test
        public void union_4(){
            MarkovWord m = new MarkovWord();
            ArrayList<MarkovData> data1 = new ArrayList<MarkovData>();
            ArrayList<MarkovData> data2 = new ArrayList<MarkovData>();
            data1.add(new MarkovData("patate", 6));
            data1.add(new MarkovData("tomate", 6));
            data2.add(new MarkovData("salade", 6));
            data2.add(new MarkovData("courgette", 9));
            int expected = 4;
            int actual = m.union(data1, data2);
            assertEquals(expected, actual, 0.01);
        } 
        
        @Test
        public void union_3(){
            MarkovWord m = new MarkovWord();
            ArrayList<MarkovData> data1 = new ArrayList<MarkovData>();
            ArrayList<MarkovData> data2 = new ArrayList<MarkovData>();
            data1.add(new MarkovData("patate", 6));
            data1.add(new MarkovData("tomate", 6));
            data2.add(new MarkovData("patate", 6));
            data2.add(new MarkovData("courgette", 9));
            int expected = 3;
            int actual = m.union(data1, data2);
            assertEquals(expected, actual, 0.01);
        } 
        
        @Test
        public void contains_0(){
            MarkovWord m = new MarkovWord("anticonstitutionnellement", 2);
            int expected = 0;
            int actual = m.contains("ch");
            assertEquals(expected, actual, 0.01);
        }
        
        @Test
        public void contains_5(){
            MarkovWord m = new MarkovWord("anticonstitutionnellement", 2);
            int expected = 5;
            int actual = m.contains("co");
            assertEquals(expected, actual, 0.01);
        } 
        
        @Test
        public void contains_2(){
            MarkovWord m = new MarkovWord("anticonstitutionnellement", 2);
            int expected = 2;
            int actual = m.contains("nt");
            assertEquals(expected, actual, 0.01);
        } 
        
        @Test
        public void processString_2(){
            MarkovWord m = new MarkovWord("nuit", 2);
            List<MarkovData> expected = new ArrayList<MarkovData>();
            expected.add(new MarkovData("jo",2));
            expected.add(new MarkovData("ou",2));
            expected.add(new MarkovData("ur",2));
            List<MarkovData> actual = m.processString("jour", 2);
            System.out.println(actual.get(0).theWord);
            assertEquals(expected, actual);
        }  
}
