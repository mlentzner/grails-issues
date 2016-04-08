package issues

class JobItemController {

    def index() { }

    def show() {}

    def create() {
        Itemized itemized = Itemized.get(params.id)
        JobItem jobItem = new JobItem()
        [itemized: itemized, jobItem: jobItem]
    }

    def save() {
        Itemized itemized = Itemized.get(params.id)
        JobItem jobItem = new JobItem()
        jobItem.properties = params
        itemized.addLineItem(jobItem)
        if (itemized.save(flush: true)) {

        } else {

        }
        redirect(controller: 'Itemized', action: 'index')
    }

    def edit() {
        Itemized itemized = Itemized.get(params.id)
        JobItem jobItem = itemized.getLineItem(params.jobItemId)
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
