import issues.EquipmentItem
import issues.Itemized
import issues.JobItem
import issues.SubItem

import org.bson.types.ObjectId

class BootStrap {

    def init = { servletContext ->
        loadSampleData()
    }

    def loadSampleData() {
        def itemizeds = Itemized.find() {}
        if (!itemizeds) {
            log.info "Loading Sample Data"
            Itemized itemized = new Itemized(name: 'Schedule A')

            JobItem jobItem = new JobItem(teamSize: 7)
            jobItem.id = new ObjectId()
            jobItem.dateCreated = new Date()
            jobItem.lastUpdated = new Date()
            itemized.addLineItem(jobItem)

            SubItem jobSubItem = new SubItem(name: 'Mechanic')
            jobSubItem.id = new ObjectId()
            jobSubItem.dateCreated = new Date()
            jobSubItem.lastUpdated = new Date()
            jobItem.addSubItem(jobSubItem)

            EquipmentItem equipmentItem = new EquipmentItem(manufacturer: 'American')
            equipmentItem.id = new ObjectId()
            equipmentItem.dateCreated = new Date()
            equipmentItem.lastUpdated = new Date()
            itemized.addLineItem(equipmentItem)

            SubItem equipmentSubItem = new SubItem(name: 'Harvest')
            equipmentSubItem.id = new ObjectId()
            equipmentSubItem.dateCreated = new Date()
            equipmentSubItem.lastUpdated = new Date()
            equipmentItem.addSubItem(equipmentSubItem)

            itemized.save(flush: true)
        }
    }

    def destroy = {
    }
}
