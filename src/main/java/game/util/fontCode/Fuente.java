package game.util.fontCode;

public enum Fuente {
    PIXEL{
        @Override
        public String getSource(){
            return ("/fonts/PixelifySans-Medium.ttf");
        }
    },
    DOGICA{
        @Override
        public String getSource(){
            return ("/fonts/dogicapixel.ttf");
        }
    },
    PPXL{
        @Override
        public String getSource(){
            return ("/fonts/pixel.ttf");
        }
    };

    public abstract String getSource();
}
