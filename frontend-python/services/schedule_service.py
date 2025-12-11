from services.api_client import api_client

def list_sessions():
    return api_client.get("sessions")
