public class CustomFunctionalInterfaceImplementation{

    String result = "";

    MyFunction<Integer> cubing = (t) -> Integer.valueOf(result = String.valueOf((t*t*t)));
    MyFunction<String> caseCheck = (s)->{
        if (s == "" || s == null) {
            return "String is null";
        }
        for(int i =0;i<s.length();i++){
            if (Character.isUpperCase(s.charAt(i))){
                result = result + Character.toLowerCase(s.charAt(i));
            }
            else {
                if (Character.isLowerCase(s.charAt(i))){
                    result = result + Character.toUpperCase(s.charAt(i));
                }
            }
        }
        return result;
    };
}
