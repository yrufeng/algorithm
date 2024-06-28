package demo;

public class SkuStock {
    private String sku;
    private String warehouse;
    private Integer qty;
    public SkuStock(String sku, String warehouse, Integer qty) {
        this.sku = sku;
        this.warehouse = warehouse;
        this.qty = qty;
    }

    /**
     * 调拨库存，操作库存
     */
    public void transferTo(SkuStock targetSku, int quantity) {
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + "开始操作库存");

            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            synchronized (targetSku){
                // 扣减调出仓库的库存
                this.qty -= quantity;
                // 增加目标仓库的库存
                targetSku.qty += quantity;
                System.out.println(Thread.currentThread().getName() + "操作库存结束");
            }
        }
    }

    public static void main(String[] args) {
        SkuStock skuStockA = new SkuStock("SKU", "WA", 100);
        SkuStock skuStockB = new SkuStock("SKU", "WB", 100);

        Thread thread1 = new Thread(() -> {
            skuStockA.transferTo(skuStockB, 50);
        }, "T1");

        Thread thread2 = new Thread(() -> {
            skuStockB.transferTo(skuStockA, 60);
        }, "T2");

        thread1.start();
        thread2.start();
    }
}