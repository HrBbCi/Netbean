
package basic.HL;
public class Thang {
    public static void main(String[] args) {
        int sothang = 0;
        String strKetQua = " ";
        sothang = Integer.parseInt(txtNhapThang.getText());
        switch(sothang){
            case 1:
                strKetQua = "Thang Mot";
                break;
            case 2:
                strKetQua = "Thang Hai";
                break;
            case 3:
                strKetQua = "Thang Ba";
                break;
            case 4:
                strKetQua = "Thang Tu";
                break;
            case 5:
                strKetQua = "Thang Nam";
                break;
            case 6:
                strKetQua = "Thang Sau";
                break;
            case 7:
                strKetQua = "Thang Bay";
                break;
             default:strKetQua = "Khong co thang";
             break;
        }
        txtKetQua.setText(strKetQua);
    }

    private static class txtNhapThang {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public txtNhapThang() {
        }
    }

    private static class txtKetQua {

        private static void setText(String strKetQua) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public txtKetQua() {
        }
    }
}
