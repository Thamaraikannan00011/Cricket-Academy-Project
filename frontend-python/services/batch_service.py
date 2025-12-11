from services.api_client import api_client

def list_batches():
    return api_client.get("batches")

def get_batch(batch_id: int):
    return api_client.get(f"batches/{batch_id}")

def create_batch(data: dict):
    return api_client.post("batches", data)

def update_batch(batch_id: int, data: dict):
    return api_client.put(f"batches/{batch_id}", data)

def delete_batch(batch_id: int):
    api_client.delete(f"batches/{batch_id}")
