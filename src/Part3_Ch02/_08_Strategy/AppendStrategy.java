package Part3_Ch02._08_Strategy;

public class AppendStrategy implements EncodingStrategy{

    @Override
    public String encode(String text) {
        return "ABCD" + text;
    }

}
