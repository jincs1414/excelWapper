
## 使用场景

 - 将数据库中的数据导出成excel

## 使用说明

```java
        //构建包装的sheet
        SheetWrapper sheetWrapper = new SheetWrapper.Builder()
                .createSheet(HSSFWorkbook.class)  //创建sheet
                .setHeader(new Hi02HeaderWrapper(hi02DomainList)) //包装原始的表头数据并设置
                .setContents(new MapContentsWrapper(contents))  //包装原始的行数据并设置
                .build();
        //写入到外部的流中
        OutputStream outputStream = new FileOutputStream("E://55.xls");
        sheetWrapper.writeTo(outputStream)
                    .closeStream();

```

## 参考文档

[类定义说明](javadoc/index.html)

## 技术点

 - builder 模式

 ```java

    class  Demo{

        private String field;

        private Demo(){
        }

        public Demo(Builder builder){
           this.field = builder.field;
        }

        public static class Builder{
           private String field;

           public Builder setField(String s){
               this.field = s;
               return this;
           }
        }
    }

 ```

  优势：
  将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示


