package devopstesterövn;

public enum Pedaler implements BatteriAnvändning {
    GAS {
        @Override
        public void konsumeraBatteri(Batteri batteri){
            batteri.setBatteriNivå(batteri.getBatteriNivå()-10);
        }
    },
    BROMS {
        @Override
        public void konsumeraBatteri(Batteri batteri) {

        }
    },
    BROMS_STOPP {
        @Override
        public void konsumeraBatteri(Batteri batteri) {

        }
    }
}
