class PlayerFormData:
    def __init__(self, form):
        self.fullName = form.get("fullName")
        self.age = int(form.get("age") or 0)
        self.role = form.get("role")
        self.battingStyle = form.get("battingStyle")
        self.bowlingStyle = form.get("bowlingStyle")
        self.batchId = form.get("batchId") or None

    def to_dict(self):
        return {
            "fullName": self.fullName,
            "age": self.age,
            "role": self.role,
            "battingStyle": self.battingStyle,
            "bowlingStyle": self.bowlingStyle,
            "batch": None if self.batchId is None else {"id": int(self.batchId)},
        }
