package issues

import org.bson.types.ObjectId

class JobItemController {

    def index() { }

    def show() {}

    def create() {
        Itemized itemized = Itemized.get(params.id)
        if (!itemized) { throw new IllegalStateException('Itemized DO could not be found') }

        JobItem jobItem = new JobItem()
        [itemized: itemized, jobItem: jobItem]
    }

    def save() {
        Itemized itemized = Itemized.get(params.id)
        JobItem jobItem = new JobItem()
        jobItem.properties = params
        jobItem.id = new ObjectId()
        itemized.addLineItem(jobItem)
        if (itemized.save(flush: true)) {

        } else {

        }
        redirect(controller: 'Itemized', action: 'index')
    }

    def edit() {
        log.info "Params: ${params}"

        Itemized itemized = Itemized.get(params.id)
        if (!itemized) { throw new IllegalStateException('Itemized DO could not be found') }

        JobItem jobItem = itemized.getLineItem(params.jobItemId)
        if (!jobItem) { throw new IllegalStateException('JobItem DO could not be found') }

        [itemized: itemized, jobItem: jobItem]
    }

    def update() {
        Itemized itemized = Itemized.get(params.id)
        JobItem jobItem = itemized.getLineItem(params.jobItemId)
        jobItem.properties = params
        if (itemized.save(flush: true)) {

        } else {

        }
        redirect(controller: 'Itemized', action: 'index')
    }

    def delete() {
        Itemized itemized = Itemized.get(params.id)
        JobItem jobItem = itemized.getLineItem(params.jobItemId)
        itemized.removeLineItem(jobItem)
        if (itemized.save(flush: true)) {

        } else {

        }
        redirect(controller: 'Itemized', action: 'index')
    }
}
