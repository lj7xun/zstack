import org.junit.Test
import org.zstack.core.Platform
import org.zstack.header.vm.VmInstanceInventory
import org.zstack.utils.gson.JSONObjectUtil
import org.zstack.zql.ast.ZQLMetadata
import org.zstack.zql.ast.sql.SQLConditionBuilder

class TestZQL {
    String text = "query vm.vmNics.id where ((uuid = 23 and name = \"hello\") or " +
            "description not null) and (nic.id = 523.2 or volume.size > 1000) " +
            "or vm.rootVolumeUuid = (query volume.uuid where name = \"root\" and type != \"Data\" or uuid in " +
            "(query volume.uuid where uuid not in (\"a5576d5e57a7443894eeb078702023fd\", \"36239a01763d4b4f8ad7cfdd0dc26f5f\"))) " +
            "restrict by (zone.uuid = \"8b78f4d7367c41dd86ebdd59052af8b9\", image.size > 100) " +
            "return with (count, metric.CPUIdleUtilization, zwatch{vm.cpuNum, vm.memorySize}) " +
            "order by uuid desc limit 10 offset 10000 " +
            "filter by zwatch{vm.CPUNum > 0 during 5m and vm.memory > 100 and {{}}}, example{func(_,100,\"text\")}"

    @Test
    void test() {
        //ZQL zql = ZQL.fromString(text)
        //println(zql.toString())

        Platform.getUuid()

        def fs = "vmNics.l3Network.l2Network.cluster.zoneUuid".split("\\.") as List
        def mpairs = ZQLMetadata.createMetadataPair(VmInstanceInventory.class.name, fs)
        mpairs.each {
            println(it.toString())
        }

        println(new SQLConditionBuilder(VmInstanceInventory.class.name, fs).build(null, null))
        println(new SQLConditionBuilder(VmInstanceInventory.class.name, ["uuid"]).build(null, null))
    }
}
