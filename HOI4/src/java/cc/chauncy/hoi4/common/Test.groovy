package cc.chauncy.hoi4.common

b = new Building()
p1 = new ProvinceBuild(100)
p1.setBunker(1)
p1.setCoastal_bunker(1)
p1.setNaval_base(1)
b.addProvinceBuilding(p1)
println(b)