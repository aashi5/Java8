package com.tutorial.javaeight;

import java.util.Arrays;

public class Sample {

	public static void main(String[] args) {
		long[] numbers= {-19,138,-64,-73,147,-168,-215,-465,-424,393,464,-347,51,296,498,433,100,217,449,101,-299,-233,92,323,381,207,-236,-43,183,-16,-488,-165,-51,-346,475,-334,416,-393,-444,-350,175,446,-359,170,-429,98,-241,-370,-424,-399,176,364,198,-483,-464,-352,275,-450,72,-200,-366,236,-364,419,459,143,-72,-300,-459,377,251,275,-241,136,374,125,-193,259,5,-309,-168,308,-492,324,-468,409,-479,-227,181,154,243,-215,-31,440,69,-309,232,-386,-202,-9,486,422,275,299,-252,-85,53,-194,488,426,-476,200,-463,315,446,-411,106,474,291,269,223,386,161,80,269,-9,39,463,473,-274,403,302,-498,131,-146,240,105,-370,-101,-303,289,-342,101,-361,-210,274,378,100,-368,-424,-52,-126,-404,116,122,-111,244,-13,-453,-460,213,275,-380,-118,87,3,-464,59,-436,-208,497,300,148,-499,-57,206,-309,431,-415,127,485,442,78,142,42,-26,315,-39,180,-235,-480,-137,371,-154,417,82,418,-329,234,388,351,-293,-71,193,-400,-226,194,300,-303,-128,-88,-248,153,-83,477,245,202,21,351,459,408,-326,-251,427,44,-248,461,490,149,445,20,-403,34,-31,-66,-101,-497,-40,-106,-440,-338,173,-111,58,-289,-173,61,293,-200,134,198,-21,-246,437,-153,-147,342,316,424,-49,-375,361,-83,6,-83,-462,-22,33,-433,32,-67,-105,361,231,-122,-144,462,-310,340,-160,-169,305,342,-317,-304,464,-147,-351,-204,-158,-69,485,-214,6,427,-415,468,-113,-96,371,-51,-72,491,-99,118,418,-480,379,-355,-183,-484,206,-267,-419,95,116,-91,-330,262,-324,-498,183,375,282,-368,243,-170,261,221,101,335,-224,-105,-231,-384,-180,-140,39,-160,-81,-452,-228,-120,-142,-310,184,241,-9,316,-467,156,284,-34,149,-233,75,385,-279,14,-166,-133,-480,28,-267,260,-224,-278,-43,-327,-77,-350,154,-217,-465,-158,-85,-20,396,471,401,-134,-494,351,215,-256,-486,-428,-432,-436,11,119,458,341,-295,25,-470,-237,-454,451,-33,497,-456,-46,-110,154,-273,447,55,272,315,353,-458,-456,-292,135,-488,-15,-175,198,61,-466,-276,224,-357,-407,365,-280,-149,175,-154,168,290,-465,18,141,-89,183,120,414,-277,180,-234,454,358,-115,51,-103,-330,-68,329,-339,-319,-318,117,-435,-238,369,346,160,435,67,-345,23,10,-124,498,-241,347,55,117,385,-57,-196,-176,37,191,-318,-305,132,187,342,340,468,130,157,463,-301,-463,-314,488,180,272,-29,242,-106,-357,262,-300,-434,-364,-350,-231,279,497,-89,452,387,-412,100,-255,-21,244,-187,-379,-483,155,-278,16,368,180,244,474,-184,-11,475,-145,-87,237,-152,-138,-324,-388,336,-185,180,383,-473,-338,-180,8,365,-30,466,200,210,345,-280,-442,463,255,-358,-40,26,-263,-413,252,405,429,-85,444,381,321,-429,262,-25,483,471,-154,-354,-236,-80,193,438,343,-130,-255,441,-381,-143,-313,-267,480,-468,41,-438,497,279,109,379,270,138,73,302,-437,303,-414,-383,-96,-424,-323,223,-377,-288,-485,92,-58,-420,24,-429,-301,415,53,83,171,418,348,-150,390,-34,158,-383,276,-480,-238,91,-395,346,305,-139,-335,-14,367,107,-137,-442,-77,139,-449,427,-241,491,26,426,-447,103,357,460,-335,207,-444,174,231,-89,319,410,117,-440,355,266,-46,-332,337,463,-110,110,-101,-36,331,242,-19,440,367,-357,-415,421,-331,-46,29,-383,-479,421,362,-10,73,-67,126,-292,-227,254,499,-454,-16,482,-186,-420,135,-214,188,352,-167,-450,-391,-10,-283,-81,-364,-32,97,318,391,447,-450,-469,-402,316,221,163,253,-233,406,-354,-358,-36,20,-430,144,468,425,-453,-112,-185,281,146,-483,79,-336,129,360,-70,-324,251,129,-51,-161,-151,-437,146,360,-449,-380,-366,394,282,445,107,487,283,-359,-355,-211,33,-296,361,289,226,289,495,332,-82,297,33,293,139,-198,-230,-270,405,370,-89,-417,298,202,130,-151,-364,-231,-480,-422,156,-384,-322,72,295,-76,-325,-286,6,106,-111,-87,305,-341,-98,272,-354,-157,-106,334,141,-360,86,7,-364,477,134,215,-418,-110,-423,224,-92,-373,146,-397,330,-243,163,377,419,315,-24,371,-236,-476,326,-348,27,138,377,-347,375,-395,451,-353,-489,-378,-358,120,283,-322,382,-230,21,-200,-55,121,-301,94,-142,184,-265,-132,-388,-162,440,-431,356,-110,-150,70,460,97,-250,243,198,409,165,33,-103,108,11,458,120,361,-486,-239,-245,-387,141,61,143,166,-466,-377,-425,303,357,399,-118,-79,99,-362,220,-456,-364,-315,136,65,-263,-32,-375,79,138,-309,380,325,-205,-88,196,-281,-474,245,-85,398,187,450};
		System.out.println(solution(numbers)) ;
		
	}
	
	
	 public static long solution(long[] numbers) {
		 if(numbers.length==0){
		        return 0;
		    }else{
		        Arrays.sort(numbers);
		        return numbers[numbers.length-1];
		    }
	}
}