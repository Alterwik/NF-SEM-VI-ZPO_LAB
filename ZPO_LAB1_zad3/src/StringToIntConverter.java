public class StringToIntConverter {
    private final static int errorCode = 1000;
    public static int convert(String string) {
        try {
            StringBuilder sbSolution = new StringBuilder();
            String arr[] = string.split(" ");
            if (arr.length == 4) {
                if (arr[0].equals("minus")) {
                    sbSolution.append("-");
                    for (int i = 1; i < arr.length; i++) {
                        sbSolution.append(changeStringInPolishToInt(arr[i]));
                    }
                } else {
                    throw new StringVecToIntConverterException(
                            "When four parameters in use the first have to be the 'minus'!");
                }
                return Integer.parseInt(sbSolution.toString());
            } else if (arr.length == 3) {
                for (int i = 0; i < arr.length; i++) {
                    sbSolution.append(changeStringInPolishToInt(arr[i]));
                }
                return Integer.parseInt(sbSolution.toString());
            } else {
                throw new StringVecToIntConverterException(
                        "Wrong number of parameters: '"+arr.length+"' have to be 3 or 4!");
            }
        }catch (StringVecToIntConverterException e){
            System.err.println(e.getMessage());
            return errorCode;
        }
    }

    private static int changeStringInPolishToInt(String numberWordInPolish) {
        try {
            int intOut;
            switch (numberWordInPolish) {
                case "zero":
                    intOut = 0;
                    break;
                case "jeden":
                    intOut = 1;
                    break;
                case "dwa":
                    intOut = 2;
                    break;
                case "trzy":
                    intOut = 3;
                    break;
                case "cztery":
                    intOut = 4;
                    break;
                case "pięć":
                    intOut = 5;
                    break;
                case "sześć":
                    intOut = 6;
                    break;
                case "siedem":
                    intOut = 7;
                    break;
                case "osiem":
                    intOut = 8;
                    break;
                case "dziewięć":
                    intOut = 9;
                    break;
                default:
                    throw new StringVecToIntConverterException(
                            "Given parameter: '" + numberWordInPolish +
                                    "' is not a 1 digit number in polish!");
            }
            return intOut;
        } catch (StringVecToIntConverterException e) {
            System.err.println(e.getMessage());
            return errorCode;
        }
    }
}
