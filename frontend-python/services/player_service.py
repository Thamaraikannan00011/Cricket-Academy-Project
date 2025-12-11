from services.api_client import api_client

def list_players():
    return api_client.get("players")

def get_player(player_id: int):
    return api_client.get(f"players/{player_id}")

def create_player(data: dict):
    return api_client.post("players", data)

def update_player(player_id: int, data: dict):
    return api_client.put(f"players/{player_id}", data)

def delete_player(player_id: int):
    api_client.delete(f"players/{player_id}")
