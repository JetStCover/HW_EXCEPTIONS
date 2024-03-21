package re.netology.ProductManager;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super(s);
    }
}