class ReturnTask implements Runnable {

    private Asset asset;

    public ReturnTask(Asset asset) {
        this.asset = asset;
    }

    @Override
    public void run() {
        if (asset instanceof ReturnCalculable rc) {
            System.out.println(asset.getSymbol() + " return = " + asset.getReturn());
        }
    }
}
