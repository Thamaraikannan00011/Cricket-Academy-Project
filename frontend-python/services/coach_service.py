from services.api_client import api_client

def list_coaches():
    return api_client.get("coaches")

def get_coach(coach_id: int):
    return api_client.get(f"coaches/{coach_id}")

def create_coach(data: dict):
    return api_client.post("coaches", data)

def update_coach(coach_id: int, data: dict):
    return api_client.put(f"coaches/{coach_id}", data)

def delete_coach(coach_id: int):
    api_client.delete(f"coaches/{coach_id}")
