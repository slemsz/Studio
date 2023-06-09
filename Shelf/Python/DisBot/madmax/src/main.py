import discord
import os
from jproperties import Properties

print("Hello World!")

def configure():
    configs = Properties()
    with open('resources/config.properties', 'rb') as config_file:
        configs.load(config_file)
    try:
        token = configs["token"].data
        return token
    except KeyError as ke:
        print(f'{ke}, lookup key was "token"')
        return null

discord_token = configure()
print(discord_token)
