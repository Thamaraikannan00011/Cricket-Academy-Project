class ScheduleFilter:
    def __init__(self, form):
        self.batchId = form.get("batchId")
        self.coachId = form.get("coachId")
