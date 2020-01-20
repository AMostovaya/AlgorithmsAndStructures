public class InvertString {

    String text;

    public InvertString(String text){
        this.text = text;
    }

    public String invert(){
        MyStack<Character> stack = new MyStack();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<text.length(); i++) {
            stack.push(text.charAt(i));
        }
        for (int i=0; i<text.length(); i++) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
