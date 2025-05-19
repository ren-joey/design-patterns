package code.testing.java;

public class PrimitiveValueTestApplication {
    public static void main(String[] args) {
        Boolean primitiveTrue = true;
        Boolean primitiveFalse = false;
        Boolean primitiveNull = null;

        // 需在 "VM Options" 欄位中加入：-ea（啟用斷言）。
        assert Boolean.TRUE.equals(primitiveTrue);
        assert Boolean.FALSE.equals(primitiveFalse);
        assert !Boolean.TRUE.equals(primitiveNull);
        assert !Boolean.FALSE.equals(primitiveNull);
        assert !Boolean.TRUE.equals(primitiveFalse);
        assert !Boolean.FALSE.equals(primitiveTrue);

        System.out.println("All assertions passed.");
    }
}
