INSERT INTO prices (BRAND_ID, START_DATE, END_DATE,PRICE_LIST,PRODUCT_ID,PRIORITY,PRICE,CURR) VALUES
(1, parseDateTime( '20200614000000', 'yyyyMMddHHmmss' ),parseDateTime( '20201231235959', 'yyyyMMddHHmmss' ),1,35455,0,35.50,'EUR'),
(1, parseDateTime( '20200614150000', 'yyyyMMddHHmmss' ), parseDateTime( '20200614183000', 'yyyyMMddHHmmss' ),2,35455,1,25.45,'EUR'),
(1, parseDateTime( '20200615000000', 'yyyyMMddHHmmss' ), parseDateTime( '20200615110000', 'yyyyMMddHHmmss' ),3,35455,1,30.50,'EUR'),
(1, parseDateTime( '20200615160000', 'yyyyMMddHHmmss' ), parseDateTime( '20201231235959', 'yyyyMMddHHmmss' ),4,35455,1,38.95,'EUR');