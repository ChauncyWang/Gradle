package cc.chauncy.hoi4

/**
 * Groovy io 工具
 * Created by 13969 on 2017/5/7.
 */
class GroovyIOTools {
    /**
     * 读取整个文件内容
     * @param file 文件名
     * @param encoding 编码方式
     * @return 文件内容
     */
    static def readAll(file,encoding="UTF8"){
        def rootPath = "D:/Idea/Gradle/HOI4/resources/"
        new File(rootPath + file).getText(encoding)
    }
}
