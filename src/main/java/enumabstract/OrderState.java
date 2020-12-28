package enumabstract;

public enum OrderState implements Deletable {

    NEW {
        @Override
        public boolean canDelete() {
            return true;
        }
    },
    CONFIRMED {
        @Override
        public boolean canDelete() {
            return true;
        }
    },
    PREPARED {
        @Override
        public boolean canDelete() {
            return true;
        }
    },
    ONBOARD,
    DELIVERED,
    RETURNED,
    DELETED;

    @Override
    public boolean canDelete() {
        return false;
    }

}
