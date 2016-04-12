import issues.EquipmentItem
import issues.Itemized
import issues.JobItem
import issues.SubItem

class BootStrap {

    def init = { servletContext ->
        loadSampleData()
    }

    def loadSampleData() {
        def itemizeds = Itemized.find() {}
        if (!itemizeds) {
            log.info "Loading Sample Data"
            Itemized itemized = new Itemized(name: 'Schedule A')
            //itemized.save(flush: true)

            JobItem jobItem = new JobItem(teamSize: 7)
            itemized.addLineItem(jobItem)
            SubItem jobSubItem = new SubItem(name: 'Mechanic')
            jobItem.addSubItem(jobSubItem)

            EquipmentItem equipmentItem = new EquipmentItem(manufacturer: 'American')
            itemized.addLineItem(equipmentItem)
            SubItem equipmentSubItem = new SubItem(name: 'Harvest')
            equipmentItem.addSubItem(equipmentSubItem)

            itemized.save(flush: true)
        }
    }

    def destroy = {
    }
}
