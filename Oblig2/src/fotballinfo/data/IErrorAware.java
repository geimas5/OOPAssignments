package fotballinfo.data;

/**
 *
 * @author Marius Geitle <geimas5@gmail.com>
 */
public interface IErrorAware {
    void reportError(String message, Exception ex);
}
