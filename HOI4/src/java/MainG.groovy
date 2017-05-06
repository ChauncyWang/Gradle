import cc.chauncy.hoi4.tools.ResourcesTools

ResourcesTools.load()
modifiters = ResourcesTools.getModifiers()

for (entry in modifiters){
    println(entry.getKey()+"-"+entry.getValue())
}