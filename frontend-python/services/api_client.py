import requests
from urllib.parse import urljoin
from config import BACKEND_BASE_URL

class ApiClient:
    def __init__(self, base_url: str = BACKEND_BASE_URL):
        self.base_url = base_url

    def _url(self, path: str) -> str:
        return urljoin(self.base_url + "/", path.lstrip("/"))

    def get(self, path: str):
        resp = requests.get(self._url(path), timeout=5)
        resp.raise_for_status()
        return resp.json()

    def post(self, path: str, json: dict):
        resp = requests.post(self._url(path), json=json, timeout=5)
        resp.raise_for_status()
        return resp.json()

    def put(self, path: str, json: dict):
        resp = requests.put(self._url(path), json=json, timeout=5)
        resp.raise_for_status()
        return resp.json()

    def delete(self, path: str):
        resp = requests.delete(self._url(path), timeout=5)
        resp.raise_for_status()
        return None

api_client = ApiClient()
