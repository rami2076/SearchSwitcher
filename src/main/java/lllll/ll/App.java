package lllll.ll;

import lllll.ll.root.app.func.search.common.enumeration.SearchConditionalPattern;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args )
    {
       for (SearchConditionalPattern  A     :  SearchConditionalPattern.values()){
    	   for (SearchConditionalPattern  B    :  SearchConditionalPattern.values()){

    		   System.out.print("case " );
    		   System.out.print("\"");
    		   	System.out.print(String.join(":", A.name(),B.name()));
    		   	System.out.print("\"");
    		   	System.out.println(":");
    	   }
       }
    }
}
