import discord
from jproperties import Properties
import logging
import os

from base import *
from constants import *
from utils import *


def configure_constants():
    configs = Properties()
    with open('resources/config.properties', 'rb') as config_file:
        configs.load(config_file)
    try:
        token = configs["TOKEN"].data
        return token
    except KeyError as ke:
        print(f'{ke}, lookup key was "token"')
        return null

intents = discord.Intents.default()
intents.message_content = True
client = discord.Client(intents = intents)
tree = discord.app_commands.CommandTree(client)

logging.basicConfig(
    format="[%(asctime)s] [%(filename)s:%(lineno)d] %(message)s", level=logging.INFO
)
logger = logging.getLogger(__name__)

@client.event
async def on_ready():
    logger.info(f"We have logged in as {client.user}.")


@client.event
async def on_message(message: DiscordMessage):
    try:
        if message.author == client.user:
            return
        channel = message.channel
        if not isinstance(channel, discord.Thread):
            return
        thread = channel
        if thread.owner_id != client.user.id:
            return
        ###
        ###
        ###


    except Exception as e:
        logger.exception(e)




def main():
    discord_token = configure_constants()
    client.run(discord_token)

main()
