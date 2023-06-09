import os
import dacite
from base import Config
from typing import Dict, List
from jproperties import Properties


def generate_constants():
    configs = Properties()
    with open('resources/config.properties', 'rb') as config_file:
        configs.load(config_file)
    try:
        dscrd_bot_token = configs["TOKEN"].data
        dscrd_bot_url = configs["GEN_URL"].data
        return dscrd_bot_token, dscrd_bot_url
    except KeyError as ke:
        print(f'{ke}, lookup key was "token"')
        return null

