package pe.edu.utp.aed.week04;

public class ArrayCopy {
    public static void arrayCopy(Object[] src, int srcPos,
                                 Object[] dest, int destPos,
                                 int length) {
        if (src == null || dest == null) {
            throw new NullPointerException("Arrays cannot be null");
        }

        if (srcPos < 0 || destPos < 0 || length < 0 ||
                srcPos + length > src.length || destPos + length > dest.length) {
            throw new IndexOutOfBoundsException("Invalid index or length");
        }

        for (int i = 0; i < length; i++) {
            dest[destPos + i] = src[srcPos + i];
        }
    }
}
